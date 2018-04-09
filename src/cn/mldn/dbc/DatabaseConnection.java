package cn.mldn.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>() ;
	private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver" ;
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:mldn" ;
	private static final String DBUSER = "scott" ;
	private static final String PASSWORD = "tiger"; 
	public static Connection get(){
		Connection conn = tl.get() ;
		try {	
			if(conn == null) {
				conn = rebuildConnection() ;
				tl.set(conn);
			}
			return conn ;
		} catch(Exception e){
			e.printStackTrace();
		}
		return null ;
	}
	public static void close() {
		Connection conn = tl.get() ;
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			tl.remove();
		}
	}
	private static Connection rebuildConnection() throws Exception{
		Class.forName(DBDRIVER) ;
		return DriverManager.getConnection(DBURL, DBUSER, PASSWORD) ;
	}
}
