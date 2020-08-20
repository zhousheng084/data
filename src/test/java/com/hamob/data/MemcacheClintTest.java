package com.hamob.data;

import com.hamob.data.service.MemcachedRunner;
import net.spy.memcached.MemcachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.SocketAddress;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemcacheClintTest {

    @Autowired
    MemcachedRunner memcachedRunner;

    @Test
    public void ClientConnet(){
        MemcachedClient client = memcachedRunner.getClient();
        Map<SocketAddress, Map<String, String>> stats = client.getStats();
        client.add("zhou",1,25);
        String age = client.get("zhou").toString();
        System.out.println(stats);
        System.out.println(age);
    }
}
