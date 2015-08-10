<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="beans.User" %>
<%@ page import="beans.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<html>
<head>
	<title>CustomerTop</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%
	User user = (User)session.getAttribute("customer");
	out.println(user.getUserName() + "さん ようこそ！<br><br>");
	List<String> recommendedItemNameList = (List)request.getAttribute("RecommendItemNameList");
%>
	<div class="title">
		☆おすすめ☆<br>
		<%
			//順番に中身がなくなるまで取り出す
			for( int i=0; i < recommendedItemNameList.size(); i++ )
			{
				String itemName = recommendedItemNameList.get(i);
				out.println(itemName + "<br>");
			}
		%>
		<br>
		☆買い物☆<br>
		<form method = "post" action="../customer/ItemListServlet">
		<input type="submit" value="商品一覧">
		</form>
		
		<form method = "post" action="../customer/PurchaseHistoryServlet">
		<input type="submit" value="購入履歴">
		</form>
		<br>
		☆その他☆<br>
		<a href="../customer/CustomerInfoChange.jsp">お客様情報の変更</a><br>
		<form method = "post" action="../common/LogOutServlet">
			<input type="submit" value="ログアウト">
		</form>
		<br>
	</div>
</body></html>