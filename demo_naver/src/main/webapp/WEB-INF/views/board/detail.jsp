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
 $("#deletebtn").on('click', function(){
	  let inputpw = prompt("암호를 입력하세요");
	  let dbpw = $("#hiddenpw").val();
	  if(inputpw == dbpw){
 		location.href="boarddelete?seq=${detaildto.seq }"
	  }
	  else{
		  alert("암호를 확인하세요");
	  }
 });//on 

 $("#updatebtn").on('click', function(){
	  let inputpw = prompt("암호를 입력하세요");
	  let dbpw = $("#hiddenpw").val();
	  if(inputpw == dbpw){
		$("#f").attr("method", "post");
		$("#f").attr("action", "boardupdate");
		$("#f").submit();
	  }
	  else{
		  alert("암호를 확인하세요");
	  }
});//on 
 
});//ready
</script>
</head>
<body>
<!-- 1개 게시물 모델(seq ~ writingtime ) 출력 -->
<form id="f" action="" method="">
	<input name="seq" value='${detaildto.seq }' readonly><br>
	<input name="title" value='${detaildto.title }'><br>
	<textarea cols=50 rows=5 name="contents">
	${detaildto.contents }
	</textarea>
	<input name='writer' value='${detaildto.writer }' readonly><br>
	<input name='viewcount' value='${detaildto.viewcount }' readonly><br>
	<input name="writingtime" value='${detaildto.writingtime }' readonly><br>
	<input id="hiddenpw" type=hidden value="${detaildto.pw}" >
	<!-- 수정버튼 삭제버튼 -->
	<input id="updatebtn" type=button value="수정버튼" >
	<input id="deletebtn" type=button value="삭제버튼" >
</form>

</body>
</html>







