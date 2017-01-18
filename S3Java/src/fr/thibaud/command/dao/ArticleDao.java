package fr.thibaud.command.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.thibaud.command.bo.Article;
import fr.thibaud.command.bo.Ramette;
import fr.thibaud.command.bo.Stylo;

public class ArticleDao {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	static final String DB_URL = "jdbc:sqlserver://localhost/TPJSE_Commande";
	//  Database credentials
	static final String USER = "sa";
	static final String PASS = "Pa$$w0rd";
	public static Article[] getArticles () {
		Connection con = null;
		Statement statement = null;
		Article article = null;
		Article[] articles = null;
		String sql = null, reference = null, marque = null, designation = null, couleur = null, type = null;
		int qteStock = 0, grammage = 0, index = 0;
		float prixUnitaire = (float) 0.0;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = con.createStatement();
			sql = "Select * from Articles";
			rs = statement.executeQuery(sql);
			articles = new Article[rs.getFetchSize()];
			while (rs.next()) {
				marque = rs.getString("marque");
				reference = rs.getString("reference");
				designation = rs.getString("designation");
				prixUnitaire = rs.getFloat("prixUnitaire");
				qteStock = rs.getInt("qteStock");
				type = rs.getString("type");
				if (type.equals("Ramette")) {
					grammage = rs.getInt("grammage");
					article = new Ramette(marque, reference, designation, prixUnitaire, qteStock, grammage);
				} else if (type.equals("Stylo")) {
					couleur = rs.getString("couleur");
					article = new Stylo(marque, reference, designation, prixUnitaire, qteStock, couleur);
				}
				articles[index] = article;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles;
	}
}
