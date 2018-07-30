<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加到购物车</title>

<style type="text/css">
.input_style{
	background-color: rgb(235, 235, 228);
	border: 0;
}
</style>
</head>
<body>
	<form:form action="${contextPath }/commodity/addToShoppingCart" method="post" commandName="shoppingCartForm">
		<div style="width:300px; border: 1px solid;">
			<form:hidden path="id"/>
			<div>
				<label>商品名</label>
				<form:input path="name" readonly="true" cssClass="input_style"/>
			</div>
			<div>
				<label>商品品牌</label>
				<form:input path="brand" readonly="true" cssClass="input_style"/>
			</div>
			<div>
				<label>商品型号</label>
				<form:input path="model" readonly="true" cssClass="input_style"/>
			</div>
			<div>
				<label>操作系统</label>
				<form:input path="os" readonly="true" cssClass="input_style"/>
			</div>
			<div>
				<label>CPU品牌</label>
				<form:input path="cpu" readonly="true" cssClass="input_style"/>
			</div>
			<div>
				<label>运行内存</label>
				<form:input path="ram" readonly="true" cssClass="input_style"/>
			</div>
			<div>
				<label>内部存储</label>
				<form:input path="sc" readonly="true" cssClass="input_style"/>
			</div>
			<div>
				<label>颜色</label>
				<form:input path="color" readonly="true" cssClass="input_style"/>
			</div>
			<div>
				<label>描述</label>
				<form:input path="discription" readonly="true" cssClass="input_style"/>
			</div>
			<div>
				<label>价格</label>
				<form:input path="price" />
				<%-- <input id = "price" type="text" readonly="readonly" value="${price/100 }" disabled="disabled"> --%>
			</div>
			<div>
				<label>数量</label>
				<form:input path="count" type="number" min = "1" onchange="showPerice(this)" />
				<form:errors path="count"></form:errors>
			</div>
			<div>
				<label>合计</label>
				<input type="text" readonly="readonly" id = "periceCount" disabled="disabled"/>
			</div>
			<input type="submit" value="提交">
			<a href="${contextPath }/">返回首页</a>
			<a href="${contextPath }/commodity/shoppingCart">购物车</a>
		</div>
	</form:form>
	<script type="text/javascript" src="${contextPath }/asets/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		var price = $("#price").val();
		function showPerice(count){
			var priceCount = $(count).val();
			$("#periceCount").val(priceCount * price);
		}
	</script>
</body>
</html>