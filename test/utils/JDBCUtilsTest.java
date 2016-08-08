package utils;

import java.sql.Connection;

import org.junit.Test;

public class JDBCUtilsTest {
	
	@Test
	public void testGetConn() throws Exception {
		Connection conn = JDBCUtils.getConn();
		System.out.println(conn.toString());
	}

}
