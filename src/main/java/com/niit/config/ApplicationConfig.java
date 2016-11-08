package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;

import com.niit.DAOImpl.BlogDAOImpl;
import com.niit.DAOImpl.ForumDAOImpl;
import com.niit.DAOImpl.UserDAOImpl;
import com.niit.model.Blog;
import com.niit.model.BlogComment;
import com.niit.model.Event;
import com.niit.model.Forum;
import com.niit.model.ForumPost;
import com.niit.model.ForumPostComment;
import com.niit.model.Friend;
import com.niit.model.JobOpportunity;
import com.niit.model.UserAuthorities;
import com.niit.model.UserDetail;
import com.niit.model.Users;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit")
public class ApplicationConfig {

	/*@Bean(name = "datasource")
	public static DataSource getOracleDatasource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521/xe");
		datasource.setUsername("newuser");
		datasource.setPassword("demopasskey");
		return datasource;
	}*/
	
		@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/coldb");
		Properties connProperties = new Properties();
		connProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		connProperties.setProperty("hibernate.show_sql", "true");
		connProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

		dataSource.setUsername("sa");
		dataSource.setPassword("");

		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");		
		properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(datasource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(UserDetail.class);
		sessionBuilder.addAnnotatedClass(Users.class);
		sessionBuilder.addAnnotatedClass(UserAuthorities.class);
		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(BlogComment.class);
		sessionBuilder.addAnnotatedClass(Forum.class);
		sessionBuilder.addAnnotatedClass(ForumPost.class);
		sessionBuilder.addAnnotatedClass(ForumPostComment.class);
		sessionBuilder.addAnnotatedClass(Event.class);
		sessionBuilder.addAnnotatedClass(JobOpportunity.class);
		sessionBuilder.addAnnotatedClass(Friend.class);
		
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransctionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;

	}
	
	@Bean
	public MultipartResolver multipartResolver() {
	    org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.
	    		multipart.commons.CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(25000000);
	    return multipartResolver;
	}
	
	@Autowired
	@Bean(name = "userDAO")
	public UserDAOImpl getUserDAO(SessionFactory sessionFactory) {

		return new UserDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "blogDAO")
	public BlogDAOImpl getBlogDAO(SessionFactory sessionFactory) {

		return new BlogDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "forumDAO")
	public ForumDAOImpl getForumDAO(SessionFactory sessionFactory) {

		return new ForumDAOImpl(sessionFactory);
	}

	/*@Autowired
	@Bean(name = "newsFeedsDAO")
	public NewsFeedsDAOImpl getNewsFeedsDAO(SessionFactory sessionFactory) {

		return new NewsFeedsDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "jobDAO")
	public JobDAOImpl getJobDAO(SessionFactory sessionFactory) {

		return new JobDAOImpl(sessionFactory);
	}

	
	  
*/
	}
