package shop.controller.form;


import javax.validation.constraints.Size;

import shop.pojo.Sex;
import shop.pojo.Users;

public class UsersForm {
	
	private Long id; 
	@Size(min = 2,max = 256 ,message = "2~256")
	private String name; 
	@Size(min = 6,max = 128 ,message = "2~128")
	private String password; 
	private Sex sex; 
	private int age;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	} 

	public Users toUsers() {
		Users users = new Users();
		users.setName(name);
		users.setPassword(password);
		users.setSex(Sex.男);
		users.setAge(15);
		return users;
	}
}
