package fr.thibaud.gestionparking.dal;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.thibaud.gestionparking.model.Personne;
import fr.thibaud.gestionparking.model.Voiture;

public class VoitureDAO extends DAO<Voiture> {

	public VoitureDAO(ConnectionDAO con) {
		super(con);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Voiture create(Voiture obj) {
		ResultSet rs = null;
		try {
			CallableStatement callableStatement = ConnectionDAO.getConnection()
					.prepareCall("{call CreateVoiture(?,?,?)}");
			callableStatement.setString(1, obj.getNom());
			callableStatement.setString(2, obj.getpI());
			callableStatement.setInt(3,
					(obj.getPersonne().getIdPersonne() != null) ? obj.getPersonne().getIdPersonne() : 0);
			rs = callableStatement.executeQuery();
			if (rs.next()) {
				obj.setIdVoiture(rs.getInt(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return obj;
	}

	@Override
	public boolean update(Voiture obj) {
		boolean deleted = false;
		try {
			CallableStatement callableStatement = ConnectionDAO.getConnection()
					.prepareCall("{call UpdateVoiture(?,?,?,?)}");
			callableStatement.setInt(1, obj.getIdVoiture());
			callableStatement.setString(2, obj.getNom());
			callableStatement.setString(3, obj.getpI());
			callableStatement.setInt(4,
					(obj.getPersonne().getIdPersonne() != null) ? obj.getPersonne().getIdPersonne() : 0);
			deleted = callableStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return deleted;
	}

	@Override
	public boolean delete(Voiture obj) {
		boolean deleted = false;
		try {
			CallableStatement callableStatement = ConnectionDAO.getConnection().prepareCall("{call DeleteVoiture(?)}");
			callableStatement.setInt(1, obj.getIdVoiture());
			deleted = callableStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return deleted;
	}

	@Override
	public Voiture find(int id) {
		ResultSet rs = null;
		Voiture voiture = null;
		try {
			CallableStatement callableStatement = ConnectionDAO.getConnection().prepareCall("{call FindVoiture(?)}");
			callableStatement.setInt(1, id);
			rs = callableStatement.executeQuery();
			if (rs.next()) {
				voiture = new Voiture(rs.getInt("IdVoiture"), rs.getString("Nom"), rs.getString("PI"));
				int idP = rs.getInt("PkPersonne");
				if (voiture != null && idP != 0) {
					Personne personne = null;
					callableStatement = ConnectionDAO.getConnection().prepareCall("{call FindPersonne(?)}");
					callableStatement.setInt(1, idP);
					rs = callableStatement.executeQuery();
					if (rs.next()) {
						personne = new Personne(rs.getInt("IdPersonne"), rs.getString("Nom"), rs.getString("Prenom"));
						if (personne != null)
							voiture.setPersonne(personne);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return voiture;
	}

	@SuppressWarnings("resource")
	@Override
	public List<Voiture> find() {
		ResultSet rs = null;
		Voiture voiture = null;
		List<Voiture> voitures = new ArrayList<Voiture>();
		CallableStatement callableStatement;
		try {
			callableStatement = ConnectionDAO.getConnection().prepareCall("{call FindVoitures()}");
			rs = callableStatement.executeQuery();
			while (rs.next()) {
				voiture = new Voiture(rs.getInt("IdVoiture"), rs.getString("Nom"), rs.getString("PI"));
				int idP = rs.getInt("PkPersonne");
				if (voiture != null && idP != 0) {
					Personne personne = null;
					callableStatement = ConnectionDAO.getConnection().prepareCall("{call FindPersonne(?)}");
					callableStatement.setInt(1, idP);
					rs = callableStatement.executeQuery();
					if (rs.next()) {
						personne = new Personne(rs.getInt("IdPersonne"), rs.getString("Nom"), rs.getString("Prenom"));
						if (personne != null)
							voiture.setPersonne(personne);
					}
				}
				voitures.add(voiture);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return voitures;
	}

}
