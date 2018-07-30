package shop.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import shop.service.UserManageService;
@Component
public class MyLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler{
	@Autowired
	private UserManageService manageService;
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		super.onLogoutSuccess(request, response, authentication);
		System.out.println("调用注销成功handle");
		//获取用户登录的信息
		UserDetailsImpl detailsImpl = (UserDetailsImpl) authentication.getPrincipal();
		//更新注销时间
		manageService.setLogoutTimeByUserId(detailsImpl.getUser().getId());
		
	}
}
