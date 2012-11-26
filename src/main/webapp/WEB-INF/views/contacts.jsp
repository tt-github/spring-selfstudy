<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Contacts</title>
	</head>
	<body>
	
		<table>
			<thead>
		  		<tr>
		  			 <td>First name</td>
		  			 <td>Last name</td>
		  			 <td>Birth date</td>
		  		</tr>
			</thead>
			<tbody>
				<c:forEach items="${contacts}" var="contact">
		   	 		<tr>
		       			<td><c:out value="${contact.firstName}" /></td>
		       			<td><c:out value="${contact.lastName}" /></td>
		      			<td><c:out value="${contact.birthDate}" /></td>
		    		</tr>
		 		 </c:forEach>
			</tbody>  
		</table>	   
	
	 <a href="<c:url value="/contacts?form"/>">Add new</a>
	</body>
</html>