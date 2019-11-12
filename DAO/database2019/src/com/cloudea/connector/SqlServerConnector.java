package com.cloudea.connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlServerConnector implements Connector {
	
	private String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=test;user=cloudea;password=123456";
	public SqlServerConnector() {}
	
	@Override
	public Connection connect() {
		try {
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			return null;
		}
	}

}
