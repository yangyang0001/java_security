package com.deepblue.security_008_signature;

import com.alibaba.fastjson.JSON;
import com.deepblue.common.AlgorithmConstant;

import java.security.*;
import java.util.AbstractList;

public class SignatureTest {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {

        byte[] bytes = "Signature Data".getBytes();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(AlgorithmConstant.DSA.name());
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        Signature signature = Signature.getInstance(keyPairGenerator.getAlgorithm());
        signature.initSign(keyPair.getPrivate());
        signature.update(bytes);

        byte[] sign = signature.sign();
        signature.initVerify(keyPair.getPublic());
        signature.update(bytes);
        boolean verify = signature.verify(sign);
        System.out.println("sign   :" + JSON.toJSONString(sign));
        System.out.println("verify :" + verify);
    }
}
