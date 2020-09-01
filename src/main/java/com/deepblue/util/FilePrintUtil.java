package com.deepblue.util;

public class FilePrintUtil {

    public static void print(byte[] bytes) {
        System.out.print("file bytes :");
        if(bytes == null || bytes.length == 0) {
            return;
        }
        for (byte b : bytes) {
            System.out.print((char)b);
        }
        System.out.println();
    }
}
