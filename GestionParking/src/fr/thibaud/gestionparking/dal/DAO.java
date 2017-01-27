package fr.thibaud.gestionparking.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO<T> {
	public DAO() {
		super();
	}
	public abstract T create(T obj);
	public abstract boolean update(T obj);
	public abstract boolean delete(T obj);
	public abstract T find(int id);
	public abstract List<T> find();
	protected abstract T itemBuilder(ResultSet rs) throws SQLException;
}
