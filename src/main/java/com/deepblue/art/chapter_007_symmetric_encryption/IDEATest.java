package com.deepblue.art.chapter_007_symmetric_encryption;

import com.deepblue.common.AlgorithmConstant;
import com.deepblue.util.HexUtil;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 当前这种加密需要 引入 Bouncy Castle 来提供
 */
public class IDEATest {

    public static void main(String[] args) throws Exception {
        String message = "原始需要机密的明文";
        String key_algorithm = AlgorithmConstant.IDEA.getName();
        String cipher_algorithm = "IDEA/ECB/ISO10126Padding";

        // 生成秘钥
        SecretKey generatorSecretKey = generatorSecretKey(key_algorithm);
        // 加密
        byte[] encoded = encodedByIDEA(generatorSecretKey, cipher_algorithm, message);

        // 还原秘钥
        SecretKey reductionSecretKey = reductionSecretKey(key_algorithm, generatorSecretKey.getEncoded());
        // 解密
        byte[] decoded = decodedByIDEA(reductionSecretKey, cipher_algorithm, encoded);

        System.out.println("原始明文 :" + message);
        System.out.println("加密后的 :" + HexUtil.getHexByBytes(encoded));
        System.out.println("解密后的 :" + HexUtil.getHexByBytes(decoded));
        System.out.println("解密明文 :" + new String(decoded));

    }

    // 生成秘钥
    public static SecretKey generatorSecretKey(String key_algorithm) throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance(key_algorithm, "BC");
        SecretKey secretKey = generator.generateKey();
        return secretKey;
    }

    // 还原秘钥, 这里需要特殊处理
    public static SecretKey reductionSecretKey(String key_algorithm, byte[] keyEncoded) throws Exception {
        SecretKey secretKey = new SecretKeySpec(keyEncoded, key_algorithm);
        return secretKey;
    }

    // 加密
    public static byte[] encodedByIDEA(SecretKey secretKey, String cipher_algorithm, String message) throws Exception {
        Cipher cipher = Cipher.getInstance(cipher_algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encoded = cipher.doFinal(message.getBytes());
        return encoded;
    }

    // 解密
    public static byte[] decodedByIDEA(SecretKey secretKey, String cipher_algorithm, byte[] encoded) throws Exception {
        Cipher cipher = Cipher.getInstance(cipher_algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decoded = cipher.doFinal(encoded);
        return decoded;
    }
}
