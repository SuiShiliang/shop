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
	//创建用户登录信息（时间）
	public void setLoginTimeByUserId(Long id);
	//更新用户注销时间
	public void setLogoutTimeByUserId(Long id);
	//获取最近的用户登录时间
	public Long getLastLoginTimeIdForUserId(Long id);
	//删除用户登录时间小于规定时间的数据
	//public void deleteUserLoginTimeRecord(Long id,Date date);
	//获取用户的登录记录条数--大于30条则删除第30条之后的记录信息
	//public Long getUserLoginTimeRecord(Long id);
	//获取用户第30条登录信息
	//public Date getUserThirtiethTimeRecordLogin(Long id);
}
