<%@page import="fr.gtm.proxibanque.metier.Conseiller"%>
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
<title>Création client</title>
</head>
<h1>
	Bienvenue<br> <small>sur le site du</small>
</h1>
<a href="index.html"><img src="pics/pic_title.png" alt="index"
	id="pic_title"></a>
<body>
	<%
	Conseiller l = (Conseiller) session.getAttribute("consdao");

	%>
	<h1>Vous avez à présent créé un compte sur ProxibanqueSI.</h1>





	<ul>
		<li>Retour à la page conseiller <br>
			<form action="redirect" method="post">
				<input type="hidden" name="id" value=<%=l.getLogin()%>>
				<input type="hidden" name="password" value=<%=l.getPwd()%>>
				<br> <input type="submit" value="Espace conseiller"
					class="btn btn-info">
			</form></li>
	</ul>
</body>
</html>