<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bienvenido</title>
</head>
<body>
	<a href="login/welcome.do">Volver</a>
	<c:forEach items="${misMensajes}" var="unMensaje">
  			<p>${unMensaje.contenido}</p>
  			<br/>  				
  	</c:forEach>
</body>
</html>