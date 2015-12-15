<%@page import="fr.gtm.proxibanque.dao.ClientDao"%>
<%@page import="fr.gtm.proxibanque.dao.ConseillerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
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
	<a href="index.html"><img src="pics/pic_title.png" alt="index"
		id="pic_title"></a>



	<%
		ClientDao cl = (ClientDao) session.getAttribute("cdao");
	%>

	<h3><%=cl.getNom() %>
		<%=cl.getPrenom() %></h3>

	<form action="resultCreaCourant" method="post" accept-charset="UTF-8">
		Date d'ouverture du compte <br> <input type="date" name="dateouv"
			class="form-control"> <input type="hidden" name="idclient"
			value=<%=cl.getId()%>> Solde du compte à l'ouverture <br>
		<div class="input-group">
			<div class="input-group-addon">€</div>
			<input type="text" name="solde" placeholder="Solde"
				class="form-control" id="exampleImputAmount">
		</div>
		<br> Découvert autorisé <br>
		<div class="input-group">
			<div class="input-group-addon">€</div>
			<input type="text" name="decouvert" value=1000 class="form-control"
				id="exampleImputAmount">
			<div class="input-group-addon">.00</div>
		</div>

		<input type="radio" name="typec" value="Compte Particulier">
		Compte Particulier <br> <input type="radio" name="typec"
			value="Compte Entreprise" checked> Compte Entreprise <br>
		<input type="submit" value="Création du Compte Courant"
			class="btn btn-info">

	</form>

	<p>
		Envoyez-nous un <a href="mailto:ben.sinivassin@gmail.com"
			class="btn btn-link">mail</a>.
	</p>
</body>
</html>