package fr.thibaud.command.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PoolConnection {

	private static Connection connection = null;
	static {
		try {
			Class.forName(Settings.getProperty("JDBC_DRIVER"));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(Settings.getProperty("DB_URL") + ";user=" + Settings.getProperty("USER") + ";password=" + Settings.getProperty("PASS"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		try {
			if (connection != null && !connection.isClosed())
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void closeConnection() {
		try {
			if (connection != null && !connection.isClosed())
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
