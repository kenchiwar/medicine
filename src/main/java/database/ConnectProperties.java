package database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectProperties {
	public static String getConnectionUrl() {
		String strCon = null;
		try {
			FileInputStream file = new FileInputStream("db.properties");
			Properties prop = new Properties();
			prop.load(file);
			strCon = prop.getProperty("url")+prop.getProperty("serverName")+":"+prop.getProperty("portNumber")
			+ "; databaseName="+ prop.getProperty("databaseName")+"; user= "+prop.getProperty("username")
			+ "; password= "+prop.getProperty("password");
		}catch (Exception e) {
			e.printStackTrace();
		}return strCon;
	}
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(getConnectionUrl());
		}catch (Exception e) {
			e.printStackTrace();
		}return conn;
	}
}
