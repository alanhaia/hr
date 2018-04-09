package cn.mldn.deptserviceimpl;

import java.util.List;
import java.util.Set;

import cn.mldn.deptimpl.DeptDAOImpl;
import cn.mldn.deptimpl.EmpDAOImpl;
import cn.mldn.ideptdao.IDeptDAO;
import cn.mldn.ideptdao.IEmpDAO;
import cn.mldn.iservice.IDeptService;
import cn.mldn.util.factory.DAOFactory;
import cn.mldn.vo.Dept;

public class DeptServiceImpl implements IDeptService {

	@Override
	public List<Dept> list() throws Exception {
		IDeptDAO idd = DAOFactory.getInstance(DeptDAOImpl.class) ;
		return idd.findAll() ;
	}

	@Override
	public boolean add(Dept dept) throws Exception {
		IDeptDAO idd = DAOFactory.getInstance(DeptDAOImpl.class) ;
		if(idd.findById(dept.getDeptno()) == null ) {
			return idd.doCreat(dept) ;
		}
		return false;
	}

	@Override
	public Dept editpre(Integer id) throws Exception {
		IDeptDAO idd = DAOFactory.getInstance(DeptDAOImpl.class) ;
		return idd.findById(id);
	}

	@Override
	public boolean edit(Dept dept) throws Exception {
		IDeptDAO idd = DAOFactory.getInstance(DeptDAOImpl.class) ;
		return idd.doUpdate(dept);
	}

	@Override
	public boolean remove(Set<Integer> ids) throws Exception {
		if(ids == null || ids.size() == 0) {
			return false ;
		}
		IEmpDAO ied = DAOFactory.getInstance(EmpDAOImpl.class) ;
		IDeptDAO idd = DAOFactory.getInstance(DeptDAOImpl.class) ;
		ied.doRemove(ids) ;
		return idd.doRemove(ids);
	}

}
