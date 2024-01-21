<%@ page
 language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>


 <!--    anyChart -->
 <link rel="stylesheet" type="text/css" href="/css/wordCloud.css">
 <script src="https://cdn.anychart.com/releases/8.12.0/js/anychart-core.min.js"></script>
<script src="https://cdn.anychart.com/releases/8.12.0/js/anychart-tag-cloud.min.js"></script>
<script src="/js/jquery-3.7.1.min.js"></script>

  <script>
 		$(document).ready(function() {
 			let txt = document.getElementById("txt");
 			
 			$("#searchbtn").on('click',function() {
 			 var word = {
           word: $("#txt").val()
       }
 				$.ajax({
 				url:"/wordCloud",
 				data:word,
 				type:"get",
 				dataType:"json",
 				contentType: "application/json;charset=utf-8",
 				success: function(response) {
 					let data = JSON.parse(JSON.stringify(response));
 					let chart = anychart.tagCloud(data);
 					
 					chart.title("HOT WORD");
 					chart.container("container");
 					
 	 				chart.hovered().fill("#333");
 	 				chart.hovered().fontWeight(600);
 				 	chart.angles([0]);
 				 /* chart.getCredits().setEnabled(false); */
  				chart.listen("pointClick",function(e) {
  					var url = "//news.naver.com/main/main.naver?mode=LSD&mid=shm&sid1=100"; /* + e.point.get("x"); */
  					window.open(url, "_blank");
  				});

        	 chart.draw(); 
        	 
 					
 				},
 			 error: function () {
         alert("정상적이지 않은 요청입니다. 다시 시도해주세요");
         location.reload();
    		 }
 			})//ajax
 				
 	/* 	// create a chart and set the data
 				var chart = anychart.tagCloud(data);

 				// set the container id
 				chart.container("container");

 				// initiate drawing the chart
 				chart.angles([0]);
 				chart.listen("pointClick",function(e) {
 					var url = "//news.naver.com/main/main.naver?mode=LSD&mid=shm&sid1=100"; /* + e.point.get("x"); 
 					window.open(url, "_blank");
 				});
 				chart.hovered().fill("#333");
 				chart.hovered().fontWeight(600);
 				chart.draw(); */
 				
 			})//on
 			
 			
 		})
 		
 				
  </script>


</head>

<body>
<header>
	<h1>word clouding</h1>
	<br>
	<div id="container" align="center"></div>
  <input type="text" name="word" id="txt">
  <!--<input type="button" value="검색" id="search">-->
  <input type="button" class="w-btn-outline w-btn-red-outline" id="searchbtn" value="검색">
</header>


</body>
</html>