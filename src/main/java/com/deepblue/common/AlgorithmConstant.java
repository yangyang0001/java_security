package com.deepblue.common;


import org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi;

public enum AlgorithmConstant {


    // 散列函数
    MD2("MD2"), MD4("MD4"), MD5("MD5"),
    SHA1("SHA-1"), SHA224("SHA-224"), SHA256("SHA-256"), SHA384("SHA-384"), SHA512("SHA-512"),
    HmacMD5("HmacMD5"), HmacSHA1("HmacSHA1"), HmacSHA256("HmacSHA256"), HmacSHA384("HmacSHA384"), HmacSHA512("HmacSHA512"),

    // 对称加密算法中最好的 对称加密算法
    AES("AES"), DES("DES"), DESede("DESede"),IDEA("IDEA"),
    PBEWithMD5AndDES("PBEWithMD5AndDES"),

    // 非对称加密算法
    RSA("RSA"), ELGAMAL("ElGamal"), DSA("DSA"), DH("DH"), ECDH("ECDH"), ECDSA("ECDSA"),

    // 数字签名算法
    MD5withRSA("MD5withRSA"), SHA1withDSA("SHA1withDSA"), SHA512withECDSA("SHA512withECDSA");


    private String name;

    private AlgorithmConstant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
