<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#ajaxbtn1").on('click', function(){ 
		$.ajax({ 
			url : "ajaxlogin",
			data : {'memberid' : $("#memberid").val() , 'pw': $("#pw").val() },
			type : 'get',
			dataType : 'json',
			success : function(response){
				//alert( JSON.stringify(response) );
				//response 객체형태->출력->문자열형태변경메소드
				if(response.loginresult == "로그인성공"){
					$("#result").css("color", "green");
				}
				else{
					$("#result").css("color", "red");
				}
				$("#result").html("<h3>" + response.loginresult + "</h3>");
			} , 
			error : function(request, e){
				alert("코드=" + request.status + " 메시지=" + request.responseText + " 오류=" + e);
			}
		});//ajax
	});//AJAXBTN1 on
	
	$("#ajaxbtn2").on('click', function(){ 
		$.ajax({ 
			url : "ajaxmypage",
			data : {'memberid' : $("#memberid").val() , 'pw': $("#pw").val() },
			type : 'post',
			dataType : 'json',
			success : function(response){
				//alert(JSON.stringify(response));//MemberDTO를  JSON형태변경
				if(response.membername == null){//회원정보 없는 경우
					$("#result").html("<h3>회원 정보가 없습니다.</h3>");
					$("#result").css("color", 'red');
				}
				else{
					$("#result").html("<h3>"+response.memberid+"</h3>");
					$("#result").append("<h3>"+response.membername+"</h3>");
					$("#result").append("<h3>"+response.phone+"</h3>");
					$("#result").append("<h3>"+response.email+"</h3>");
					$("#result").append("<h3>"+response.regdate+"</h3>");
					$("#result").css("color", 'blue');
				}
			} , 
			error : function(request, e){
				alert("코드=" + request.status + " 메시지=" + request.responseText + " 오류=" + e);
			}
		});//ajax
	});//AJAXBTN2 on
	
	$("#ajaxbtn3").on('click', function(){ 
		$.ajax({ 
			url : "ajaxlist",
			//data : {'memberid' : $("#memberid").val() , 'pw': $("#pw").val() }, //admin-admin
			type : 'post',
			dataType : 'json',
			success : function(response){
			//	alert(JSON.stringify(response));//MemberDTO를  JSON형태변경
		/*	[	{memberid:xxx, pw:xxx , .......email:xxxx},
				{memberid:xxx, pw:xxx , .......email:xxxx},
				{memberid:xxx, pw:xxx , .......email:xxxx},
				{memberid:xxx, pw:xxx , .......email:xxxx},
				{memberid:xxx, pw:xxx , .......email:xxxx} ]*/
				
				//if(response == null){//
				//	$("#result").html("<h3>관리자가 아닙니다.</h3>");
				//	$("#result").css("color", 'red');
				//}
				//else{
					$("#result").html("");
					$("#result").css("color", 'blue');
					for(let i = 0; i <= response.length; i++){
						$("#result").append("<h3><A href='abc'>"+response[i].memberid + "</a>:");
						$("#result").append(response[i].membername + ":");
						$("#result").append(response[i].phone + ":");
						$("#result").append(response[i].email+"</h3>");
					}
				//}*/
			} , 
			error : function(request, e){
				alert("코드=" + request.status + " 메시지=" + request.responseText + " 오류=" + e);
			}
		});//ajax
	});//AJAXBTN3 on
	
	$("#result").on('click', "a", function(e){//5개
		e.preventDefault();
		//클릭한 회원의 암호 #result 출력 ajax 요청 - url "ajaxgetpw/회원아이디
		$.ajax({ 
			url : "ajaxgetpw/" + $(this).text() ,
			type : 'post',
			dataType : 'json',
			success : function(response){
				//alert(JSON.stringify(response));//MemberDTO를  JSON형태변경
				$("#result").html("<h1>암호는 " + response.pw + " 입니다</h3>");
			} , 
			error : function(request, e){
				alert("코드=" + request.status + " 메시지=" + request.responseText + " 오류=" + e);
			}
		});//ajax
	})
	
	
	
	
	
	
	$("#ajaxbtn4").on('click', function(){ 
		$.ajax({ 
			url : "ajaxgetpw/" + $("#memberid").val() ,
			type : 'post',
			dataType : 'json',
			success : function(response){
				//alert(JSON.stringify(response));//MemberDTO를  JSON형태변경
				$("#result").html("<h1>암호는 " + response.pw + " 입니다</h3>");
			} , 
			error : function(request, e){
				alert("코드=" + request.status + " 메시지=" + request.responseText + " 오류=" + e);
			}
		});//ajax
	});//AJAXBTN4 on
	
	$("#uploadbtn").on('click', function(e){ 
		e.preventDefault();
		let data = new FormData($("#uploadform").get(0) );  //html form태그 입력태그--자바스크립트객체
		$.ajax({ 
			url : "ajaxupload"  ,
			type : 'post',
			data : data, 
			encType:"multipart/form-data",
			processData : false, //name=value 전송x(requst.getParameter() x)
			contentType : false, //request.setContentType("text/html")
			dataType : 'json',
			success : function(response){
				//alert(JSON.stringify(response));//MemberDTO를  JSON형태변경
				$("#uploadresult").html(response.uploadresult);
			} , 
			error : function(request, e){
				alert("코드=" + request.status + " 메시지=" + request.responseText + " 오류=" + e);
			}
		});//ajax
	});//AJAXBTN4 on
});//ready
</script>
</head>
<body>
<h1>ajax 테스트</h1>
<form action="nonajaxlogin" >
아이디<input type=text name="memberid" id="memberid"><br>
암호<input type=password name="pw" id="pw"><br>
<input type=submit value="nonajax로그인">
<input type=button id="ajaxbtn1" value="ajax로그인">
<input type=button id="ajaxbtn2" value="ajax내정보조회">
<input type=button id="ajaxbtn3" value="ajax모든회원정보">
<input type=button id="ajaxbtn4" value="ajax암호">
</form>
<div id="result"> 회원정보결과표시 </div>
<hr>
<h1>ajax 파일업로드</h1>
<form id="uploadform" >
	파일선택 : <input type=file name="uploadfile">
<input type=button value="파일업로드" id="uploadbtn">
</form>
<div id="uploadresult">파일업로드결과표시</div>
</body>
</html>









