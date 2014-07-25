/**
 * 
 */
package com.springjavaconfig.configuration;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Harmeet Singh
 *
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.springjavaconfig.repository")
public class DBConfiguration {

	private static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://localhost/spring_test"; 
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.jdbc.Driver";  
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "root";  
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "root";
    
    @Bean
    public DataSource dataSource(){
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setUrl(PROPERTY_NAME_DATABASE_URL);
    	dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER);
    	dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
    	dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);;
    	
    	return dataSource;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
    	LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
    	factoryBean.setDataSource(dataSource());
    	factoryBean.setPersistenceProviderClass(HibernatePersistence.class);
    	factoryBean.setPackagesToScan("com.springjavaconfig.entity"); //  use Spring-based scanning for entity classes in the classpath
    	factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
    	return factoryBean;
    }

	private JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter.setDatabase(Database.MYSQL);
		jpaVendorAdapter.setGenerateDdl(true);
		return jpaVendorAdapter;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	
}
