package shop.config;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private MyLoginSuccessHandle loginSuccessHandle;
	@Autowired
	private MyLogoutSuccessHandler logoutSuccessHandler;
	
	// 默认所有请求都需要登录，对于这个后台管理系统来说，可以不改
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()// 配置页面授权
		.antMatchers("/regUser","/login","/asets/**").permitAll()// 登录页面允许所有用户访问（包括匿名）
//		.antMatchers("/regUser").permitAll()
//		.antMatchers("/login").permitAll()
		.antMatchers("/**").authenticated()// 其他页面仅限于登录用户访问
		
		.and().sessionManagement()// 配置会话管理
			.maximumSessions(1)// 指定每个账号最多同时活跃会话数，为1表示同一个用户名二次登录会使第一次登录失效
			.sessionRegistry(sessionRegistry())// 注入会话注册表
		
		.and()
		
		.and().formLogin()// 配置表单登录 -登录配置
			.loginPage("/login")// 指定登录页面的路径：显示表单（自己写） GET /login；提交表单（springsecurity自带） POST /login
			.defaultSuccessUrl("/")// 指定默认的登录成功页面（比如直接访问登录页面，而不是其他需要登录的页面触发的）
			.successHandler(loginSuccessHandle)
		
		.and().logout()//注销配置
			.logoutSuccessUrl("/")
			.logoutSuccessHandler(logoutSuccessHandler)
			
		;
		
	}
	
	
	@Bean // 维护Map<UserDetailsImpl, SessionIdSet>，可以从中获取当前有哪些登录用户及其会话
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}
}
