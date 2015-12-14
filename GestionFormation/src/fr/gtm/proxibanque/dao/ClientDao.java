package fr.gtm.proxibanque.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientDao {
	protected String nom;
	protected String prenom;
	protected String adresse;
	protected String codePostal ;
	protected String ville ;
	protected String telephone ;
	protected String email;

	//constructeur
	public ClientDao() {
		// TODO Auto-generated constructor stub
	}

	//setters getters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void creerClient(String nom,	String pre,	String adresse,	String codep, String ville, String tel, String mail){

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
			String sql = "INSERT INTO client (ID, NOM, PRENOM, ADRESSE, CODEPOSTAL, VILLE, TELEPHONE, EMAIL) VALUES (BEN.seqClient.nextval,?,?,?,?,?,?,?)";
			PreparedStatement stm = cn.prepareStatement(sql);
			
			stm.setString(1, nom);
			stm.setString(2, pre);
			stm.setString(3, adresse);
			stm.setString(4, codep);
			stm.setString(5, ville);
			stm.setString(6, tel);
			stm.setString(7, mail);
			
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



/*	public ClientDao lireConseiller(String id, String pwd){

		//informations acces bdd
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String login="ben";
		String passwd="ben";
		Connection cn =null;
		Statement st=null;
		ResultSet rs = null;

		ClientDao consdao= new ClientDao();
		try{
			//Etape 1 : charger driver
			Class.forName("oracle.jdbc.OracleDriver");
			//Etape 2: Creer connexion
			cn=DriverManager.getConnection(url, login, passwd);
			//Etape 3: Creer requete
			st=cn.createStatement();
			String sql= "SELECT * FROM client where login='"+id +"' and password='"+pwd+"'";
			//Etape 4: Executer requete
			rs=st.executeQuery(sql);
			//Etape 5: recuperer le resultat
			while(rs.next()){
				consdao.nom=rs.getString("nom");
				consdao.prenom=rs.getString("prenom");
				consdao.identifiant=rs.getString("login");
				consdao.pwd=rs.getString("password");

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
		return consdao;

	}*/

}
