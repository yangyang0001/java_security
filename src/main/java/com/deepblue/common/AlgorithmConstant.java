package com.deepblue.common;


public enum AlgorithmConstant {

    // 散列函数
    SHA("SHA"),

    MD5("MD5"),

    Mac("Mac"),

    // 对称加密算法中最好的 对称加密算法
    AES("AES"),

    DES("DES"),

    // 非对称加密算法
    DH("DH"),

    ECDH("ECDH"),

    DSA("DSA"),

    RSA("RSA");

    /**
     * 非对称机密算法
     * DH  ECDH  ECDSA  DSA  RSA
     */
    private String name;

    private AlgorithmConstant(String name) {
        this.name = name;
    }
}
