package com.niit.config;

	import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.CartDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.OrderDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.dao.UserDao;
import com.niit.daoimpl.CartDaoImpl;
import com.niit.daoimpl.CategoryDaoImpl;
import com.niit.daoimpl.OrderDaoImpl;
import com.niit.daoimpl.ProductDaoImpl;
import com.niit.daoimpl.SupplierDaoImpl;
import com.niit.daoimpl.UserDaoImpl;

	@Configuration
	@ComponentScan("com.niit.config")
	@EnableTransactionManagement
	public class Hibernateconfig {
		@Autowired
		@Bean(name = "dataSource")
		public DataSource getH2DataSource() {

			DriverManagerDataSource dataSource = new DriverManagerDataSource();

			dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");

			dataSource.setDriverClassName("org.h2.Driver");

			dataSource.setUsername("sa");
			dataSource.setPassword("");

			return dataSource;
		}

		private Properties getHibernateProperties() {
			Properties properties = new Properties();
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			properties.put("hibernate.format_sql", "true");
			return properties;
		}

		@Autowired
		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) {

			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
			sessionBuilder.addProperties(getHibernateProperties());
			sessionBuilder.scanPackages("com.niit.model");
			return sessionBuilder.buildSessionFactory();
		}

		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

			return transactionManager;
		}

		@Autowired
		@Bean(name = "ProductDao")
		public ProductDao getProductDao(SessionFactory sessionFactory)

		{
			return new ProductDaoImpl(sessionFactory);
		}

		@Autowired
		@Bean(name = "CategoryDao")
		public CategoryDao getCategoryDao(SessionFactory sessionFactory)

		{
			return new CategoryDaoImpl(sessionFactory);
		}

		@Autowired
		@Bean(name = "SupplierDao")
		public SupplierDao getSupplierDao(SessionFactory sessionFactory)

		{
			return new SupplierDaoImpl(sessionFactory);
		}

		@Autowired
		@Bean(name = "UserDao")
		public UserDao getUserDao(SessionFactory sessionFactory)

		{
			return new UserDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean(name = "CartDao")
		public CartDao getCartDao(SessionFactory sessionFactory)

		{
			return new CartDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean(name = "OrderDao")
		public OrderDao getOrderDao(SessionFactory sessionFactory)

		{
			return new OrderDaoImpl(sessionFactory);
		}

	}



