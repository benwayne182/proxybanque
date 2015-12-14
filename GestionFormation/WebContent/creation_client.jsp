<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<%@ page import="fr.gtm.proxibanque.dao.ConseillerDao"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
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
<title>Creation client</title>
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

	<form action="redirectCreaClient" method="post" accept-charset="UTF-8"
		autocomplete="on">
		<fieldset class="fieldset">
			<legend>Formulaire de création de client</legend>
			Nom<br>
			<p>
				<input type="text" class="form-control" name="nom" placeholder="Nom"
					required>
			</p>
			<br> Prenom<br>
			<p>
				<input type="text" class="form-control" name="prenom"
					placeholder="Prénom" required>
			</p>
			<br> Adresse<br>
			<p>
				<input type="text" class="form-control" name="adresse"
					placeholder="Adresse">
			</p>
			<br> Code Postal<br>
			<p>
				<input type="text" class="form-control" name="codepostal"
					placeholder="Code Postal">
			</p>
			<br> Ville<br>
			<p>
				<input type="text" class="form-control" name="ville"
					placeholder="Ville">
			</p>
			<br> Telephone<br>
			<p>
				<input type="text" class="form-control" name="telephone"
					placeholder="Telephone">
			</p>
			<br> E-mail<br>
			<p>
				<input type="email" class="form-control" name="email"
					placeholder="E-mail">
			</p>
			<p>
				<input type="hidden" name="idconseiller"
					value=<%=l.getIdConseiller()%> readonly="readonly">
			</p>
			<br> <input type="submit" value="Submit" class="btn btn-primary">
		</fieldset>
	</form>
<body>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</html>
