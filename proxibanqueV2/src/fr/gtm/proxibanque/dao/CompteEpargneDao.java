package fr.gtm.proxibanque.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.gtm.proxibanque.metier.CompteEpargne;

/**
 * Classe implementant l'interface {@link fr.gtm.proxibanque.dao.ICompteEpargneDao}
 * @author Adminl
 *
 */
public class CompteEpargneDao implements ICompteEpargneDao{


	/**
	 * Constructeur
	 */
	public CompteEpargneDao() {

	}

	public void creerCompte(String idclient, String dateOuverture, String solde, String tauxRemuneration){

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
			String sql = "INSERT INTO compteepargne (NUMCOMPTE, DATECREA, SOLDE, IDCLIENT, TAUXREM) VALUES (BEN.seqCompte.nextval,?,?,?,?)";
			PreparedStatement stm = cn.prepareStatement(sql);

			stm.setString(1, dateOuverture);
			stm.setString(2, solde);
			stm.setString(3, idclient);
			stm.setString(4, tauxRemuneration);


			//Etape 4: Executer requete
			stm.executeUpdate();
			System.out.println("Compte �pargne ajout�");

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

	public CompteEpargne lireCompte(String idclient){

		//informations acces bdd
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String login="ben";
		String passwd="ben";
		Connection cn =null;
		Statement st=null;
		ResultSet rs = null;
		CompteEpargne c=new CompteEpargne();
		try{
			//Etape 1 : charger driver
			Class.forName("oracle.jdbc.OracleDriver");
			//Etape 2: Creer connexion
			cn=DriverManager.getConnection(url, login, passwd);
			//Etape 3: Creer requete
			st=cn.createStatement();
			String sql= "SELECT * FROM compteepargne where idclient='"+idclient+"'";
			//Etape 4: Executer requete
			rs=st.executeQuery(sql);

			while(rs.next()){
				c.setSolde(rs.getString("solde"));
				c.setNumcompte(rs.getString("numcompte"));
			}
			System.out.println("Compte �pargne trouv�");

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
	 * Methode permettant de trouver un compte �pargne en fonction de son numero de compte
	 * @param numcompteD
	 * @return
	 */
	public CompteEpargne findCompte(int numcompteD) {
		//informations acces bdd
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String login="ben";
		String passwd="ben";
		Connection cn =null;
		Statement st=null;
		ResultSet rs = null;
		CompteEpargne c=new CompteEpargne();
		try{
			//Etape 1 : charger driver
			Class.forName("oracle.jdbc.OracleDriver");
			//Etape 2: Creer connexion
			cn=DriverManager.getConnection(url, login, passwd);
			//Etape 3: Creer requete
			st=cn.createStatement();
			String sql= "SELECT * FROM compteepargne where numcompte='"+numcompteD+"'";
			//Etape 4: Executer requete
			rs=st.executeQuery(sql);

			while(rs.next()){
				c.setSolde(rs.getString("solde"));
				c.setNumcompte(rs.getString("numcompte"));
				c.setDateOuverture(rs.getString("datecrea"));
				c.setTauxRemuneration(rs.getString("tauxrem"));
			}

			System.out.println("Recherche de compte �pargne effectu�e");

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
	
	
	public void modifCompteE(int numcompteC, String solde){

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
			String sql = "UPDATE compteepargne SET solde =? WHERE numcompte="+numcompteC;
			PreparedStatement stm = cn.prepareStatement(sql);

			Float soldeF=Float.parseFloat(solde);
			stm.setFloat(1, soldeF);


			//Etape 4: Executer requete
			stm.executeUpdate();
			System.out.println("Compte modifi�");

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
