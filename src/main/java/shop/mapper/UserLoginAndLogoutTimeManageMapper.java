package shop.mapper;

import shop.pojo.UserLoginAndLogoutTimeManage;

public interface UserLoginAndLogoutTimeManageMapper {

	// 创建用户登录信息（时间）
	public void setLoginTimeByUserId(Long id);

	// 更新用户注销时间
	public void setLogoutTimeByTimeId(Long timeId);

	// 获取最近的用户登录时间
	public UserLoginAndLogoutTimeManage getLastLoginTimeIdForUserId(Long id);
	// 删除用户登录时间小于规定时间的数据
	// public void deleteUserLoginTimeRecord(Long id,Date date);
	// 获取用户的登录记录条数--大于30条则删除第30条之后的记录信息
	// public Long getUserLoginTimeRecord(Long id);
	// 获取用户第30条登录信息
	// public Date getUserThirtiethTimeRecordLogin(Long id);
}
