package fr.gtm.proxibanque.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.gtm.proxibanque.dao.ConseillerDao;
import fr.gtm.proxibanque.metier.Conseiller;
/**
 * Classe de test de DAO du conseiller
 * @author Adminl
 *
 */
public class ConseillerDaoTest{

	ConseillerDao consdao;
	String id; String pwd;
	Connection cn =null;
	ResultSet rs = null;

	/**
	 * Initialization
	 */
	@Before public void initialize() {

		consdao = new ConseillerDao();
		id="ben"; pwd="ben";

	}

	/**
	 * Connection à la base des données: coordonnées du pilote, login et mot de passe
	 */
	@Before public void testConnection() {
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String login="ben";
		String passwd="ben";

		try{
			//Etape 1 : charger driver
			Class.forName("oracle.jdbc.OracleDriver");
			//Etape 2: Creer connexion
			cn=DriverManager.getConnection(url, login, passwd);

		} catch (SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e2){
			e2.printStackTrace();

		}
	}

	/**
	 * tester si la connection existe
	 */
	@Test public void testConnectionNotNull() {
		Assert.assertNotNull(cn);

	}

	/**
	 * Test de la méthode lire un conseiller
	 */
	@Test public void testRead() {
		Conseiller cons=consdao.lireConseiller("ben", "ben");
		Assert.assertThat(cons, IsInstanceOf.instanceOf(Conseiller.class));

	}

	/**
	 * Test de la methode effectuer un virement
	 */
	@Test public void virementTest() {
		consdao.virement(1,2, 500);
	}

	/**
	 * Se deconnecter
	 */
	@After public void closeConnection() {
		try {
			//Etape 5: fermer connec
			cn.close();

		} catch (SQLException e3) {
			e3.printStackTrace();

		}


	}
	
	@Test public void creerConsTestJpa() {
		consdao.creerConseiller("test", "test", "test", "test");
	}

}
