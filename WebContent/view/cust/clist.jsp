<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" 
uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Cust List Page</h1>

<c:forEach var="c" items="${clist }">
<h4>
<a href="cupdate.mc?id=${c.id }">${c.id } ${c.name } ${c.age }</a>
</h4>
</c:forEach>

</body>
</html>







