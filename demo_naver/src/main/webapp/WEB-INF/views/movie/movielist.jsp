<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="moviereserve" method="get">
	아이디<input type=text name="id"><br>
	암호<input type=password name="pw"><br>
	나이<input type=number name="age" required="required"><br>
	<select multiple>
    <option value="movie1">서울의 봄</option>
    <option value="movie2">그대들은 어떻게 살 것인가</option>
    <option value="movie3">헝거게임</option>
    <option value="movie4">더 마블스</option>
    <option value="movie5">프레디의 피자가게</option>
	</select>
	<input type=submit value="신청"/>
</form>

</body>
</html>