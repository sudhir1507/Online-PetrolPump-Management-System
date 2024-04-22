<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="CSS/adminstyle.css" rel="stylesheet">
<link href="CSS/employeeloginstyle.css" rel="stylesheet">
</head>
<body>
	<div class='container'>
	   <form name='frm' action="validate" method='POST'>
	    <ul class='subcontainer'>
		   <li><input type='text' name='email' value='' placeholder='Enter email as username' class='control'/></li>
	       <li><input type='text' name='contact' value='' placeholder='Enter contact as password' class='control'/></li>
	       <li><input type='submit' name='s' value='login' class='control' /></li>
	    	
	    </ul>
	    </form>
	</div>
</body>
</html>