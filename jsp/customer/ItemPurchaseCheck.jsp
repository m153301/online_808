<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>ItemPurchaseCheck</title>
	
</head>
<body>
	<div style="text-align: right;">
		<form method = "post" action="../customer/RecommendedItemGetServlet">
			<input type="submit" value="買い物を終わる">
		</form>
		<br><br>
	</div>
	<br>
	<br>
	<form action="../customer/PurchaseCheckServlet" method="post">
	<table style="text-align: left; width: 360px; margin-left: auto; margin-right: auto; height: 360px;" border="1" cellpadding="2" cellspacing="2">
		<tbody>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;" rowspan="1" colspan="2">購入商品</td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">□商品名□</td>
				<td style="text-align: center; width: 180px; height: 60px;"><%= request.getAttribute("ItemNAME") %></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">□単価□</td>
				<td style="text-align: center; width: 180px; height: 60px;"><%= request.getAttribute("ItemPRICE") %></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">□購入数□</td>
				<td style="text-align: center; width: 180px; height: 60px;"><%= request.getAttribute("ItemSTOCK") %></td>
			</tr>
			<tr>
				<td style="text-align: center; width: 180px; height: 60px;">□合計□</td>
				<td style="text-align: center; width: 180px; height: 60px;"><%= request.getAttribute("PRICE") %></td>
			</tr>
			<tr>
				<td colspan="2" rowspan="1" style="text-align: center; width: 180px; height: 60px;">
					<input type="submit" value="確定">
				</td>
			</tr>
		</tbody>
			<input type="hidden" name="ItemID" value=<%= request.getAttribute("ItemID") %>>
			<input type="hidden" name="ItemNUM" value=<%= request.getAttribute("ItemSTOCK") %>>
			<input type="hidden" name="ItemPRICE" value=<%= request.getAttribute("ItemPRICE") %>>
			<input type="hidden" name="ItemSTOCK" value=<%= request.getAttribute("ItemSTOCK2") %>>
	</table>
	</form>
</body>
</html>