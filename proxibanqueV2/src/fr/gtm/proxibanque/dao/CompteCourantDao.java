package fr.gtm.proxibanque.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.gtm.proxibanque.metier.CompteCourant;

public class CompteCourantDao{

	
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
			System.out.println("Compte courant ajout�");

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
			
			System.out.println("Compte courant trouv�");

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
}
