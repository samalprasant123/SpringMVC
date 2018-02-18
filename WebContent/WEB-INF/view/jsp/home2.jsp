<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<sql:query var="rs" dataSource="jdbc/OffersDB">
SELECT id, name, email, text FROM offer
</sql:query>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Test</title>
	</head>
	
	<body>
		<%-- <h2>Hello <b>Session: <%= session.getAttribute("name") %></b></h2>  --%>
		<h2>Hello <b>Request: <%= request.getAttribute("name") %></b></h2>
		<p>Hello Request using EL: ${name}</p>
		<p> <c:out value="${name}"></c:out> </p>
		
		<c:forEach var="offer" items="${rs.rows}">
		    ID ${offer.id}<br/>
		    NAME ${offer.name}<br/>
		    EMAIL ${offer.email}<br/>
		    TEXT ${offer.text}<br/>
		</c:forEach>
		
	</body>
	
</html>