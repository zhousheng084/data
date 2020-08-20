package com.hamob.data;

import com.hamob.data.listener.FileListenerFactory;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class DataApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(DataApplication.class, args);
    }

    @Autowired
    private FileListenerFactory fileListenerFactory;

    @Override
    public void run(ApplicationArguments args){
        //创建监听者
        FileAlterationMonitor fileAlterationMonitor = fileListenerFactory.getMonitor();

        try {

            fileAlterationMonitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
