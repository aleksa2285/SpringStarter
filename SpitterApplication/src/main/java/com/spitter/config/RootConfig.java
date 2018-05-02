package com.spitter.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(value = "com.spitter", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value= EnableWebMvc.class)
})
public class RootConfig {

    @Bean
    public DataSource dataSource() throws NamingException {
        return (DataSource) new JndiTemplate().lookup("java:comp/env/jdbc/spitterdb");
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() throws NamingException {
//        LocalSessionFactoryBean sessionFactory  = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("com.spitter.util");
//        sessionFactory.setHibernateProperties(hibernateProperties());
//        return sessionFactory;
//    }
    @Bean
    public PlatformTransactionManager geJpaTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        try {
            transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return transactionManager;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource());
        emfb.setJpaVendorAdapter(jpaVendorAdapter());
        emfb.setJpaProperties(hibernateProperties());
        emfb.setPackagesToScan("com.spitter.util");
        return emfb;
    }
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        return adapter;
    }
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
    private final Properties hibernateProperties(){
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty("hibernate.max_fetch_depth", "3");
        hibernateProperties.setProperty("hibernate.jdbc.fetch_size", "50");
        hibernateProperties.setProperty("hibernate.jdbc.batch_size", "10");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.format_sql", "true");
        hibernateProperties.setProperty("hibernate.use_sql_comments", "true");

        return hibernateProperties;
    }

}