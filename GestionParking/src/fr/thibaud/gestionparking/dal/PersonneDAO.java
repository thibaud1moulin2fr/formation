package fr.thibaud.gestionparking.dal;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.thibaud.gestionparking.model.Personne;

public class PersonneDAO extends DAO<Personne> {

	public PersonneDAO(ConnectionDAO con) {
		super(con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Personne create(Personne obj) {
		ResultSet rs = null;
		try {
			CallableStatement callableStatement = ConnectionDAO.getConnection()
					.prepareCall("{call CreatePersonne(?,?)}");
			callableStatement.setString(1, obj.getNom());
			callableStatement.setString(2, obj.getPrenom());
			rs = callableStatement.executeQuery();
			if (rs.next()) {
				obj.setIdPersonne(rs.getInt(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return obj;
	}

	@Override
	public boolean update(Personne obj) {
		boolean deleted = false;
		try {
			CallableStatement callableStatement = ConnectionDAO.getConnection()
					.prepareCall("{call UpdateVoiture(?,?,?)}");
			callableStatement.setInt(1, obj.getIdPersonne());
			callableStatement.setString(2, obj.getNom());
			callableStatement.setString(3, obj.getPrenom());
			deleted = callableStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return deleted;
	}

	@Override
	public boolean delete(Personne obj) {
		boolean deleted = false;
		try {
			CallableStatement callableStatement = ConnectionDAO.getConnection().prepareCall("{call DeletePersonne(?)}");
			callableStatement.setInt(1, obj.getIdPersonne());
			deleted = callableStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return deleted;
	}

	@Override
	public Personne find(int id) {
		ResultSet rs = null;
		Personne personne = null;
		try {
			CallableStatement callableStatement = ConnectionDAO.getConnection().prepareCall("{call FindPersonne(?)}");
			callableStatement.setInt(1, id);
			rs = callableStatement.executeQuery();
			if (rs.next()) {
				personne = new Personne(rs.getInt("IdPersonne"), rs.getString("Nom"), rs.getString("Prenom"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personne;
	}

	@Override
	public List<Personne> find() {
		ResultSet rs = null;
		Personne personne = null;
		List<Personne> personnes = new ArrayList<Personne>();
		try {
			CallableStatement callableStatement = ConnectionDAO.getConnection().prepareCall("{call FindPersonnes()}");
			rs = callableStatement.executeQuery();
			while (rs.next()) {
				personne = new Personne(rs.getInt("IdPersonne"), rs.getString("Nom"), rs.getString("Prenom"));
				if (personne != null)
					personnes.add(personne);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personnes;
	}

}
