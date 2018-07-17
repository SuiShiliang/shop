<%@ tag language="java" pageEncoding="UTF-8"%>
<!--  -->
<%@ attribute name="title" required="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title }</title>
</head>
<body>

	<div class="content">
		<!-- 去tag的参数（index.jsp中的title） -->
		<h2>${title }</h2>
		<!-- 将tag中的内容插入到这里 -->
		<jsp:doBody></jsp:doBody>
	</div>
	<div class="footer">copyright 2018</div>
</body>
</html>