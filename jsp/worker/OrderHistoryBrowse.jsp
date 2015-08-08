<%@page import="controller.OrderHistoryBrowseManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.text.ParseException" %>

<%
ArrayList<String> orderHistoryList = (ArrayList<String>)request.getAttribute("OrderHistoryList");
%>

<html>
<head>
	<title>OrderHistoryBrowse</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div style="text-align: right;">
	<a href="WorkerTop.jsp">トップに戻る</a><br>
</div>
<br>
<br>
<div style="margin: 0pt auto; width: 700px; height: 850px; border:#d0d0d0 solid 5px;">
	<div class="title" style="text-align: center;">発注履歴</div>
	<br>

<%

Iterator<String> iterator = orderHistoryList.iterator();

out.println("<table style='text-align: center; width: 600px; height: 300px;' border='1' cellpadding='2' cellspacing='2'>");
out.print("<br><br>");
out.println("<tr>");
out.println("<td> 発注番号 </td>");
out.println("<td> 発注者 </td>");
out.println("<td> 商品名 </td>");
out.println("<td> 日付 </td>");
out.println("<td> 発注数 </td>");
out.println("</tr>");

while(iterator.hasNext()){

	out.println("<tr>");
	out.println("<td>"+ iterator.next() +"</td>");
	out.println("<td>"+ iterator.next() +"</td>");
	out.println("<td>"+ iterator.next() +"</td>");
	out.println("<td>"+ iterator.next() +"</td>");
	out.println("<td>"+ iterator.next() +"</td>");
	out.println("</tr>");

}
%>

</div>
</body>


</html>