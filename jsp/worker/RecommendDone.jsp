<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>RecommendDone</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="title">
		<br>
		<br>
		<%
			String recommendRegistResult = (String)request.getAttribute("recommendRegistResult");
			out.println( recommendRegistResult );
		%>
		<br>
		<br>
		<br>
		<br>
		<br>
		<a href="WorkerTop.jsp">トップに戻る</a><br>
	</div>
</body>
</html>