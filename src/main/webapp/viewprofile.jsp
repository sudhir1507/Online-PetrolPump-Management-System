<%@page import="org.petrolpump.admin.model.EmployeeModel"%>
<%@page import="org.petrolpump.admin.service.EmployeeService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="org.petrolpump.admin.service.*" %>
<%@page import="org.petrolpump.admin.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="CSS/adminstyle.css" rel="stylesheet">
<link href="CSS/employeeloginstyle.css" rel="stylesheet">
</head>
<%@include file='employeedashboard.jsp'%>
<body>
<%!
EmployeeModel e; 
EmployeeService empService;
%>
    <%
      int employeeId=Integer.parseInt(session.getAttribute("employeeId").toString());
      empService=new EmployeeServiceImpl();
      e=empService.getProfile(employeeId);
     
    %>
    <div id="first">
    <form name='frm' action="updateprofile" method="post" >
			<input type="hidden" name="id" value='<%=e.getId()%>' class="control" /><br/><br/>
    <input type="text" name="name" value='<%=e.getName()%>' class="control"/><br/><br/>
    <input type="text" name="email" value='<%=e.getEmail()%>' class="control"/><br/><br/>
    <input type="text" name="contact" value='<%=e.getContact()%>' class="control"/><br/><br/>
    <input type="text" name="address" value='<%=e.getAddress()%>' class="control"/><br/><br/>
    <input type="text" name="salary" value='<%=e.getSal()%>' class="control"/><br/><br/>
    <input type="submit" name="s" value='Update profile' class="control"/>
    </form>
    </div>
</body>
</html>