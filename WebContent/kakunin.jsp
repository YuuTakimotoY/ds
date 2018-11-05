<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="web.Cart2Bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購入確認画面</title>
</head>
<body>
	<h1>購入してよろしいでしょうか</h1>
	<table>
	<%int count =0; %>
	<%int c =0;%>
	<%ArrayList<Cart2Bean> acb2=(ArrayList<Cart2Bean>)request.getAttribute("avc"); %>
	<% for(Cart2Bean cb2:acb2){ %>
		<% double x = 0.08*cb2.getPro_price()*cb2.getPro_kosu(); %>
		<% int s = (int)x;%>
		<% int d = cb2.getPro_price()*cb2.getPro_kosu(); %>
		<% c += s ;%>
		<% count += d ; %>
		<tr><th>商品名</th><th>単価</th><th>数量</th></tr>
		<tr><td><%=cb2.getPro_name() %></td><td><%=cb2.getPro_price() %></td><td><%=cb2.getPro_kosu() %></td></tr>
		<%}%>
		<tr><td colspan="2">消費税</td><td>\<%= c %></td></tr>
		<tr><td colspan="2">合計金額</td><td>\<%= count %></td></tr>
	</table>
	<a href=kensaku.jsp><input type="button" value="いいえ"></a>
	<a href=kakunin.jsp><input type="button" value="はい"></a>
</body>
</html>