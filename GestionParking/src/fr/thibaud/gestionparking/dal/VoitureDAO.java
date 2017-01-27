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
import fr.thibaud.gestionparking.model.Voiture;

public class VoitureDAO extends DAO<Voiture> {

	private static Logger logger = MonLogger.getLogger(PersonneDAO.class.getName());

	public VoitureDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Voiture create(Voiture obj) {
		ResultSet rs = null;
		try (Connection con = ConnectionDAO.getConnection()) {
			CallableStatement callableStatement = con.prepareCall("{call CreateVoiture(?,?,?)}");
			callableStatement.setString(1, obj.getNom());
			callableStatement.setString(2, obj.getpI());
			callableStatement.setInt(3,
					(obj.getPersonne().getIdPersonne() != null) ? obj.getPersonne().getIdPersonne() : 0);
			rs = callableStatement.executeQuery();
			if (rs.next()) {
				obj.setIdVoiture(rs.getInt(1));
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, obj.toString() + " not inserted.\n" + e.toString());
		}
		if (obj.getIdVoiture() != null)
			logger.log(Level.INFO, obj.toString() + " inserted.");
		else
			logger.log(Level.SEVERE, obj.toString() + " not inserted.");
		return obj;
	}

	@Override
	public boolean update(Voiture obj) {
		boolean updated = false;

		try (Connection con = ConnectionDAO.getConnection()) {
			CallableStatement callableStatement = con.prepareCall("{call UpdateVoiture(?,?,?,?)}");
			callableStatement.setInt(1, obj.getIdVoiture());
			callableStatement.setString(2, obj.getNom());
			callableStatement.setString(3, obj.getpI());
			callableStatement.setInt(4,
					(obj.getPersonne().getIdPersonne() != null) ? obj.getPersonne().getIdPersonne() : 0);
			int count = callableStatement.executeUpdate();
			updated = (count == 1) ? true : false;
		} catch (Exception e) {
			logger.log(Level.SEVERE, obj.toString() + " not updated.\n" + e.toString());
			e.printStackTrace();
		}
		if (updated)
			logger.log(Level.INFO, obj.toString() + " updated.");
		else
			logger.log(Level.SEVERE, obj.toString() + " not updated.");
		return updated;
	}

	@Override
	public boolean delete(Voiture obj) {
		boolean deleted = false;

		try (Connection con = ConnectionDAO.getConnection()) {
			CallableStatement callableStatement = con.prepareCall("{call DeleteVoiture(?)}");
			callableStatement.setInt(1, obj.getIdVoiture());
			int count = callableStatement.executeUpdate();
			deleted = (count == 1) ? true : false;
		} catch (Exception e) {
			logger.log(Level.SEVERE, obj.toString() + " not deleted.\n" + e.toString());
			e.printStackTrace();
		}
		if (deleted)
			logger.log(Level.INFO, obj.toString() + " deleted.");
		else
			logger.log(Level.SEVERE, obj.toString() + " not deleted.");
		return deleted;
	}

	@Override
	public Voiture find(int id) {
		ResultSet rs = null;
		Voiture voiture = null;

		try (Connection con = ConnectionDAO.getConnection()) {
			CallableStatement callableStatement = con.prepareCall("{call FindVoiture(?)}");
			callableStatement.setInt(1, id);
			rs = callableStatement.executeQuery();
			if (rs.next()) {
				voiture = itemBuilder(rs);
				int idP = rs.getInt("FkPersonne");
				if (voiture != null && idP != 0) {
					callableStatement = ConnectionDAO.getConnection().prepareCall("{call FindPersonne(?)}");
					callableStatement.setInt(1, idP);
					rs = callableStatement.executeQuery();
					if (rs.next()) {
						Personne personne = new PersonneDAO().itemBuilder(rs);
						if (personne != null)
							voiture.setPersonne(personne);
					}
				}
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.toString());
		}
		if (voiture != null)
			logger.log(Level.INFO, voiture.toString() + " found.");
		else
			logger.log(Level.SEVERE, "Voiture for ID : " + id + " not found.");
		return voiture;
	}

	@Override
	public List<Voiture> find() {
		ResultSet rs = null;
		Voiture voiture = null;
		List<Voiture> voitures = new ArrayList<Voiture>();
		CallableStatement callableStatement;

		try (Connection con = ConnectionDAO.getConnection()) {
			callableStatement = con.prepareCall("{call FindVoitures()}");
			rs = callableStatement.executeQuery();
			while (rs.next()) {
				voiture = itemBuilder(rs);
				int idP = rs.getInt("FkPersonne");
				if (voiture != null && idP != 0) {
					callableStatement = ConnectionDAO.getConnection().prepareCall("{call FindPersonne(?)}");
					callableStatement.setInt(1, idP);
					rs = callableStatement.executeQuery();
					if (rs.next()) {
						Personne personne = new PersonneDAO().itemBuilder(rs);
						if (personne != null)
							voiture.setPersonne(personne);
					}
				}
				voitures.add(voiture);
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.toString());
			e.printStackTrace();
		}
		if (voitures.size() == 0)
			logger.log(Level.INFO, "Table Voitures in database is empty.");
		else
			logger.log(Level.INFO, voitures.toString() + "\nfound.");
		return voitures;
	}

	@Override
	protected Voiture itemBuilder(ResultSet rs) throws SQLException {
		Voiture voiture = new Voiture();
		voiture.setIdVoiture(rs.getInt("IdVoiture"));
		voiture.setNom(rs.getString("Nom"));
		voiture.setpI(rs.getString("PI"));
		return voiture;
	}

}
