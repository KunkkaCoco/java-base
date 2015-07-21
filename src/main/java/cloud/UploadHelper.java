package cloud;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * Created by chenweichao on 15-7-20.
 */
public class UploadHelper {

    public static final String  ACCESS_KEY ="xOkyLbF8-56aPxzfA95Qw8IJeVg6hU6hk9UcZ7lD";
    public static final String  SECRET_KEY ="qFtKx4qbVE5Agjh5JtrfBzNLIp0e_HO_P4BdRNx7";
    public static final String  DOMAIN ="http://7xjxv4.com1.z0.glb.clouddn.com/";

    public static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);


    // 简单上传，使用默认策略
    private static String getUpToken0(){
        return auth.uploadToken("bucket");
    }

    // 覆盖上传
    private static String getUpToken1(String bucket,String Key){
        return auth.uploadToken(bucket, Key);
    }

    // 设置指定上传策略
    private static String getUpToken2(String bucket,String Key, Long expires,StringMap policy){
        return auth.uploadToken(bucket, Key, expires, policy);
    }

    // 设置预处理、去除非限定的策略字段
    private static String getUpToken3(String bucket,String Key, Long expires,StringMap policy,boolean strict){
        return auth.uploadToken(bucket, Key, expires, policy, strict);
    }

    /**
     * 生成上传token
     *
     * @param bucket  空间名
     * @param key     key，可为 null
     * @param expires 有效时长，单位秒。默认3600s
     * @param policy  上传策略的其它参数，如 new StringMap().put("endUser", "uid").putNotEmpty("returnBody", "")。
     *        scope通过 bucket、key间接设置，deadline 通过 expires 间接设置
     * @param strict  是否去除非限定的策略字段，默认true
     * @return 生成的上传token
     */
    public static  String uploadToken(String bucket, String key, Long expires, StringMap policy, Boolean strict){
        if (CommonUtil.isEmpty(expires)){
            expires = 3600L;
        }
        if (!CommonUtil.isEmpty(policy) && !CommonUtil.isEmpty(strict)) {
            return getUpToken3(bucket,key,  expires, policy, strict);

        }else if (!CommonUtil.isEmpty(policy)){
            return getUpToken2(bucket,key, expires, policy);
        }

        return getUpToken1(bucket, key);
    }
}
