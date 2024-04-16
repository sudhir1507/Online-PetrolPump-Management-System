<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="org.petrolpump.admin.service.*,java.util.*,org.petrolpump.admin.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!FuelService fueltypeService = new FuelTypeServiceImpl();%>
	<%@include file="admindashbord.jsp"%>
	<div class="col py-3">
		<br>
		<br>
		<br>
		<br>
		<h3>FuelType Details</h3>
		<table class="table" style="background-color: gray;">
			<thead>
				<tr>
					<th scope="col">Sr.NO</th>
					<th scope="col">Fuel Type</th>
					<th scope="col">Delete</th>
					<th scope="col">Update</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<FuelTypeModel> list = fueltypeService.getAllFuelTypes();
				int count = 0;
				for (FuelTypeModel m : list) {
				%>
				<tr>
					<th scope="row"><%=++count%></th>
					<td><%=m.getName()%></td>
					<td><a href="delfuel?id=<%=m.getId()%>"><img src="images/Trash.webp" alt="delete icon" width="30" height="30" class="rounded-circle"></a></td>
					<td><a href="updatefuel?id=<%=m.getId()%>&name=<%=m.getName()%>"><img src="images/edit.webp" alt="update icon" width="30" height="30" class="rounded-circle"></a></td>
				</tr>
				<%
				}
				%>

			</tbody>
		</table>

	</div>
	</div>
	</div>
</body>
</html>