package shop.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("shop")
public class AppConfig extends WebMvcConfigurerAdapter{

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/jsp",".jsp");
	}
	@Bean
	public DataSource dataSource(Environment env) {
		String jdbcurl = env.getProperty("");
		String username = env.getProperty("");
		String password = env.getProperty("");
		String driverClassName = env.getProperty("");
		DriverManagerDataSource ds = 
				new DriverManagerDataSource(jdbcurl,username,password);
		ds.setDriverClassName(driverClassName);
		return ds;
	}
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource ds) {
		SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
		sf.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		sf.setDataSource(ds);
		return sf;

	}
}
