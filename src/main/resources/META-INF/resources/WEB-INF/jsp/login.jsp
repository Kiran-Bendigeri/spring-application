<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lgin Page</title>

<style type="text/css">

	body{
	background-color: maroon;
	
	}

	#form-container{
	
		border-radius: 25px;
		border:5px double white;
		width : 500px;
		margin-inline : auto;
		margin-top: 200px;
		color: white;
		padding: 25px;
	
	}
	
	#button,
	#reset-button{
		padding: 5px;
		background-color: black;
		text-decoration: blink;
		color: white;
		border-radius: 5px;	
	}
	
	#reset-button{
	background-color: red;
	}
	

</style>

</head>
<body>

<div id="form-container">

<h1 style="text-align: center;" id="login-status">Login</h1>

<form style="position: relative; left: 100px;" action="welcome" id="form">
	
	
	<table cellpadding="5px" cellspacing="0px">
	
		<tr>
			<td>Username :</td>
			<td><input name="username" type="text" id="u-name" class="user-name"></td>
		</tr>
		
		<tr>
			<td>Email :</td>
			<td><input name="email" type="email" id="email" class="email"></td>
		</tr>
		
		<tr>
			<td>Password :</td>
			<td><input name="password" type="password" id="password" class="password"></td>
		</tr>
		
		<tr>
			<td><button type="submit" id="button">Submit</button></td>
			<td><button type="reset" id="reset-button">Reset</button></td>
		</tr>
		
	</table>
	
</form>

</div>

</body>
</html>