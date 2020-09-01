package com.deepblue.security_003_digestinputstream;

import com.deepblue.common.AlgorithmConstant;
import com.deepblue.util.FilePrintUtil;
import com.deepblue.util.HexUtil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class DigestInputStreamTest {

    public static void main(String[] args) {
        String filePath1 = "D:\\study_workspace\\java_security\\src\\main\\java\\com\\deepblue\\inaction\\study_007_mac_signature\\mac.txt";
        String filePath2 = "D:\\study_workspace\\java_security\\src\\main\\java\\com\\deepblue\\inaction\\study_007_mac_signature\\mac_copy.txt";

        String algorithm = AlgorithmConstant.SHA256.getName();
        byte[] hashByFile = getHashByFile(filePath1, algorithm);
        System.out.println(HexUtil.getHexByBytes(hashByFile));
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        byte[] hashByFile2 = getHashByFile(filePath2, algorithm);
        System.out.println(HexUtil.getHexByBytes(hashByFile2));

    }

    public static byte[] getHashByFile(String filePath, String algorithm) {
        byte[] result = null;
        InputStream in = null;
        DigestInputStream dis = null;
        try {
            System.out.println("algorithm  :" + algorithm);
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            in = new FileInputStream(filePath);
            dis = new DigestInputStream(in, digest);
            byte[] bytes = new byte[in.available()];
            dis.read(bytes);
            // 打印文件
            FilePrintUtil.print(bytes);
            // 计算消息摘要
            result = dis.getMessageDigest().digest();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(dis != null) {
                    dis.close();
                }
                if(in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
