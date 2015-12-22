<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Virement</title>
</head>


<body>
	<h1>
		Bienvenue<br> <small>sur le site du</small>
	</h1>
	<a href="index.html"><img src="pics/pic_title.png" alt="index"
		id="pic_title"></a>

	<form action="redirectVirement" method="post" accept-charset="UTF-8"
		autocomplete="on">
		<fieldset class="fieldset">
			<legend>Formulaire de Virement</legend>
			Numero de compte débité<br>
			<p>
				<input type="text" class="form-control" name="numdeb" placeholder="Compte débité"
					required>
			</p>
			<br> Numero de compte crédité<br>
			<p>
				<input type="text" class="form-control" name="numcred"
					placeholder="Compte crédité" required>
			</p>
			<br> Montant<br>
			<p>
				<input type="text" class="form-control" name="montant"
					placeholder="Montant">
			</p>
			<br> <input type="submit" value="Virement" class="btn btn-primary">
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
