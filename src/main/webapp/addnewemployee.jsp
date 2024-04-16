<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.petrolpump.admin.model.*,org.petrolpump.admin.service.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="admindashbord.jsp"%>
	<div class="col py-3">
		<form class="formarea" name="frm" action="addemployee" method="POST">
			<div class="mb-3 ">
				<label for="exampleInputEmail1" class="form-label">Employee Name</label><br> 
				<input type="text" class="form-control control" name="name" id="exampleInputEmail1" placeholder="Gajanan" aria-describedby="emailHelp">	
			</div>
			<div class="mb-3 ">
				<label for="exampleInputEmail1" class="form-label">Employee Email</label><br> 
				<input type="text" class="form-control control" name="email" id="exampleInputEmail1" placeholder="Gajanan@gmail.com" aria-describedby="emailHelp">	
			</div>
			<div class="mb-3 ">
				<label for="exampleInputEmail1" class="form-label">Employee Contact</label><br>
				<input type="text" class="form-control control" name="contact" id="exampleInputEmail1" placeholder="9988776738" aria-describedby="emailHelp">	
			</div>
			<div class="mb-3 ">
				<label for="exampleInputEmail1" class="form-label">Employee Address</label><br>
				<input type="text" class="form-control control" name="address" id="exampleInputEmail1" placeholder="PUNE" aria-describedby="emailHelp">	
			</div>
			<div class="mb-3 ">
				<label for="exampleInputEmail1" class="form-label">Employee salary</label><br>
				<input type="text" class="form-control control" name="sal" id="exampleInputEmail1" placeholder="10000" aria-describedby="emailHelp">	
			</div>
			<button type="submit" class="btn btn-primary">Add New Emoloyee</button>
		</form>
	</div>
	
	</div>
	</div>
</body>
</html>