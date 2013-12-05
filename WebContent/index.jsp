<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>mi Timeline</title>
		
		<style type="text/css">
body{
	background-color: #CEF6F5;
	font-family: 'Source Sans Pro', sans-serif;
	font-size: 20px;

}


#contenedor{  
		text-align:center;
  width: 1200px;"WebContent/META-INF"
  display: block;
  margin-left: auto;
  margin-right: auto;
}
#head{

	color:#646464;
	font-family: 'Crimson Text', serif; font-weight: 700; 
	padding-left: 4px;
	width:97%;
	height:20%;
	background-color: #BFD5D7;
	float: left;
	clear:both;
	margin-bottom: 2px;

}


#body1{
	padding-left: 4px;
	width:20%;
	height:70%;
	background-color: #0080FF;
	float: left;
	margin-right: 2px;
}

#body2{

	padding-left: 4px;
	width:38%;
	height:70%;
	background-color: #086A87;
	float: left;
	margin-right: 2px;
}
#body3{
	padding-left: 4px;
	width:38%;
	height:70%;
	background-color: #088A85;
	float: left;
}
#footer{
	padding-left: 4px;
	width:97%;
	height:10%;
	background-color: #646464;
	float: left;
	clear:both;
	

}

#box{
	text-align: right;
	width:600px;
	clear:both;
	float:left;
		}

#left{
	width:150px;
	float:left;
	clear:left;
	margin-right:10px;
}
#right{
	width:150px;
	float:left;
	clear:right;
}



.input{
	height:20px;
    width:150px;
    background:#FDFDFD;
    border:2px solid #A3F7E2;
    padding:10px;
    margin-top:5px;
    font-size:14px;

    color:#5B5F5E;
    box-shadow: 2px 2px 5px #999;
}
</style>
		

	</head>
	<body>
	<%-- 	<jsp:useBean id="userLogin" scope="request" --%>
	<%-- 		class="ar.edu.unlam.talleweb.timelineme.beans.UserBean" /> --%>
	
		<div class="alert">
			${message}
		</div>
		<form action="login/auth.do" class="form-horizontal" method='POST'>
			<div class="control-group">
				<label class="control-label" for="inputUsername">Nombre de usuario</label>
				<div class="controls">
					<input type="text" name="username" id="inputUsername" placeholder="jack">
					
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">Contraseña</label>
				<div class="controls">
					<input type="password" name="password" id="inputPassword" placeholder="Contraseña">
				
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn">Ingresar</button>
				</div>
			</div>
		</form>
		<form action="login/registrar.do" class="form-horizontal" method='POST'>
			<div class="control-group">
				<label class="control-label" for="inputUsername">Nombre de usuario</label>
				<div class="controls">
					<input type="text" name="username" id="inputUsername" placeholder="jack">
					
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">Contraseña</label>
				<div class="controls">
					<input type="password" name="password" id="inputPassword" placeholder="Contraseña">
				
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">Empresa</label>
				<div class="controls">
					<input type="text" name="empresa" id="inputEmpresa" placeholder="Contraseña">
				
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn">Registrar</button>
				</div>
			</div>
		</form>
	</body>
</html>