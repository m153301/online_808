<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="beans.User" %>
<%@ page import="beans.Item" %>
<%@ page import="java.util.ArrayList" %>
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
	ArrayList<Item> recommendedItemList = (ArrayList)request.getAttribute("RecommendedItemList");
%>
	<div class="title">
		☆おすすめ☆<br>
		<%
			//iteratorの生成
			Iterator<Item> iterator=recommendedItemList.iterator();
			//順番に中身がなくなるまで取り出す
			while(iterator.hasNext())
			{
				Item item = iterator.next();
				out.println(item.getItemName() + "<br>");
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