package com.deepblue.art.chapter_006_message_digest;

import com.deepblue.common.AlgorithmConstant;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class MessageDigest_003_MAC_Test {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String algorithm = AlgorithmConstant.RSA.getName();
        KeyPairGenerator generator = KeyPairGenerator.getInstance(algorithm);
        generator.initialize(1024);

    }
}
