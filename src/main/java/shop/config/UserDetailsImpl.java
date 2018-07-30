package shop.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import shop.pojo.Users;

public class UserDetailsImpl extends User{
	private static final long serialVersionUID = 1L;
	private Users user;

	public UserDetailsImpl(Users user) {
		super(
				user.getName(), 
				user.getPassword(),
				buildAuthorities(user)
				);
		this.user = user;
	}
	
	public static List<GrantedAuthority> buildAuthorities(Users user){
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole().getName()));
		//lambda表达式
		user.getRole().getPermissions().forEach(
				per -> {
					authorities.add(new SimpleGrantedAuthority("PERM_"+per.getName()));
					});
		return authorities;
	}
	
	public Users getUser() {
		return user;
	}

}
