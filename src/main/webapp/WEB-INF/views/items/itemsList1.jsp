<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/28
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag"%>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<div>
    <input type="text" name="title" `/>
</div>
<table width="100%" border=1>
    <tr>
        <td>商品名称1</td>
        <td>商品价格1</td>
        <td>生成日期1</td>
        <td>商品描述1</td>
        <td>操作1</td>
    </tr>

    <c:forEach items="${itemList}" var="item">
        <tr>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td><fmt:formatDate value="${item.createTime}" pattarn="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${item.description}</td>
            <td><a href="${pageContext.request.contextPath}/item/editItem.action?id=${item.id}">修改</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
