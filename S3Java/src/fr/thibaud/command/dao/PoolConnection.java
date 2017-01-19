package fr.thibaud.command.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PoolConnection {

	private static Connection connection = null;
	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				Class.forName(Settings.getProperty("JDBC_DRIVER"));
				connection = DriverManager.getConnection(Settings.getProperty("DB_URL") + ";user=" + Settings.getProperty("USER") + ";password=" + Settings.getProperty("PASS"));
				return connection;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
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
