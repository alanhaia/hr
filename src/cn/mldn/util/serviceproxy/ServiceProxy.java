package cn.mldn.util.serviceproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.mldn.dbc.DatabaseConnection;

public class ServiceProxy implements InvocationHandler {
	private Object target ;
	public Object bind(Object target) {
		this.target = target ;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this) ;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object obj = null ;
		try {
			if(method.getName().startsWith("add")||
					method.getName().startsWith("edit")||
					method.getName().startsWith("remove")) {
				DatabaseConnection.get().setAutoCommit(false);
				try {	
					obj = method.invoke(this.target, args) ;
					DatabaseConnection.get().commit();
				}catch(Exception e) {
					DatabaseConnection.get().rollback();
					throw e ;
				}
			}else {
				obj = method.invoke(this.target, args) ;
			}
		}catch(Exception e) {
			throw e ;
		}finally {
			DatabaseConnection.close();
		}
		return obj;
	}

}
