package com.deepblue.art.chapter_007_symmetric_encryption;

import com.deepblue.common.AlgorithmConstant;
import com.deepblue.util.HexUtil;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;

public class AESTest {

    public static void main(String[] args) throws Exception {

        String key_algorithm = AlgorithmConstant.AES.getName();
        String cipher_algorithm = "AES/ECB/PKCS5Padding";

        String message = "Java加密与解密的艺术";

        // 生成秘钥
        SecretKey generatorSecretKey = generatorSecretKey(key_algorithm);
        // 加密
        byte[] encoded = encodedByAES(generatorSecretKey, cipher_algorithm, message);

        // 还原秘钥
        SecretKey reductionSecretKey = reductionSecretKey(key_algorithm, generatorSecretKey.getEncoded());
        // 解密
        byte[] decoded = decodedByAES(reductionSecretKey, cipher_algorithm, encoded);


        System.out.println("原始明文 :" + message);
        System.out.println("加密后的 :" + HexUtil.getHexByBytes(encoded));
        System.out.println("解密后的 :" + HexUtil.getHexByBytes(decoded));
        System.out.println("解密明文 :" + new String(decoded));

    }


    /**
     * 生成秘钥
     */
    public static SecretKey generatorSecretKey(String key_algorithm) throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance(key_algorithm);
        SecretKey secretKey = generator.generateKey();
        return secretKey;
    }


    /**
     * 还原秘钥
     */
    public static SecretKey reductionSecretKey(String key_algorithm, byte[] key_encoded) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(key_encoded, key_algorithm);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(key_algorithm);
        SecretKey reductionKey = factory.generateSecret(keySpec);
        return reductionKey;
    }


    /**
     * 加密
     */
    public static byte[] encodedByAES(SecretKey secretKey, String cipher_algorithm, String message) throws Exception {
        Cipher cipher = Cipher.getInstance(cipher_algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encoded = cipher.doFinal(message.getBytes());
        return encoded;
    }

    /**
     * 解密
     */
    public static byte[] decodedByAES(SecretKey secretKey, String cipher_algorithm, byte[] encoded) throws Exception {
        Cipher cipher = Cipher.getInstance(cipher_algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decoded = cipher.doFinal(encoded);
        return decoded;
    }

}
