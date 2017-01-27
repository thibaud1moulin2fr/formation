package fr.thibaud.gestionparking.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.thibaud.gestionparking.model.Personne;

public class PersonneDAO extends DAO<Personne> {
	private static Logger logger = MonLogger.getLogger(PersonneDAO.class.getName());

	public PersonneDAO() {
		super();
	}

	@Override
	public Personne create(Personne obj) {
		ResultSet rs = null;
		try (Connection con = ConnectionDAO.getConnection()) {
			CallableStatement callableStatement = con.prepareCall("{call CreatePersonne(?,?)}");
			callableStatement.setString(1, obj.getNom());
			callableStatement.setString(2, obj.getPrenom());
			rs = callableStatement.executeQuery();
			if (rs.next()) {
				obj.setIdPersonne(rs.getInt(1));
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, obj.toString() + " not inserted.\n" + e.toString());
		}
		if (obj.getIdPersonne() != null)
			logger.log(Level.INFO, obj.toString() + " inserted.");
		else
			logger.log(Level.SEVERE, obj.toString() + " not inserted.");
		return obj;
	}

	@Override
	public boolean update(Personne obj) {
		boolean updated = false;
		try (Connection con = ConnectionDAO.getConnection()) {
			CallableStatement callableStatement = con.prepareCall("{call UpdatePersonne(?,?,?)}");
			callableStatement.setInt(1, obj.getIdPersonne());
			callableStatement.setString(2, obj.getNom());
			callableStatement.setString(3, obj.getPrenom());
			int count = callableStatement.executeUpdate();
			updated = (count == 1) ? true : false;
		} catch (Exception e) {
			logger.log(Level.SEVERE, obj.toString() + " not updated.\n" + e.toString());
		}
		if (updated)
			logger.log(Level.INFO, obj.toString() + " updated.");
		else
			logger.log(Level.SEVERE, obj.toString() + " not updated.");
		return updated;
	}

	@Override
	public boolean delete(Personne obj) {
		boolean deleted = false;
		int count = 0;
		try (Connection con = ConnectionDAO.getConnection()) {
			CallableStatement callableStatement = con.prepareCall("{call DeletePersonne(?)}");
			callableStatement.setInt(1, obj.getIdPersonne());
			count = callableStatement.executeUpdate();
			deleted = (count > 0) ? true : false;
		} catch (Exception e) {
			logger.log(Level.SEVERE, obj.toString() + " not deleted.\n" + e.toString());
		}
		if (deleted)
			logger.log(Level.INFO, obj.toString() + " deleted.");
		else
			logger.log(Level.SEVERE, obj.toString() + " not deleted.");
		return deleted;
	}

	@Override
	public Personne find(int id) {
		ResultSet rs = null;
		Personne personne = null;
		try (Connection con = ConnectionDAO.getConnection()) {
			CallableStatement callableStatement = con.prepareCall("{call FindPersonne(?)}");
			callableStatement.setInt(1, id);
			rs = callableStatement.executeQuery();
			if (rs.next()) {
				personne = itemBuilder(rs);
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.toString());
		}
		if (personne != null)
			logger.log(Level.INFO, personne.toString() + " found.");
		else
			logger.log(Level.SEVERE, "Personne for ID : " + id + " not found.");
		return personne;
	}

	@Override
	public List<Personne> find() {
		ResultSet rs = null;
		Personne personne = null;
		List<Personne> personnes = new ArrayList<Personne>();
		try (Connection con = ConnectionDAO.getConnection()) {
			CallableStatement callableStatement = con.prepareCall("{call FindPersonnes}");
			rs = callableStatement.executeQuery();
			while (rs.next()) {
				personne = itemBuilder(rs);
				if (personne != null) {
					personnes.add(personne);
				}
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.toString());
		}
		if (personnes.size() == 0)
			logger.log(Level.INFO, "Table Personnes in database is empty.");
		else
			logger.log(Level.INFO, personnes.toString() + "\nfound.");
		return personnes;
	}

	@Override
	protected Personne itemBuilder(ResultSet rs) throws SQLException {
		Personne personne = new Personne();
		personne.setIdPersonne(rs.getInt("IdPersonne"));
		personne.setNom(rs.getString("Nom"));
		personne.setPrenom(rs.getString("Prenom"));
		return personne;
	}

}
