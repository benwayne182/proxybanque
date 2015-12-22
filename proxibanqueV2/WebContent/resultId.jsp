<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="fr.gtm.proxibanque.dao.ClientDao"%>
<%@page import="fr.gtm.proxibanque.dao.ConseillerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page import="fr.gtm.proxibanque.metier.Conseiller"%>
<%@ page import="fr.gtm.proxibanque.metier.Client"%>
<%@ page import="java.util.HashSet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		Conseiller l = (Conseiller) session.getAttribute("consdao");
		ArrayList<Client> listeclient = (ArrayList<Client>) session.getAttribute("listeclient");
	%>
	<h1>Liste de vos clients</h1>
	<ul>
		<c:forEach var="item" items="${listeclient}">

			<li>
				<h3>Client ${item.id} ${item.prenom} ${item.nom}</h3>
				<form action="redirectLireClient" method="post"
					accept-charset="UTF-8" autocomplete="on" class="form-list-client">

					<input type="hidden" name="idclient" value=${item.id
						}
						readonly="readonly"> <br> <input type="submit"
						value="Modifier le client" class="btn btn-primary">

				</form>
				<form action="redirectSupprClient" method="post"
					accept-charset="UTF-8" autocomplete="on" class="form-list-client">

					<input type="hidden" name="idclient" value=${item.id
						}
						readonly="readonly"> <br> <input type="submit"
						value="Supprimer le client" class="btn btn-primary">

				</form>
				<form action="redirectCompteEpargne" method="post"
					class="form-list-client">
					<input type="hidden" name="idclient" value=${item.id
					}> <input
						type="submit" value="Nouveau Compte Epargne" class="btn btn-info">
				</form>
				<form action="redirectCompteCourant" method="post"
					class="form-list-client">
					<input type="hidden" name="idclient" value=${item.id
					}> <input
						type="submit" value="Nouveau Compte Courant" class="btn btn-info">
				</form>
				<form action="redirectListeCompte" method="post"
					class="form-list-client">
					<input type="hidden" name="idclient" value=${item.id}> <input
						type="submit" value="Liste Comptes Client" class="btn btn-info">
				</form>

			</li>
			<br>

		</c:forEach>
	</ul>

	<br>

	<ul>
		<li><a href="creation_client.jsp" class="btn btn-info"
			role="button">Créer un client</a></li>
	</ul>
		<ul>
		<li><a href="virement.jsp" class="btn btn-info"
			role="button">Effectuer un virement entre deux comptes</a></li>
	</ul>
	<p>
		Envoyez-nous un <a href="mailto:ben.sinivassin@gmail.com"
			class="btn btn-link">mail</a>.
	</p>
</body>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="script.js"></script>
</html>