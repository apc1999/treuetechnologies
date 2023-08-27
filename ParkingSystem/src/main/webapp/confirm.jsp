<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Parking System</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }
        
        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px;
            background-color: #333;
            color: #fff;
            width: 100%;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }
        
        header a {
            color: #fff;
            text-decoration: none;
            font-size: 24px;
            margin-right: 20px;
        }
        
        header button {
            background-color: #fff;
            color: #333;
            border: none;
            padding: 8px 16px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s ease-in-out;
        }
        
        header button:hover {
            background-color: #ddd;
        }
        
        h1 {
            color: #333;
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
    <header>
        <a href="home.jsp"><i class="fas fa-house"></i></a>
        <a href="logoutlink"><button>LogOut</button></a>
    </header>
	
    <% int count = (int) request.getAttribute("count");
    if (count > 0) { %>
        <h1>Your Spot is Booked</h1>
    <% } else { %>
        <h1>Sorry, Spot is not available</h1>
    <% } %>
</body>
</html>
