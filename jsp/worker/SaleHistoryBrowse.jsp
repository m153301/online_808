<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="beans.SaleHistory" %>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.ParseException" %>

<%
	ArrayList<SaleHistory> saleList = (ArrayList<SaleHistory>)request.getAttribute("SaleList");
%>

<html>
<head>
	<title>SaleBrowse</title>
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
	Iterator<SaleHistory> iterator = saleList.iterator();
SaleHistory sale = iterator.next();

Date buyDate1 = new Date();
Date buyDate2 = new Date();


while(iterator.hasNext()){


	out.println("<table style='text-align: center; width: 600px; height: 300px;' border='1' cellpadding='2' cellspacing='2'>");
	out.print("<br><br>");
	out.println("<big>");
	out.println(sale.getBuyDate());
	out.println("</big>");
	out.println("<tr>");
	out.println("<td> 商品名 </td>");
	out.println("<td> 単価 </td>");
	out.println("<td> 売上数 </td>");
	out.println("<td> 計 </td>");
	out.println("</tr>");

	int total = 0, subtotal = 0;

	do{

		out.println("<tr>");
		out.println("<td>"+ sale.getItemName() +"</td>");
		out.println("<td>"+ sale.getItemPrice() +"</td>");
		out.println("<td>"+ sale.getPurchaseQuantity() +"</td>");
		subtotal = sale.getItemPrice() * sale.getPurchaseQuantity();
		total = total + subtotal;
		out.println("<td>"+ subtotal +"</td>");
		out.println("</tr>");

		buyDate1 = sale.getBuyDate();
		if(iterator.hasNext()){
	sale = iterator.next();
		}
		else{
	sale.setBuyDate(DateFormat.getDateInstance().parse("0000/00/00"));
		}
		buyDate2 = sale.getBuyDate();

	}while(buyDate1.equals(buyDate2));


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





