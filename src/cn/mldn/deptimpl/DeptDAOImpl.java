package cn.mldn.deptimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.dbc.AbstractUtil;
import cn.mldn.dbc.DatabaseConnection;
import cn.mldn.ideptdao.IDeptDAO;
import cn.mldn.vo.Dept;

public class DeptDAOImpl extends AbstractUtil implements IDeptDAO {
	private Connection conn = DatabaseConnection.get() ;
	private PreparedStatement pstmt = null ;
	@Override
	public List<Dept> findAll() throws SQLException {
		List<Dept> all = new ArrayList<Dept>() ;
		String sql = " SELECT d.deptno,d.dname,d.loc,temp.count,temp.avg,temp.avgyear,temp.max,temp.min "
				+ " FROM dept d,( "
				+ " 		SELECT deptno,COUNT(*) count,AVG(sal+NVL(comm,0)) avg, "
				+ " 			TRUNC(AVG(MONTHS_BETWEEN(SYSDATE,hiredate)/12)) avgyear, "
				+ " 			MAX(sal+NVL(comm,0)) max,MIN(sal+NVL(comm,0)) min "
				+ " 		FROM emp GROUP BY deptno) temp "
				+ " WHERE d.deptno = temp.deptno(+) ";
		pstmt = conn.prepareStatement(sql) ;
		ResultSet rs = pstmt.executeQuery() ;
		while(rs.next()) {
			Dept dept = new Dept() ;
			dept.setDeptno(rs.getInt(1));
			dept.setDname(rs.getString(2));
			dept.setLoc(rs.getString(3));
			dept.getStat().put("count", rs.getInt(4)) ;
			dept.getStat().put("avg", rs.getInt(5)) ;
			dept.getStat().put("avgyear", rs.getInt(6)) ;
			dept.getStat().put("max", rs.getInt(7)) ;
			dept.getStat().put("min", rs.getInt(8)) ;
			all.add(dept) ;
		}
		return all;
	}
	@Override
	public boolean doCreat(Dept dept) throws SQLException {
		String sql = " INSERT INTO dept(deptno,dname,loc) VALUES (?,?,?) " ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, dept.getDeptno());
		this.pstmt.setString(2, dept.getDname());
		this.pstmt.setString(3, dept.getLoc());
		return this.pstmt.executeUpdate() > 0 ;
	}
	@Override
	public Dept findById(Integer id) throws SQLException {
		String sql = " SELECT deptno,dname,loc FROM dept WHERE deptno=? " ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setInt(1, id);
		Dept dept = null ;
		ResultSet rs = this.pstmt.executeQuery() ;
		if(rs.next()) {
			dept = new Dept() ;
			dept.setDeptno(rs.getInt(1));
			dept.setDname(rs.getString(2));
			dept.setLoc(rs.getString(3));
		}
		return dept;
	}
	@Override
	public boolean doUpdate(Dept dept) throws SQLException {
		String sql = " UPDATE dept SET dname=?,loc=? WHERE deptno=? " ;
		this.pstmt = this.conn.prepareStatement(sql) ;
		this.pstmt.setString(1, dept.getDname());
		this.pstmt.setString(2, dept.getLoc());
		this.pstmt.setInt(3, dept.getDeptno());
		return this.pstmt.executeUpdate() > 0 ;
	}
	@Override
	public boolean doRemove(Set<Integer> ids) throws SQLException {
		return super.doRemoveHandle(ids, "dept", "deptno");
	}

}
