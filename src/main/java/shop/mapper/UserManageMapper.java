package shop.mapper;


import shop.pojo.Users;

public interface UserManageMapper {

	//根据用户名查找用户
	public Users findByUsername(String username);
	//用户注册
	public void registerUser(Users user);
	//删除用户
	public void deleteUser(Long id);
	//修改用户基本信息
	public void updateUser(Users user);
}
