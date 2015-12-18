Proxibanque V2 SI - description
Le conseiller s'identifie grâce à son login et mot de passe. Une fois l'identification réussie s'affiche sa liste de clients. Une erreur d'identification envoie un message d'erreur et le conseiller est invité à renseigner de nouveau ses identifiants.
La liste de clients affiche pour chaque client le numéro client qui lui est affecté, son nom et son prénom.
Options à la disposition du conseiller pour chaque client :
- modifier les informations du client
- supprimer le client
- créer un compte courant pour le client
- créer un compte épargne pour le client
- accéder à la liste de comptes ouverts pour ce client
La création de compte courant ou compte épargne dirige le conseiller vers une page de formulaire lui permettant de rentrer les informations nécessaires à la création du compte en base.
Une fois le compte créé, le conseiller est redirigé vers son écran d'accueil pour poursuivre son activité.



Guide de l'utilisateur
Installation de l'application
- database oracle
	L'application s'installe sur un poste ayant accès à une base de données ORACLE version 11.
- script pour création des tables
	Copier le chemin d'accès au script SQL de création des tables 
	Ouvrir une fenêtre de ligne de commande SQL*Plus, se connecter en entrant la ligne suivante (sans les guillemets) puis en validant : "connect system/system"
	Vous êtes à présent connecté.
	Taper (sans guillemets) "@" puis coller le chemin d'accès au script en enlevant l'extension .sql, comme dans l'exemple suivant: SQL> @C:\Users\Adminl\Desktop\scrapbookSQL (pour exécuter le script scrapbookSQL.sql).
	Les tables sont à présent créées et prêtes à être utilisées par les employés
	
- déploiement de l'application
	Démarrer le serveur d'application Tomcat
	Glisser le livrable (fichier avec extension *.war) dans répertoire Webapps du dossier d'installation de Tomcat
	Une fois l'	application déployée, un dossier au nom du fichier war est visible dans le répertoire Webapps.
	Démarrer le navigateur, rentrer l'adresse suivante "http://localhost:8080/proxibanquev2/" (sans guillemets)
	Vous êtes à présent sur la page d'accueil de l'application.
	

	
Fonctionnalités de l'application
- créer conseiller
	sur l'écran d'accueil,cliquer sur le bouton "créer conseiller"
	remplir le formulaire
	cocher la case "j'accepte les CGU" avant de valider ("submit")
	
- créer client
	S'identifier en tant que conseiller en renseignant login et mot de passe.
	La liste des clients du conseiller s'affiche, avec les actions possibles pour chaque client.
	A la fin de la liste, cliquer sur le bouton "créer client". Remplir le formulaire et valider. 
	Au retour sur la page d'accueil conseiller, le nouveau client est ajouté à la liste.

- modifier client
	Cliquer sur le bouton "modifier client" sur la page d'accueil conseiller
	Rentrer les valeurs à modifier
	Cliquer sur valider
	Une confirmation apparaît, cliquer sur le bouton "retour" pour revenir à la page d'accueil conseiller
	Le bouton "accueil" dirige le conseiller vers la page de login de l'application
	
- supprimer client
	Cliquer sur le bouton "supprimer client" sur la page d'accueil conseiller
	Une confirmation apparaît
	
- créer un compte
	La procédure pour créer un compte courant ou un compte épargne est similaire 
	Cliquer sur le bouton "créer compte courant" ou "créer compte épargne"
	Renseigner les champs demandés, pouis valider
	Une confirmation apparaît
	
- visualiser la liste de compte par client
	cliquer sur le bouton "liste compte" pour le client sélectionné
	La liste des comptes pour le client apparaît
