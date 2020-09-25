package com.deepblue.art.chapter_006_message_digest;

import org.apache.commons.codec.digest.DigestUtils;

public class MessageDigest_002_SHA_Test {

    public static void main(String[] args) {
        String message = "Java加密与解密的艺术";
        String sha256Hex = DigestUtils.sha256Hex(message);
        String sha384Hex = DigestUtils.sha384Hex(message);
        String sha512Hex = DigestUtils.sha512Hex(message);
        System.out.println("sha256Hex :" + sha256Hex);
        System.out.println("sha384Hex :" + sha384Hex);
        System.out.println("sha512Hex :" + sha512Hex);
    }

}
