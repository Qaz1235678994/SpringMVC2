// 測試區要補上跟正式區一樣的路徑，模擬正式環境
package core.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.SpringSessionContext;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("web.*.*.impl")
@EnableTransactionManagement
public class TestConfig {

	// 二托
	@Bean
	 public DataSource dataSource() throws IllegalArgumentException, NamingException {
	  return new DriverManagerDataSource(
			  // 因為測試無法使用 JNDI 要自己補資料庫連線三寶(路徑,名稱,密碼)
			  "jdbc:mysql:///JAVA_FRAMEWORK",
			  "root",
			  "123456"
			  );
	 }
	
	
	@Bean
	 public SessionFactory sessionFactory() throws IllegalArgumentException, NamingException {
	  return new LocalSessionFactoryBuilder(dataSource())
	    .scanPackages("web.*.entity")
	    .addProperties(getHibernateProperties())
	    .buildSessionFactory();
	 }

	 private Properties getHibernateProperties() {
	  Properties properties = new Properties();
	  properties.setProperty("hibernate.dialect", MySQLDialect.class.getName());
	  properties.setProperty("hibernate.show_sql", "true");
	  properties.setProperty("hibernate.format_sql", "true");
	  properties.setProperty("hibernate.current_session_context_class", SpringSessionContext.class.getName());
	  return properties;
	 }
	 
	 // 託管交易管理器
	 @Bean
	 public TransactionManager transactionManager() throws IllegalArgumentException, NamingException {
	  return new HibernateTransactionManager(sessionFactory());
	 }
	
}
