package com.deepblue.security_002_messagedigest;

import com.alibaba.fastjson.JSON;
import com.deepblue.common.AlgorithmConstant;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

/**
 * MessageDigest 第一个引擎类, 摘要引擎类
 */
public class MessageDigestTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(AlgorithmConstant.MD5.name());
        byte[] bytes = "MD5".getBytes();
        messageDigest.update(bytes);

        byte[] digestBytes = messageDigest.digest();
        int digestLength = messageDigest.getDigestLength();
        String algorithm = messageDigest.getAlgorithm();
        Provider provider = messageDigest.getProvider();

        // bytes        : "TUQ1", digestBytes : "fxOKCRabJQ6dyzeBQJBzeA=="
        System.out.println("bytes        : " + JSON.toJSONString(bytes) + ", digestBytes : " + JSON.toJSONString(digestBytes));
        System.out.println("digestLength : " + digestLength);
        System.out.println("algorithm    : " + algorithm);
        System.out.println("name : " + provider.getName() + ", version: " + provider.getVersion() + ", info: " + provider.getInfo());


    }
}
