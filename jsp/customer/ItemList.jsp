<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="beans.Item" %> 
<%@ page import="java.util.ArrayList" %> 
<%@ page import="java.util.Iterator" %> 
<% 
ArrayList<Item> itemList = (ArrayList)request.getAttribute("ItemList"); 
%> 

<html>
<head>
	<title>ItemList</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div style="text-align: right;">
		<form method = "post" action="../customer/RecommendItemNameGetServlet">
			<input type="submit" value="買い物を終わる">
		</form>
		<br>
	</div>
	<br>
	<br>
	
	<table style="text-align: left; width: 470px; margin-left: auto; margin-right: auto; height: 480px;" border="1" cellpadding="2" cellspacing="2">
		<tbody>
			<tr align="center">
				<td style="width: 170px; height: 60px;" colspan="4" rowspan="1">商品一覧<br></td>
			</tr>
			<tr>
			    <td style="text-align: center; width: 20px; height: 60px;">    </td>
				<td style="text-align: center; width: 150px; height: 60px;">商品名</td>
				<td style="text-align: center; width: 150px; height: 60px;">単価</td>
				<td style="vertical-align: middle; width: 150px; text-align: center;">在庫</td>
			</tr>
			
			<%
			Iterator<Item> iterator=itemList.iterator();
			
			while(iterator.hasNext())
			{
			out.println("<form action='../customer/ItemPurchaseServlet' method='post'>");
				Item item = iterator.next();
				out.println("<tr>");
					out.println("<td style='text-align: center; width: 20px; height: 60px;'>" + item.getItemId() + "</td>");
					out.println("<td style='text-align: center; width: 150px; height: 60px;'>");
						out.println("<input type='submit' value=" + item.getItemName() + ">");
					out.println("</td>");
					out.println("<td style='text-align: center; width: 150px; height: 60px;'>" + item.getItemPrice() + "</td>");
					out.println("<td style='vertical-align: middle; width: 150px; text-align: center;'>あと" + item.getItemStock() + "個</td>");
					
					out.println("<input type='hidden' name='itemID' value=" + item.getItemId() + ">");
					out.println("<input type='hidden' name='itemNAME' value=" + item.getItemName() + ">");
					out.println("<input type='hidden' name='itemPRICE' value=" + item.getItemPrice() + ">");
					out.println("<input type='hidden' name='itemSTOCK' value=" + item.getItemStock() + ">");
				out.println("</tr>");
				out.println("</form>");
			}
			%>
		
		</tbody>
	</table>
	
</body>
</html>