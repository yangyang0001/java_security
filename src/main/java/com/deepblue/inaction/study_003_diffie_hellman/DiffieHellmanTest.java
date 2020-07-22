package com.deepblue.inaction.study_003_diffie_hellman;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * G^A mod P
 */
public class DiffieHellmanTest {

    public static List<Integer> allNOList = Lists.newArrayList(3, 5, 7, 11, 13, 17, 19);

    /**
     * TODO 验证一下每一个素数都有自己的生成元
     * P为素数, G为P 的生成元
     * @param args
     */
    public static void main(String[] args) {

        for(int i = 0; i < allNOList.size(); i++) {
            // 素数P
            Integer P = allNOList.get(i);
            // G为生成元
            for(int G = 1; G <= P-1; G++) {
                // A从1-(P-2)
                for (int A = 1; A <= P-2; A++) {
                    double pow = Math.pow(G, A);
                    double mod = pow % P;
                    System.out.println("P: " + P + ", G: " + G + ", A: " + A + ", \tG^A mod P : " + mod);
                }
            }
        }

    }

}
