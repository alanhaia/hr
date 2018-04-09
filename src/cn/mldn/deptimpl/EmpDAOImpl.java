package cn.mldn.deptimpl;

import java.util.Iterator;
import java.util.Set;

import cn.mldn.dbc.AbstractUtil;
import cn.mldn.ideptdao.IEmpDAO;

public class EmpDAOImpl extends AbstractUtil implements IEmpDAO {

	@Override
	public boolean doRemove(Set<Integer> ids) throws Exception {
		return super.doRemoveHandle(ids, "emp", "deptno");
	}

}
