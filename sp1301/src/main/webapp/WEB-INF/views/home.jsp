<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<P>http://localhost:8080/ex/board/confirmId?id=abcd&pw=1112</P>
<P>http://localhost:8080/ex/board/checkId?id=abcd&pw=111</P>
<p>http://localhost:8080/ex/member/join?name=superman&id=eve&pw=111&email=aaa@aaa.com</p>

</body>
</html>
