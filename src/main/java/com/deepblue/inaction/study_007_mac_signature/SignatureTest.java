package com.deepblue.inaction.study_007_mac_signature;

import com.deepblue.common.AlgorithmConstant;
import com.deepblue.util.FilePrintUtil;
import com.deepblue.util.HexUtil;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.Buffer;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;

public class SignatureTest {

    public static void main(String[] args) throws Exception {



        String filePath = "/Users/yangjianwei/IdeaProjects/java_security/src/main/java/com/deepblue/inaction/study_007_mac_signature/mac.txt";
        InputStream in = new FileInputStream(filePath);
        BufferedInputStream bis = new BufferedInputStream(in);
        byte[] buffer = new byte[in.available()];
        bis.read(buffer);
        FilePrintUtil.print(buffer);

        String algorithm = AlgorithmConstant.RSA.getName();
        KeyPairGenerator generator = KeyPairGenerator.getInstance(algorithm);
        generator.initialize(512);
        KeyPair keyPair = generator.generateKeyPair();

        Signature signature = Signature.getInstance(algorithm);
        signature.initSign(keyPair.getPrivate());
        signature.update(buffer);
        byte[] sign = signature.sign();
        System.out.println("signature  :" + HexUtil.getHexByBytes(sign));

        signature.initVerify(keyPair.getPublic());
        signature.update(buffer);
        boolean verify = signature.verify(sign);

        System.out.println("verify     :" + verify);


    }
}
