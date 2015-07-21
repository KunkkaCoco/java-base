package cloud;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CommonUtil {

    private static final Pattern json_pattern_1 = Pattern.compile("^\\{(.*?)\\}$");
    private static final Pattern jaon_pattern_2 = Pattern.compile("^\\[(.*?)\\]$");

    private static final Log logger = LogFactory.getLog(CommonUtil.class);


    /**
     * 检查字符串是否是json格式的，是返回true，否返回false
     * 
     * @param content
     * @return
     */
    public static boolean checkIfJSON(String content) {
        if (isEmpty(content)) {
            return false;
        }

        boolean b1 = json_pattern_1.matcher(content).find();
        boolean b2 = jaon_pattern_2.matcher(content).find();

        return (b1 || b2);
    }

    /**
     * 给浮点数后面补0
     * 
     * @param d
     * @param scale
     * @return
     */
    public static String getFixedScaleDouble(double d, int scale) {
        BigDecimal big = BigDecimal.valueOf(d);
        big = big.setScale(scale, RoundingMode.HALF_UP); // 默认四舍五入
        return big.toString();
    }

    /**
     * 给一个java bean的字符串字段填充空值
     * @param <T>
     * 
     * @param object
     * @param clazz
     */
    public static <T> void fillEmptyToBean(Object object, Class<T> clazz) {
        Method[] methods = clazz.getMethods();
        if (methods != null) {

            for (Method f : methods) {
                if (!f.getName().startsWith("set")) {
                    continue;
                }
                try {
                    Method mGet = clazz.getMethod(f.getName().replaceAll("set", "get"));
                    String fieldType = mGet.getReturnType().getName();
                    if (fieldType.equals("java.lang.String")) {
                        Object value = mGet.invoke(object);
                        if (value == null) {
                            f.invoke(object, "");
                        }
                    }
                } catch (Exception ex) {
                    logger.error(ex.getMessage());
                }
            }
        }
    }


    /**
     * 获取一个类的泛型参数数组，如果这个类没有泛型参数，返回 null
     */
    public static Type[] getTypeParams(Class<?> klass) {
        // TODO 这个实现会导致泛型丢失,只能取得申明类型
        if (klass == null || "java.lang.Object".equals(klass.getName())) {
            return null;
        }
        // 看看父类
        Type superclass = klass.getGenericSuperclass();
        if (superclass instanceof ParameterizedType) {
            return ((ParameterizedType) superclass).getActualTypeArguments();
        }

        // 看看接口
        Type[] interfaces = klass.getGenericInterfaces();
        for (Type inf : interfaces) {
            if (inf instanceof ParameterizedType) {
                return ((ParameterizedType) inf).getActualTypeArguments();
            }
        }
        return getTypeParams(klass.getSuperclass());
    }

    /**
     * 获取一个类的某个一个泛型参数
     *
     * @param klass 类
     * @param index 参数下标 （从 0 开始）
     * @return 泛型参数类型
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getTypeParam(Class<?> klass, int index) throws Exception {
        Type[] types = getTypeParams(klass);
        if (index >= 0 && index < types.length) {
            Type t = types[index];
            Class<T> clazz = (Class<T>) CommonUtil.getTypeClass(t);
            if (clazz == null) {
                throw new Exception("Type '%s' is not a Class" + t.toString());
            }
            return clazz;
        }
        throw new Exception("Class type param out of range %d/%d" + index + types.length);
    }

    /**
     * 获取一个 Type 类型实际对应的Class
     *
     * @param type 类型
     * @return 与Type类型实际对应的Class
     */
    @SuppressWarnings("rawtypes")
    public static Class<?> getTypeClass(Type type) {
        Class<?> clazz = null;
        if (type instanceof Class<?>) {
            clazz = (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            clazz = (Class<?>) pt.getRawType();
        } else if (type instanceof GenericArrayType) {
            GenericArrayType gat = (GenericArrayType) type;
            Class<?> typeClass = getTypeClass(gat.getGenericComponentType());
            return Array.newInstance(typeClass, 0).getClass();
        } else if (type instanceof TypeVariable) {
            TypeVariable tv = (TypeVariable) type;
            Type[] ts = tv.getBounds();
            if (ts != null && ts.length > 0) {
                return getTypeClass(ts[0]);
            }
        } else if (type instanceof WildcardType) {
            WildcardType wt = (WildcardType) type;
            Type[] tLow = wt.getLowerBounds();// 取其下界
            if (tLow.length > 0) {
                return getTypeClass(tLow[0]);
            }
            Type[] tUp = wt.getUpperBounds(); // 没有下界?取其上界
            return getTypeClass(tUp[0]);// 最起码有Object作为上界
        }
        return clazz;
    }

    /**
     * 滤掉所有特殊字符
     *
     * @param str 需要被过滤的字符串
     * @return 过滤后得到的字符串
     * @throws PatternSyntaxException
     */
    public static String filterString(String str) throws PatternSyntaxException {
        if (org.springframework.util.StringUtils.isEmpty(str)) {
            return "";
        }
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\"《》]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("@").trim();
    }

    /**
     * 根据生日获取年龄
     *
     * @param birthday 生日日期
     * @return 年龄
     */
    public static int getAge(Date birthday) {
        Calendar cal = Calendar.getInstance();

        if (cal.before(birthday)) {
            return 0;
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthday);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                // monthNow==monthBirth
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                // monthNow>monthBirth
                age--;
            }
        }
        return age;
    }

    /**
     * 判断一个对象是否为空。它支持如下对象类型：
     * <ul>
     * <li>null : 一定为空
     * <li>数组
     * <li>集合
     * <li>Map
     * <li>其他对象 : 一定不为空
     * </ul>
     *
     * @param obj 任意对象
     * @return 是否为空
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof CharSequence && "".equals(obj)) {
            return true;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection<?>) {
            return ((Collection<?>) obj).isEmpty();
        }
        if (obj instanceof Map<?, ?>) {
            return ((Map<?, ?>) obj).isEmpty();
        }
        return false;
    }

    /**
     * 较方便的创建一个列表，比如：
     * <p/>
     * <pre>
     * List&lt;Pet&gt; pets = Lang.list(pet1, pet2, pet3);
     * </pre>
     * <p/>
     * 注，这里的 List，是 ArrayList 的实例
     *
     * @param eles 可变参数
     * @return 列表对象
     */
    public static <T> List<T> list(T... eles) {
        ArrayList<T> list = new ArrayList<T>(eles.length);
        for (T ele : eles) {
            list.add(ele);
        }
        return list;
    }

    public static void main(String[] args) {
    }

}
