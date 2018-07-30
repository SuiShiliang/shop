<%@ tag language="java" pageEncoding="UTF-8"%>
<!--  -->
<%@ attribute name="title" required="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- 设置根路径变量 -->
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title }</title>
<link href="${contextPath }/asets/bootstrap-3.3.7/dist/css/bootstrap.css" rel="stylesheet" >
<link href="${contextPath }/asets/css/index.css" rel="stylesheet">
</head>
<body>
	<div class="header">
		<ul class="menu">
			<!-- 管理员管理 -->
			<sec:authorize access="hasAnyAuthority('PERM_LOOK_ADMIN','PERM_UPDATE_ADMIN','PERM_DELETE_ADMIN','PERM_ADD_ADMIN')">
				<%-- <sec:authorize access="hasAnyAuthority('PREM_LOOK_ADMIN')">
					<li class="menuItem" onclick="window.href.location='${contextPath }/admin/findAllOperator'">查看管理员</li>
				</sec:authorize>
				
				<sec:authorize access="hasAnyAuthority('PREM_UPDATE_ADMIN')">
					<li class="menuItem" onclick="window.href.location='${contextPath }/admin/editOperator'">修改管理员</li>
				</sec:authorize>
				
				<sec:authorize access="hasAnyAuthority('PREM_DELETE_ADMIN')">
					<li class="menuItem" onclick="window.href.location='${contextPath }/admin/deleteOperator'">删除管理员</li>
				</sec:authorize>
				
				<sec:authorize access="hasAnyAuthority('PREM_ADD_ADMIN')">
					<li class="menuItem" onclick="window.href.location='${contextPath }/admin/addOperator'">添加管理员</li>
				</sec:authorize> --%>
				<li class="menuItem" onclick="window.location.href='${contextPath }/admin/manageOperator'">管理员管理</li>
			</sec:authorize>
			<!-- 商品管理 -->
			<!-- 'PERM_LOOK_COMMODITY',该权限基本都有所以不能在此显示 -->
			<sec:authorize access="hasAnyAuthority('PERM_UPDATE_COMMODITY','PERM_DELTE_COMMODITY','PERM_ADD_COMMODITY')">
				<li class="menuItem" onclick="window.location.href='${contextPath }/commodity/manageCommodity'">商品管理</li>
			</sec:authorize>
			<sec:authorize access="hasAnyAuthority('PERM_SHOPPING')">
				<li class="menuItem" onclick="window.location.href='${contextPath }/commodity/shoppingCart'">购物车</li>
			</sec:authorize>
		</ul>
	
		<div class="userDispaly">
				尊敬的
				<a href=""><sec:authentication property="principal.username"/></a>
				，欢迎登录电商城
			
			<form action="${contextPath}/logout" method="post">
				<sec:csrfInput/>
				<button type="submit">注销登录</button>
			</form>
		</div>
	</div>

	<div class="content">
		<!-- 去tag的参数（index.jsp中的title） -->
		<%-- <h2>${title }</h2> --%>
		<!-- 将tag中的内容插入到这里 -->
		<jsp:doBody></jsp:doBody>
	</div>
	<div class="footer">copyright 2018</div>
	
	<script type="text/javascript" src="${contextPath }/asets/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="${contextPath }/asets/bootstrap-3.3.7/dist/js/bootstrap.js"></script>
</body>
</html>