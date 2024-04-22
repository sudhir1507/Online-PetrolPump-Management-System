<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.petrolpump.admin.service.*" %>
<%@page import="org.petrolpump.admin.model.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="CSS/adminstyle.css" rel="stylesheet">
<link href="CSS/view.css" rel="stylesheet">

</head>
<%@include file='employeedashboard.jsp'%>
<body>
	<%!
		EmployeeModel e; 
		EmployeeService empService;
		int count=0;
	%>
	
	<table>
	<caption>Allocated Machines</caption>
        <tr> 
			<th scope="col">Sr.NO</th>
			<th scope="col">Machine Code</th>
			<th scope="col">Date</th>
			<th scope="col">Start Time</th>
			<th scope="col">End Time</th>
	   </tr>
    <%
      int employeeId=Integer.parseInt(session.getAttribute("employeeId").toString());
      empService=new EmployeeServiceImpl();
      List<Object[]> list=empService.viewAllocatedMachies(employeeId);
      int count = 0;
		for (Object obj[] : list) {
    %>
    <tr>
    	<td><%=++count %></td>
    	<td><%=obj[0]%></td>
		<td><%=obj[1]%></td>
		<td><%=obj[2]%></td>
		<td><%=obj[3]%></td>
     </tr>
    <%
	}
    %>
    
    </table>
</body>
</html>