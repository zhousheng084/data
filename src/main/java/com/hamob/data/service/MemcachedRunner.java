package com.hamob.data.service;

import net.spy.memcached.MemcachedClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.InetSocketAddress;

@Component
@Order(1)
public class MemcachedRunner implements CommandLineRunner {

    private Logger logger = LogManager.getLogger(MemcachedRunner.class);

    @Resource
    private MemcacheSource memcacheSource;

    private MemcachedClient client;


    @Override
    public void run(String... args){

                try{
                    client = new MemcachedClient(new InetSocketAddress(memcacheSource.getIp(), memcacheSource.getPort()));
                }catch (IOException e){
                    logger.error("init MemcacheClinet failed"+ e);
                }

    }


    public MemcachedClient getClient() {
        return client;
    }

}
