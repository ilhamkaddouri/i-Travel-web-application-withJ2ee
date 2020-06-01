<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddEndroit" method="post">
	<input name="nom" type="text" placeholder="Nom Endroit" >
	<input name="ville" type="text" placeholder="Ville" >
	<input name="location" type="text" placeholder="Location" >
	<input name="desc" type="text" placeholder="Description" >
	<input name="image" type="text" placeholder="Image" >
	 <input type="submit" name="hoteladd" value="Valider" class="btn btn-primary py-3 px-5">
</form>
</body>
</html>