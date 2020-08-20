package com.hamob.data.listener;


import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

public class FileListener extends FileAlterationListenerAdaptor {

    private ListenerService listenerService;
    //构造函数注入
    public FileListener(ListenerService listenerService) {
        this.listenerService = listenerService;
    }

    //文件创建执行
    public void onFileCreate(File file){

    }

    //文件创建修改
    public void onFileChange(File file){}

    //文件创建删除
    public void onFileDelete(File file){
    }

    //目录修改
     public void onDirectoryChange(File file){}

     //目录删除
    public void onDirectoryDelete(File file){
        System.out.println("==================================");
        listenerService.delete();
    }

    //轮询开始
    public void onStart(FileAlterationObserver observer){
        //observer.addListener(new FileListener(listenerService).onDirectoryDelete(new File("\\home\\hanbang\\txt\\采集机ID_201911201427839_TXT_data_1.zip")));
        //出发业务
        listenerService.method();
    }

    //轮询结束
    public void onStop(FileAlterationObserver observer){

        //listenerService.delete();
    }
}