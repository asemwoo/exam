<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YONGIN LMS</title>
</head>
<body>

<form action="login.do" method="post">
	YONGIN LMS<br>
	I      D:<input type="text" name="id" /><br>
	PASSWORD:<input type ="password" name="pwd"/><br>
	
	
	  <input type="radio" name="kk" id="prof" value="Professor"checked>
	  <label for="prof">교수</label>

	  <input type="radio" name="kk" id="stud" value="student">
	  <label for="stud">학생</label><br>
	  
	  <input type="submit" value="로그인" />

	  </form>
</body>
</html>