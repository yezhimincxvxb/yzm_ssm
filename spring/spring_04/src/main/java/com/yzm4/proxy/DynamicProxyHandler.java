package com.yzm4.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class DynamicProxyHandler implements InvocationHandler {

    // 目标对象，被代理对象
    private final Object targetObject;

    public DynamicProxyHandler(Object targetObject) {
        this.targetObject = targetObject;
    }

    /**
     * @param proxy  动态代理对象
     * @param method 目标对象被调用的方法
     * @param args   指定被调用方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("目标方法执行之前：" + Arrays.toString(args));

        Object invoke = method.invoke(targetObject, args);

        System.out.println("目标方法执行之后：" + Arrays.toString(args));
        return invoke;
    }

    /**
     * Proxy.newProxyInstance（）作用：根据指定的类装载器、一组接口 & 调用处理器 生成动态代理类实例，并最终返回
     * 参数1：类加载器
     * 参数2：指定目标对象的实现接口，使代理对象也能默认的实现该接口
     * 参数3：指定InvocationHandler对象。即动态代理对象在调用方法时，会关联到哪个InvocationHandler对象
     */
    public Object newProxyInstance() {
        return Proxy.newProxyInstance(
//                DynamicProxyHandler.class.getClassLoader(),
                targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),
                this);
    }
}
