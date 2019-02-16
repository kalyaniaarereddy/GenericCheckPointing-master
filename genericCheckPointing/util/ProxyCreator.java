package genericCheckPointing.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import genericCheckPointing.server.StoreRestoreI;

/**
 * 
 * @author Abhi
 * 
 * class to create an instance of proxy
 */
public class ProxyCreator {

	public StoreRestoreI createProxy(Class<?>[] interfaceArray, InvocationHandler handler){
		StoreRestoreI storeRestoreRef = (StoreRestoreI)
										Proxy.newProxyInstance(
												getClass().getClassLoader(),
												interfaceArray,
												handler
												);

		return storeRestoreRef;
	}
	
}
