package shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import shop.mapper.UserManageMapper;
import shop.pojo.Users;
import shop.service.UserManageService;
@Service
public class UserManageServiceImpl implements UserManageService {

	@Autowired
	private UserManageMapper userManageMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Users findByUsername(String username) {
		return null;
	}

	@Override
	public void registerUser(Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userManageMapper.registerUser(user);
	}

	@Override
	public void deleteUser(Long id) {

	}

	@Override
	public void updateUser(Users user) {

	}

}
