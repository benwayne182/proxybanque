<%@page import="fr.gtm.proxibanque.metier.Conseiller"%>
<%@page import="fr.gtm.proxibanque.metier.CompteCourant"%>
<%@page import="fr.gtm.proxibanque.metier.CompteEpargne"%>
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
		Conseiller l = (Conseiller) session.getAttribute("consdao");
		CompteEpargne ce = (CompteEpargne) session.getAttribute("cedao");
		CompteCourant cc = (CompteCourant) session.getAttribute("ccdao");
	%>
	<h2>Liste des comptes du client</h2>
	<div class="table-div">
		<table class="table">

			<tr>
				<td class="fline">Type de compte</td>
				<td class="fline">Numero de compte</td>
				<td class="fline">Solde</td>
				<td class="fline">Statut</td>
			</tr>
			<tr>
				<td>Compte Courant</td>
				<td><%=cc.getNumcompte()%></td>
				<td><%=cc.getSolde()%></td>
				<td><%=cc.getStatut()%></td>
			</tr>
			<tr>
				<td>Compte Epargne</td>
				<td><%=ce.getNumcompte()%></td>
				<td><%=ce.getSolde()%></td>
				<td></td>
			</tr>
		</table>
	</div>
	<ul>
		<li>Retour à la page conseiller <br>
			<form action="redirect" method="post">
				<input type="hidden" name="id" value=<%=l.getLogin()%>>
				<input type="hidden" name="password" value=<%=l.getPwd()%>>
				<br> <input type="submit" value="Espace conseiller"
					class="btn btn-info">
			</form></li>
	</ul>
	<p>
		Envoyez-nous un <a href="mailto:ben.sinivassin@gmail.com"
			class="btn btn-link">mail</a>.
	</p>
</body>
</html>