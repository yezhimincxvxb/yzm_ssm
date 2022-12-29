# IOC 底层原理


# BeanFactory、ApplicationContext
- BeanFactory：
- ApplicationContext：

# DI 依赖注入
有两种方式：
- 构造器注入
- set 方法注入

# FactoryBean
工厂bean

# Bean 的作用域
- Singleton：单例，默认
- Prototype：原型，多实例

# Bean 的生命周期

# 自动装配 (基于XML实现)
```xml
<bean id="emp2" class="com.yzm.autowire.Emp" autowire="byName">
    <property name="name" value="lisi"/>
</bean>
```
```text
autowire：
byName：根据名称查找
byType：根据类型查找，同一类型的Bean有多个实例对象时，会报错
```
# 注解开发

# Aop
面向切面编程
利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。

## 术语
```text
连接点：可以被增强的方法
切入点：实际被真正增强的方法
通知(增强)：实际增强的逻辑部分称为通知
    前置通知：
    后置通知：
    异常通知：
    最终通知：
    环绕通知：
切面：动作，把通知应用到切入点的过程
```
切入点表达式：
```text
execution([权限修饰符-星号][返回类型-可省略][类全路径][方法名称][参数列表])
eg：
execution(* com.yzm4.service.UserService.add(..))
execution(* com.yzm4.service.UserService.*(..))
```
advice通知执行顺序：
```text
异常情况：环绕前通知 --> 前置通知 --> 执行方法 --> 异常通知 --> 后置通知 --> 没有环绕后通知
无异常情况：环绕前通知 --> 前置通知 --> 执行方法 --> 最终通知 --> 后置通知 --> 环绕后通知
```
优先级：使用 @Order 注解 值越小优先级越高

