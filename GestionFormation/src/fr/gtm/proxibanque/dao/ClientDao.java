package fr.gtm.proxibanque.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.gtm.proxibanque.metier.Client;
/**
 * 
 * @author BS, ML
 *
 */
public class ClientDao extends Client{
 //constructeur

	public ClientDao(String nom, String prenom, String adresse, String codePostal, String ville, String telephone) {
		super(nom, prenom, adresse, codePostal, ville, telephone);
	}

	/**
	 * @param nom
	 * @param pre
	 * @param adresse
	 * @param codep
	 * @param ville
	 * @param tel
	 * @param mail
	 * @param idcons
	 */
	public void creerClient(String nom,	String pre,	String adresse,	String codep, String ville, String tel, String mail, String idcons){

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
			String sql = "INSERT INTO client (ID, NOM, PRENOM, ADRESSE, CODEPOSTAL, VILLE, TELEPHONE, EMAIL, idConseiller) VALUES (BEN.seqClient.nextval,?,?,?,?,?,?,?,?)";
			PreparedStatement stm = cn.prepareStatement(sql);

			stm.setString(1, nom);
			stm.setString(2, pre);
			stm.setString(3, adresse);
			stm.setString(4, codep);
			stm.setString(5, ville);
			stm.setString(6, tel);
			stm.setString(7, mail);
			stm.setString(8, idcons);


			//Etape 4: Executer requete
			stm.executeUpdate();
			System.out.println("Client ajouté");

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


	/**
	 * @param idconseiller
	 * @return
	 */
	public ArrayList<ClientDao> lireClients(int idconseiller){

		//informations acces bdd
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String login="ben";
		String passwd="ben";
		Connection cn =null;
		Statement st=null;
		ResultSet rs = null;

		ArrayList<ClientDao> listeclient= new ArrayList<ClientDao>();
		try{
			//Etape 1 : charger driver
			Class.forName("oracle.jdbc.OracleDriver");
			//Etape 2: Creer connexion
			cn=DriverManager.getConnection(url, login, passwd);
			//Etape 3: Creer requete
			st=cn.createStatement();
			String sql= "SELECT * FROM client where idconseiller='"+idconseiller+"'";
			//Etape 4: Executer requete
			rs=st.executeQuery(sql);
			//Etape 5: recuperer le resultat


			while(rs.next()){
				ClientDao client=new ClientDao(nom, prenom, adresse, codePostal, ville, telephone);
				client.setId(rs.getString("id"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getString("prenom"));
				client.setAdresse(rs.getString("adresse"));
				client.setCodePostal(rs.getString("codepostal"));
				client.setVille(rs.getString("ville"));
				client.setTelephone(rs.getString("telephone"));
				client.setEmail(rs.getString("email"));
				client.setIdconseiller(rs.getInt("idconseiller"));

				listeclient.add(client);

			}
			System.out.println("Liste client trouvée");


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
		return listeclient;

	}

	/**
	 * @param idclient
	 * @return
	 */
	public ClientDao lireClient(String idclient){

		//informations acces bdd
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String login="ben";
		String passwd="ben";
		Connection cn =null;
		Statement st=null;
		ResultSet rs = null;
		ClientDao client=new ClientDao(nom, prenom, adresse, codePostal, ville, telephone);
		try{
			//Etape 1 : charger driver
			Class.forName("oracle.jdbc.OracleDriver");
			//Etape 2: Creer connexion
			cn=DriverManager.getConnection(url, login, passwd);
			//Etape 3: Creer requete
			st=cn.createStatement();
			String sql= "SELECT * FROM client where id='"+idclient+"'";
			//Etape 4: Executer requete
			rs=st.executeQuery(sql);

			while(rs.next()){
				client.setId(rs.getString("id"));
				client.setNom(rs.getString("nom"));
				client.setPrenom(rs.getString("prenom"));
				client.setAdresse(rs.getString("adresse"));
				client.setCodePostal(rs.getString("codepostal"));
				client.setVille(rs.getString("ville"));
				client.setTelephone(rs.getString("telephone"));
				client.setEmail(rs.getString("email"));
				client.setIdconseiller(rs.getInt("idconseiller"));

			}
			System.out.println("Client trouvé");

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
		return client;

	}
	/**
	 * @param idclient
	 * @param nom
	 * @param pre
	 * @param adresse
	 * @param codep
	 * @param ville
	 * @param mail
	 * @param idcons
	 */
	public void modifClient(String idclient, String nom, String pre,	String adresse,	String codep, String ville, String mail, String idcons){

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
			String sql = "UPDATE CLIENT SET NOM =?, PRENOM =?, ADRESSE =?, CODEPOSTAL =?, VILLE =?, EMAIL =?, idConseiller =? WHERE id="+idclient;
			PreparedStatement stm = cn.prepareStatement(sql);

			stm.setString(1, nom);
			stm.setString(2, pre);
			stm.setString(3, adresse);
			stm.setString(4, codep);
			stm.setString(5, ville);
			stm.setString(6, mail);
			stm.setString(7, idcons);


			//Etape 4: Executer requete
			stm.executeUpdate();
			System.out.println("Client modifié");

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

	/**
	 * @param idclient
	 */
	public void supprClient(String idclient){

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
			String sql = "DELETE FROM client WHERE id="+idclient;


			//Etape 4: Executer requete
			st.executeQuery(sql);
			System.out.println("Client supprimé");

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
}
