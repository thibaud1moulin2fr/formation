/**
 * 
 */
package fr.thibaud.command.dao;

import java.util.List;

public interface Repository<T> {
	public void update(T data) throws Exception;
	public void insert(T data) throws Exception;
	public void delete(T data) throws Exception;
	public <Type> T selectById(Type id) throws Exception;
	public List<T> selectAll() throws Exception;
	public <Type> List<T> selectAll(Type value) throws Exception;
}
