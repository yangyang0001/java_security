package com.deepblue.common;


public enum AlgorithmConstant {


    // 散列函数
    MD2("MD2"), MD4("MD4"), MD5("MD5"),
    SHA1("SHA-1"), SHA256("SHA-256"), SHA384("SHA-384"), SHA512("SHA-512"),

    // 对称加密算法中最好的 对称加密算法
    AES("AES"), DES("DES"),

    // 非对称加密算法
    RSA("AES"), DSA("DSA"), DH("DH"), ECDH("ECDH");


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
