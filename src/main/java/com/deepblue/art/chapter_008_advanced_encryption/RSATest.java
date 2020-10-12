package com.deepblue.art.chapter_008_advanced_encryption;

import com.deepblue.common.AlgorithmConstant;
import com.deepblue.util.HexUtil;
import com.google.common.collect.Maps;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;

public class RSATest {

    public static final String ALGORITHM  = AlgorithmConstant.RSA.getName();
    public static final String PUBLIC_KEY  = "RSA_PUBLIC";
    public static final String PRIVATE_KEY = "RSA_PRIVATE";

    public static Map<String, Key> KEY_MAP = Maps.newHashMap();

    public static void main(String[] args) throws Exception {
        String message = "需要加密的数据";
        // 初始化公私钥
        initKey();
        byte[] publicEncoded  = KEY_MAP.get(PUBLIC_KEY).getEncoded();
        byte[] privateEncoded = KEY_MAP.get(PRIVATE_KEY).getEncoded();

        PublicKey publicKey   = reductionPublicKey(publicEncoded);
        PrivateKey privateKey = reductionPrivateKey(privateEncoded);

        // 公钥加密
        byte[] encoded = encodedByPublicKey(publicKey, message);
        // 私钥解密
        byte[] decoded = decodedByPrivateKey(privateKey, encoded);

        System.out.println("原始明文 :" + message);
        System.out.println("加密后的 :" + HexUtil.getHexByBytes(encoded));
        System.out.println("解密后的 :" + HexUtil.getHexByBytes(decoded));
        System.out.println("解密明文 :" + new String(decoded));
    }

    // 生成密钥对
    public static void initKey() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM);
        KeyPair keyPair = generator.generateKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        KEY_MAP.put(PUBLIC_KEY, publicKey);
        KEY_MAP.put(PRIVATE_KEY, privateKey);
    }

    // 还原公钥
    public static PublicKey reductionPublicKey(byte[] key) throws Exception {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(key);
        KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
        PublicKey publicKey = factory.generatePublic(keySpec);
        return publicKey;
    }

    // 还原私钥
    public static PrivateKey reductionPrivateKey(byte[] key) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
        PrivateKey privateKey = factory.generatePrivate(keySpec);
        return privateKey;
    }

    // 公钥加密
    public static byte[] encodedByPublicKey(PublicKey publicKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] publicEncoded = cipher.doFinal(message.getBytes());
        return publicEncoded;
    }

    // 私钥加密
    public static byte[] encodedByPrivateKey(PrivateKey privateKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] privateEncoded = cipher.doFinal(message.getBytes());
        return privateEncoded;
    }

    // 公钥解密
    public static byte[] decodedByPublicKey(PublicKey publicKey, byte[] encoded) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] publicDecoded = cipher.doFinal(encoded);
        return publicDecoded;
    }

    // 私钥解密
    public static byte[] decodedByPrivateKey(PrivateKey privateKey, byte[] encoded) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] privateDecoded = cipher.doFinal(encoded);
        return privateDecoded;
    }
}
