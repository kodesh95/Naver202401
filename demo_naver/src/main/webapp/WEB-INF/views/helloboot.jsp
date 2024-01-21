<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.7.1.min.js" ></script>
<script>
$(document).ready(function(){
	$("#ajaxbtn").on('click', function(){
		$.ajax({
			url : "helloajax",
			type :"get",
			dataType : 'json',
			success : function(server){
				$("#ajaxresult").html(server.model);
			}
		});
	});
});
</script>
</head>
<body>
<h1>helloboot.jsp 파일입니다.</h1>

<img src="/images/html5.jpg">

<input type=button value="ajax요청버튼" id="ajaxbtn">
ajax결과출력:<h1 id='ajaxresult'></h1>
</body>
</html>