package io.itjun.examples.math;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/**
 * 字符串转md5
 */
public class MD5Tool {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "123456";
        System.out.println(get(password).equals(givenPassword_whenHashing_thenVerifying(password)));
    }

    public static String givenPassword_whenHashing_thenVerifying(String password)
            throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(password.getBytes());
        String myHash = DatatypeConverter.printHexBinary(digest).toLowerCase();
        System.out.println(myHash);
        return myHash;
    }

    public static String get(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b : bytes) {
                int value = b & 0xff;
                if (value >> 4 == 0) {// 运算符右移补0
                    builder.append("0").append(Integer.toHexString(value));
                } else {
                    builder.append(Integer.toHexString(value));
                }
            }
            return builder.toString().toLowerCase(Locale.ROOT);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

}
