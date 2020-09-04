package com.deepblue.inaction.study_009_digital_signature;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 数字签名和认证
 */
public class DigitalSignatureTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String reason = "就是拒绝";
        String format = String.format("您的封面不符合封面要求：(%s)，请重新上传", reason);
        System.out.println("format template:" + format);
    }

}
