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
			int x = Integer.parseInt( (String)request.getAttribute("x") );
			if( x == 1 )
			{
				out.println("登録が完了しました");
			}
			else if( x == 0 )
			{
				out.println("その商品はすでに別の店員によって登録されていますm(_ _)m");
			}
			else if( x == -1 )
			{
				out.println("おすすめ登録に失敗しましたm(_ _)m");
			}
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