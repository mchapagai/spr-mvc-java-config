package com.examples.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * @author mchapagai
 * Equivalent to xml-equivalent/datasourse-config.xml
 */
@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:swe.properties"})
@ComponentScan({"com.examples"})
public class DataSourceConfig {

    private static final String PROPERTY_NAME_DATA_SOURCE = "jdbc.driverClassName";
    private static final String PROPERTY_NAME_URL = "jdbc.url";
    private static final String PROPERTY_NAME_USERNAME = "jdbc.username";
    private static final String PROPERTY_NAME_PASSWORD = "jdbc.password";
    
	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL = "hibernate.hbm2ddl.auto";
	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

    @Autowired
    private Environment env;

    /**
     * Manages the JDBC connection
     * @return comboPooledDataSource
     */
    @Bean (name = "dataSource")
    public DataSource dataSource() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        try {
            comboPooledDataSource.setDriverClass(env.getRequiredProperty(PROPERTY_NAME_DATA_SOURCE));
            comboPooledDataSource.setJdbcUrl(env.getRequiredProperty(PROPERTY_NAME_URL));
            comboPooledDataSource.setUser(env.getRequiredProperty(PROPERTY_NAME_USERNAME));
            comboPooledDataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_PASSWORD));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        return comboPooledDataSource;
    }
    
    /**
     * SessionFactory management
     * @return sessionFactory
     */
	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL));
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		return properties;
	}
	
	/**
	 * Hibernate4 ORM
	 * Manages the Object Relational Mapping
	 * @param sessionFactory
	 * @return transaction
	 */
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transaction = new HibernateTransactionManager();
		transaction.setSessionFactory(sessionFactory);
		return transaction;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
}
