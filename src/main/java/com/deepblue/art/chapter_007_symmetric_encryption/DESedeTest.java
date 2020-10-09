package com.deepblue.art.chapter_007_symmetric_encryption;

import com.deepblue.common.AlgorithmConstant;
import com.deepblue.util.HexUtil;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;

public class DESedeTest {

    public static void main(String[] args) throws Exception {

        String message = "Java加密与解密的艺术";
        String key_algorithm = AlgorithmConstant.DESede.getName();
        String cipher_algorithm = "DESede/ECB/PKCS5Padding";

        // 获取秘钥
        SecretKey generatorSecretKey = generatorSecretKey(key_algorithm);
        // 加密
        byte[] encoded = encodedByDESede(generatorSecretKey, cipher_algorithm, message);

        // 还原秘钥
        SecretKey reductionSecretKey = reductionSecretKey(key_algorithm, generatorSecretKey.getEncoded());
        // 解密
        byte[] decoded = decodedByDECede(reductionSecretKey, cipher_algorithm, encoded);

        System.out.println("原始明文 :" + message);
        System.out.println("加密后的 :" + HexUtil.getHexByBytes(encoded));
        System.out.println("解密后的 :" + HexUtil.getHexByBytes(decoded));
        System.out.println("解密明文 :" + new String(decoded));

    }


    // 生成秘钥
    public static SecretKey generatorSecretKey(String key_algorithm) throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance(key_algorithm);
        SecretKey secretKey = generator.generateKey();
        return secretKey;
    }

    // 还原秘钥
    public static SecretKey reductionSecretKey(String key_algorithm, byte[] keyEncoded) throws Exception {
        DESedeKeySpec keySpec = new DESedeKeySpec(keyEncoded);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(key_algorithm);
        SecretKey secretKey = factory.generateSecret(keySpec);
        return secretKey;
    }

    // 加密
    public static byte[] encodedByDESede(SecretKey secretKey, String cipher_algorithm, String message) throws Exception {
        Cipher cipher = Cipher.getInstance(cipher_algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encoded = cipher.doFinal(message.getBytes());
        return encoded;
    }

    // 解密
    public static byte[] decodedByDECede(SecretKey secretKey, String cipher_algorithm, byte[] encoded) throws Exception {
        Cipher cipher = Cipher.getInstance(cipher_algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decoded = cipher.doFinal(encoded);
        return decoded;
    }
}
