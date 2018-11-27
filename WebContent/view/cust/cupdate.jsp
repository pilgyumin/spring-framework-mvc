<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Cust Update Page</h1>
	<form method="post" action="cupdateimpl.mc?id=${cid }">
		ID ${cid }<br>
		Pwd<input type="password" name="pwd"><br> 
		Name<input type="text" name="name"><br> 
		Age<input type="number" name="age"><br>
		<input type="submit" value="Register">
		<button id=""></button>
	</form>
</body>
</html>