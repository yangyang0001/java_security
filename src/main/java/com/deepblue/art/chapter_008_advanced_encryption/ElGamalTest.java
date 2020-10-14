package com.deepblue.art.chapter_008_advanced_encryption;

import com.deepblue.common.AlgorithmConstant;
import com.deepblue.util.HexUtil;
import com.google.common.collect.Maps;
import com.sun.prism.image.CachingCompoundImage;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;

public class ElGamalTest {

    public static final String ALGORITHM = AlgorithmConstant.ELGAMAL.getName();

    public static final String PUBLIC_KEY = "publicKey";
    public static final String PRIVATE_KEY = "privateKey";

    public static Map<String, Key> KEY_MAP = Maps.newHashMap();


    public static void main(String[] args) throws Exception {
        initKey();
        String publicKeyFormat  = KEY_MAP.get(PUBLIC_KEY).getFormat();
        String privateKeyFormat = KEY_MAP.get(PRIVATE_KEY).getFormat();
        System.out.println("publicKeyFormat  :" + publicKeyFormat);
        System.out.println("privateKeyFormat :" + privateKeyFormat);
        String message = "Java加密与解密的艺术";

        // 公钥加密
        PublicKey publicKey   = reductionPublicKey(KEY_MAP.get(PUBLIC_KEY).getEncoded());
        byte[] encoded = encodedByPublicKey(publicKey, message);

        // 私钥解密
        PrivateKey privateKey = reductionPrivateKey(KEY_MAP.get(PRIVATE_KEY).getEncoded());
        byte[] decoded = decodedByPrivateKey(privateKey, encoded);

        System.out.println("原始明文 :" + message);
        System.out.println("加密后的 :" + HexUtil.getHexByBytes(encoded));
        System.out.println("解密后的 :" + HexUtil.getHexByBytes(decoded));
        System.out.println("解密明文 :" + new String(decoded));
    }

    public static void initKey() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(ALGORITHM, "BC");
        generator.initialize(1024);
        KeyPair keyPair = generator.generateKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        KEY_MAP.put(PUBLIC_KEY, publicKey);
        KEY_MAP.put(PRIVATE_KEY, privateKey);
    }

    public static PublicKey reductionPublicKey(byte[] key) throws Exception {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(key);
        KeyFactory factory = KeyFactory.getInstance(ALGORITHM, "BC");
        PublicKey publicKey = factory.generatePublic(keySpec);
        return publicKey;
    }

    public static PrivateKey reductionPrivateKey(byte[] key) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory factory = KeyFactory.getInstance(ALGORITHM, "BC");
        PrivateKey privateKey = factory.generatePrivate(keySpec);
        return privateKey;
    }

    public static byte[] encodedByPublicKey(PublicKey publicKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] publicKeyEncoded = cipher.doFinal(message.getBytes());
        return publicKeyEncoded;
    }

    public static byte[] encodedByPrivateKey(PrivateKey privateKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] privateEncoded = cipher.doFinal(message.getBytes());
        return privateEncoded;
    }

    public static byte[] decodedByPublicKey(PublicKey publicKey, byte[] encoded) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] publicDecoded = cipher.doFinal(encoded);
        return publicDecoded;
    }

    public static byte[] decodedByPrivateKey(PrivateKey privateKey, byte[] encoded) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] privateDecoded = cipher.doFinal(encoded);
        return privateDecoded;
    }


}
