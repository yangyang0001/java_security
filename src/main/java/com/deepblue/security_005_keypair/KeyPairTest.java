package com.deepblue.security_005_keypair;

import java.security.*;

public class KeyPairTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        KeyPairGenerator generator = KeyPairGenerator.getInstance("DSA");
        generator.initialize(1024);
        KeyPair keyPair = generator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        Provider provider = generator.getProvider();

        System.out.println("provider  : " + provider.getName());
        System.out.println("privateKey: " + privateKey.getFormat());
        System.out.println("publicKey : " + publicKey.getFormat());

    }

}
