<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="projet.beans.Personne"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hello
 <% Personne currentUser = (Personne )(session.getAttribute("currentSessionUser"));%>
			
            Welcome <%= currentUser.getEmail() %>
</body>
</html>