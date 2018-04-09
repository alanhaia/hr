package cn.mldn.ideptdao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.mldn.vo.Dept;

public interface IDeptDAO {
	public List<Dept> findAll() throws SQLException ;
	public boolean doCreat(Dept dept) throws SQLException ;
	public Dept findById(Integer id) throws SQLException ;
	public boolean doUpdate(Dept dept) throws SQLException ;
	public boolean doRemove(Set<Integer> ids) throws SQLException ;
}
