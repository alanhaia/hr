package cn.mldn.dbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractUtil {
	protected Connection conn ;
	protected PreparedStatement pstmt ;
	public AbstractUtil() {
		this.conn = DatabaseConnection.get() ;
	}
	public <T> boolean doRemoveHandle(Set<T> ids,String tableName,String column) throws SQLException{
		StringBuffer buf = new StringBuffer() ;
		buf.append(" DELETE FROM ").append(tableName).append(" WHERE ").append(column).append(" IN( ") ;
		Iterator<T> iter = ids.iterator() ;
		while(iter.hasNext()) {
			buf.append(iter.next()).append(",") ;
		}
		buf.delete(buf.length()-1, buf.length()).append(" )") ;
		String sql = buf.toString() ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		return this.pstmt.executeUpdate() > 0 ;
	}
}
