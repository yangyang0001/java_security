package com.deepblue.inaction.study_007_mac_signature;

import com.alibaba.fastjson.JSON;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.stream.Stream;

public class MD5Test {

    public static void main(String[] args) throws IOException {
        String filePath1 = "D:\\study_workspace\\java_security\\src\\main\\java\\com\\deepblue\\inaction\\study_007_mac_signature\\mac.txt";
        String filePath2 = "D:\\study_workspace\\java_security\\src\\main\\java\\com\\deepblue\\inaction\\study_007_mac_signature\\mac_copy.txt";

        byte[] first  = getHashByFile(filePath1);
        System.out.println(JSON.toJSONString(first));
        System.out.println("-----------------------------------------------------------------------");


        byte[] second = getHashByFile(filePath2);
        System.out.println(JSON.toJSONString(second));
        System.out.println("-----------------------------------------------------------------------");
    }

    public static byte[] getHashByFile(String filePath) {
        byte[] result = null;
        InputStream in = null;
        BufferedInputStream bis = null;

        try {
            in = new FileInputStream(filePath);
            bis = new BufferedInputStream(in);
            byte[] bytes = new byte[in.available()];
            bis.read(bytes);
            print(bytes);
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(bytes);
            result = digest.digest();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(bis != null) {
                    bis.close();
                }
                if(in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static void print(byte[] bytes) {
        if(bytes == null || bytes.length == 0) {
            return;
        }
        for (byte b : bytes) {
            System.out.print((char)b);
        }
        System.out.println();
    }

}
