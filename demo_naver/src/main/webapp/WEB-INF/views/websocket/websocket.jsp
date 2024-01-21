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
<input type=button id="exitbtn" value="퇴장">
<h1>채팅 영역</h1>
<div id='chatmessagearea' style="background-color:pink; border:2px solid black"></div>
전송 메시지 <input type=text id='message'>
<input type=button id="sendbtn" value="메시지전송">

<script>
websocket = null;
$("#enterbtn").on('click', function(){
	if(websocket == null || websocket.CLOSED){
		websocket = new WebSocket("ws://localhost:9070/ws");
	}
	websocket.onopen = function(){console.log("웹소켓연결성공");};
	websocket.onclose = function(){console.log("웹소켓해제성공");}
	websocket.onmessage = function(event){
		let data = event.data;
		$("#chatmessagearea").append(data + "<br>");
		console.log("웹소켓서버로부터 수신성공");
		
	};

})//enterbtn

$("#exitbtn").on('click', function(){
	websocket.close();
})//exitbtn

$("#sendbtn").on('click', function(){
	//내가 서버로 	보낸다
	let nick = $("#nickname").val();
	let msg = $("#message").val();
	websocket.send(nick + " : "+ msg);
	console.log("웹소켓서버로 송신성공")
})//sendbtn
</script>

</body>
</html>