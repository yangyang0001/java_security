package com.deepblue.security_005_keypair;

import com.alibaba.fastjson.JSON;
import com.deepblue.common.AlgorithmConstant;
import sun.security.jca.JCAUtil;

import java.security.*;

/**
 * 公钥和私钥
 */
public class KeyPairTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("DSA");
        generator.initialize(1024);
        Provider provider = generator.getProvider();
        String algorithm = generator.getAlgorithm();
        KeyPair keyPair = generator.generateKeyPair();
        PublicKey  publicKey  = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        System.out.println("provider.name: " + provider.getName() + ", provider.version: " + provider.getVersion() + "provider.info: " + provider.getInfo());
        System.out.println("algorithm    : " + algorithm);
        System.out.println("publicKey  algorithm : " + publicKey.getAlgorithm()  + ", format: " + publicKey.getFormat()  + ", encoded: " + JSON.toJSONString(publicKey.getEncoded()));
        System.out.println("privateKey algorithm : " + privateKey.getAlgorithm() + ", format: " + privateKey.getFormat() + ", encoded: " + JSON.toJSONString(privateKey.getEncoded()));
    }

}
