package shop.pojo;

import java.util.Date;

public class UserLoginAndLogoutTimeManage {
	private Long id;
	private Boolean isuer;
	private Date loginTime; 
	private Date logoutTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getIsuer() {
		return isuer;
	}
	public void setIsuer(Boolean isuer) {
		this.isuer = isuer;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Date getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	} 
	
}
