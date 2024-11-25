<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   
.container{
	
	height:300px;
	width:500px;
	text-align:center;
	align-content:center;
	border-radius:10px;
	background-color:white;
	text-decoration:none;
	margin-left:500px;
	margin-top:150px;
	 
}
.container:hover{
    background-color: lightgoldenrodyellow;
}
body{
	
	background-color:yellowgreen;
}
button{
 background-color:white;
 padding:20px;
 height:5px;
 width:200px;
 font-size:20px;
 text-align:center;
 border-radius:8px;
 }
 button:hover{
      background-color:orange;
      text-transform: uppercase;
 }
</style>
</head>
<body>
<div class="container">
<form action="index.html" method="post">
<h2>Current Date:  ${date}</h2>
<h2>City Name:  ${city}</h2>
 <h2>Current Temperature: ${temperature}<small><sup>o</sup></small>C ${weatherCondition }</h2>
 
 <h2>Current Wind Speed:  ${windSpeed} m/s</h2>
 <h2>Current time: ${time}</h2>
 <h2> ${city} humidity :${humidity } g/m3</h2>
 
 <button>Back to Home</button>
 </form>
</div>
</body>

</html>