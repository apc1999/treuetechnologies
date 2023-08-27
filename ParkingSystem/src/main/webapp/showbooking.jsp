<%@page import="Model.ParkingDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PARKING SYSTEM</title>
</head>
<body>
		<%ArrayList<ParkingDTO>bookingList=(ArrayList<ParkingDTO>)request.getAttribute("bookinglist"); %>
		<%out.println(bookingList); %>
		<table>
		<tr>
		<th>BOOKING ID</th>
		<th>BOOKING DATE</th>
		<th>LOCATION</th>
		<th>PRICE</th>
		<th>CHECK IN TIME</th>
		<th>CHECK OUT TIME</th>
		</tr>
		<% for(ParkingDTO b:bookingList) {%>
		<td><%=b.getBookingId() %></td>
		<td><%=b.getBookDate() %></td>
		<td><%=b.getLocation() %></td>
		<td><%=b.getPrice() %></td>
		<td><%=b.getCheckIn() %></td>
		<td><%=b.getCheckOut() %></td>
		<%} %>
		</table>
</body>
</html>