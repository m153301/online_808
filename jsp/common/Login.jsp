<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<br>
	<br>
	<div class="title">
		セキュア<br>
		ネット販売システム<br>
	</div>
	<table style="width: 360px; margin-left: auto; margin-right: auto; height: 240px;" border="1" cellpadding="2" cellspacing="2">
		<tbody>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;" rowspan="1" colspan="2">ログイン</td>
			</tr>
			<form action="./LoginServlet" method="post">
			<tr>
				<td style="text-align: center; width: 100px; height: 60px;">ID</td>
				<td style="text-align: center; width: 260px; height: 60px;"><input name="id" type="text"></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 100px; height: 60px;">Pass</td>
				<td style="text-align: center; width: 260px; height: 60px;"><input name="pass" type="password"> </td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;" rowspan="1" colspan="2">
					<input type="submit" value="Enter" />
				</td>
			</tr>
			</form>
		</tbody>
	</table>
	<br>
	<div class="center">
		<a href="./CustomerInfoRegist.jsp">新規の方はこちらから</a><br>
	</div>
	<br>
</body>
</html>