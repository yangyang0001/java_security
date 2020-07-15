package com.deepblue.security_006_keyfactory;

import com.alibaba.fastjson.JSON;
import com.deepblue.common.AlgorithmConstant;

import javax.crypto.SecretKeyFactory;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

public class KeyFactoryTest {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(AlgorithmConstant.RSA.name());
        generator.initialize(1024);
        KeyPair keyPair = generator.generateKeyPair();
        // 发送者 发送的 秘钥字节 数组
        byte[] encoded = keyPair.getPrivate().getEncoded();

        // 拿到 私密秘钥 字节
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        KeyFactory keyFactory = KeyFactory.getInstance(AlgorithmConstant.RSA.name());
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        String format = privateKey.getFormat();
        System.out.println(format);

    }
}
