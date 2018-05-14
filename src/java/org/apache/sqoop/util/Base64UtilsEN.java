package org.apache.sqoop.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class Base64UtilsEN {
    private static final int CACHE_SIZE = 1024;
    public static byte[] decode(String base64) throws Exception {
        return new BASE64Decoder().decodeBuffer(base64);
    }
    public static String encodeFile(String filePath) throws Exception {
        byte[] bytes = fileToByte(filePath);
        return encode(bytes);
    }
    public static String encode(byte[] bytes) throws Exception {
        return new BASE64Encoder().encode(bytes);
    }
    public static byte[] fileToByte(String fileName) throws Exception {
        String path = Base64UtilsEN.class.getClassLoader().getResource("./"+fileName).getFile();
//        System.out.println("path = " + path);
        String routingPath = null;
        String os = System.getProperty("os.name");

        if(path.startsWith("file:")){
            routingPath = path.substring(5);
        }else {
            routingPath = path;
        }

        if(os.toLowerCase().startsWith("win")){
            routingPath = path.substring(1);
        }

        byte[] data = new byte[0];
//        System.out.println("routingPath = " + routingPath);
        File file = new File(routingPath);
        if (file.exists()) {
            FileInputStream in = new FileInputStream(file);
            ByteArrayOutputStream out = new ByteArrayOutputStream(2048);
            byte[] cache = new byte[CACHE_SIZE];
            int nRead = 0;
            while ((nRead = in.read(cache)) != -1) {
                out.write(cache, 0, nRead);
                out.flush();
            }
            out.close();
            in.close();
            data = out.toByteArray();
        }
        return data;
    }
}