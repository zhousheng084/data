package com.hamob.data.utils;

import java.io.*;

/**
 * 读取文件内容
 */
public class ReadFile {

    public static String getContent(File file){
        StringBuffer result = new StringBuffer();
        FileReader fileReader = null;
        BufferedReader br;
        try {
            fileReader = new FileReader(file);
            br = new BufferedReader(fileReader);
            String s =null;
            while((s= br.readLine()) != null){
                result.append(s);
            }
            br.close();
            fileReader.close();
            System.gc();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static byte[] readImage(String path){
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
        try {
            fileInputStream = new FileInputStream(path);
            bufferedInputStream = new BufferedInputStream(fileInputStream);

            byte [] temp = new byte[1024];
            int size = 0;
            while((size =fileInputStream.read(temp))!=-1){
                out.write(temp,0,size);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedInputStream.close();
                fileInputStream.close();
                System.gc();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }
}
