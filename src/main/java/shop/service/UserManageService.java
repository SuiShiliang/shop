package shop.service;

import shop.pojo.Users;

public interface UserManageService {

	public Users findByUsername(String username);

	public void registerUser(Users user);

	public void deleteUser(Long id);

	public void updateUser(Users user);

	public void setLoginTimeByUserId(Long id);
	
	public void setLogoutTimeByUserId(Long id);

}
