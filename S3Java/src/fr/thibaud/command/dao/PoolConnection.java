package fr.thibaud.command.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PoolConnection {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
	static final String DB_URL = "jdbc:sqlserver://127.0.0.1;databaseName=TPJSE_Commande";
	//  Database credentials
	static final String USER = "sa";
	static final String PASS = "Pa$$w0rd";
	public static Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			return DriverManager.getConnection(DB_URL + ";user=" + USER + ";password=" + PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
