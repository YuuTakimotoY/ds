<%@page import = "web.ProductBean" %>
<%@page import = "web.CategoryBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%ProductBean sb = (ProductBean)request.getAttribute("sho"); %>
	<%CategoryBean cb2 =(CategoryBean)request.getAttribute("ca"); %>
	<img align="left" src="<%= sb.getPro_img()%>">
	<div align="right">
		<h1>商品紹介</h1>
		<table>
		<tr><th>商品名</th><td><%= sb.getPro_name() %></td></tr>
		<tr><th>カテゴリ</th><td><%=cb2.getCat_name() %></td></tr>
		<tr><th>価格</th><td><%=sb.getPro_price() %></td></tr>
		<tr><th>在庫</th><td><%=sb.getStock_no() %></td></tr>
		<tr><th>商品紹介</th><td><%=sb.getPro_msg()%></td></tr>
		<tr><td>
		個数
		<form action="cart"method="post">
		<select>
			<option value =0>選んでください</option>
			<% for(int i =1;i<sb.getStock_no(){%>
			<option value =<%= i %>><%= i%></option>
			<%} %>
		</select>
		<input type ="submit"name="pro_cd" value="<%= sb.getPro_cd()%>">
		</form>
		<a href="search.jsp"><button>戻る</button></a>　

		</td></tr>
		</table>
	</div>

</body>
</html>