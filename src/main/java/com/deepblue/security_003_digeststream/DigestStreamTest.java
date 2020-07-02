package com.deepblue.security_003_digeststream;

import com.alibaba.fastjson.JSON;
import com.deepblue.common.AlgorithmConstant;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 思考：
 *      普通的
 */
public class DigestStreamTest {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        digestInputStreamTest();
        digestOutputStreamTest();
    }

    private static void digestInputStreamTest() throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance(AlgorithmConstant.MD5.name());
        byte[] bytes = "MD5".getBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        DigestInputStream dis = new DigestInputStream(bis, digest);

        dis.read(bytes);
        byte[] disBytes = dis.getMessageDigest().digest();
        System.out.println("disBytes:" + JSON.toJSONString(disBytes));
        dis.close();
    }

    public static void digestOutputStreamTest() throws NoSuchAlgorithmException, IOException {
        byte[] bytes = "MD5".getBytes();
        MessageDigest digest = MessageDigest.getInstance(AlgorithmConstant.MD5.name());
        ByteOutputStream bos = new ByteOutputStream();
        DigestOutputStream dos = new DigestOutputStream(bos, digest);
        dos.write(bytes);
        dos.flush();

        byte[] dosBtyes = dos.getMessageDigest().digest();
        System.out.println("dosBytes:" + JSON.toJSONString(dosBtyes));
        dos.close();
    }
}
