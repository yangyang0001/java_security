package com.deepblue.inaction.study_009_digital_signature;

import com.deepblue.common.AlgorithmConstant;
import com.deepblue.util.HexUtil;
import java.security.*;

/**
 * 数字签名和验证
 */
public class DigitalSignatureTest {

    public static void main(String[] args) throws Exception {
        byte[] bytes = "Digital Signature".getBytes();
        String algorithm = AlgorithmConstant.RSA.getName();
        KeyPairGenerator generator = KeyPairGenerator.getInstance(algorithm);
        generator.initialize(512);
        KeyPair keyPair = generator.generateKeyPair();
        Signature signature = Signature.getInstance(generator.getAlgorithm());

        signature.initSign(keyPair.getPrivate());
        signature.update(bytes);

        byte[] sign = signature.sign();
        System.out.println("signature :" + HexUtil.getHexByBytes(sign) + ", signature.length :" + HexUtil.getHexByBytes(sign).length());

        signature.initVerify(keyPair.getPublic());
        signature.update(bytes);

        System.out.println("verify    :" + signature.verify(sign));

    }

}
