package com.deepblue.inaction.study_007_mac_signature;

import com.alibaba.fastjson.JSON;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

public class MD5Test {

    public static void main(String[] args) throws IOException {
        byte[] first = getFirstFileMessageDigestValue();
        byte[] seond = getSeondFileMessageDigestValue();
        System.out.println("first digest:" + JSON.toJSONString(first));
        System.out.println("seond digest:" + JSON.toJSONString(seond));
    }

    public static byte[] getFirstFileMessageDigestValue() {
        byte[] result = null;
        InputStream  inputStream  = null;
        try {
            inputStream = new FileInputStream("D:\\study_workspace\\java_security\\src\\main\\java\\com\\deepblue\\inaction\\study_007_mac_signature\\mac.txt");
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            byte[] bytes = new byte[inputStream.available()];
            bis.read(bytes);
            System.out.println("---------------------------------- first bytes start -----------------------------------");
            for(byte b : bytes) {
                System.out.print((char)b);
            }
            System.out.println("\n---------------------------------- first bytes end -----------------------------------");

            MessageDigest digest = MessageDigest.getInstance("MD5");
//            digest.update(bytes, 0, bytes.length);      //Ls3eOVkFHZE/YbFFeeoTbQ==
            digest.update(bytes);                         //Ls3eOVkFHZE/YbFFeeoTbQ==

            byte[] digestValue = digest.digest();
            result = digestValue;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static byte[] getSeondFileMessageDigestValue() {
        byte[] result = null;
        InputStream  inputStream  = null;
        try {
            inputStream = new FileInputStream("D:\\study_workspace\\java_security\\src\\main\\java\\com\\deepblue\\inaction\\study_007_mac_signature\\mac_copy.txt");
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            byte[] bytes = new byte[inputStream.available()];
            bis.read(bytes);
            System.out.println("---------------------------------- seond bytes start -----------------------------------");
            for(byte b : bytes) {
                System.out.print((char)b);
            }
            System.out.println("\n---------------------------------- seond bytes end -----------------------------------");

            MessageDigest digest = MessageDigest.getInstance("MD5");
//            digest.update(bytes, 0, bytes.length);      //Ls3eOVkFHZE/YbFFeeoTbQ==
            digest.update(bytes);                         //Ls3eOVkFHZE/YbFFeeoTbQ==

            byte[] digestValue = digest.digest();
            result = digestValue;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
