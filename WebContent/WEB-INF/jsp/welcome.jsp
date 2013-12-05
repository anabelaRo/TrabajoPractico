<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bienvenido</title>
</head>
<body>
	<p>${message}</p>
	<a href="../misMensajes.do">Ver Publicaciones De Mi Empresa</a>
	<form action="../publicar.do" method="post">
		<textarea rows="4" cols="10" name="contenido"></textarea>
		<input type="submit" value="Publicar" />
	</form>
	<a href="../empresas.do">Ver Empresas</a>
	<a href="../misEmpresas.do">Ver Empresas Que Sigo</a>
</body>
</html>