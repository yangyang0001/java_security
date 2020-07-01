package com.deepblue.common;


public enum AlgorithmConstant {

    SHA("SHA"),

    MD5("MD5"),

    // 对称加密算法中最好的 对称加密算法
    AES("AES");

    private String name;

    private AlgorithmConstant(String name) {
        this.name = name;
    }
}
