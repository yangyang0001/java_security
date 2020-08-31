package com.deepblue.util;

public class HexUtil {

    /**
     * byte数组 转化为 16进制
     * @param bytes
     * @return
     */
    public static String getHexByBytes(byte[] bytes) {
        if(bytes == null || bytes.length == 0) {
            return null;
        }

        StringBuffer sb = new StringBuffer("");
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
