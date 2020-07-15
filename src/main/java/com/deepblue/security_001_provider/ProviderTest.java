package com.deepblue.security_001_provider;

import java.security.Provider;
import java.security.Security;
import java.util.Arrays;

public class ProviderTest {
    private static int i = 0;
    public static void main(String[] args) {
        Provider[] providers = Security.getProviders();
        Arrays.stream(providers).forEach(item -> {
            System.out.println(++i + ",name:" + item.getName() + ",version:" + item.getVersion() + ",info:" + item.getInfo());
        });
    }
}
