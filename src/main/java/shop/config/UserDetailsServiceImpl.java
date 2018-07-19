package shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import shop.mapper.UserManageMapper;
import shop.pojo.Users;
import shop.service.impl.UserDetailsImpl;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserManageMapper userManageMapper;
	public UserDetailsServiceImpl(UserManageMapper userManageMapper) {
		this.userManageMapper = userManageMapper;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		Users user = userManageMapper.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("账号【"+username+"】未找到");
		}
		return new UserDetailsImpl(user);
	}
	
	
	
}
