package cn.mldn.util.factory;

import cn.mldn.util.serviceproxy.ServiceProxy;

public class ServiceFactory {
	public static<T> T getInstance(Class<T> cls) {
		try {
			return (T)new ServiceProxy().bind(cls.newInstance()) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
}
