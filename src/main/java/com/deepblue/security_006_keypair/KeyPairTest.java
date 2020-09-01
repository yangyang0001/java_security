package com.deepblue.security_006_keypair;

import com.deepblue.common.AlgorithmConstant;
import com.deepblue.util.HexUtil;

import java.security.*;

public class KeyPairTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String algorithm = AlgorithmConstant.RSA.getName();
        KeyPairGenerator generator = KeyPairGenerator.getInstance(algorithm);
        generator.initialize(512);
        KeyPair keyPair = generator.generateKeyPair();
        PublicKey  aPublic  = keyPair.getPublic();
        PrivateKey aPrivate = keyPair.getPrivate();
        byte[] publicEncoded = aPublic.getEncoded();
        byte[] privatEncoded = aPrivate.getEncoded();

        /**
         * publicEncoded.length :94,  publicKey :305c300d06092a864886f70d0101010500034b003048024100bc17b09c2b91481ef86284e7a21d261bf38886cd0ad5f7a888fe532b62cad3fc6e8a5b1bd866eff9043e13cb014cd0b668be15dda72c9ea2ac7d4171daa0065b0203010001
         * privatEncoded.length :344, privatKey :30820154020100300d06092a864886f70d01010105000482013e3082013a020100024100bc17b09c2b91481ef86284e7a21d261bf38886cd0ad5f7a888fe532b62cad3fc6e8a5b1bd866eff9043e13cb014cd0b668be15dda72c9ea2ac7d4171daa0065b020301000102400fb17a4ecd63c5bcafc4a88a1b008b99716c46b2fce075555e78b9bfb8f26b555393aa296a8b78a188c7ccc3c7454e3820118dea97f38fc9b88cba92ccd140c1022100f71636061b78240aa20101331b9e04ee0a0d22436df3ede11b91ac709f9daae3022100c2e0ae4de2e847db972c853922deaaf1766563658347af32a9867f1db96a38290220665969f96fa97d6c761cea6d4c3451a074c369fcfa6fbf8aae8bd21d38d0ebb70221009b844a1585daf05d614afa161aa9afa97a5e76efefd02914390d482c24678be10220469415a9efd226a852b9b7b45eddabeed76d471339b7973a6e3f11b41be8359a
         */
        System.out.println("publicEncoded.length :" + publicEncoded.length + ", publicKey :" + HexUtil.getHexByBytes(publicEncoded));
        System.out.println("privatEncoded.length :" + privatEncoded.length + ", privatKey :" + HexUtil.getHexByBytes(privatEncoded));
    }

}
