<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Wave Cineplex</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="user.jsp" style="font-size: 40px;"><b>Wave Cineplex</b></a>
    </div>
  </div>
</nav>

<body style="background: linear-gradient(to bottom, red, yellow);">
<form action="food" method="post">
<div>
  <div class="container">
    <table class="table table-hover">
        <thead>
            <tr>
            <th>Select</th>
                <th>Item</th>
                <th></th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
        
            <tr>
                <td><input type="radio" value="food1" name="id"></td>
                <td><img src="img/2.jpg" style="width: 150px; height: 150px;"></td>
                <td style="margin-top: 100px;">1 Coca Cola + 1 medium Popcorn</td>
                <td>100</td>
            </tr> 
           <tr>
                <td><input type="radio" value="food2" name="id"></td>
                <td><img src="img/1.jpg" style="width: 150px; height: 150px;"></td>
                <td style="margin-top: 100px;">1 Coca Cola + 1 Small Fries + 1 Veg Burger</td>
                <td>150</td>
            </tr>
           <tr>
                <td><input type="radio" value="food3" name="id"></td>
                <td><img src="img/3.jpg" style="width: 150px; height: 150px;"></td>
                <td style="margin-top: 100px;">1 Coca Cola + 2 Medium fries + 2 Veg Burger</td>
                <td>200</td>
            </tr>
        </tbody>
    </table>
    <input type="submit" value="Order" class="btn btn-primary">
  </div>
  </div>
  </form>
</div>
</body>
</html>