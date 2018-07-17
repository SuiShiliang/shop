package shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

@Configuration
@EnableWebSecurity // 获得了springSecurityFilterChain组件
@EnableGlobalMethodSecurity(prePostEnabled = true)  // 开启方法级别权限检查支持（@PreAuthorize）
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/**").authenticated()
		
		.and()
		
		.sessionManagement()
		.maximumSessions(1)
		.sessionRegistry(sessionRegistry())
		.and()
		
		.and()
		
		.formLogin()
		.loginPage("/login")
		.defaultSuccessUrl("/");
	}
	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}
}
