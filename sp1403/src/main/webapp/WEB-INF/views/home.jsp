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
<P>Not Good : 
<P>http://localhost:8080/ex/studentConfirm?id=aaa
<P>Good : 
<P>http://localhost:8080/ex/studentConfirm?id=abc
</body>
</html>
