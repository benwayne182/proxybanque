package fr.gtm.proxibanque.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.gtm.proxibanque.dao.ConseillerDao;

public class ConseillerDaoTest{
	
	ConseillerDao consdao;
	String id; String pwd;
	Connection cn =null;
	ResultSet rs = null;
	
    @Before public void initialize() {

		consdao = new ConseillerDao(null, null, null, null);
		id="ben"; pwd="ben";

     }
    
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
    
    @Test public void test() {
    	Assert.assertNotNull(cn);
    	
    }
     
    
    @After public void closeConnection() {
			try {
				//Etape 5: fermer connec
				cn.close();

			} catch (SQLException e3) {
				e3.printStackTrace();

			}

		
    }

}
