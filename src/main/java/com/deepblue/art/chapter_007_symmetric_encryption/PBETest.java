package com.deepblue.art.chapter_007_symmetric_encryption;

import com.deepblue.util.HexUtil;
import org.checkerframework.checker.units.qual.C;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PBETest {

    public static void main(String[] args) throws Exception {
        // 需要加密的 信息
        String message = "Java加密与解密艺术";

        // 算法
        String algorithm = "PBEWithMD5AndDES";
        // 口令
        String password = "Yang199001";
        // 盐
        byte[] salt = initSalt();
        // 加密迭代次数
        int count = 100;

        // 生成秘钥
        SecretKey generatorSecretKey = generatorSecretKey(algorithm, password);
        // 加密
        byte[] encoded = encodedByPBE(generatorSecretKey, algorithm, salt, count, message);

        // 还原秘钥
        SecretKey secretKey = reductionSecretKey(algorithm, password);
        // 解密
        byte[] decoded = decodedByPBE(secretKey, algorithm, salt, count, encoded);

        System.out.println("原始明文 :" + message);
        System.out.println("加密后的 :" + HexUtil.getHexByBytes(encoded));
        System.out.println("解密后的 :" + HexUtil.getHexByBytes(decoded));
        System.out.println("解密明文 :" + new String(decoded));

    }

    /**
     * 初始化盐
     * @return
     */
    public static byte[] initSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = secureRandom.generateSeed(8);
        return salt;
    }

    /**
     * 生成秘钥
     * 生成秘钥 和 还原秘钥 是一样的功能
     * @return
     */
    public static SecretKey generatorSecretKey(String algorithm, String password) throws Exception {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory factory = SecretKeyFactory.getInstance(algorithm);
        SecretKey secretKey = factory.generateSecret(keySpec);
        return secretKey;
    }

    /**
     * 还原秘钥
     * 生成秘钥 和 还原秘钥 是一样的功能
     * @return
     */
    public static SecretKey reductionSecretKey(String algorithm, String password) throws Exception {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory factory = SecretKeyFactory.getInstance(algorithm);
        SecretKey secretKey = factory.generateSecret(keySpec);
        return secretKey;
    }

    /**
     * 加密
     * @return
     */
    public static byte[] encodedByPBE(SecretKey secretKey, String algorithm, byte[] salt, int count, String message) throws Exception {
        PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, count);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);
        byte[] encoded = cipher.doFinal(message.getBytes());
        return encoded;
    }

    /**
     * 解密
     * @return
     */
    public static byte[] decodedByPBE(SecretKey secretKey, String algorithm, byte[] salt, int count, byte[] encoded) throws Exception {
        PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, count);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);
        byte[] decoded = cipher.doFinal(encoded);
        return decoded;
    }

}
