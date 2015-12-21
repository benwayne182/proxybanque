package fr.gtm.proxibanque.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.gtm.proxibanque.metier.Conseiller;
/**
 * Classe permettant la communication avec la table "Conseiller" de la base de données.
 * Permet de créer un nouveau conseiller et d'extraire les informations de la table.
 * 
 * 
 * 
 * @author BS, ML
 * @version 2.0
 *
 */
public class ConseillerDao {

/**
 * Méthode de création d'un nouveau conseiller. Les arguments de la méthode sont récupéreés des paramètres issus de la saisie du formulaire de création conseiller. 
 * 
 * @param nom
 * @param prenom
 * @param identifiant
 * @param pwd
 */
	public void creerConseiller(String nom,	String prenom,	String identifiant,	String pwd){
		//informations acces bdd
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String login="ben";
		String passwd="ben";
		Connection cn =null;
		Statement st=null;

		try{
			//Etape 1 : charger driver
			Class.forName("oracle.jdbc.OracleDriver");
			//Etape 2: Creer connexion
			cn=DriverManager.getConnection(url, login, passwd);
			//Etape 3: Creer requete
			st=cn.createStatement();

			String sql= "INSERT INTO conseiller (ID, NOM, PRENOM, LOGIN, PASSWORD) VALUES (BEN.seqCons.nextval,'"+nom+"','"+prenom+"','"+identifiant+"','"+pwd+"')";
			//Etape 4: Executer requete
			st.executeUpdate(sql);
			System.out.println("Conseiller ajouté");

		} catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e2){
			e2.printStackTrace();

		} finally{
			try {
				//Etape 5: fermer connec
				cn.close();
				st.close();

			} catch (SQLException e3) {
				e3.printStackTrace();

			}

		}

	}


/**
 * Méthode permettant d'extraire les informations d'un conseiller suite à la saisie de son login et de son mot de passe.
 * 
 * @param id
 * @param pwd
 * @return
 */
	public Conseiller lireConseiller(String id, String pwd){

		//informations acces bdd
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String login="ben";
		String passwd="ben";
		Connection cn =null;
		Statement st=null;
		ResultSet rs = null;

		Conseiller cons= new Conseiller();
		try{
			//Etape 1 : charger driver
			Class.forName("oracle.jdbc.OracleDriver");
			//Etape 2: Creer connexion
			cn=DriverManager.getConnection(url, login, passwd);
			//Etape 3: Creer requete
			st=cn.createStatement();
			String sql= "SELECT * FROM conseiller where login='"+id +"' and password='"+pwd+"'";
			//Etape 4: Executer requete
			rs=st.executeQuery(sql);
			//Etape 5: recuperer le resultat
			while(rs.next()){
				cons.setIdConseiller(rs.getInt("id"));
				cons.setNom(rs.getString("nom"));
				cons.setPrenom(rs.getString("prenom"));
				cons.setIdentifiant(rs.getString("login"));
				cons.setPwd(rs.getString("password"));

			}
			System.out.println("Conseiller trouvé");

		} catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e2){
			e2.printStackTrace();

		} finally{
			try {
				//Etape 5: fermer connec
				cn.close();
				st.close();

			} catch (SQLException e3) {
				e3.printStackTrace();

			}

		}
		return cons;

	}

}
