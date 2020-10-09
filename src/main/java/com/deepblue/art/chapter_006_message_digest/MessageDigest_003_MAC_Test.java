package com.deepblue.art.chapter_006_message_digest;

import com.alibaba.fastjson.JSON;
import com.deepblue.common.AlgorithmConstant;
import com.deepblue.util.HexUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.bouncycastle.util.encoders.Hex;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.K;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


/**
 * 消息认证码
 *  1、获取秘钥      对称私密秘钥
 *  2、获取消息摘要
 */
public class MessageDigest_003_MAC_Test {

    public static void main(String[] args) throws Exception {
        testHmacUtils();
    }

    public static byte[] getHmacKey(String algorithm) throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance(algorithm);
        byte[] encoded = generator.generateKey().getEncoded();
        System.out.println("GetHmacKey encoded     :" + JSON.toJSONString(encoded));
        System.out.println("GetHmacKey encoded hex :" + HexUtil.getHexByBytes(encoded));
        return encoded;
    }

    public static void testHmacUtils() throws Exception{
        String message= "Java加密与解密的艺术";
        String algorithm1 = AlgorithmConstant.HmacMD5.getName();

        byte[] key1 = getHmacKey(algorithm1);
        byte[] bytes1 = HmacUtils.getInitializedMac(algorithm1, key1).doFinal(message.getBytes());
        System.out.println("algorithm1 :" + algorithm1 + ", HmacMD5_messageDigest    :" + HexUtil.getHexByBytes(bytes1) + "\n");
    }


}
