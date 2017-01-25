package fr.thibaud.gestionparking.dal;

import java.util.List;

public abstract class DAO<T> {
	protected ConnectionDAO con = null;

	public DAO(ConnectionDAO con) {
		super();
		this.con = con;
	}
	public abstract T create(T obj);
	public abstract boolean update(T obj);
	public abstract boolean delete(T obj);
	public abstract T find(int id);
	public abstract List<T> find();
}
