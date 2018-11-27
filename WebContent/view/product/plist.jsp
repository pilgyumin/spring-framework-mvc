<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style>
img{
	width:100px;
}
</style>

<script>

</script>
</head>
<body>
<h1>Product List</h1>
<c:forEach var="p" items="${plist }">
<h3>
<img src="img/${p.imgname }"> 
<a href="pdetail.mc?id=${p.id }">
${p.name } ${p.price }</a>
</h3>
</c:forEach>
</body>
</html>







