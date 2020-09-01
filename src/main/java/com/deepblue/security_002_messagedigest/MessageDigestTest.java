package com.deepblue.security_002_messagedigest;

import com.alibaba.fastjson.JSON;
import com.deepblue.common.Constant;
import com.deepblue.util.HexUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

public class MessageDigestTest {

    private static byte[] update = "ABCDE".getBytes();

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Constant.DIGEST_ALGORITHM_LIST.stream().forEach(item -> {
            try {
                MessageDigest digest = MessageDigest.getInstance(item);
                Provider provider = digest.getProvider();
                String algorithm = digest.getAlgorithm();
                digest.update(update);
                byte[] value = digest.digest();
                System.out.println("ABCDE 字符串经过 " + algorithm + " Hash函数后, hashValue :" + HexUtil.getHexByBytes(value));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
