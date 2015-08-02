<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.text.ParseException" %>

<%
	ArrayList<String> saleHistoryList = (ArrayList<String>)request.getAttribute("SaleHistoryList");
%>

<html>
<head>
	<title>SaleHistoryBrowse</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div style="text-align: right;">
	<a href="WorkerTop.jsp">トップに戻る</a><br>
</div>
<br>
<br>
<div style="margin: 0pt auto; width: 700px; height: 850px; border:#d0d0d0 solid 5px;">
	<div class="title" style="text-align: center;">売上</div>
	<br>

<%
int i = 0, total, subTotal, price, quantity;
int length = saleHistoryList.size();
int date = 0;

while(i < length-1 ){
	out.println("<table style='text-align: center; width: 600px; height: 300px;' border='1' cellpadding='2' cellspacing='2'>");
	out.print("<br><br>");
	out.println("<big>");
	out.println(saleHistoryList.get(i));
	out.println("</big>");
	out.println("<tr>");
	out.println("<td> 商品名 </td>");
	out.println("<td> 単価 </td>");
	out.println("<td> 購入数 </td>");
	out.println("<td> 小計 </td>");
	out.println("</tr>");

	total = 0;
	subTotal = 0;
	date = i;


	while(saleHistoryList.get(date).equals(saleHistoryList.get(i))){

		out.println("<tr>");

		i++;
		out.println("<td>"+ saleHistoryList.get(i) +"</td>");//商品名

		i++;
		price = Integer.parseInt(saleHistoryList.get(i));
		out.println("<td>"+ price +"</td>");//単価

		i++;
		quantity = Integer.parseInt(saleHistoryList.get(i));
		out.println("<td>"+ quantity +"</td>");//購入数

		subTotal = price * quantity;
		total = total + subTotal;
		out.println("<td>"+ subTotal +"</td>");
		out.println("</tr>");

		if(i != length-1){
			i++;
		}

	}


	out.println("<tr>");
	out.println("<td> 計 </td>");
	out.println("<td> - </td>");
	out.println("<td> - </td>");
	out.println("<td>"+ total + "</td>");
	out.println("</tr>");

}
%>

</div>
</body>


</html>





