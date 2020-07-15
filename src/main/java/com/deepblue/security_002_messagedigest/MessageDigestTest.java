package com.deepblue.security_002_messagedigest;

import com.alibaba.fastjson.JSON;
import com.deepblue.common.Constant;
import com.google.common.collect.Lists;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;

public class MessageDigestTest {

    private static byte[] update = "zhangsan".getBytes();

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Constant.DIGEST_ALGORITHM_LIST.stream().forEach(item -> {
            try {
                MessageDigest digest = MessageDigest.getInstance(item);
                Provider provider = digest.getProvider();
                String algorithm = digest.getAlgorithm();
                digest.update(update);
                byte[] value = digest.digest();
                System.out.println("value:" + JSON.toJSONString(value) + ",name:" + provider.getName() + ",version:" + provider.getVersion() + ", algorithm:" + algorithm);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
