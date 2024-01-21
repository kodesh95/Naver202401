<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#writerbtn").on('click', function(){
		$.ajax({
			url : 'getwriter/' + $("#writer").val() ,
			//data : {memberid : $("#writer").val() } ,
			type : 'get',
			dataType : 'json' ,
			success : function(response){
				let output = "<h4>"+ response.membername + "</h4>";
				output += "<h4>"+ response.email + "</h4>";
				output += "<h4>"+ response.phone + "</h4>";
				output += "<h4>"+ response.regdate + "</h4>";
			    $("#writeinform").html(output);
			},
			error : function(status){
				alert("오류")
			}
			
		});
	})
});
</script>
</head>
<body>
<form action="boardwrite" method=post >
제목 : <input type=text name="title" ><br>
내용 :<textarea rows="5" cols="50" name="contents">
 여기에 내용을 입력하세요.
</textarea><br>
작성자 : <input type=text name="writer" id="writer" value="${sessionid }" readonly><br>
글암호 : <input type=text name="pw"><br>
<input type=submit value="글작성">
<input type=button id="writerbtn" value="작성자정보보기">
</form>

<div id="writeinform"></div>
<!-- 작성자정보보기  버튼 클릭시
getwriter url 호출- writer  value (get|post) 전송-ajax 요청 
(컨트롤러 
@RequestMapping("getWriter")
XXXX
??? 메소드(???) - MemberDTO 객체 리턴
)
writer 해당 이름, 이메일, 폰번호, 가입일 writeinform 출력 - ajax 응답
 -->
</body>
</html>

