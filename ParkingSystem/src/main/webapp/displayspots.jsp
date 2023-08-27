<%@page import="Model.ParkingDTO"%>
<%@page import="java.util.ArrayList"%>
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
	}
	
	h3 {
	    color: #333 ;
	    margin-top: 20px;
	}
	
	table {
	    border-collapse: collapse;
	    width: 80%;
	    margin: 20px auto;
	    background-color: #fff;
	    box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
	}
	
	th, td {
	    padding: 10px;
	    text-align: center;
	}
	
	th {
	    background-color: #333;
	    color: #fff;
	}
	
	tr:nth-child(even) {
	    background-color: #f2f2f2;
	}
	
	button {
	    padding: 5px 10px;
	    background-color: #007bff;
	    color: #fff;
	    border: none;
	    cursor: pointer;
	}
	
	button:hover {
	    background-color: #0056b3;
	}
	
	a {
	    text-decoration: none;
	}
	
	a button {
	    margin-top: 10px;
	}
	
	a button:hover {
	    background-color: #0056b3;
	}
	       
    </style>
</head>
<body>
    <h3>Search Results:</h3>
    <% ArrayList<ParkingDTO> spots = (ArrayList<ParkingDTO>) request.getAttribute("spot"); %>
    <div>
    	<a href="home.jsp"><i class="fas fa-house"></i></a>
        <a href="logoutlink"><button>Logout</button></a>
    </div>
    <table border="1">
        <tr>
            <th>Spot Number</th>
            <th>Location</th>
            <th>Availability</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <% for (ParkingDTO spot : spots) { %>
        <tr>
            <td><%= spot.getSpotNumber() %></td>
            <td><%= spot.getLocation() %></td>
            <td><%= spot.getSpotAvailability() %></td>
            <td><%= spot.getPrice()%></td>
            <td>
                <form action="bookform.jsp" method="get"> 
                    <input type="hidden" name="spotId" value="<%= spot.getSpotId() %>">
                    <button type="submit">Book</button>
                </form>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
