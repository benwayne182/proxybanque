package fr.gtm.proxibanque.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.gtm.proxibanque.metier.CompteCourant;
import fr.gtm.proxibanque.metier.CompteEpargne;
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
public class ConseillerDao implements IConseillerDao{

	
	
	/*@Inject
	CompteCourantDao ccdao;
	@Inject
	CompteEpargneDao cedao;*/
	CompteCourantDao ccdao = new CompteCourantDao();
	CompteEpargneDao cedao = new CompteEpargneDao();
	/**
	 * Méthode de création d'un nouveau conseiller. Les arguments de la méthode sont récupéreés des paramètres issus de la saisie du formulaire de création conseiller. 
	 * 
	 * @param nom
	 * @param prenom
	 * @param identifiant
	 * @param pwd
	 */
	public void creerConseiller(String nom,	String prenom,	String identifiant,	String pwd){
		/*//informations acces bdd
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

		}*/
		// 1 : Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		
		// 2 : Ouverture transaction 
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		// 3 : Instanciation Objet métier
		Conseiller conseiller = new Conseiller(nom, prenom, identifiant, pwd);
		// 4 : Persistance Objet/Relationnel : création d'un enregistrement en base
		em.persist(conseiller);
		// 5 : Fermeture transaction 
		tx.commit();

		// 6 : Fermeture unité de travail JPA 
		em.close();
		emf.close();
		
		
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



	/**
	 * Méthode permettant d'effectuer un virement entre deux comptes
	 * @param numcompteD numéro du compte à débiter
	 * @param numcompteC numéro du compte à créditer
	 * @param montant montant du virement
	 */
	public void virement(int numcompteD, int numcompteC, float montant) {
		CompteCourant ccd= new CompteCourantDao().findCompte(numcompteD);
		CompteEpargne ced= new CompteEpargneDao().findCompte(numcompteD);
		CompteCourant ccc= new CompteCourantDao().findCompte(numcompteC);
		CompteEpargne cec= new CompteEpargneDao().findCompte(numcompteC);

		if (ccd.getSolde()!=null) {
			if (ccc.getSolde()!=null) {
				float soldeCD=Float.parseFloat(ccd.getSolde());
				float soldeCC=Float.parseFloat(ccc.getSolde());
				float decouvertCD=Float.parseFloat(ccd.getDecouvert());
				if((soldeCD+decouvertCD)>=montant) {
					soldeCD-=montant;
					soldeCC+=montant;
					String soldeCDs=String.valueOf(soldeCD);
					String soldeCCs=String.valueOf(soldeCC);
					ccdao.modifCompteC(numcompteD, soldeCDs);
					ccdao.modifCompteC(numcompteC, soldeCCs);

				}else {
					System.out.println("Solde insuffisant sur le compte débité");
				}
			}else if (cec.getSolde()!=null) {
				float soldeCD=Float.parseFloat(ccd.getSolde());
				float soldeCC=Float.parseFloat(cec.getSolde());
				float decouvertCD=Float.parseFloat(ccd.getDecouvert());
				if((soldeCD+decouvertCD)>=montant) {
					soldeCD-=montant;
					soldeCC+=montant;
					String soldeCDs=String.valueOf(soldeCD);
					String soldeCCs=String.valueOf(soldeCC);
					ccdao.modifCompteC(numcompteD, soldeCDs);
					cedao.modifCompteE(numcompteC, soldeCCs);

				}else {
					System.out.println("Solde insuffisant sur le compte débité");
				}
			}else {
				System.out.println("Virement impossible, compte à créditer inexistant");
			}

		}else if (ced.getSolde()!=null) {
			if (ccc.getSolde()!=null) {
				float soldeCD=Float.parseFloat(ced.getSolde());
				float soldeCC=Float.parseFloat(ccc.getSolde());
				if((soldeCD)>=montant) {
					soldeCD-=montant;
					soldeCC+=montant;
					String soldeCDs=String.valueOf(soldeCD);
					String soldeCCs=String.valueOf(soldeCC);
					cedao.modifCompteE(numcompteD, soldeCDs);
					ccdao.modifCompteC(numcompteC, soldeCCs);

				}else {
					System.out.println("Solde insuffisant sur le compte débité");
				}
			}else if (cec.getSolde()!=null) {
				float soldeCD=Float.parseFloat(ced.getSolde());
				float soldeCC=Float.parseFloat(cec.getSolde());
				if((soldeCD)>=montant) {
					soldeCD-=montant;
					soldeCC+=montant;
					String soldeCDs=String.valueOf(soldeCD);
					String soldeCCs=String.valueOf(soldeCC);
					cedao.modifCompteE(numcompteD, soldeCDs);
					cedao.modifCompteE(numcompteC, soldeCCs);

				}else {
					System.out.println("Solde insuffisant sur le compte débité");
				}
			}else {
				System.out.println("Virement impossible, compte à créditer inexistant");
			}

		}else {
			System.out.println("Virement impossible, compte à débiter inexistant");
		}
	}

}
