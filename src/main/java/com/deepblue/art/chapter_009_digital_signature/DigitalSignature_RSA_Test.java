package com.deepblue.art.chapter_009_digital_signature;

import com.deepblue.common.AlgorithmConstant;
import com.deepblue.util.HexUtil;
import com.google.common.collect.Maps;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;

/**
 * 经典数字签名算法
 */
public class DigitalSignature_RSA_Test {

    public static final String KEY_ALGORITHM = AlgorithmConstant.RSA.getName();
    public static final String SIGN_ALGORITHM = AlgorithmConstant.MD5withRSA.getName();

    public static final String PUBLIC_KEY = "publicKey";
    public static final String PRIVATE_KEY = "privateKey";

    public static Map<String, Key> KEY_MAP = Maps.newHashMap();

    public static void main(String[] args) throws Exception {
        initKey();

        PublicKey publicK   = (PublicKey) KEY_MAP.get(PUBLIC_KEY);
        PrivateKey privateK = (PrivateKey) KEY_MAP.get(PRIVATE_KEY);
        System.out.println("publicKeyFormat  :" + publicK.getFormat());
        System.out.println("privateKeyFormat :" + privateK.getFormat());

        PrivateKey privateKey = reductionPrivateKey(privateK.getEncoded());
        PublicKey publicKey   = reductionPublicKey(publicK.getEncoded());

        String message = "要签名的消息";
        byte[] signature = signature(privateKey, message);
        boolean verify = verify(publicKey, message, signature);

        System.out.println("签名消息 :" + message);
        System.out.println("数字签名 :" + HexUtil.getHexByBytes(signature));
        System.out.println("认证结果 :" + verify);

    }

    public static void initKey() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        generator.initialize(1024);
        KeyPair keyPair = generator.generateKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        KEY_MAP.put(PUBLIC_KEY, publicKey);
        KEY_MAP.put(PRIVATE_KEY, privateKey);
    }

    public static PublicKey reductionPublicKey(byte[] key) throws Exception {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(key);
        KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = factory.generatePublic(keySpec);
        return publicKey;
    }

    public static PrivateKey reductionPrivateKey(byte[] key) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(key);
        KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = factory.generatePrivate(keySpec);
        return privateKey;
    }

    public static byte[] signature(PrivateKey privateKey, String message) throws Exception {
        Signature signature = Signature.getInstance(SIGN_ALGORITHM);
        signature.initSign(privateKey);
        signature.update(message.getBytes());
        byte[] sign = signature.sign();
        return sign;
    }

    public static boolean verify(PublicKey publicKey, String message, byte[] sign) throws Exception {
        Signature signature = Signature.getInstance(SIGN_ALGORITHM);
        signature.initVerify(publicKey);
        signature.update(message.getBytes());
        boolean verify = signature.verify(sign);
        return verify;
    }
}
