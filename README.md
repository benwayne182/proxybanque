# proxibanque

##Description V3
Le conseiller s'identifie grâce à son login et mot de passe. Une fois l'identification réussie s'affiche sa liste de clients. Une erreur d'identification envoie un message d'erreur et le conseiller est invité à renseigner de nouveau ses identifiants.
La liste de clients affiche pour chaque client le numéro client qui lui est affecté, son nom et son prénom.
Options à la disposition du conseiller pour chaque client :

* modifier les informations du client
* supprimer le client
* créer un compte courant pour le client
* créer un compte épargne pour le client
* accéder à la liste de comptes ouverts pour ce client

La création de compte courant ou compte épargne dirige le conseiller vers une page de formulaire lui permettant de rentrer les informations nécessaires à la création du compte en base.
Une fois le compte créé, le conseiller est redirigé vers son écran d'accueil pour poursuivre son activité.

##Documentation
Veuillez suivre les indications suivantes:

1. Ouvrez le dossier *proxibanque*.
2. Ouvrez le dossier *doc*.
3. Double cliquez sur *index.html*.

##Guide de l'utilisateur
###Installation de l'application
L'application s'installe sur un poste ayant accès à une base de données ORACLE version 11 et le serveur d'application Tomcat v8.0.

####Script pour création des tables
1. Depuis la ligne de commande SQL (connectés au compte de système), créez un nouveau utilisateur "ben", mot de passe "ben"
```sql
create user ben identified by ben;
grant connect, resource to ben;
```
Connectez vous à l'utilisateur ben
```sql
connect ben/ben
```
Vous êtes à présent connecté.

Taper le chemin d'acces au au script en enlevant l'extension .sql, comme dans l'exemple suivant, pour le script *script.sql*
```sql
@"/path/"script
```
où "/path" est le chemin de l'emplacement du fichier sur le disque.
Les tables sont à présent créées et prêtes à être utilisées par les employés.

###Déploiement de l'application

1. Démarrer le serveur d'application Tomcat en cliquant sur le fichier "bin\startup.bat"
2. Glisser le livrable (fichier avec extension *.war) dans répertoire Webapps du dossier d'installation de Tomcat
3. Une fois l'application déployée, un dossier au nom du fichier war est visible dans le répertoire Webapps.
4. Démarrer le navigateur, rentrer l'adresse suivante <http://localhost:8080/proxibanque/>
5. Vous êtes à présent sur la page d'accueil de l'application.

###Fonctionnalités de l'application

####Créer conseiller
1. Sur l'écran d'accueil,cliquer sur le bouton *Créer conseiller*
2. Remplir le formulaire
3. Cocher la case *J'accepte les CGU* avant de valider (*Submit*)
	
####Créer client

1. S'identifier en tant que conseiller en renseignant login et mot de passe.
2. La liste des clients du conseiller s'affiche, avec les actions possibles pour chaque client.
3. A la fin de la liste, cliquer sur le bouton *Créer client*. Remplir le formulaire et valider. 
4. Au retour sur la page d'accueil conseiller, le nouveau client est ajouté à la liste.

####Modifier client
1. Cliquer sur le bouton *Modifier client* sur la page d'accueil conseiller
2. Rentrer les valeurs à modifier
3. Cliquer sur valider
4. Une confirmation apparaît, cliquer sur le bouton *Retour* pour revenir à la page d'accueil conseiller
5. Le bouton *Accueil* dirige le conseiller vers la page de login de l'application
	
####Supprimer client
1. Cliquer sur le bouton *Supprimer client* sur la page d'accueil conseiller
2. Une confirmation apparaît
	
####Créer un compte
1. La procédure pour créer un compte courant ou un compte épargne est similaire 
2. Cliquer sur le bouton *Créer compte courant* ou *Créer compte épargne*
3. Renseigner les champs demandés, puis valider
4. Une confirmation apparaît
	
####Visualiser la liste de compte par client
1. Cliquer sur le bouton *Liste compte* pour le client sélectionné
2. La liste des comptes pour le client apparaît
