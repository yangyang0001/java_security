package com.deepblue.security_004_digestoutputstream;

import com.deepblue.common.AlgorithmConstant;
import com.deepblue.util.FilePrintUtil;
import com.deepblue.util.HexUtil;

import java.io.*;
import java.security.DigestOutputStream;
import java.security.MessageDigest;


/**
 * 此处的DigestOutputStream 依赖 InputStream 来获取
 */
public class DigestOutputStreamTest {

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
        BufferedInputStream bis = null;
        DigestOutputStream dos = null;
        try {
            System.out.println("algorithm  :" + algorithm);
            in = new FileInputStream(filePath);
            bis = new BufferedInputStream(in);
            byte[] bytes = new byte[in.available()];
            bis.read(bytes);
            FilePrintUtil.print(bytes);

            MessageDigest digest = MessageDigest.getInstance(algorithm);
            dos = new DigestOutputStream(new ByteArrayOutputStream(), digest);
            dos.write(bytes);
            dos.flush();
            result = dos.getMessageDigest().digest();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(bis != null) {
                    bis.close();
                }
                if(in != null) {
                    in.close();
                }
                if(dos != null) {
                    dos.flush();
                    dos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
