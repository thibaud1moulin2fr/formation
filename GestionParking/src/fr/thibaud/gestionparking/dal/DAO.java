package fr.thibaud.gestionparking.dal;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {
	protected Connection con = null;

	public DAO(Connection con) {
		super();
		this.con = con;
	}
	public abstract T create(T obj);
	public abstract boolean update(T obj);
	public abstract boolean delete(T obj);
	public abstract T find(int id);
	public abstract List<T> find();
}
