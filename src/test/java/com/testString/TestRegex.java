package com.testString;

/**
 * <p>
 * Title: TestRegex.java
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author maximus
 * @date 2015年6月9日
 */
public class TestRegex {
    public static void main(String[] args) {
        String regex = "[\\W\\w]{1}";// 所有的1个字符
        // String regex = "\d";//数字
        // String regex = "\\D";// 非数字
        // String regex = "[\\s\\S]";// 非数字

        String str = "\r";
        System.out.println(str.matches(regex));
    }
}
