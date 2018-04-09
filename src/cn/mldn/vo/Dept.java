package cn.mldn.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Dept implements Serializable {
	private Integer deptno ;
	private String dname ;
	private String loc ;
	private Map<String,Object> stat = new HashMap<String,Object>() ;
	public Map<String, Object> getStat() {
		return stat;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
