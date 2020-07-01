package com.deepblue.security_003_digeststream;

import com.alibaba.fastjson.JSON;
import com.deepblue.common.AlgorithmConstant;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

public class DigestStreamTest {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        MessageDigest digest = MessageDigest.getInstance(AlgorithmConstant.MD5.name());

        byte[] bytes = "MD5".getBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        DigestInputStream dis = new DigestInputStream(bis, digest);
//        dis.read(bytes, 0, bytes.length);
        dis.read(bytes);

        byte[] digestBytes = digest.digest();
        int digestLength = digest.getDigestLength();
        String algorithm = digest.getAlgorithm();
        Provider provider = digest.getProvider();

        // bytes : "TUQ1", digestBytes : "aWkce9zDzm1dihNh8i0ErA=="
        System.out.println("bytes        : " + JSON.toJSONString(bytes) + ", digestBytes : " + JSON.toJSONString(digestBytes));
        System.out.println("digestLength : " + digestLength);
        System.out.println("algorithm    : " + algorithm);
        System.out.println("name : " + provider.getName() + ", version: " + provider.getVersion() + ", info: " + provider.getInfo());

        dis.close();

    }
}
