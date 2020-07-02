package com.deepblue.security_002_messagedigest;

import com.alibaba.fastjson.JSON;
import com.deepblue.common.AlgorithmConstant;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

public class MessageDigestTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance(AlgorithmConstant.MD5.name());
        byte[] bytes = "".getBytes();
        digest.update(bytes);

        int digestLength = digest.getDigestLength();
        String algorithm = digest.getAlgorithm();
        byte[] digestValue = digest.digest();
        Provider provider = digest.getProvider();

        System.out.println("digestLength    : " + digestLength);
        System.out.println("algorithm       : " + algorithm);
        System.out.println("digestValue     : " + JSON.toJSONString(digestValue));
        System.out.println("provider.name   : " + provider.getName());
        System.out.println("provider.version: " + provider.getVersion());
        System.out.println("provider.info   : " + provider.getInfo());

    }

}
