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
	
	<%@include file="admindashbord.jsp"%>
	<div class="col py-3">
		<br>
		<br>
		<br>
		<br>
		<h3>Employee Details</h3>
		<table class="table" style="background-color: gray;">
			<thead>
				<tr>
					<th scope="col">Sr.NO</th>
					<th scope="col">Employee Name</th>
					<th scope="col">Contact</th>
					<th scope="col">Allocate Machine</th>
					<th scope="col">Delete</th>
					<th scope="col">Update</th>
				</tr>
			</thead>
			<tbody>
				<%
				EmployeeService empService=new EmployeeServiceImpl();
				List<EmployeeModel> list=empService.getAllEmployees();
				int count=0;
				for(EmployeeModel eModel:list){
				%>
				 <tr>
				 <td><%=++count %></td>
				 <td><%=eModel.getName() %></td>
				 <td><%=eModel.getContact() %></td>
				 <td><a href='allocatemachine?empid=<%=eModel.getId()%>&empName=<%=eModel.getName()%>'>ALLOCATE MACHINE</a></td>
				 <td><a href='deleteemployee?empid=<%=eModel.getId()%>'><img src="images/Trash.webp" alt="delete icon" width="30" height="30" class="rounded-circle"></a></td>
				 <td><a href='updateemployee?empid=<%=eModel.getId()%>&empName=<%=eModel.getName()%>&empEmail=<%=eModel.getEmail()%>&empContact=<%=eModel.getContact()%>&empAddress=<%=eModel.getAddress()%>&empSalary=<%=eModel.getSal()%>'><img src="images/edit.webp" alt="update icon" width="30" height="30" class="rounded-circle"></a></td>
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