package com.deepblue.common;

import com.google.common.collect.Lists;

import java.util.List;

public class Constant {
    public static List<String> DIGEST_ALGORITHM_LIST = Lists.newArrayList("MD2", "MD5", "SHA-1", "SHA-256", "SHA-384", "SHA-512");
    public static List<String> DC_ALGORITHM_LIST     = Lists.newArrayList("AES", "DES");
    public static List<String> UDC_ALGORITHM_LIST    = Lists.newArrayList("RSA", "DSA", "DH", "ECDH");
}
