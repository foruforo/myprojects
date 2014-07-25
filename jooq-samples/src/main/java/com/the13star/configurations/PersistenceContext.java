/**
 * 
 */
package com.the13star.configurations;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Programmers
 *
 */
@Configuration
@ComponentScan({"com.the13star.service.test", "com.the13star.service.impl", "com.the13star.dao.impl" })
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class PersistenceContext {

	@Autowired
	private Environment environment;

	@Bean(destroyMethod = "close") // destroyMethod attribute is used to close the bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("db.driver").trim());
		dataSource.setUrl(environment.getRequiredProperty("db.url").trim());
		dataSource.setUsername(environment.getRequiredProperty("db.username").trim());
		dataSource.setPassword(environment.getRequiredProperty("db.password").trim());
		dataSource.setInitialSize(5);
		dataSource.setMaxTotal(5);
		return dataSource;
	}

	// To delay opening a jdbc connection until the first actual sql statement
	// happens use LazyConnectionDataSourceProxy
	@Bean
	public LazyConnectionDataSourceProxy lazyConnectionDataSource() {
		return new LazyConnectionDataSourceProxy(dataSource());
	}

	// Configure jOOQ's ConnectionProvider to use Spring's
	// TransactionAwareDataSourceProxy,
	// which can dynamically discover the transaction context
	/**
	 * Configure the TransactionAwareDataSourceProxy bean. This bean ensures
	 * that all JDBC connection are aware of Spring-managed transactions. In
	 * other words, JDBC connections participates in thread-bound transactions
	 */
	@Bean
	public TransactionAwareDataSourceProxy transactionAwareDataSource() {
		return new TransactionAwareDataSourceProxy(lazyConnectionDataSource());
	}

	/**
	 * Configure the DataSourceTransactionManager bean. We must pass the
	 * LazyConnectionDataSourceProxy bean as as constructor argument when we
	 * create a new DataSourceTransactionManager object.
	 */
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() {
		return new DataSourceTransactionManager(lazyConnectionDataSource());
	}

	/**
	 * Configure the DataSourceConnectionProvider bean. jOOQ will get the used
	 * connections from the DataSource given as a constructor argument. We must
	 * pass the TransactionAwareDataSourceProxy bean as a constructor argument
	 * when we create a new DataSourceConnectionProvider object. This ensures
	 * that the queries created jOOQ participate in Spring-managed transactions.
	 */
	@Bean
	public DataSourceConnectionProvider connectionProvider() {
		return new DataSourceConnectionProvider(transactionAwareDataSource());
	}

	@Bean
	public JOOQToSpringExceptionTransformer jooqToSpringExceptionTranslator() {
		return new JOOQToSpringExceptionTransformer();
	}

	/**
	 * Invoking an internal, package-private constructor for the example
	 * Implement your own Configuration for more reliable behaviour
	 */
	@Bean
	public DefaultConfiguration configuration() {
		DefaultConfiguration configuration = new DefaultConfiguration();
		configuration.set(connectionProvider());
		configuration.set(new DefaultExecuteListenerProvider(
				jooqToSpringExceptionTranslator()));

		String sqlDialect = environment.getRequiredProperty("jooq.sql.dialect");
		SQLDialect dialect = SQLDialect.valueOf(sqlDialect);
		configuration.set(dialect);

		return configuration;

	}

	/**
	 * Configure the DSL object, optionally overriding jOOQ Exceptions with
	 * Spring Exceptions. We use this bean when we are creating database queries
	 * with jOOQ.
	 */
	@Bean
	public DSLContext dslContext() {
		return new DefaultDSLContext(configuration());
	}

	/**
	 * We use this bean to create the database schema for database when our
	 * application is started (If you don’t use an embedded database, you don’t
	 * have to configure this bean).
	 */
	/*
	@Bean
	public DataSourceInitializer dataSourceInitializer() {
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource());
		
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScript(new ClassPathResource(environment.getRequiredProperty("")));
		
		dataSourceInitializer.setDatabasePopulator(databasePopulator);
		return dataSourceInitializer;
	}*/
}
