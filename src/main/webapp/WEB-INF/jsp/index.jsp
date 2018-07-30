<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:layout title="首页">
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
				<th>操作</th>
			</tr>
			<c:forEach items="${commodityList }" var="commodityItem">
				<tr>
					<td>${commodityItem.name }</td>
					<td>${commodityItem.brand }</td>
					<td>${commodityItem.model }</td>
					<td>${commodityItem.os }</td>
					<td>${commodityItem.cpu }</td>
					<td>${commodityItem.ram }</td>
					<td>${commodityItem.sc }</td>
					<td>${commodityItem.color }</td>
					<td>${commodityItem.discription }</td>
					<td>￥${commodityItem.price/100.0 }元</td>
					<td>
						<button onclick="window.location.href='${contextPath}/commodity/${commodityItem.id }/getCommodityById'">加入购物车</button>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="${contextPath}">返回首页</a>
	</body>
</t:layout>