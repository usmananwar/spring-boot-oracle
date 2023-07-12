//package com.bezkoder.spring.oracle.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class OracleDataSourceConfig {
//
//    @Value("${spring.datasource.url}")
//    String databaseUrl;
//
//
//    @Value("${spring.datasource.username}")
//    String databaseUserName;
//
//    @Value("${spring.datasource.password}")
//    String databasePassword;
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//        dataSource.setUrl(databaseUrl);
//        dataSource.setUsername(databaseUserName);
//        dataSource.setPassword(databasePassword);
//        return dataSource;
//    }
//}