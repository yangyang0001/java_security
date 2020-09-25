package com.deepblue.art.chapter_005_email;

import com.deepblue.util.HexUtil;
import org.bouncycastle.util.encoders.Base64Encoder;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class Base64Test {

    public static void main(String[] args) throws Exception {
        String msg = "Java加密与解密的艺术";
        String encode = Base64.encodeBase64String(msg.getBytes());
        byte[] bytes = Base64.decodeBase64(encode);
        String decode = new String(bytes);
        System.out.println("原文:" + msg);
        System.out.println("encode:" + encode);
        System.out.println("decode:" + decode);
    }

}
