<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Liste des contacts</title>
</head>
<body>
	<h1>Liste des contacts</h1>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Prénom</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
		            
		
			<c:forEach var="contact" items="${contacts}">
				<tr>
					<td>${contact.id}</td>
					<td>${contact.nom}</td>
					<td>${contact.prenom}</td>
					<td>${contact.email}</td>
				</tr>
			</c:forEach>
            

		</tbody>
	</table>
	
</body>
</html>