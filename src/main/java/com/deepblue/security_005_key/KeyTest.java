package com.deepblue.security_005_key;

import com.google.common.collect.Lists;

import javax.crypto.SecretKey;
import java.lang.reflect.Type;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

public class KeyTest {
    public static void main(String[] args) {
        Key key = null;
        ArrayList<Class<?>> classList = Lists.newArrayList();
        classList.add(SecretKey.class);
        classList.add(PublicKey.class);
        classList.add(PrivateKey.class);

        for (Class<?> clazz : classList) {
            Type[] genericInterfaces = clazz.getGenericInterfaces();
            System.out.println("clazzName :" + clazz.getSimpleName());
            for (Type type : genericInterfaces) {
                System.out.println(type.getTypeName());
            }
            System.out.println("---------------------------------------------------------------------------------------");
        }
    }
}
