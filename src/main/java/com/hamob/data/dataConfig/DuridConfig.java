package com.hamob.data.dataConfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;


@Configuration
public class DuridConfig {


    private Logger logger = LogManager.getLogger(DuridConfig.class);


	@Autowired
	DuridProperties duridProperties;


    @Primary
    @Bean
	public DataSource druidDataSource() {
		DruidDataSource duridDataSource = new DruidDataSource();
		duridDataSource.setDriverClassName(duridProperties.getDriverClassName());
		duridDataSource.setUrl(duridProperties.getUrl());
		duridDataSource.setUsername(duridProperties.getUsername());
		duridDataSource.setPassword(duridProperties.getPassword());
		duridDataSource.setMinIdle(duridProperties.getMinIdle());
		duridDataSource.setInitialSize(duridProperties.getInitialSize());
		duridDataSource.setMaxActive(duridProperties.getMaxActive());
		duridDataSource.setTimeBetweenEvictionRunsMillis(duridProperties.getTimeBetweenEvictionRunsMillis());
		duridDataSource.setMinEvictableIdleTimeMillis(duridProperties.getMinEvictableIdleTimeMillis());
		duridDataSource.setValidationQuery(duridProperties.getValidationQuery());
		duridDataSource.setTestWhileIdle(true);
		duridDataSource.setTestOnBorrow(false);
		duridDataSource.setTestOnReturn(false);
		duridDataSource.setPoolPreparedStatements(true);
		duridDataSource.setMaxPoolPreparedStatementPerConnectionSize(duridProperties.getMaxPoolPreparedStatementPerConnectionSize());
		try {
			duridDataSource.setFilters(duridProperties.getFilters());
		}catch (SQLException e) {
			logger.error("durid configuration initalization filter"+e);
		}
		return duridDataSource;
    }

	@Bean
	public  JdbcTemplate getJdbcTemplate() {

		JdbcTemplate JdbcTemplate = new JdbcTemplate(druidDataSource());

		return JdbcTemplate;

	}
}
