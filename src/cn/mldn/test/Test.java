package cn.mldn.test;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.mldn.dbc.DatabaseConnection;
import cn.mldn.deptserviceimpl.DeptServiceImpl;
import cn.mldn.iservice.IDeptService;
import cn.mldn.util.factory.ServiceFactory;
import cn.mldn.util.serviceproxy.ServiceProxy;
import cn.mldn.vo.Dept;

public class Test {

	public static void main(String[] args) throws Exception{
		Connection conn = DatabaseConnection.get() ;
		String ids = "21@22@" ;
		String[] result = ids.split("@") ;
		Set<Integer> deptnos = new HashSet<Integer>() ;
		for(int x = 0 ; x < result.length ; x ++){
			deptnos.add(Integer.parseInt(result[x]));
		}
		IDeptService deptService= ServiceFactory.getInstance(DeptServiceImpl.class) ;
		System.out.println(deptnos);
		System.out.println(deptService.remove(deptnos));
	}
}

