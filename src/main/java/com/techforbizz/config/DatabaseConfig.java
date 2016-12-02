package com.techforbizz.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

	@Autowired
	private Environment environment;
	
	@Autowired
	private DataSource dataSource;

	private Logger log = LoggerFactory.getLogger(DatabaseConfig.class);
	
  /**
   * DataSource definition for database connection. Settings are read from
   * the application.properties file (using the env object).
   */
	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName( environment.getProperty("db.driver") );
		dataSource.setUrl( environment.getProperty("db.url") );
		dataSource.setUsername( environment.getProperty("db.username") );
		dataSource.setPassword( environment.getProperty("db.password") );

		return dataSource;
	}
	
	/**
   * Declare the JPA entity manager factory.
   */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		
		entityManagerFactory.setDataSource( dataSource );
		entityManagerFactory.setPackagesToScan( environment.getProperty("entityManager.packageToScan").toString() );
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		
		entityManagerFactory.setJpaProperties(properties);
		
		return entityManagerFactory;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory( entityManagerFactory().getObject() );
		log.info("Database configurations created.");
		return transactionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
}
