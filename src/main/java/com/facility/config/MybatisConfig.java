package com.facility.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
public class MybatisConfig {


    @Resource
    private DataSource dataSource;

    @Value("${spring.datasource.driver-class-name}")
    private String datasourceDriveClassName;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @PostConstruct
    public void init(){

    }
}
