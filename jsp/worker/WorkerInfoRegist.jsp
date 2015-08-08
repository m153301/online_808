<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>WorkerInfoRegist</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<br>
	<br>
	<form action = "./WorkerInfoRegistServlet", method = "post">
	<table style="text-align: left; width: 360px; margin-left: auto; margin-right: auto; height: 360px;" border="1" cellpadding="2" cellspacing="2">
		<tbody>
			
			<tr align="center">
				<td style="width: 180px; height: 60px;" colspan="2" rowspan="1">店員情報登録</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">氏名</td>
				<td style="text-align: center; width: 180px; height: 60px;"><input name="worker_name" type="text"></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">店員ID<br>${error}</td>
				<td style="text-align: center; width: 180px; height: 60px;"><input name="worker_id" type="text"></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">パスワード</td>
				<td style="text-align: center; width: 180px; height: 60px;"><input name="worker_pass" type="password"></td>
			</tr>
			<tr>
				<td colspan="2" rowspan="1" style="text-align: center; width: 180px; height: 60px;">
					<button name="enter">確認</button><br>
				</td>
			</tr>
		</tbody>
	</table>
	</form>
</body>
</html>