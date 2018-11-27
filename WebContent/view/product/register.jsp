<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Product Register Page</h1>
	<form method="post" action="paddimpl.mc" enctype="multipart/form-data">
		NAME<input type="text" name="name"><br> 
		PRICE<input type="number" name="price"><br> 
		IMGNAME<input type="file" name="mf"><br> 
		<input type="submit" value="Register">
</body>
</html>