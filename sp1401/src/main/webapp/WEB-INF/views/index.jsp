<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>POST 이용한 전송</p>
	<form action="student" method="post">
		student id : <input type="text" name="id"> <br />
		<input type="submit" value="전송">
	</form>

<p>GET 이용한 전송</p>
	<form action="student" method="get">
		student id : <input type="text" name="id"> <br />
		<input type="submit" value="전송">
	</form>
	
</body>
</html>