<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.List" import="beans.Item" %>
<html>
<head>
	<title>ItemInfoChangeList</title>
	
</head>
<body>
	<div style="text-align: right;"><a href="WorkerTop.jsp">トップに戻る</a><br></div>
	<br>
	<br>
	
		<form action="./ItemInfoChangeCheckServlet" method="post">
		<table style="text-align: left; width: 490px; margin-left: auto; margin-right: auto; height: 540px;" border="1" cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="text-align: center; width: 40px; height: 60px;" colspan="4" rowspan="1">商品情報変更</td>
				</tr>
				<tr>
					<td style="text-align: center; width: 40px; height: 60px;">変更</td>
					<td style="text-align: center; width: 75px; height: 60px;">商品名</td>
					<td style="text-align: center; width: 150px; height: 60px;">単価</td>
					<td style="vertical-align: middle; width: 150px; text-align: center;">在庫</td>
				</tr>
				<%
					List<String> errors = (List<String>)request.getAttribute("errors");
					if(errors != null){
						out.println("<font color='#f00'>");
						for(String error : errors) out.println(error + "<br>");
						out.println("</font>");
					}
					List<Item> items = (List<Item>)request.getAttribute("items");
					HttpSession hs = request.getSession();
					hs.setAttribute("items", items);
					for( Item item : items )
					{
						out.println("<tr>");
						out.println("<td style='text-align: center; width: 40px; height: 60px;'>");
						out.println("<input type='radio' name='item_id' value=" + item.getItemId() + ">");
						out.println("</td>");
						out.println("<td style='text-align: center; width: 75px; height: 60px;'>" + item.getItemName() + "</td>");
						out.println("<td style='text-align: center; width: 150px; height: 60px;'>" + item.getItemPrice() + "円</td>");
						out.println("<td style='vertical-align: middle; width: 150px; text-align: center;'>あと" + item.getItemStock() + "個</td>");
						out.println("</tr>");
					}
				%>
				<tr>
					<td colspan="4" rowspan="1" style="text-align: center;">
						<input type="submit" value="変更"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>