package cn.jzteam.deep.service;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

public class JdkAOPTest implements InvocationHandler{
	
	private Object obj;
	
	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Object getProxy(){
//		Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(obj.getClass());
		enhancer.setCallback(this);
		
		
		return enhancer.create();
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			System.out.println("我是jdk代理前置方法");
			method.invoke(obj, args);
			System.out.println("我是jdk代理后置方法");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		JdkAOPTest test = new JdkAOPTest();
		test.setObj(new Son());
		Person p = (Person)test.getProxy();
		p.say();
	}

}
interface Person{
	public void say();
	public void eat();
}
class Son implements Person{
	public void say(){
		System.out.println("我在say");
		eat();
	}
	
	public void eat(){
		System.out.println("我在eat");
	}
}

