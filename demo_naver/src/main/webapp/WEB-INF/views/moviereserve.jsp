<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<H1>${id } 회 원 님 ${age }살입니다</H1>
<h2>시청 가능 영화목록 </h2>

<H3>${resultmovie }</H3>

<video src="/mvc/resources/multimedia/chrome.mp4"  controls width=600 height=400 
poster="resources/multimedia/chrome.jpg"></video>
</body>
</html>