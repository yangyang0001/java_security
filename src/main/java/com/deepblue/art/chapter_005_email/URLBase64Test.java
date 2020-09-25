package com.deepblue.art.chapter_005_email;

import org.apache.commons.codec.binary.Base64;

public class URLBase64Test {

    public static void main(String[] args) {
        String message = "Java加密与解密的艺术";
        String encode = Base64.encodeBase64URLSafeString(message.getBytes());
        byte[] bytes = Base64.decodeBase64(encode);
        String decode = new String(bytes);
        System.out.println("原文:" + message);
        System.out.println("encode:" + encode);
        System.out.println("decode:" + decode);


    }
}
