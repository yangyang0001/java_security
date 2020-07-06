package com.deepblue.security_004_algorithmparam;


import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;

public class AlgorithmParamTest {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        AlgorithmParameterGenerator generator = AlgorithmParameterGenerator.getInstance("DES");
        generator.init(56);
        byte[] encoded = generator.generateParameters().getEncoded();
        BigInteger bigInteger = new BigInteger(encoded);
        /**
         * encoded    :"BAi0sBIEmZO4Jw=="
         * bigInteger :19050059810401951135783
         */
        System.out.println("encoded    :" + JSON.toJSONString(encoded));
        System.out.println("bigInteger :" + bigInteger);


        AlgorithmParameters parameters = AlgorithmParameters.getInstance("DES");
        byte[] bytes = bigInteger.toByteArray();
        parameters.init(bytes);
        System.out.println(JSON.toJSONString(parameters.getEncoded()));


    }
}
