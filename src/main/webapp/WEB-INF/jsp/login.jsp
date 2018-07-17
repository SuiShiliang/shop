<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
</head>
<body>
	<h1>管理员</h1>
	<c:if test="${loginError }">
		<h2 style="color: red;">用户名或密码错误</h2>
	</c:if>
	
	<form action="" method="post">
		<sec:csrfInput/>
		
		<div>
			<label for="username"></label>
			<input name = "username" id="username">
		</div>
	
		<div>
			<label for="password"></label>
			<input name = "password" id="password">
		</div>
		
		<div>
			<input type="submit" value="登录">
		</div>
	
	</form>


</body>
</html>