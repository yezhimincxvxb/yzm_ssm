package com.yzm4.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ProxyCglib implements MethodInterceptor {
    private final Object targetObject;

    public ProxyCglib(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Object getInstance() {
        //Cglib中的加强器，类似于咱们JDK动态代理中的Proxy类，该类就是用来获取代理对象的
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(targetObject.getClass().getClassLoader());
        //设置父类的字节码对象。为啥子要这样做呢？因为使用CGLIB生成的代理类是属于目标类的子类的，也就是说代理类是要继承自目标类的
        enhancer.setSuperclass(targetObject.getClass());
        //设置回调(拦截器即代理对象)，这里相当于是对于代理类上所有方法的调用，都会调用Callback，而Callback则需要实现intercept()方法进行拦截
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("调用方法名：" + method.getName() + ", 方法参数：" + Arrays.toString(args));
        Object object = proxy.invokeSuper(obj, args);
        System.out.println("返回结果：" + object);
        return object;
    }
}
