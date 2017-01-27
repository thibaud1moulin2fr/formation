package fr.thibaud.gestionparking.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(Settings.getProperty("DB_URL") + ";user=" + Settings.getProperty("USER")
				+ ";password=" + Settings.getProperty("PASS"));
	}
}
