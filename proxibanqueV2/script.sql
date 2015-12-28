Prompt *******************************************************************************
Prompt BIENVENUE DANS LE PROGRAMME D INSTALLATION DE PROXIBANQUE SI
Prompt *******************************************************************************

Prompt PREPARATION DE LA BASE DE DONNEES

--suppression tables
drop table client cascade constraints purge;
drop table conseiller cascade constraints purge;
drop table comptecourant cascade constraints purge;
drop table compteepargne cascade constraints purge;
-- suppression sequences
drop sequence seqCons;
drop sequence seqClient;
drop sequence seqCompte;

Prompt CREATION DES TABLES DE LA BASE DE DONNEES

--Creation sequences
CREATE SEQUENCE seqCons
START WITH     1
INCREMENT BY   1;
 
CREATE SEQUENCE seqClient 
START WITH     1
INCREMENT BY   1;

CREATE SEQUENCE seqCompte 
START WITH     1
INCREMENT BY   1;
 
-- Creation tables 
create table conseiller(id int constraint pk_conseiller primary key, nom varchar(20), prenom varchar(20), login varchar(20) unique, password varchar(30));
create table client(id int constraint pk_client primary key, nom varchar(60), prenom varchar(60), adresse varchar(60), codePostal varchar(5), ville varchar(60), telephone varchar(10), email varchar(60), idConseiller int constraint fk_idcons references conseiller(id) on delete cascade);
create table comptecourant(numcompte number, dateCrea varchar(30), solde number, idclient int constraint pk_comptecourant primary key constraint fk_idclientcourant references client(id) on delete cascade, decouvert number, statut varchar(20));
create table compteepargne(numcompte number, dateCrea varchar(30), solde number, idclient int constraint pk_compteepargne primary key constraint fk_idclientepargne references client(id) on delete cascade, tauxrem varchar(5));
commit;

Prompt *******************************************************************************
prompt FIN DE CREATION DE LA BASE
Prompt *******************************************************************************
