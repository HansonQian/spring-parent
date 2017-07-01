### 1、Spring框架概述

#### 1.1、Spring是什么?
    
- Spring是一个开源框架，Spring是于2003 年兴起的一个轻量级的Java 开发框架，
    由Rod Johnson 在其著作Expert One-On-One J2EE Development and Design中阐述的部分理念和原型衍生而来。
    它是为了解决企业应用开发的复杂性而创建的。
    框架的主要优势之一就是其分层架构，分层架构允许使用者选择使用哪一个组件，同时为 J2EE 应用程序开发提供集成的框架。
    Spring使用基本的JavaBean来完成以前只可能由EJB完成的事情。然而，Spring的用途不仅限于服务器端的开发。
    从简单性、可测试性和松耦合的角度而言，任何Java应用都可以从Spring中受益。
    Spring的核心是控制反转（IoC）和面向切面（AOP）。
    简单来说，Spring是一个分层的JavaSE/EE full-stack(一站式) 轻量级开源框架


- 轻量级：与EJB对比，依赖资源少，销毁的资源少
    
    
- 分层：一站式，每一层都提供的解决方案

    web层：struts,Spring-mvc
        
    service层：spring
        
    dao层：hibernate、mybatis、jdbcTemplate、spring-data
 
#### 1.2、Spring由来
- Expert One-to-One J2EE Design and Development

- Expert One-to-One J2EE Development without EJB
    
#### 1.3、Spring核心
  Spring核心是**控制反转(IOC)**和**面向切面(AOP)**
    
#### 1.4、Spring优点
- 方便解耦，简化开发（高内聚低耦合）

    1、Spring就是一个大工厂(容器)，可以将所有对象创建和依赖关系维护，交给Spring管理
    
    2、Spring工厂是用于生产bean
    

- AOP编程的支持
    
    1、Spring提供面向切面编程，可以方便的实现对程序进行权限拦截、运行监控等功能

- 声明式事务的支持

    1、只需要通过配置（或者注解）就可以完成对事务的管理，而无需手动编写事务
    
- 方便程序的测试

    1、Spring对Junit4支持，可以通过注解方便的测试Spring程序
    
- 方便集成各种优秀框架
    
    1、Spring不排斥各种优秀的开源框架，其内部提供了对各种优秀框架
            （如：Struts、Hibernate、MyBatis、Quartz等）的直接支持

- 降低JavaEE API的使用难度

    1、Spring 对JavaEE开发中非常难用的一些API（JDBC、JavaMail、远程调用等），
            都提供了封装，使这些API应用难度大大降低

#### 1.5、Spring体系结构
Spring框架是一个分层架构，它包含一系列的功能要素并被分为大约20个模块。这些模块分为Core Container、
Data Access/Integration、Web、AOP(Aspect Oriented Programming)、Instrumentation和部分测试部分

核心容器：beans、core、context、expression


### 2、入门案例IOC
#### 2.1、导入jar包
- 4+1：4个核心（beans、core、cotext、express）+ 1个依赖（commons-logging）

#### 2.2、目标类
- 提供UserService接口和实现类
- 获得UserService实现类的实例
- 路径见(spring-ioc下website.hanson.spring.a_ioc包中)

> 以前的开发方式是直接new一个示例,先将要将创建对象示例交给Spring,也就是说将创建对象的控制权交由Spring了(IoC 控制反转)


#### 2.3、配置文件
- 位置：任意，开发中一般放在classpath下(src)
- 名称：任意，开发中一般以applicationContext来命名
- 内容：添加schema约束
- 约束文件位置：spring-framework-3.2.0.RELEASE\docs\spring-framework-reference\html\ xsd-config.html
- 路径见(spring-ioc下resources\a_ioc\beans.xml)

#### 2.4、测试

- 测试代码路径(website.hanson.spring.a_ioc.TestIoC)

### 3、入门案例DI

- DI(Dependency Injection):依赖注入
    - is a  ： 是一个，继承
    - has a :  有一个,成员变量，依赖
        - 依赖：一个对象需要使用另一个对象
        - 注入：通过setter方法进行另一个对象实例设置
- 示例程序路径(website.hanson.spring.b_di包)
- 测试代码(website.hanson.spring.b_di.TestDI)

### 4、核心API

> 了解整体。

- BeanFactory：这是一个工厂，用于生成任意Bean，当配置文件被加载，就进行对象实例化

- Application：是BeanFactory的子接口，功能更强大。(国际化处理、事件传递、Bean自动装配、各种不同应用层的Context实现),当第一次调用时，进行对象实例化

    - ClassPathXmlApplicationContext：用于加载classpath（类路径、src）下的xml，加载xml运行时位置 --> /WEB-INF/classes/...xml
    - FileSystemXmlApplicationContext：用于加载指定盘符下的xml，加载xml运行时位置 --> /WEB-INF/...xml
        - 通过java web ServletContext.getRealPath() 获得具体盘符

### 5、装备Bean基于XML方式
#### 5.1、实例化Bean方式

> 3种bean实例化方式包括：默认构造函数、静态工厂、实例工厂。

- 默认构造
    - 当配置为<bean id="" class=""/>,这种配置就是默认构造函数。
    - 参考入门ioc程序

- 静态工厂
    - 用于生成实例对象，所有的方法必须是static
    - 常常用于Spring整合其他框架(工具)
    - 基本配置方式为 <bean id="" class="" factory-method="静态方法名"/>
    - 将静态工程实例的创建交给Spring
    - class确定静态工厂的权限定类名
    - factory-method 确定静态方法名
    - 参考程序website.hanson.spring.c_inject.b_static_factory.StaticFactory

- 实例工厂
    - 必须先有工厂实例对象，通过实例对象创建对象。提供所有的方法都是“非静态”的。
    - 参考程序(website.hanson.spring.c_inject.c_factory)

#### 5.2、Bean种类

- 普通bean：之前操作的都是普通的bean,<bean id="" class="A"> ，spring直接创建A实例，并返回.
- FactoryBean：是一个特殊的bean，具有工厂生成对象能力，只能生成特定的对象。
    - bean必须使用 FactoryBean接口，此接口提供方法 getObject() 用于获得特定bean。
        - <bean id="" class="FB"> 先创建FB实例，使用调用getObject()方法，并返回方法的返回值
            - FB fb = new FB();	
            - return fb.getObject();
- BeanFactory 和 FactoryBean 对比
    - BeanFactory：工厂，用于生成任意bean。
    - FactoryBean：特殊bean，用于生成另一个特定的bean。
        - 例如：ProxyFactoryBean ，此工厂bean用于生产代理。<bean id="" class="....ProxyFactoryBean"> 获得代理对象实例。AOP使用




#### 5.3、作用域

> 用于确定Spring创建bean实例的个数。


类别 | 说明
---|---
singleton | 在SpringIoC容器中仅存在一个Bean实例,Bean以单例方式存在。默认值
prototype | 每次从容器中调用Bean时,都返回一个新的实例,即每次调用getBean时,相当于new
request | 每次HTTP请求都会创建一个新的Bean,该作用域仅适用于WebApplicationContext环境
session | 同一个HTTP Session共享一个Bean,不同Session使用不同Bean,该作用域仅适用于WebApplicationContext环境
globalSession | 一般用于Portlet应用环境,该作用域仅适用于WebApplicationContext环境

- 取值：
    - singleton 单例，默认值
    - prototype 多例，每执行一次getBean将获得一个新的实例
- 配置：
    - <bean id="" class="" scope=""/>

#### 5.4、Bean的生命周期

##### 5.4.1、初始化和销毁

- 目标方法执行前、目标方法执行后,将进行初始化或销毁
    - <bean id="" init-method="初始化方法名称" destroy-method="销毁的方法名称"/>
- 要执行销毁方法必须是单例
- Spring要执行close方法

##### 5.4.2、BeanPostProcessor后处理Bean
- Spring提供一种机制,只要实现BeanPostProcessor,并将实现类提供给spring容器Spring会自动执行,在初始化方法前执行before,在初始化方法后执行after

- Factory hook that allows for custom modification of new bean instances, e.g. checking for marker interfaces or wrapping them with proxies. 

- Spring提供工厂勾子，用于修改实例对象，可以生成代理对象，是AOP底层

- 后处理bean作用于所有目标类
    - 如何只作用一个,可以通过参数2,beanName进行控制



#### 5.5、属性依赖注入

> 依赖注入方式分为:手动装配和自动装配（接口装配）

- 手动装配
    - 一般进行配置信息都采用手动
        - 基于XML装配:构造方法、setter方法
        - 基于注解注解装配
- 自动装配
    - struts2和spring整合可以自动装配
        - byType：按类型装配
        - byName：按名称装配
        - constructor：构造装配
        - auto：不确定装配

##### 5.5.1、构造函数

>程序路径 website.hanson.spring.f_xml.a_constructor

- <constructor-arg>配置信息
    - name ：参数的名称
    - value：设置普通数据
    - ref：引用数据，一般是另一个bean id值
    - index ：参数的索引号，从0开始 。如果只有索引，匹配到了多个构造方法时，默认使用第一个
    - type ：确定参数类型

##### 5.5.2、setter方法

-程序路径 website.hanson.spring.f_xml.b_setter

- 普通数据
    - <property name="" value="值">
    - 等效于
        - <property name="">
            - <value>值</value>

- 引用数据
    - <property name="" ref="另一个bean id">
    - 等效于
        - <property name="">
        - <ref bean="另一个bean"/>
    

##### 5.5.3、P命名空间

>程序路径 website.hanson.spring.f_xml.c_p

- 对“setter方法注入”进行简化，替换<property name="属性名">，而是在<bean p:属性名="普通值"  p:属性名-ref="引用值">
- p命名空间使用前提，必须添加命名空间


##### 5.5.4、SpEL

- 对<property>进行统一编程，所有的内容都使用value
- <property name="" value="#{表达式}">
    - #{123}、#{'jack'}： 数字、字符串
    - #{beanId}：另一个bean引用
    - #{beanId.propName}：操作数据
    - #{beanId.toString()}：执行方法
    - #{T(类).字段|方法}：静态方法或字段

##### 5.5.5、集合注入

>参考程序 website.hanson.spring.f_xml.e_collection

- 数组 <array>
- List <list>
- Set <set>
- Map <map> <entry>
- Properties <props>

### 6、装备Bean基于注解方式

> 注解:是一个类,使用@注解名称,使用注解取代xml文件,提高开发效率!

- 类级别注解
    - @Component:描述Spring框架中Bean
    - @Repository :用于对Dao实现类进行标注
    - @Service :用于对Service实现类进行标注
    - @Controller :用于对Controller实现类进行注解
- 声明周期注解
    - @Scope:配置Bean的作用范围
    - @PostConstruct 初始化方法
    - @PreDestory  销毁方法
- 依赖注入
    - @Value：注入普通值
    - @Autowired:按照类型注入
    - @Autowired @Qualifer("名称") 按照名称注入
    - @Resource("名称")
