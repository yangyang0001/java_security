package com.deepblue.security_001_security;

import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class SecurityTest {

    public static void main(String[] args) {

        Provider[] providers = Security.getProviders();
        AtomicInteger integer = new AtomicInteger(1);
        for (Provider p : providers) {
            System.out.println(integer + " name: " + p.getName() + ", version: " + p.getVersion() + ", info: " + p.getInfo());
            integer.incrementAndGet();
        }


    }
}
