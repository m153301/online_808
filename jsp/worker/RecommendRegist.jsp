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
	<title>RecommendRegist</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div style="text-align: right;">
		<a href="WorkerTop.jsp">トップに戻る</a><br>
	</div>
	<br>
	<br>
	<form action="./RecommendRegistServlet" method="post">
		<table style="text-align: left; width: 490px; margin-left: auto; margin-right: auto; height: 540px;" border="1" cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="text-align: center; width: 40px; height: 60px;" colspan="4" rowspan="1">おすすめ登録</td>
				</tr>
				<tr>
					<td style="text-align: center; width: 40px; height: 60px;">選択</td>
					<td style="text-align: center; width: 75px; height: 60px;">商品名</td>
					<td style="text-align: center; width: 150px; height: 60px;">単価</td>
					<td style="vertical-align: middle; width: 150px; text-align: center;">在庫</td>
				</tr>
				<%
				//iteratorの生成
				Iterator<Item> iterator=itemList.iterator();
				//順番に中身がなくなるまで取り出す
				while(iterator.hasNext())
				{
					Item item = iterator.next();
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
						<button type="submit">登録</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>