package com.deepblue.security_007_securerandom;

import com.alibaba.fastjson.JSON;
import com.deepblue.common.AlgorithmConstant;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecureRandomTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AlgorithmConstant.DES.name());
        keyGenerator.init(secureRandom);
        SecretKey secretKey = keyGenerator.generateKey();
        System.out.println("secretKey :" + JSON.toJSONString(secretKey));
    }
}
