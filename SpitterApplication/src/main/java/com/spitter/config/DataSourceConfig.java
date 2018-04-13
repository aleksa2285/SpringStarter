//package com.spitter.config;
//
//import org.springframework.context.annotation.*;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jndi.JndiTemplate;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//
//@Configuration
//
//
//public class DataSourceConfig {
//
//    @Bean
//    @Primary
//    public DataSource dataSource() throws NamingException {
//        return (DataSource) new JndiTemplate().lookup("java:comp/env/jdbc/spitterdb");
//    }
//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource){
//        return new JdbcTemplate(dataSource);
//   }
//
//}
