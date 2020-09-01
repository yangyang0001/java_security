package com.deepblue.security_003_digestinputstream;

import java.io.FileInputStream;
import java.io.InputStream;

public class DigestInputStream {

    public static void main(String[] args) {
        try {
            InputStream in = new FileInputStream("");
            DigestInputStream dis = new DigestInputStream("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
