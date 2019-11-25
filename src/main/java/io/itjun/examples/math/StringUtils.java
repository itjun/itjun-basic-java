package io.itjun.examples.math;

/**
 * 常用字符串工具
 */
public class StringUtils {

    /**
     * <pre>
     * Utils.isEmpty(null)      = true
     * Utils.isEmpty("")        = true
     * Utils.isEmpty(" ")       = false
     * Utils.isEmpty("bob")     = false
     * Utils.isEmpty("  bob  ") = false
     * </pre>
     *
     * @param str 目标字符串
     * @return 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * <pre>
     * Utils.isNotEmpty(null)      = false
     * Utils.isNotEmpty("")        = false
     * Utils.isNotEmpty(" ")       = true
     * Utils.isNotEmpty("bob")     = true
     * Utils.isNotEmpty("  bob  ") = true
     * </pre>
     *
     * @param str 目标字符串
     * @return 判断字符串不为空
     */
    public static boolean isNotEmpty(String str) {
        return !Utils.isEmpty(str);
    }

    /**
     * <pre>
     * Utils.isBlank(null)      = true
     * Utils.isBlank("")        = true
     * Utils.isBlank(" ")       = true
     * Utils.isBlank("bob")     = false
     * Utils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param str 目标字符串
     * @return 判断是否为纯空格
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <pre>
     * StringUtils.isNotBlank(null)      = false
     * StringUtils.isNotBlank("")        = false
     * StringUtils.isNotBlank(" ")       = false
     * StringUtils.isNotBlank("bob")     = true
     * StringUtils.isNotBlank("  bob  ") = true
     * </pre>
     *
     * @param str 目标字符串
     * @return 判断是否不含纯空格
     */
    public static boolean isNotBlank(String str) {
        return !StringUtils.isBlank(str);
    }

}
