<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="beans.User" %>
<html>
<head>
  <title>WorkerTop</title>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%
//	User user = (User)session.getAttribute("worker");
//	out.println(user.getUserName() + "さん ようこそ！<br>");
%>
<br>
	<div class="title">
		☆商品☆<br>
		<a href="../worker/ItemInfoRegist.jsp">商品登録</a><br>
		<a href="../worker/ItemInfoChangeListServlet">商品編集</a><br>
		<form action="../worker/ItemInfoGetServlet" method="post">
			<button type="submit" style="border:none;background-color:transparent;" >おすすめ登録</button>
		</form><br>
		☆売上☆<br>

		<form method = "post" action="../worker/SaleBrowseServlet">
		<input type="submit" value="売上確認">
		</form>
		<br>
		☆発注履歴☆<br>

		<form method = "post" action="../worker/OrderedBrowseServlet">
		<input type="submit" value="発注履歴確認">
		</form>

		<br>
		☆その他☆<br>
		<a href="../worker/WorkerInfoRegist.jsp">店員登録</a><br>
		<form method = "post" action="../common/LogOutServlet">
			<input type="submit" value="ログアウト">
		</form>
		<br>
	</div>
</body>
</html>