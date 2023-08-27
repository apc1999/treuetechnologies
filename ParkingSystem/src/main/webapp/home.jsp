<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parking System</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
    margin: 0;
    padding: 0;
  }

  h1, h2 {
    text-align: center;
    margin-top: 10px;
  }
  .header-tag{
  text-align: left;
  }

  .container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin: 20px;
    padding: 10px;
    background-color: #fff;
    border-radius: 4px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }

  .container a {
    text-decoration: none;
    color: #333;
  }

  .button {
    padding: 8px 16px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.2s;
  }

  .button:hover {
    background-color: #45a049;
  }

  .form-container {
    display: flex;
    justify-content: center;
    align-items: center;
    margin: 20px;
    padding: 20px;
    background-color: #fff;
    border-radius: 4px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }

  .label {
    font-weight: bold;
    margin-right: 10px;
  }

  .input-text {
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }

  .submit-button {
    padding: 8px 16px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.2s;
  }

  .submit-button:hover {
    background-color: #45a049;
  }

  .suggestions {
    display: flex;
    justify-content: center;
    margin-top: 10px;
  }

  .suggestions ul {
    list-style-type: none;
    padding: 0;
  }

  .suggestions li {
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    cursor: pointer;
    background-color: #fff;
    transition: background-color 0.2s;
  }

  .suggestions li:hover {
    background-color: #f2f2f2;
  }

  .center-text {
    text-align: center;
    margin: 10px;
    font-style: italic;
  }

  /* Header and Footer */
  footer {
    background-color: #333;
    color: #fff;
    padding: 10px;
    text-align: center;
  }
  
</style>

</head>
<body>

<%
   String name = (String) request.getAttribute("username");
%>

<header >
  <h1 class="header-tag">WELCOME <%= name %></h1>
</header>

<div class="container">
  <a href="bookinglink" class="button">Yours Booking</a>
  <a href="logoutlink" class="button">Log Out</a>
</div>

<div class="form-container">
  <h2>Parking Spot Search</h2><br>
  <h3>Search By Location</h3>
  <form action="searchlink" method="get">
   
    <input type="text" name="loc" id="locationInput" class="input-text" onkeyup="showSuggestions()">
    <input type="submit" value="SEARCH" class="submit-button">
  </form>
</div>

<div class="suggestions" id="suggestions"></div>

<footer>
  &copy; 2023 Parking System. All rights reserved.
</footer>



<script>
  const suggestionsList = [
    "Hadapsar",
    "Magarpatta",
    "Wagholi(BJS)",
    "PuneStation",
    "Ramtekadi"
  ];

  function showSuggestions() {
    const input = document.getElementById("locationInput");
    const userInput = input.value.toLowerCase();
    const suggestionsDiv = document.getElementById("suggestions");
    suggestionsDiv.innerHTML = "";

    if (!userInput) {
      return;
    }

    const matchingSuggestions = suggestionsList.filter(suggestion =>
      suggestion.toLowerCase().includes(userInput)
    );

    if (matchingSuggestions.length === 0) {
      suggestionsDiv.innerHTML = "<p class='center-text'>No suggestions found.</p>";
    } else {
      const suggestionListElement = document.createElement("ul");
      matchingSuggestions.forEach(suggestion => {
        const suggestionItem = document.createElement("li");
        suggestionItem.textContent = suggestion;
        suggestionItem.onclick = () => {
          input.value = suggestion;
          suggestionsDiv.innerHTML = "";
        };
        suggestionListElement.appendChild(suggestionItem);
      });
      suggestionsDiv.appendChild(suggestionListElement);
    }
  }
</script>
</body>
</html>
