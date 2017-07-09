### JdbcTemplate

> 应用程序路径 sping-jdbc

- 是什么？
    - 是spring提供用于操作JDBC工具类，类似：DBUtils
    - 依赖 连接池DataSource(数据源)
- 创建一张表用于测试
    - t_user.sql
- 添加如下maven依赖
    - org.springframework.spring-beans.jar
    - org.springframework.spring-context.jar
    - org.springframework.spring-core.jar
    - org.springframework.spring-expression.jar
    - org.springframework.spring-jdbc.jar
    - org.springframework.spring-tx.jar
    - mysql-connector-java.jar
    - com.alibaba.druid.jar
    - junit4

### 使用API
- 创建表t_user的实体类 website.hanson.spring.a_domain.User
- api代码

```
    @Test
    public void testApi() {
        //1、创建数据源（连接池）
        DruidDataSource dataSource = new DruidDataSource();
        //1.1、数据库连接参数
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        //1.2、配置初始化大小、最小、最大
        dataSource.setInitialSize(1);
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(20);
        //1.3、配置获取连接等待超时时间,单位毫秒
        dataSource.setMaxWait(60000);
        //1.4、配置间隔多久才进行一次监测,监测需要关闭的空闲连接,单位毫秒
        dataSource.setMinEvictableIdleTimeMillis(300000);

        //2、创建JdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //3、使用JdbcTemplate模板
        jdbcTemplate.update("INSERT  INTO t_user(username,password) VALUES (?,?)", "hanson", "23456");
    }
    
```
- 总结
    - 构造对象可以交给Spring完成(IOC)
    - 属性属注入(DI)
    - 模板在Dao层使用

### 利用spring实现

- 核心配置文件
    - c_durid/beans.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
        <!--运行JVM参数覆盖-->
        <property name="systemPropertiesModeName" value="SYSTEM_PROPERTIES_MODE_OVERRIDE"/>
        <property name="ignoreResourceNotFound" value="true"/>
        <!--加载资源文件-->
        <property name="locations">
            <array>
                <value>classpath*:jdbc.properties</value>
            </array>
        </property>
    </bean>

    <!--1、配置数据源-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close">
        <!-- 数据库驱动 -->
        <property name="driverClassName" value="${jdbc.driver}"/>
        <!-- 基本属性 url、user、password -->
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.user}"/>
        <property name="password" value="${jdbc.password}"/>

        <!-- 配置初始化大小、最小、最大 -->
        <property name="initialSize" value="1"/>
        <property name="minIdle" value="1"/>
        <property name="maxActive" value="20"/>

        <!-- 配置获取连接等待超时的时间 -->
        <property name="maxWait" value="60000"/>

        <!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
        <property name="timeBetweenEvictionRunsMillis" value="60000"/>

        <!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
        <property name="minEvictableIdleTimeMillis" value="300000"/>

        <property name="validationQuery" value="SELECT 'x'"/>
        <property name="testWhileIdle" value="true"/>
        <property name="testOnBorrow" value="false"/>
        <property name="testOnReturn" value="false"/>
        <!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
        <property name="poolPreparedStatements" value="true"/>
        <property name="maxPoolPreparedStatementPerConnectionSize" value="20"/>

    </bean>

    <!--2、配置jdbc模板-->

    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!--3、配置Dao-->
    <bean id="userDao" class="website.hanson.spring.c_druid.UserDao">
        <property name="jdbcTemplate" ref="jdbcTemplate"/>
    </bean>

</beans>
```

- website.hanson.spring.c_druid.UserDao提供对象属性JdbcTemplate
- 测试代码
    - website.hanson.spring.c_druid.TestJdbcTemplate
- 其他数据源配置也类似,dbcp、c3p0、bonecp等等

### 使用JdbcDaoSupport
- UserDao继承JdbcDaoSupport完成CRUD

```
package website.hanson.spring.d_jdbcDaoSupport;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import website.hanson.spring.a_domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Title: UserDao
 * Description:使用JdbcDaoSupport
 * Author:HanSon
 */
public class UserDao extends JdbcDaoSupport {
    /**
     * 新增
     *
     * @param user
     */
    public void add(User user) {
        String sql = "Insert into user values(null,?)";
        this.getJdbcTemplate().update(sql, user.getUsername());
    }

    /**
     * 更新
     *
     * @param user
     */
    public void update(User user) {
        String sql = "update user set name=? where id=?";
        this.getJdbcTemplate().update(sql, user.getUsername(), user.getId());
    }

    /**
     * 删除
     *
     * @param user
     */
    public void delete(User user) {
        String sql = "delete from user where id=?";
        this.getJdbcTemplate().update(sql, user.getId());
    }

    /**
     * 查询总数
     *
     * @return
     */
    public int findCount() {
        String sql = "SELECT COUNT(1) FROM USER";
        return this.getJdbcTemplate().queryForInt(sql);
    }

    /**
     * 查询字段
     *
     * @param id
     * @return
     */
    public String findNameById(int id) {
        String sql = "SELECT name FROM USER where id=? ";
        return this.getJdbcTemplate().queryForObject(sql, String.class, id);
    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public User findUserById(int id) {
        String sql = "SELECT * FROM USER where id=? ";
        User user = this.getJdbcTemplate().queryForObject(sql,
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rownum)
                            throws SQLException {
                        User user = new User();
                        user.setId(rs.getInt("id"));
                        user.setUsername(rs.getString("username"));
                        user.setPassword(rs.getString("password"));
                        return user;
                    }
                }, id);
        return user;
    }

    /**
     * 查询列表
     *
     * @return
     */
    public List<User> findAll() {
        String sql = "SELECT * FROM USER ";
        List<User> list = (List<User>) this.getJdbcTemplate().query(sql,
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rownum)
                            throws SQLException {
                        User user = new User();
                        user.setId(rs.getInt("id"));
                        user.setUsername(rs.getString("username"));
                        user.setPassword(rs.getString("password"));
                        return user;
                    }
                });
        return list;
    }
}


```

- beans.xml配置
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
        <!--运行JVM参数覆盖-->
        <property name="systemPropertiesModeName" value="SYSTEM_PROPERTIES_MODE_OVERRIDE"/>
        <property name="ignoreResourceNotFound" value="true"/>
        <!--加载资源文件-->
        <property name="locations">
            <array>
                <value>classpath*:jdbc.properties</value>
            </array>
        </property>
    </bean>

    <!--1、配置数据源-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close">
        <!-- 数据库驱动 -->
        <property name="driverClassName" value="${jdbc.driver}"/>
        <!-- 基本属性 url、user、password -->
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.user}"/>
        <property name="password" value="${jdbc.password}"/>

        <!-- 配置初始化大小、最小、最大 -->
        <property name="initialSize" value="1"/>
        <property name="minIdle" value="1"/>
        <property name="maxActive" value="20"/>

        <!-- 配置获取连接等待超时的时间 -->
        <property name="maxWait" value="60000"/>

        <!-- 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒 -->
        <property name="timeBetweenEvictionRunsMillis" value="60000"/>

        <!-- 配置一个连接在池中最小生存的时间，单位是毫秒 -->
        <property name="minEvictableIdleTimeMillis" value="300000"/>

        <property name="validationQuery" value="SELECT 'x'"/>
        <property name="testWhileIdle" value="true"/>
        <property name="testOnBorrow" value="false"/>
        <property name="testOnReturn" value="false"/>
        <!-- 打开PSCache，并且指定每个连接上PSCache的大小 -->
        <property name="poolPreparedStatements" value="true"/>
        <property name="maxPoolPreparedStatementPerConnectionSize" value="20"/>

    </bean>

    <!--2、配置Dao
       dao继承JdbcDaoSupport,之后只需要注入数据源,底层将自动创建JdbcTemplete模板
    -->
    <bean id="userDao" class="website.hanson.spring.d_jdbcDaoSupport.UserDao">
        <property name="dataSource" ref="dataSource"/>
    </bean>
</beans>
```
