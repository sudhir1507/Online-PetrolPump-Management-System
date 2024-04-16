<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="admindashbord.jsp"%>
	<div class="col py-3">
		<form class="formarea" name="frm" action="fueltype" method="POST">
			<div class="mb-3 ">
				<label for="exampleInputEmail1" class="form-label">Fuel Type</label><br><br> 
				<input type="text" class="form-control control" name="type" id="exampleInputEmail1" placeholder="Enter Fuel Type" aria-describedby="emailHelp">
			</div>
			<br><br>
			<button type="submit" class="btn btn-primary">Add New Fuel Type</button>
		</form>
	</div>
	
	</div>
	</div>
</body>
</html>