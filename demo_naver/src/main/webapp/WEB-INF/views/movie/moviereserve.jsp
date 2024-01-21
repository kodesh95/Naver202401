<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>${infodto.id } 회원님 ${infodto.age } 살 입니다.</h2>
<h2>시청 가능한 영화 목록</h2>
<%
String[] arr=request.getParameterValues("available");

%>
</body>
</html>