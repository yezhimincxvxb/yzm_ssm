# mybatis-config.xml
配置顺序：
properties?, settings?, typeAliases?, typeHandlers?, objectFactory?, plugins?, environments?, mappers?

# properties 属性。
属性可以在外部进行配置，并可以进行动态替换。你既可以在典型的 Java 属性文件中配置这些属性，也可以在 properties 元素的子元素中设置。

如果一个属性在不只一个地方进行了配置，那么，MyBatis 将按照下面的顺序来加载：
```text
1.首先读取在 properties 元素体内指定的属性。
2.然后根据 properties 元素中的 resource 属性读取类路径下属性文件，或根据 url 属性指定的路径读取属性文件，并覆盖之前读取过的同名属性。
3.最后读取作为方法参数传递的属性，并覆盖之前读取过的同名属性。
```
因此，通过方法参数传递的属性具有最高优先级，resource/url 属性中指定的配置文件次之，最低优先级的则是 properties 元素中指定的属性。
```xml
<properties resource="db.properties" />
```
# settings 设置。
缓存：cacheEnabled 默认true
日志：logImpl 可选值：SLF4J | LOG4J | LOG4J2 | JDK_LOGGING | COMMONS_LOGGING | STDOUT_LOGGING | NO_LOGGING
 ```text
1.标准日志输出：STDOUT_LOGGING
2.LOG4J
3.LOG4J2
4.SLF4J
```   
驼峰命名：mapUnderscoreToCamelCase 默认false
```xml
<settings>
    <setting name="logImpl" value="STDOUT_LOGGING"/>
    <setting name="mapUnderscoreToCamelCase" value="true"/>
</settings>
```
# typeAliases 类型别名
类型别名可为 Java 类型设置一个缩写名字。 它仅用于 XML 配置，意在降低冗余的全限定类名书写。
```xml
<typeAliases> 
    <typeAlias type="com.yzm2.entity.User" alias="user"/>
    <package name="com.yzm2.entity"/>
</typeAliases>
```
或在实体类上使用注解:@Alias(“user”)

# typeHandlers 类型处理器
MyBatis 在设置预处理语句（PreparedStatement）中的参数或从结果集中取出一个值时， 都会用类型处理器将获取到的值以合适的方式转换成 Java 类型。

# objectFactory 对象工厂
每次 MyBatis 创建结果对象的新实例时，它都会使用一个对象工厂（ObjectFactory）实例来完成实例化工作。
默认的对象工厂需要做的仅仅是实例化目标类，要么通过默认无参构造方法，要么通过存在的参数映射来调用带有参数的构造方法。
如果想覆盖对象工厂的默认行为，可以通过创建自己的对象工厂来实现。
```xml
<objectFactory type="com.yzm2.factory.MyObjectFactory">
    <!--        <property name="" value=""/>-->
</objectFactory>
```
# plugins 插件
MyBatis 允许你在映射语句执行过程中的某一点进行拦截调用。默认情况下，MyBatis 允许使用插件来拦截的方法调用包括：
```text
Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)
ParameterHandler (getParameterObject, setParameters)
ResultSetHandler (handleResultSets, handleOutputParameters)
StatementHandler (prepare, parameterize, batch, update, query)
```
```xml
<plugins>
    <plugin interceptor="com.yzm2.plugin.PagePlugin"/>
</plugins>
```
# environments 环境配置
MyBatis 可以配置成适应多种环境，这种机制有助于将 SQL 映射应用于多种数据库之中， 现实情况下有多种理由需要这么做。例如，开发、测试和生产环境需要有不同的配置；

默认JDBC事务管理器、数据源POOLED(这种数据源的实现利用“池”的概念将 JDBC 连接对象组织起来，避免了创建新的连接实例时所必需的初始化和认证时间。)
```xml
<environments default="development">
    <environment id="development">
        <transactionManager type="JDBC"/>
        <dataSource type="POOLED">
            <property name="driver" value="${driver}"/>
            <property name="url" value="${url}"/>
            <property name="username" value="${username}"/>
            <property name="password" value="${password}"/>
        </dataSource>
    </environment>
</environments>
```
# mappers 映射器
```xml
<mappers>
    <mapper resource="mapper/UserMapper.xml"/>
</mappers>
```


