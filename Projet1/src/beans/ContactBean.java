package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ContactBean {
	 private int id;
	    private String nom;
	    private String prenom;
	    private String email;
	    
	    public ContactBean(int id, String nom, String prenom , String email) {
	        this.id = id;
	        this.nom = nom;
	        this.prenom = prenom;
	        this.email = email;
	    }

		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public static List<ContactBean> getContacts() {
	        List<ContactBean> contacts = new ArrayList<ContactBean>();
	        
	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;
           
	        try {
	            // Charger le driver JDBC Oracle
	            Class.forName("oracle.jdbc.driver.OracleDriver");

	            // Établir une connexion à la base de données Oracle
	            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "kouki");

	            // Créer une requête SQL
	            stmt = conn.createStatement();
	            rs = stmt.executeQuery("SELECT * FROM contact");

	            // Récupérer les résultats de la requête et créer des objets Contact correspondants
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String nom = rs.getString("nom");
	                String prenom = rs.getString("prenom");
	                String email = rs.getString("email");
	                ContactBean contact = new ContactBean(id, nom, prenom,email);
	                contacts.add(contact);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();}
	        finally {
	            // Fermer les ressources de la base de données
	            try {
	                if (rs != null) rs.close();
	                if (stmt != null) stmt.close();
	                if (conn != null) conn.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return contacts;
}
		
		}
