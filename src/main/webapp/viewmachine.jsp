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
	<%!MachineService machineService = new MachineServiceImpl();%>
	<%@include file="admindashbord.jsp"%>
	<div class="col py-3">
		<br>
		<br>
		<br>
		<br>
		<h3>Machine Details</h3>
		<table class="table" style="background-color: gray;">
			<thead>
				<tr>
					<th scope="col">Sr.NO</th>
					<th scope="col">Machine Code</th>
					<th scope="col">Fuel Type</th>
					<th scope="col">Capcity</th>
					<th scope="col">Delete</th>
					<th scope="col">Update</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Object[]> list = machineService.getAllMachines();
				int count = 0;
				for (Object obj[] : list) {
				%>
				<tr>
					<th scope="row"><%=++count%></th>
					<td><%=obj[0]%></td>
					<td><%=obj[1]%></td>
					<td><%=obj[2]%></td>
					<td><a href="del?machineid=<%=(int)obj[3]%>"><img src="images/Trash.webp" alt="delete icon" width="30" height="30" class="rounded-circle"></a></td>
					<td><a href="updmachine?mid=<%=(int)obj[3]%>&mcode=<%=obj[0].toString()%>"><img src="images/edit.webp" alt="update icon" width="30" height="30" class="rounded-circle"></a></td>
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