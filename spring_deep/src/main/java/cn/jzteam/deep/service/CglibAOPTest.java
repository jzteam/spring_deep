package cn.jzteam.deep.service;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibAOPTest implements MethodInterceptor {

	public Object getProxy(Class clazz) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);

		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("我是cglib代理前置方法");
		methodProxy.invokeSuper(obj, args);
		System.out.println("我是cglib代理后置方法");
		return null;
	}

	public static void main(String[] args) {
		CglibAOPTest test = new CglibAOPTest();
		Son proxy = (Son)test.getProxy(Son.class);
		
		String proxyName = proxy.getClass().getName();
		System.out.println("proxyName="+proxyName);
		Method[] declaredMethods = proxy.getClass().getDeclaredMethods();
		for (Method method : declaredMethods) {
			System.out.println(method.getName());
		}
		
		proxy.say();
	}

}

