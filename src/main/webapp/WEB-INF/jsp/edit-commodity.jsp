<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="title" value="${commodity.id == null ? '添加商品' : '修改商品信息'}"></c:set>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title }</title>
</head>
<body>
	<form:form action="" method="post" commandName="commodity">
		<div>
			<label>商品名</label>
			<form:input path="name"/>
		</div>
		<div>
			<label>商品品牌</label>
			<form:select path="brand">
				<form:option value="华为">华为</form:option>
				<form:option value="VIVO">VIVO</form:option>
				<form:option value="OPPO">OPPO</form:option>
				<form:option value="小米">小米</form:option>
			</form:select>
		</div>
		<div>
			<label>商品型号</label>
			<form:select path="model">
				<form:option value="I型">I型</form:option>
				<form:option value="II型">II型</form:option>
				<form:option value="III型">III型</form:option>
				<form:option value="IV型">IV型</form:option>
			</form:select>
		</div>
		<div>
			<label>操作系统</label>
			<form:select path="os">
				<form:option value="Android">Android</form:option>
				<form:option value="Apple">Apple</form:option>
				<form:option value="Mac os">Apple</form:option>
			</form:select>
		</div>
		<div>
			<label>CPU品牌</label>
			<form:input path="cpu"/>
		</div>
		<div>
			<label>运行内存</label>
			<form:input path="ram" type = "number" min = "1" max = "16"/>
		</div>
		<div>
			<label>内部存储</label>
			<form:input path="sc" type = "number" min = "16" max = "256"/>
		</div>  
		<div>
			<label>颜色</label>
			<form:input path="color"/>
		</div>
		<div>
			<label>描述</label>
			<form:input path="discription"/>
		</div>
		<div>
			<label>价格（分）</label>
			<form:input path="price" type = "number"/>
		</div>
		<div>
			<input type="submit" value="提交">
		</div>
	</form:form>
</body>
</html>