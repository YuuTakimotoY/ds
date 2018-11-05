<%@page import="web.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="web.KensakuBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><center>

	<br>
		<h1 align="center">商品検索</h1>
		<br>

		<%--検索機能 --%>
		<%--serachServletへpost送信 --%>
		<form action="kensaku" method="post">

		<table align="center">
		<%--ワード検索 --%>
		<tr><td>検索ワード</td>
			<td><input type="text" placeholder='商品名を入力してください' size="40" name="word"></td></tr>

		<%-- カテゴリ検索 --%>
		<tr><td>カテゴリ</td>
		<% ArrayList<CategoryBean> cate = (ArrayList<CategoryBean>)session.getAttribute("categ"); %>
			<td><select name="cat_id">
				<option value="0">カテゴリを選択してください</option>
		<% for(CategoryBean acb:cate){ %>
				<option value="<%= acb.getCat_id() %>"><%= acb.getCat_name() %></option>
		<% } %>
			</select></td></tr>
		</table>
		<br>
		<input type="submit" value="検索">
		<br><br>
		</form>
		<br>
		<%--検索結果表示 --%>
		<% ArrayList<KensakuBean> akb =(ArrayList<KensakuBean>)request.getAttribute("kensaku"); %>
		<%if(akb!=null){ %>
		<form action="product"method="post">
		<table align="center" border="1"width="500">
		<tr><th>商品名</th><th>価格</th><th>詳細</th></tr>
		<% for(KensakuBean kb:akb){ %>
		<tr>
		<td><%= kb.getPro_name() %></td>
		<td><%= kb.getPro_price() %></td>
		<td><button type="submit" name="pro_code" value="<%= kb.getPro_cd() %>">詳細</button></td>
		</tr>
		<% } %>
		</table>
		</form>
		<%}else{ %>
		検索結果がありません。
		<% }; %>
</center></body>
</html>