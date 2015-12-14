package fr.gtm.proxibanque.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConseillerDao {
	protected int idConseiller;
	protected String nom;
	protected String prenom;
	protected String identifiant;
	protected String pwd;

	//constructeur
	public ConseillerDao() {
		// TODO Auto-generated constructor stub
	}

	//setters getters
	public int getIdConseiller() {
		return idConseiller;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}


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

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

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



	public ConseillerDao lireConseiller(String id, String pwd){

		//informations acces bdd
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String login="ben";
		String passwd="ben";
		Connection cn =null;
		Statement st=null;
		ResultSet rs = null;

		ConseillerDao consdao= new ConseillerDao();
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
				consdao.idConseiller=rs.getInt("id");
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

	}

}
