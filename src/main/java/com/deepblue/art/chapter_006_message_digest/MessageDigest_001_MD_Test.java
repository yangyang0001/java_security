package com.deepblue.art.chapter_006_message_digest;

import com.deepblue.util.HexUtil;
import org.apache.commons.codec.digest.DigestUtils;

public class MessageDigest_001_MD_Test {

    public static void main(String[] args) {
        String message = "Java加密和解密的艺术";
        //MD2, MD5
        String md2Hex = DigestUtils.md2Hex(message);
        String md5Hex = DigestUtils.md5Hex(message);
        System.out.println("md2Hex :" + md2Hex);
        System.out.println("md5Hex :" + md5Hex);
    }

}
