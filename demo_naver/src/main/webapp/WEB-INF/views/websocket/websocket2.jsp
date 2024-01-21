<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.7.1.min.js"></script>
</head>

<body>

별명:<input type=text id="nickname" value="${param.id }">
<input type=button id="enterbtn" value="입장"> 
<input type=button id="enterbtn" value="퇴장"> 
<h1>채팅영역</h1>
<div id="chatmessagearea" style="background-color:orange; border:2px solid #333333"></div>
전송메세지 <input type=text id='message'>
<input type=button id="sendbtn" value="메세지전송">

<script>
	$("#enterbtn").on('click', function(){
		websocket=new Websocket("ws://localhost:9070/ws");
		websocket.onopen = function() {
			console.log("웹소켓연결성공");
		};
		websocket.onclose=function(){console.log("웹소켓해제성공");};
		websocket.onmessage=function() {
			console.log("웹소켓서버로부터 수신성공")
		}
	})
	$("#exitbtn").on('click', function(){
		websocket.close();
	})
</script>

</body>
</html>