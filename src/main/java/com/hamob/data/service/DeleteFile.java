package com.hamob.data.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeleteFile {

        //递归删除文件夹
        public static boolean deleteFile(File file){

            boolean success = false;
            if (file.exists()) {
                if (file.isDirectory()) {
                    File[] files = file.listFiles();
                    for (File file1 : files) {//递归删除文件或目录
                        success = deleteFile(file1);
                    }
                } else {
                    success = file.delete();
                }
            } else {
                success = false;
            }
            return success;

        }


        public static boolean deleteDir(String dir) {

            try {
                Files.delete(Paths.get(dir));
                System.out.println("目录/文件已被删除！");
                return true;


            } catch (Exception e){

                e.printStackTrace();

                System.out.println("目录/文件删除失败！");
                return false;

            }

        }


}
