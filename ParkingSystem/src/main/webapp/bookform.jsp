<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Parking System</title>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        /* Additional styling for the container */
        .container {
            width: 100%;
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
        }

        /* Styling for the header section */
        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 10px;
        }

        /* Styling for the logout button */
        .logout-button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 5px 10px;
            border-radius: 3px;
            cursor: pointer;
            text-decoration: none;
        }

        .logout-button:hover {
            background-color: #0056b3;
        }

        /* Styling for the horizontal line */
        hr {
            margin: 20px 0;
            border: none;
            border-top: 1px solid #ccc;
        }

        /* Styling for form elements */
        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="date"],
        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        /* Styling for submit button */
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    
        <div class="header">
            <a href="home.jsp"><i class="fas fa-house"></i></a>
            <a href="logoutlink" class="logout-button">Logout</a>
        </div>
        <hr>
        <form action="bookspotlink" method="get">
            <input type="hidden" name="spotId" value="<%= request.getParameter("spotId") %>">
            <label for="bookdate">Select Booking Date</label>
            <input type="date" id="bookdate" name="bookdate" required><br>
            <label for="checkintime">Enter Check-In Time (HH:MM:SS)</label>
            <input type="text" id="checkintime" name="checkintime" pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]" required>
            <small>Format: HH:MM:SS</small><br>
            <label for="checkouttime">Enter Check-Out Time (HH:MM:SS)</label>
            <input type="text" id="checkouttime" name="checkouttime" pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]" required>
            <small>Format: HH:MM:SS</small><br>
            <input type="submit" value="Book Spot">
        </form>
  
</body>
</html>
