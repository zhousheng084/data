package com.hamob.data;

import com.hamob.data.dataConfig.DuridConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@SpringBootTest
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
class DataApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Autowired
//    DuridConfig duridConfig;

    @Test
    void contextLoads() {

       // JdbcTemplate jdbcTemplate=  duridConfig.getJdbcTemplate();

        List<Map<String, Object>> keyList = jdbcTemplate.queryForList("select * from keywords ");
        System.out.println(keyList.size());
    }

}
