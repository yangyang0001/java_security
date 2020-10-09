package com.deepblue.art.chapter_007_symmetric_encryption;

import com.alibaba.fastjson.JSON;
import com.deepblue.common.AlgorithmConstant;
import com.deepblue.util.HexUtil;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.text.CharacterIterator;

public class DESTest {

    public static void main(String[] args) throws Exception {
        String message = "Java加密与解密的艺术_YANG";
        String key_algorithm = AlgorithmConstant.DES.getName();
        String cipher_algorithm = "DES/ECB/PKCS5Padding";

        // 生成秘钥
        SecretKey generatorKey = generatorSecretKey(key_algorithm);
        // 加密
        byte[] encoded = encodedByDES(generatorKey, cipher_algorithm, message);

        // 还原秘钥
        SecretKey reductionKey = reductionSecretKey(key_algorithm, generatorKey.getEncoded());
        // 解密
        byte[] decoded = decodedByDES(reductionKey, cipher_algorithm, encoded);

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
        generator.init(56);
        SecretKey secretKey = generator.generateKey();
        return secretKey;
    }

    /**
     * 还原秘钥
     * @param key_algorithm
     * @param keyEncoded
     * @return
     */
    public static SecretKey reductionSecretKey(String key_algorithm, byte[] keyEncoded) throws Exception {
        DESKeySpec keySpec = new DESKeySpec(keyEncoded);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(key_algorithm);
        SecretKey secretKey = factory.generateSecret(keySpec);
        return secretKey;
    }

    /**
     * 加密
     */
    public static byte[] encodedByDES(SecretKey secretKey, String cipher_algorithm, String message) throws Exception {
        Cipher cipher = Cipher.getInstance(cipher_algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encoded = cipher.doFinal(message.getBytes());
        return encoded;
    }

    /**
     * 解密
     */
    public static byte[] decodedByDES(SecretKey secretKey, String cipher_algorithm, byte[] encoded) throws Exception {
        Cipher cipher = Cipher.getInstance(cipher_algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decoded = cipher.doFinal(encoded);
        return decoded;
    }




}
