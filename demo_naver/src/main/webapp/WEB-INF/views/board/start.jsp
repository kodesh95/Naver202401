<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#writinglink").on('click', function(ev){
		let sessionid = <%=session.getAttribute("sessionid") %>;
		if(sessionid == null){
			alert("로그인 먼저 하셔야 합니다.");
			ev.preventDefault();
		}
	})//on
});//ready
</script>
</head>
<body>
<h1>로그인여부=<%=session.getAttribute("sessionid") %></h1>
<h1> 나의 게시판 화면입니다. </h1>
<h2> 메뉴는 다음과 같습니다.</h2>
<ul>
	<li><a href='boardlist'>게시물리스트 보러가기(로그인하지 않아도 됩니다)</a></li>
	<li><a id="writinglink" href='boardwrite'>글쓰러가기(로그인 먼저 하셔야 합니다)</a></li>
	<li><a href='boardlogin'>로그인하기</a></li>
	<li><a href='boardlogout'>로그아웃하기</a></li>
</ul>
</body>
</html>