<%@page import="shop.pojo.ShopingCar"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
</head>
<body>
	<table>
			<tr>
				<th>商品名</th>
				<th>商品品牌</th>
				<th>商品型号</th>
				<th>操作系统</th>
				<th>CPU品牌</th>
				<th>运行内存</th>
				<th>内部存储</th>
				<th>颜色</th>
				<th>描述</th>
				<th>价格</th>
				<th>数量</th>
				<th>总价</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${shopingCarts }" var="shopingCartItem">
				<tr>
					<td>${shopingCartItem.commoditie.name }</td>
					<td>${shopingCartItem.commoditie.brand }</td>
					<td>${shopingCartItem.commoditie.model }</td>
					<td>${shopingCartItem.commoditie.os }</td>
					<td>${shopingCartItem.commoditie.cpu }</td>
					<td>${shopingCartItem.commoditie.ram }</td>
					<td>${shopingCartItem.commoditie.sc }</td>
					<td>${shopingCartItem.commoditie.color }</td>
					<td>${shopingCartItem.commoditie.discription }</td>
					<td>￥${shopingCartItem.commoditie.price/100.0 }元</td>
					<td>${shopingCartItem.count}</td>
					<c:set value="${shopingCartItem.count}" var="countS"></c:set>
					<c:set value="${shopingCartItem.commoditie.price/100.0 }" var="priceS"></c:set>
					<td><c:out value="${countS*priceS }"></c:out> </td>
					<td>
						<button onclick="window.location.href='${contextPath}/commodity/${shopingCartItem.commoditie.id }/getCommodityById'">修改</button>
						<button onclick="window.location.href='${contextPath}/commodity/${shopingCartItem.commoditie.id }/deleteShopingItem'">删除</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="${contextPath }/">返回首页</a>
</body>
</html>