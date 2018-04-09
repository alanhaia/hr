package cn.mldn.iservice;

import java.util.List;
import java.util.Set;

import cn.mldn.vo.Dept;

public interface IDeptService {
	public List<Dept> list() throws Exception  ; 
	public boolean add(Dept dept) throws Exception ;
	public Dept editpre(Integer id) throws Exception ;
	public boolean edit(Dept dept) throws Exception ;
	public boolean remove(Set<Integer> ids) throws Exception ;
}
