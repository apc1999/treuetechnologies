<%@page import="java.util.ArrayList"%>
<%@page import="Model.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Store</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    .book-card {
        border: 1px solid #ccc;
        padding: 20px;
        margin: 20px;
        display: inline-block;
        background-color: #fff;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }
    h2 {
        margin: 0;
        font-size: 24px;
        color: #333;
    }
    p {
        margin: 10px 0;
        font-size: 16px;
        color: #555;
    }
    form {
        margin-top: 10px;
    }
    input[type="submit"] {
        background-color: #3498db;
        color: white;
        border: none;
        padding: 8px 12px;
        border-radius: 4px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #2387c9;
    }
</style>
</head>
<body>
<% ArrayList<BookDTO> bookList = (ArrayList<BookDTO>) session.getAttribute("list"); %>
<div align="right">
    <h1>Cart Details:</h1>
</div>
<hr>
<% for (BookDTO b : bookList) { %>
    <div class="book-card">
        <h2><%= b.getBookName() %></h2>
        <p>Author: <%= b.getBookAuthor() %></p>
        <p>Price: <%= b.getBookPrice() %></p>
        <p>Category: <%= b.getBookCategory() %></p>
        <p>Quantity: <%= b.getQty() %></p>
        <form action="bookinglink" method="get"> 
            <input type="hidden" name="bookId" value="<%= b.getBookId() %>">
            <input type="hidden" name="bookPrice" value="<%= b.getBookPrice() %>">
            <input type="submit" value="Buy">
        </form>
    </div>
<% } %>
</body>
</html>
