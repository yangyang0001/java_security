package com.deepblue.inaction.study_002_byte_sequence;

import com.alibaba.fastjson.JSON;
import com.deepblue.common.Constant;

import java.util.BitSet;

/**
 * 比特序列的计算
 *      01101101    A
 * XOR
 *      11111111    B
 * -----------------------
 *      10010010    C
 * XOR
 *      11111111    B
 * ------------------------
 *      01101101    A
 */
public class ByteSequenceTest {

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("");
        char[] chars = Constant.BYTE_STR.toCharArray();
        for(char c : chars) {
            System.out.println(c + "\t比特序列:\t0" + Integer.toBinaryString(c));
        }

    }
}
