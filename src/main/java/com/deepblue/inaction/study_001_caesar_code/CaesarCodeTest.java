package com.deepblue.inaction.study_001_caesar_code;

/**
 * 凯撒秘密 移位密码
 * 
 * 明文:
 * a b c d e f g h i j k l m n o p q r s t u v w x y z
 * 秘文:
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 */
public class CaesarCodeTest {
    
    private static String MI_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public static String parseSecurity(String securityStr, Integer key) {
        StringBuffer result = new StringBuffer("");
        char[] chars = securityStr.toCharArray();
        for(char c : chars) {
            int index = MI_STR.indexOf(c) + 26;
            String str = String.valueOf(MI_STR.charAt(index-key)).toLowerCase();
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 26; i++) {
            String result = parseSecurity("PELCGBTENCUL", i);
            System.out.println("秘钥为:\t" + i + ",\t结果:\t" + result);
        }
    }
    
    
}
