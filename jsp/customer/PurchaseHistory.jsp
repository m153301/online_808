<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="beans.PurchaseHistory" %> 
<%@ page import="java.util.ArrayList" %> 
<%@ page import="java.util.Iterator" %> 
<%
 	ArrayList<PurchaseHistory> purchaseList = (ArrayList)request.getAttribute("PurchaseList");
 %>
<html>
<head>
	<title>PurchaseHistory</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div style="text-align: right;">
		<form method = "post" action="../customer/RecommendedItemGetServlet">
			<input type="submit" value="買い物を終わる">
		</form>
		<br>
	</div>
	<br>
	<br>
	<table style="text-align: left; width: 450px; margin-left: auto; margin-right: auto; height: 360px;" border="1" cellpadding="2" cellspacing="2">
		<tbody>
			<tr>
				<td colspan="3" rowspan="1" style="text-align: center; width: 150px; height: 60px;">購入履歴</td>
			</tr>
			<%
				Iterator<PurchaseHistory> iterator=purchaseList.iterator();
				
				while(iterator.hasNext())
				{
					PurchaseHistory purchase = iterator.next();
					out.println("<tr>");
						out.println("<td style='text-align: center; width: 180px; height: 60px;'>" + purchase.getBuyDate() + "</td>");
						out.println("<td style='text-align: center; width: 180px; height: 60px;'>" + purchase.getItemName() + "</td>");
						out.println("<td style='text-align: center; width: 180px; height: 60px;'>" + purchase.getPurchaceQuantity() + "</td>");

					out.println("</tr>");
				}
			%>
		</tbody>
	</table>
</body>
</html>