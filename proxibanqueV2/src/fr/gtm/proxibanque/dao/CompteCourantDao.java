package fr.gtm.proxibanque.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.gtm.proxibanque.metier.CompteCourant;

public class CompteCourantDao implements ICompteCourantDao{


	//constructeur(vide)
	public CompteCourantDao() {

	}


	public void creerCompte(String idclient, String dateOuverture, String solde, String decouvert, String statut){

		//informations acces bdd
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String login="ben";
		String passwd="ben";
		Connection cn =null;

		try{
			//Etape 1 : charger driver
			Class.forName("oracle.jdbc.OracleDriver");
			//Etape 2: Creer connexion
			cn=DriverManager.getConnection(url, login, passwd);
			//Etape 3: Creer requete
			String sql = "INSERT INTO comptecourant (NUMCOMPTE, DATECREA, SOLDE, IDCLIENT, DECOUVERT, STATUT) VALUES (BEN.seqCompte.nextval,?,?,?,?,?)";
			PreparedStatement stm = cn.prepareStatement(sql);

			stm.setString(1, dateOuverture);
			stm.setString(2, solde);
			stm.setString(3, idclient);
			stm.setString(4, decouvert);
			stm.setString(5, statut);


			//Etape 4: Executer requete
			stm.executeUpdate();
			System.out.println("Compte courant ajouté");

		} catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e2){
			e2.printStackTrace();

		} finally{
			try {
				//Etape 5: fermer connec
				cn.close();
				//st.close();

			} catch (SQLException e3) {
				e3.printStackTrace();

			}

		}

	}

	public CompteCourant lireCompte(String idclient){

		//informations acces bdd
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String login="ben";
		String passwd="ben";
		Connection cn =null;
		Statement st=null;
		ResultSet rs = null;
		CompteCourant c=new CompteCourant();
		try{
			//Etape 1 : charger driver
			Class.forName("oracle.jdbc.OracleDriver");
			//Etape 2: Creer connexion
			cn=DriverManager.getConnection(url, login, passwd);
			//Etape 3: Creer requete
			st=cn.createStatement();
			String sql= "SELECT * FROM comptecourant where idclient='"+idclient+"'";
			//Etape 4: Executer requete
			rs=st.executeQuery(sql);

			while(rs.next()){
				c.setSolde(rs.getString("solde"));
				c.setNumcompte(rs.getString("numcompte"));
				c.setStatut(rs.getString("statut"));
			}

			System.out.println("Compte courant trouvé");

		} catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e2){
			e2.printStackTrace();

		} finally{
			try {
				//Etape 5: fermer connec
				cn.close();

			} catch (SQLException e3) {
				e3.printStackTrace();

			}

		}
		return c;

	}

	/**
	 * Methode permettant de trouver un compte courant en fonction de son numero de compte
	 * @param numcompte
	 * @return
	 */
	public CompteCourant findCompte(int numcompte) {
		//informations acces bdd
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String login="ben";
		String passwd="ben";
		Connection cn =null;
		Statement st=null;
		ResultSet rs = null;
		CompteCourant c=new CompteCourant();
		try{
			//Etape 1 : charger driver
			Class.forName("oracle.jdbc.OracleDriver");
			//Etape 2: Creer connexion
			cn=DriverManager.getConnection(url, login, passwd);
			//Etape 3: Creer requete
			st=cn.createStatement();
			String sql= "SELECT * FROM comptecourant where numcompte='"+numcompte+"'";
			//Etape 4: Executer requete
			rs=st.executeQuery(sql);

			while(rs.next()){
				c.setSolde(rs.getString("solde"));
				c.setNumcompte(rs.getString("numcompte"));
				c.setStatut(rs.getString("statut"));
				c.setDateOuverture(rs.getString("datecrea"));
				c.setDecouvert(rs.getString("decouvert"));
			}

			System.out.println("Recherche de compte courant effectuée");

		} catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e2){
			e2.printStackTrace();

		} finally{
			try {
				//Etape 5: fermer connec
				cn.close();

			} catch (SQLException e3) {
				e3.printStackTrace();

			}

		}
		return c;
	}
	
	public void modifCompteC(int numcompte, String solde){

		//informations acces bdd
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String login="ben";
		String passwd="ben";
		Connection cn =null;

		try{
			//Etape 1 : charger driver
			Class.forName("oracle.jdbc.OracleDriver");
			//Etape 2: Creer connexion
			cn=DriverManager.getConnection(url, login, passwd);
			//Etape 3: Creer requete
			String sql = "UPDATE comptecourant SET solde =? WHERE numcompte="+numcompte;
			PreparedStatement stm = cn.prepareStatement(sql);

			Float soldeF=Float.parseFloat(solde);
			stm.setFloat(1, soldeF);


			//Etape 4: Executer requete
			stm.executeUpdate();
			System.out.println("Compte modifié");

		} catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e2){
			e2.printStackTrace();

		} finally{
			try {
				//Etape 5: fermer connec
				cn.close();

			} catch (SQLException e3) {
				e3.printStackTrace();

			}

		}

	}
}
