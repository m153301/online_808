<%@ page language="java" contentType="text/html; charset=UTF-8" import= "java.util.List" %>
<html>
<head>
	<title>ItemInfoRegist</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div style="text-align: right;"><a href="WorkerTop.jsp">トップに戻る</a><br></div>
	<br>
	<br>
		<%
		List<String> errors = (List<String>)request.getAttribute("errors");
		if( errors != null ){
			out.println("<font color='#f00'>");
			for(String error : errors) out.println(error + "<br>");
			out.println("</font>");
		}
	%>
	<form method="post" action="./ItemInfoRegistServlet">
	<table style="text-align: left; width: 360px; margin-left: auto; margin-right: auto; height: 360px;" border="1" cellpadding="2" cellspacing="2">
		<tbody>
			<tr align="center">
				<td style="width: 180px; height: 60px;" colspan="2" rowspan="1">商品情報登録</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">品名</td>
				<td style="text-align: center; width: 180px; height: 60px;"><input name="item_name" type="text"></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">単価</td>
				<td style="text-align: center; width: 180px; height: 60px;"><input name="item_price" type="text"></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">在庫</td>
				<td style="text-align: center; width: 180px; height: 60px;"><input name="item_stock" type="text"></td>
			</tr>
			<tr>
				<td colspan="2" rowspan="1" style="text-align: center; width: 180px; height: 60px;">
					<input type="submit" name="enter" value="登録">
				</td>
			</tr>
		</tbody>
	</table>
	</form>
</body>
</html>