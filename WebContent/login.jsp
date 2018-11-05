<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
		<h1 align="center">ログイン</h1>
		<%--入力した値がない場合と間違っていた場合 --%>
		<% String er =(String)request.getAttribute("error"); %>
		<% String no =(String)request.getAttribute("null"); %>

		<% if(no != null){ %><%--空白の場合 --%>
		<p align =center style="color:red;">入力してください。</p>
		<% }else if(er != null){ %><%-- --%>
		<p align =center style="color:red;">入力された情報が間違っています。</p>
		<% } %>
		
		<form action="login" method="post">
			<table align="center">


				<tr>
					<th >名前</th>
					<td><input type="text" name="name"></td>
				</tr>


				<tr>
					<th >パスワード</th>
					<td><input type="password" name="password"></td>
				</tr>


			</table>
			<p align="center">
			<input type="submit" value="LOGIN">
			</p>
		</form>
	
</body>
</html>