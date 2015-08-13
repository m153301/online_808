<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="beans.Item" %> 
<%@ page import="java.util.ArrayList" %> 
<%@ page import="java.util.Iterator" %> 
<!-- ItemInfoGetServletからリストを取得 --> 
<% 
ArrayList<Item> itemList = (ArrayList)request.getAttribute("ItemList"); 
%> 

<html>
<head>
	<title>ItemPurchase</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div style="text-align: right;">
		<form method = "post" action="../customer/RecommendItemNameGetServlet">
			<input type="submit" value="買い物を終わる">
		</form>
		<br><br>
	</div>
	<div></div>
	<br>
	<br>
	<form action="../customer/PurchaseRegistServlet" method="post">
	<table style="text-align: left; width: 360px; margin-left: auto; margin-right: auto; height: 300px;" border="1" cellpadding="2" cellspacing="2">
		<tbody>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">△商品名△</td>
				<td style="text-align: center; width: 180px; height: 60px;"><%= request.getAttribute("ItemNAME") %></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">△単価△</td>
				<td style="text-align: center; width: 180px; height: 60px;"><%= request.getAttribute("ItemPRICE") %></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">△在庫△</td>
				<td style="text-align: center; width: 180px; height: 60px;"><%= request.getAttribute("ItemSTOCK") %></td>
			</tr>
			<tr>
				<td colspan="2" rowspan="1" style="text-align: center; width: 180px; height: 60px;">購入する個数を選んでください<br>
					<select name="number">
						<option value="0">選択してください</option>
						<%
						Integer i = Integer.parseInt(request.getParameter("itemSTOCK")); 
						for(Integer j = 1;j <= i;j++)
						{
							out.println("<option value=" + j + ">" + j + "</option>");
						}
						%>

					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" rowspan="1" style="text-align: center; width: 180px; height: 60px;">
					<input type="submit" value="確認">
				</td>
			</tr>
			<input type="hidden" name="ItemID" value=<%= request.getAttribute("ItemID") %>>
			<input type="hidden" name="ItemNAME" value=<%= request.getAttribute("ItemNAME") %>>
			<input type="hidden" name="ItemPRICE" value=<%= request.getAttribute("ItemPRICE") %>>
			<input type="hidden" name="ItemSTOCK" value=<%= request.getAttribute("ItemSTOCK") %>>
		</tbody>
	</table>
	</form>
</body>
</html>