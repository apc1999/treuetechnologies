<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Store</title>
    <style>
       /* Reset some default styles */
        body, h1, h2, h3, h4, p, ul, li, form, button {
            margin: 0;
            padding: 0;
        }

        /* Global styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            color: #333;
        }

        /* Header */
        header {
            background-color: #222;
            color: #fff;
            padding: 10px 0;
        }

        nav ul {
            list-style-type: none;
        }

        nav ul li {
            display: inline;
            margin-right: 20px;
        }

        nav a {
            text-decoration: none;
            color: #fff;
        }

        /* Search bar */
        .search-bar {
            margin-top: 10px;
            text-align: center;
        }

        .search-bar input[type="text"] {
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .search-bar button {
            padding: 5px 10px;
            background-color: #222;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        /* Hero section */
        .hero {
            text-align: center;
            margin-top: 20px;
        }

        .hero-banner {
            position: relative;
        }

        .hero-banner img {
            max-width: 100%;
            height: auto;
        }

        .cta-button {
            position: absolute;
            bottom: 20px;
            left: 50%;
            transform: translateX(-50%);
            padding: 10px 20px;
            background-color: #222;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        /* Featured categories */
        .featured-categories {
            display: flex;
            justify-content: space-around;
            align-items: center;
            margin: 20px 0;
        }

        .category {
            text-align: center;
        }

        .category img {
            max-width: 100%;
            height: auto;
        }

        /* Bestsellers */
        .bestsellers {
            text-align: center;
            margin: 20px 0;
        }

        .bestsellers h2 {
            margin-bottom: 10px;
        }

        .book {
            display: inline-block;
            margin: 10px;
        }

        .book img {
            max-width: 100%;
            height: auto;
        }

        /* Newsletter section */
        .newsletter {
            text-align: center;
            margin: 20px 0;
        }

        .newsletter h2 {
            margin-bottom: 10px;
        }

        .newsletter input[type="email"] {
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .newsletter button {
            padding: 5px 10px;
            background-color: #222;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        /* Footer */
        footer {
            background-color: #222;
            color: #fff;
            text-align: center;
            padding: 20px 0;
        }

        .footer-links {
            list-style-type: none;
            margin-bottom: 10px;
        }

        .footer-links li {
            display: inline;
            margin-right: 15px;
        }

        .footer-links a {
            text-decoration: none;
            color: #fff;
        }

        /* Contact information */
        footer p {
            margin-top: 10px;
        }
    </style>

    
 
</head>
<body>

    <header>
        <nav>
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="#">Contact Us</a></li>
                <li><a href="cartlink" id="cart-icon">Cart</a></li>
                <li><a hreg="orderslink">Yours Orders</a>
            </ul>
        </nav>
    </header>
    <section>
    <div class="about-us">
        <h2 align="center">About Us</h2>
        <p>Welcome to our online book store! We are passionate about providing you with a wide selection of books across various genres. Our goal is to connect readers with their favorite authors and stories. Whether you're a casual reader or a devoted bookworm, we have something for everyone.</p>
        <p>At our book store, we believe in the power of literature to inspire, educate, and entertain. Our team is dedicated to curating a collection of both timeless classics and the latest bestsellers. We strive to create an enjoyable and seamless shopping experience for book enthusiasts of all ages.</p>
        <p>Thank you for choosing us as your destination for literary exploration. We're excited to be a part of your reading journey!</p>
    </div>
   </section>
    <section>
        <div class="search-bar">
            <h3>Search By Category</h3>
            <form action="searchlink" method="get">
                <input type="text" placeholder="Search..." name="searchbook">
                <button type="submit">Search</button>
            </form>
        </div>
    </section>
    <footer>
        <ul class="footer-links">
            <li><a href="#">Privacy Policy</a></li>
            <li><a href="#">Terms and Conditions</a></li>
            <li><a href="#">FAQs</a></li>
        </ul>
        <p>Contact us at: contact@example.com</p>
    </footer>
    
   
</body>
</html>