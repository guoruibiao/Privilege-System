package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
	public static String DRIVER = "com.mysql.jdbc.Driver";

	public static String URL = "jdbc:mysql://localhost:3306/PrivilegeSystem";

	public static String USER = "root";

	public static String PASSWORD = "mysql";

	public static Connection getConn() {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			if (conn != null) {
				return conn;
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
		return null;
	}

	public static void release(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}
}
