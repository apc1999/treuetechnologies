<!DOCTYPE html>
<%@page import="Model.BookDTO"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Store</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .book-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            padding: 20px;
            max-width: 1200px;
            margin: 0 auto;
        }
        .book-card {
            border: 1px solid #ccc;
            padding: 20px;
            margin: 20px;
            width: calc(33.33% - 40px);
            background-color: #ffffff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            transition: transform 0.2s, box-shadow 0.2s;
        }
        .book-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        h3 {
            margin: 0;
            font-size: 18px;
        }
        p {
            margin: 8px 0;
            font-size: 14px;
            color: #555;
        }
        form {
            margin-top: 10px;
        }
        input[type="number"], textarea {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 100%;
            margin-bottom: 10px;
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
    <%
        ArrayList<BookDTO> bookList = (ArrayList<BookDTO>) request.getAttribute("list");
    %>
    
    <div class="book-container">
        <% for (BookDTO b : bookList) { %>
        <div class="book-card">
            <h3><%= b.getBookName() %></h3>
            <p>Author: <%= b.getBookAuthor() %></p>
            <p>Category: <%= b.getBookCategory() %></p>
            <p>Price: <%= b.getBookPrice() %></p>
            
            <form action="ratecommentbooklink" method="get">
                <input type="hidden" name="bookId" value="<%= b.getBookId() %>">
                Rating: <input type="number" name="rating" min="1" max="5" value="1">
                Comment: <textarea name="comment" rows="3" cols="30"></textarea>
                <input type="submit" value="Rate and Comment">
            </form>
            
            <form action="addtocartlink" method="get">
                <input type="hidden" name="bookId" value="<%= b.getBookId() %>">
                Quantity: <input type="number" name="quantity" value="1" min="1">
                <input type="submit" value="Add to Cart">
            </form>
        </div>
        <% } %>
    </div>
</body>
</html>

