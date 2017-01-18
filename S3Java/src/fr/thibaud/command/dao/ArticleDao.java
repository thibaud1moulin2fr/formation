package fr.thibaud.command.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.thibaud.command.bll.Repository;
import fr.thibaud.command.bo.Article;
import fr.thibaud.command.bo.Ramette;
import fr.thibaud.command.bo.Stylo;

public class ArticleDao implements Repository<Article> {

	@Override
	public void update(Article data) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Article data) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Article data) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <Type> Article selectById(Type id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Article> selectAll() throws Exception {
		Statement statement = null;
		Article article = null;
		List<Article> articles = null;
		String sql = null, reference = null, marque = null, designation = null, couleur = null, type = null;
		int qteStock = 0, grammage = 0;
		float prixUnitaire = (float) 0.0;
		ResultSet rs = null;
		try {
			statement = PoolConnection.getConnection().createStatement();
			sql = "Select * from Articles";
			articles = new ArrayList<Article>();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				article = null;
				marque = rs.getString("marque");
				reference = rs.getString("reference");
				designation = rs.getString("designation");
				prixUnitaire = rs.getFloat("prixUnitaire");
				qteStock = rs.getInt("qteStock");
				type = rs.getString("type").trim();
				if (type.equals("Ramette")) {
					grammage = rs.getInt("grammage");
					article = new Ramette(marque, reference, designation, prixUnitaire, qteStock, grammage);
				} else if (type.equals("Stylo")) {
					couleur = rs.getString("couleur");
					article = new Stylo(marque, reference, designation, prixUnitaire, qteStock, couleur);
				}
				articles.add(article);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public <Type> List<Article> selectAll(Type value) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
