# XML 映射文件
## 元素
### select
```xml
<select
  id="命名空间中唯一的标识符"
  parameterType="参数的类全限定名或别名。"
  resultType="返回结果的类全限定名或别名。 注意，如果返回的是集合，那应该设置为集合包含的类型，而不是集合本身的类型。 resultType 和 resultMap 之间只能同时使用一个。"
  resultMap="对外部 resultMap 的命名引用。"
  flushCache="将其设置为 true 后，只要语句被调用，都会导致本地缓存和二级缓存被清空，默认值：false。"
  useCache="将其设置为 true 后，将会导致本条语句的结果被二级缓存缓存起来，默认值：对 select 元素为 true。">
    
</select>
```
### insert, update 和 delete
```xml
<insert
  id="命名空间中唯一的标识符"
  parameterType="参数的类全限定名或别名"
  flushCache="true"
  useGeneratedKeys="是否主键自动生成，适用于自动递增字段"
  keyProperty="自动生成的主键赋值给Java对象的属性"
  keyColumn="数据库主键字段">
    
</insert>
```
```xml
<update
  id="命名空间中唯一的标识符"
  parameterType="参数的类全限定名或别名"
  flushCache="true">

</update>
```
```xml
<delete
  id="命名空间中唯一的标识符"
  parameterType="参数的类全限定名或别名"
  flushCache="true">

</delete>
```
### selectKey
```xml
<selectKey
  keyProperty="结果应该被设置到的目标属性"
  resultType="结果的类型"
  order="如果设置为 BEFORE，那么它首先会生成主键，设置 keyProperty 再执行插入语句。如果设置为 AFTER，那么先执行插入语句，然后是 selectKey 中的语句"> 
```
### sql ：用来定义可重用的 SQL 代码片段，以便在其它语句中使用。
```xml
<sql id="userColumns"> 
    ${alias}.id,${alias}.username,${alias}.password 
</sql>
<select id="selectUsers" resultType="map">
    select
        <include refid="userColumns"><property name="alias" value="t1"/></include>,
        <include refid="userColumns"><property name="alias" value="t2"/></include>
    from some_table t1
    cross join some_table t2
</select>
```
### resultMap：结果映射
```xml
<resultMap id="" type="返回结果类型">
    <id column="主键字段" property="主键属性映射"/>
    <result column="非主键字段" property="非主键属性映射"/>
    <result column="非主键字段" property="非主键属性映射"/>
    ...
    <!-- 一对一，嵌套查询 -->
    <association property="account" javaType="account" select="getAccountToId" column="id"/>
    <!-- 一对一，嵌套结果映射 -->
    <association property="account" javaType="account">
        <id column="主键字段" property="主键属性映射"/>
        <result column="非主键字段" property="非主键属性映射"/>
    </association>
    <!-- 一对多，嵌套查询 -->
    <collection property="movies" javaType="List" ofType="movie" select="getMovieById" column="id" />
    <!-- 一对多，嵌套结果映射 -->
    <collection property="movies" ofType="movie">
        <id column="主键字段" property="主键属性映射"/>
        <result column="非主键字段" property="非主键属性映射"/>
    </collection>
</resultMap>
```
# 动态 SQL
## if：根据条件包含 where 子句的一部分。
```xml
<if test="title != null">
    AND title like #{title}
</if>
<if test="author != null and author.name != null">
    AND author_name like #{author.name}
</if>
```
## choose、when、otherwise 类似于  Java 中的 switch 语句
```xml
<choose>
    <when test="title != null">
        AND title like #{title}
    </when>
    <when test="author != null and author.name != null">
        AND author_name like #{author.name}
    </when>
    <otherwise>
        AND featured = 1
    </otherwise>
</choose>
```
## trim、where、set
```xml
<!-- where 元素只会在子元素返回任何内容的情况下才插入 “WHERE” 子句。而且，若子句的开头为 “AND” 或 “OR”，where 元素也会将它们去除。 -->
<where>
    <if test="state != null">
        state = #{state}
    </if>
    <if test="title != null">
        AND title like #{title}
    </if>
    <if test="author != null and author.name != null">
        AND author_name like #{author.name}
    </if>
</where>
<trim prefix="WHERE" prefixOverrides="AND |OR ">
...
</trim>

<!-- set 元素会动态地在行首插入 SET 关键字，并会删掉额外的逗号 -->
<set>
    <if test="username != null">username=#{username},</if>
    <if test="password != null">password=#{password},</if>
    <if test="email != null">email=#{email},</if>
    <if test="bio != null">bio=#{bio}</if>
</set>
<trim prefix="SET" suffixOverrides=",">
...
</trim>
```
## foreach：遍历
```xml
  <foreach collection="list" index="index" item="item" open="(" separator="," close=")">
        #{item}
  </foreach>
<!--你可以将任何可迭代对象（如 List、Set 等）、Map 对象或者数组对象作为集合参数传递给 foreach。
当使用可迭代对象或者数组时，index 是当前迭代的序号，item 的值是本次迭代获取到的元素。
当使用 Map 对象（或者 Map.Entry 对象的集合）时，index 是键，item 是值。-->
```
## bind
```xml
<select id="selectBlogsLike" resultType="Blog">
  <bind name="pattern" value="'%' + _parameter.getTitle() + '%'" />
  SELECT * FROM BLOG
  WHERE title LIKE #{pattern}
</select>
```








