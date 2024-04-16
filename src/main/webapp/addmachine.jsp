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
		<form class="formarea" name="frm" action="newmachine" method="POST">
			<div class="mb-3 ">
				<label for="exampleInputEmail1" class="form-label">Machine code</label><br><br> 
				<input type="text" class="form-control control" name="machineCode" id="exampleInputEmail1" placeholder="Enter Machine Code" aria-describedby="emailHelp">
				<br><br>
				<table>
				<%
				FuelService fService=new FuelTypeServiceImpl();
				List<FuelTypeModel> list=fService.getAllFuelTypes();
				for(FuelTypeModel m:list){
				%>
				<tr>
				<td> <input type="checkbox" name="ftype" value='<%=m.getId()%>'/>&nbsp;&nbsp;<%=m.getName() %></td>
				<td align="right"> <input type="text" name="capacity" value=''/></td>
				</tr>
				<%
				}
				%>
				</table>
			</div>
			<br><br>
			<button type="submit" class="btn btn-primary">Add New Machine</button>
		</form>
	</div>
	
	</div>
	</div>
</body>
</html>