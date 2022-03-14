/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author Cris John Alonzaga
 */
@Configuration
public class HibernateConfig {
    @Autowired
    private Environment enviroment;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(enviroment.getProperty("packagesToScan"));
        sessionFactory.setHibernateProperties(hibernateProperties());
 
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource  ds = new DriverManagerDataSource ();
        ds.setDriverClassName(enviroment.getProperty("datasource.driver-class-name"));
        ds.setUrl(enviroment.getProperty("datasource.url"));
        ds.setUsername(enviroment.getProperty("datasource.username"));
        ds.setPassword(enviroment.getProperty("datasource.password"));
 
        return ds;
    }
 
    private final Properties hibernateProperties() {
        Properties hibernate = new Properties();
        hibernate.setProperty("hibernate.hbm2ddl.auto", enviroment.getProperty("hibernate.hbm2ddl.auto"));
        hibernate.setProperty("hibernate.dialect", enviroment.getProperty("hibernate.dialect"));
        hibernate.setProperty("hibernate.show_sql", enviroment.getProperty("hibernate.show_sql"));
 
        return hibernate;
    }
}
