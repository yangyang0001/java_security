package com.deepblue.inaction.study_007_mac_signature;

import com.deepblue.common.AlgorithmConstant;
import com.deepblue.util.HexUtil;
import com.deepblue.util.FilePrintUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/**
 * 散列函数 输出值的长度都是固定的
 */
public class HashTest {

    public static void main(String[] args) throws IOException {
        String filePath1 = "D:\\study_workspace\\java_security\\src\\main\\java\\com\\deepblue\\inaction\\study_007_mac_signature\\mac.txt";
        String filePath2 = "D:\\study_workspace\\java_security\\src\\main\\java\\com\\deepblue\\inaction\\study_007_mac_signature\\mac_copy.txt";

        /** 经验证MD系列的 散列值的长度都为 128比特即16字节 */
//        String algorithm = AlgorithmConstant.MD2.getName();    // 散列值长度: 16字节
//        String algorithm = AlgorithmConstant.MD4.getName();    // 散列值长度: 16字节
//        String algorithm = AlgorithmConstant.MD5.getName();    // 散列值长度: 16字节

        /**SHA-1 列, SHA-2系列, SHA-3系列(没有提供这种散列算法)*/
//        String algorithm = AlgorithmConstant.SHA1.getName();   // 散列值长度: 20字节
//        String algorithm = AlgorithmConstant.SHA224.getName(); // 散列值长度: 28字节
        String algorithm = AlgorithmConstant.SHA256.getName(); // 散列值长度: 32字节
//        String algorithm = AlgorithmConstant.SHA384.getName(); // 散列值长度: 48字节
//        String algorithm = AlgorithmConstant.SHA512.getName(); // 散列值长度: 64字节

        byte[] first  = getHashByFile(filePath1, algorithm);
        System.out.println("first.length:" + first.length + ",  first:  " + HexUtil.getHexByBytes(first) + ", first.hex.length: " + HexUtil.getHexByBytes(first).length());
        // f0393febe8baaa55e32f7be2a7cc180bf34e52137d99e056c817a9c07b8f239a
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        byte[] second = getHashByFile(filePath2, algorithm);
        System.out.println("second.length:" + second.length + ", second: " + HexUtil.getHexByBytes(second)+ ", second.hex.length: " + HexUtil.getHexByBytes(second).length());
        // e9c0f8b575cbfcb42ab3b78ecc87efa3b011d9a5d10b09fa4e96f240bf6a82f5

    }

    public static byte[] getHashByFile(String filePath, String algorithm) {
        byte[] result = null;
        InputStream in = null;
        try {
            System.out.println("algorithm  :" + algorithm);
            // 构造 DigestInputStream
            in = new FileInputStream(filePath);
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            DigestInputStream dis = new DigestInputStream(in, digest);
            // 将文件 读入到 digest 中
            byte[] bytes = new byte[in.available()];
            dis.read(bytes);
            // 打印 bytes
            FilePrintUtil.print(bytes);
            result = dis.getMessageDigest().digest();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
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
