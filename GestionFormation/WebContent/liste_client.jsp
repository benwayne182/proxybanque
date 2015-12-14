<%@page import="fr.gtm.proxibanque.dao.ConseillerDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<%@ page import="fr.gtm.proxibanque.dao.ConseillerDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="style.css" />
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
<title>Login Conseiller Proxibanque</title>
</head>
<body>
	<h1>
		Bienvenue<br> <small>sur le site du</small>
	</h1>
	<a href="index.html"><img src="pics/logo_CA.jpg" alt="index"
		width=300px class="img-rounded"></a>



	<%
		ConseillerDao l = (ConseillerDao) session.getAttribute("consdao");
	%>
	<ul>
		<li>Création client<br> <a href="creation_client.jsp"
			class="btn btn-info" role="button">Créer un client</a></li>
		<li>Consultation client <br> <a href="liste_client.jsp" class="btn btn-info"
			role="button">Consulter votre liste de clients</a></li>
	</ul>
	<p>
		Envoyez-nous un <a href="mailto:ben.sinivassin@gmail.com"
			class="btn btn-link">mail</a>.
	</p>
</body>
</html>