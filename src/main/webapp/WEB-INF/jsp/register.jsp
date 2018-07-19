<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
</head>
<body>

	<form:form action="" method="post" commandName="usersForm">
		<div>
			<label>用户名</label> 
			<form:input path="name" />
			<form:errors path="name"></form:errors>
		</div>
		<div>
			<label>密码</label> 
			<form:input path="password"/>
			<form:errors path="password"></form:errors>
		</div>
		<div>
			<input type="submit" value="注册">
			<input type="reset" value="清除">
		</div>
		<div>
			<a href="${contextPath }/login">返回登录</a>
		</div>
	</form:form>

</body>
</html>