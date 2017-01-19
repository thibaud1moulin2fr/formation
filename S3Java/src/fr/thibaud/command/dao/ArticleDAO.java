package fr.thibaud.command.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.thibaud.command.bll.Repository;
import fr.thibaud.command.bo.Article;
import fr.thibaud.command.bo.Ramette;
import fr.thibaud.command.bo.Stylo;

public class ArticleDAO implements Repository<Article> {

	@Override
	public void update(Article data) throws Exception {
		PreparedStatement statement = null;
		String sql = null;
		sql = "Update Articles set values('?','?','?','?','?','?','?','?') where reference = '?';";
		statement = PoolConnection.getConnection().prepareStatement(sql);
		statement.setString(1, data.getReference());
		statement.setString(2, data.getMarque());
		statement.setString(3, data.getDesignation());
		statement.setFloat(4, data.getPrixUnitaire());
		statement.setInt(5, data.getQteStock());
		if (data instanceof Stylo) {
			statement.setInt(6, 0);
			statement.setString(7, ((Stylo) data).getCouleur());
			statement.setString(8, "Stylo");
		} else if (data instanceof Ramette) {
			statement.setInt(6, ((Ramette) data).getGrammage());
			statement.setString(7, null);
			statement.setString(8, "Ramette");
		}
		statement.setString(9, data.getReference());
		statement.execute();
	}

	@Override
	public void insert(Article data) throws Exception {
		PreparedStatement statement = null;
		String sql = null;
		sql = "Insert into Articles values('?','?','?','?','?','?','?','?');";
		statement = PoolConnection.getConnection().prepareStatement(sql);
		statement.setString(1, data.getReference());
		statement.setString(2, data.getMarque());
		statement.setString(3, data.getDesignation());
		statement.setFloat(4, data.getPrixUnitaire());
		statement.setInt(5, data.getQteStock());
		if (data instanceof Stylo) {
			statement.setInt(6, 0);
			statement.setString(7, ((Stylo) data).getCouleur());
			statement.setString(8, Stylo.class.getName());
		} else if (data instanceof Ramette) {
			statement.setInt(6, ((Ramette) data).getGrammage());
			statement.setString(7, null);
			statement.setString(8, Ramette.class.getName());
		}
		statement.execute();
	}

	@Override
	public void delete(Article data) throws Exception {
		PreparedStatement statement = null;
		String sql = null;
		sql = "Delete from Articles where reference = '?';";
		statement = PoolConnection.getConnection().prepareStatement(sql);
		statement.setString(1, data.getReference());
		statement.execute();
	}

	@Override
	public <Type> Article selectById(Type id) throws Exception {
		Statement statement = null;
		Article article = null;
		String sql = null, reference = null, marque = null, designation = null, couleur = null, type = null;
		int qteStock = 0, grammage = 0;
		float prixUnitaire = (float) 0.0;
		ResultSet rs = null;
		statement = PoolConnection.getConnection().createStatement();
		sql = "Select * from Articles where reference = '" + id + "';";
		rs = statement.executeQuery(sql);
		if (rs.next()) {
			article = null;
			marque = rs.getString("marque");
			reference = rs.getString("reference");
			designation = rs.getString("designation");
			prixUnitaire = rs.getFloat("prixUnitaire");
			qteStock = rs.getInt("qteStock");
			type = rs.getString("type").trim();
			if (type.equals(Ramette.class.getName())) {
				grammage = rs.getInt("grammage");
				article = new Ramette(marque, reference, designation, prixUnitaire, qteStock, grammage);
			} else if (type.equals(Stylo.class.getName())) {
				couleur = rs.getString("couleur");
				article = new Stylo(marque, reference, designation, prixUnitaire, qteStock, couleur);
			}
		}
		return article;
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
			sql = "Select * from Articles;";
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
				if (type.equals(Ramette.class.getName())) {
					grammage = rs.getInt("grammage");
					article = new Ramette(marque, reference, designation, prixUnitaire, qteStock, grammage);
				} else if (type.equals(Stylo.class.getName())) {
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
		Statement statement = null;
		Article article = null;
		List<Article> articles = null;
		String sql = null, reference = null, marque = null, designation = null, couleur = null;
		int qteStock = 0, grammage = 0;
		float prixUnitaire = (float) 0.0;
		ResultSet rs = null;
		statement = PoolConnection.getConnection().createStatement();
		sql = "Select * from Articles where Type = '" + value + "';";
		articles = new ArrayList<Article>();
		rs = statement.executeQuery(sql);
		while (rs.next()) {
			article = null;
			marque = rs.getString("marque");
			reference = rs.getString("reference");
			designation = rs.getString("designation");
			prixUnitaire = rs.getFloat("prixUnitaire");
			qteStock = rs.getInt("qteStock");
			if (value.equals(Ramette.class.getName())) {
				grammage = rs.getInt("grammage");
				article = new Ramette(marque, reference, designation, prixUnitaire, qteStock, grammage);
			} else if (value.equals(Stylo.class.getName())) {
				couleur = rs.getString("couleur");
				article = new Stylo(marque, reference, designation, prixUnitaire, qteStock, couleur);
			}
			articles.add(article);
		}
		return null;
	}

}
