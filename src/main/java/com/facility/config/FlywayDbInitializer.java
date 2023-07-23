package com.facility.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.PostMapping;

import javax.sql.DataSource;
import java.sql.SQLException;

@DependsOn("mybatisConfig")
@Configuration
@Slf4j
public class FlywayDbInitializer {

    @Resource
    private DataSource dataSource;


    private static final String sqlType="mysql";
    @PostConstruct
    public void migrateFlyway() {
        try {
            String databaseProductName = dataSource.getConnection().getMetaData().getDatabaseProductName();
            if(databaseProductName.equalsIgnoreCase(sqlType)){
//                Flyway flyway = Flyway.configure().dataSource(dataSource).outOfOrder(true).locations("db/migration").load();
//                flyway.migrate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
