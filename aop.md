### 1、AOP介绍
>对应程序spring-aop
#### 1.1、什么是AOP
- AOP Aspect Oriented Programing 面向切面编程
- AOP 采取横向机制，取代了传统纵向继承体系重复性代码（性能监控、事务管理、安全检查、缓存）
- Spring AOP 使用纯Java实现，不需要专门的编译过程和类加载器，在运行期通过代理方式向目标类织入增强代码
- AspectJ 是一个基于Java语言的AOP框架，Spring2.0开始，Spring AOP引入对Aspect的支持，Aspectj扩展了Java语言，提供了一个专门的编译器，在编译时提供横向代码的织入


#### 1.2、AOP实现原理

- JDK动态代理:接口+实现类
- CGLIB代理:对类生成代理

#### 1.3、AOP术语
- Joinpoint（连接点）：所谓连接点是指那些被拦截到的点。在Spring中，这些点指的是方法，因为Spring只支持方法类型的连接点
- Pointcut（切入点）：所谓切入点是指我们要对哪些Jointpoint进行拦截的定义
- Advice（通知/增强）：所谓通知是指拦截到Joinpoint之后要做的事情就是通知，通知分为前置通知,后置通知,异常通知,最终通知,环绕通知(切面要完成的功能)
- Introduction（引介）：引介是一种特殊的通知，在不修改类代码的前提下，Introduction可以在运行期为类动态地添加一些属性和方法
- Target（目标对象）：代理的目标对象
- Weaving（织入）：是指把增强应用到目标对象来创建新的代理对象的过程，Spring采用动态代理织入，而AspectJ采用编译期织入和类装载期织入
- Proxy（代理）：一个类被AOP织入增强后，就产生一个结果的代理类
- Aspect（切面）：是切入点和通知（引介）的结合

### 2、手动方式进行代理

#### 2.1、JDK动态代理

> JDK动态代理对"装饰者"设计模式 简化.使用前提必须有接口。

- 目标类:接口+实现类
- 切面类:用于存通知 MyAspect
- 工厂类:编写工厂生成代理类
- 动态代理对象 $Proxy编号

- 测试 (工程路径 website.hanson.spring.a_proxy.a_jdk)
    - 目标类 UserService
    - 切面类 MyAspect
    - 工厂类 MyJDKProxyBeanFactory

#### 2.2、CGLIB字节码增强

- 没有接口,只有实现类
- 采用字节码增强框架CGLIB,在运行时 创建目标类子类
- 导入jar包
    - 手动导入
        - 核心包：cglib.jar
        - 依赖包：asm-3.3.jar
    - spring方式
        - spring-core中已经整合了上述两个

- 测试(工程路径 website.hanson.spring.a_proxy.b_cglib)
    - 目标类：只是类没有接口 CustomerService
    - 切面类：MyAspect
    - 工厂类：MyCGLibProxyBeanFactory

#### 2.3、AOP联盟定义的通知类型接口(规范)

- AOP联盟为通知Advice定义了 org.aopalliance.aop.Advice
- Spring按照通知Advice在目标类方法的连接点位置,可以分为5类
    - 前置通知 org.springframework.aop.MethodBeforeAdvice
        - 在目标方法执行前实施增强
    - 后置通知 org.springframework.aop.AfterReturningAdvice
        - 在目标方法执行后实施增强
    - 环绕通知 org.aopalliance.intercept.MethodInterceptor
        - 在目标方法执行前后实施增强
    - 异常抛出通知 org.springframework.aop.ThrowsAdvice
        - 在方法抛出异常后实施增强
    - 引介通知 org.springframework.aop.IntroductionInterceptor
        - 在目标类中添加一些新的方法和属性

```

环绕通知,必须手动执行目标方法
try{
    //前置通知
    //执行目标方法
    //后置通知
}catch(){
    //抛出异常通知
}

```

#### 2.4、Spring编写代理：半自动

> 让Spring创建代理对象,需要从Spring容器中手动获取代理对象

- 导入jar包
    - 核心：4+1
    - AOP：AOP联盟(规范)、spring-aop(实现)
        - com.springsource.org.aopallliance
        - spring-aop
- 测试(应用程序路径)
    - 目标类 BookService
    - 实现类 BookServiceImpl
    - 增强类 *Advice
    - 配置文件 spring.b_proxy_factory_bean/beans.xml
    - 测试类 website.hanson.spring.b_proxy_factory_bean.TestProxyFactoryBean
- 底层机制
    - 如果目标类有接口，则使用JDK的动态代理
    - 如果没有接口,采用cglib字节码增强
    - 如果声明optimize=true,则无论是否有接口，都使用cglib

#### 2.5、Spring AOP编程：全自动

> 从Spring中获取的目标类,如果我们配置aop,spring将自动生成代理（后处理Bean）

- 要确定目标类,需要aspect切入点表达式,需要jar包aspecj
- aop编程
    - 导入命名空间
    - 使用<aop:config>进行配置
        - <aop:pointcut>：切入点，从目标对象获取具体的方法
        - <aop:advisor>：特殊的切面,只有一个通知和一个切入点
            - advice-ref:通知引用
            - ponitcut-ref：切入点引用
    - 切入点表达式
        - execution(        *       website.hanson.spring.c_spring_aop.    *            .         *                (..)  )
        - 选择方法     返回值任意                   包名                 类名任意             方法名任意         参数任意

    - proxy-target-class="false" 
        - 默认使用JDK动态代理
- 程序路径
    -  website.hanson.spring.c_spring_aop

### 3、AspctJ

#### 3.1、介绍

- AspectJ是一个基于Java语言的AOP框架
- Spring2.0以后新增了对AspectJ切点表达式的支持
- @Aspect是AspectJ1.5新增功能,通过JDK1.5注解技术,允许直接在Bean类中定义切面,新版本Spring框架,建议使用AspectJ方式来开发AOP

#### 3.2切入点表达式
- execution()：用于描述方法
    - 语法：execution(修饰符 返回值 包.类.方法名(参数)throws异常) 
        - 修饰符：一般省略
            - public：公共方法
            - *：任意修饰符
        - 返回值：不能省略
            - void：没有返回值
            - String：返回值是字符串
            - *：任意返回值
        - 包：[省略]
            - website.hanson.spring：固定包名
            - website.hanson.spring.*.service：spring包下面子包任意
            - website.hanson.spring..：spring包下面所有子包
            - website.hanson.spring.*.service..：spring包下任意子包,固定目录service,service目录下任意子包
        - 类：[省略]
            - UserServiceImpl：指定类
            - *Impl：以Impl结尾的类
            - User*：以User开头的类
            - *：任意
        - 方法名,不能省略
            - addUser()：固定方法名
            - add*：以add开头的方法
            - *Do：以Do结尾
            - *：任意方法名
        - 参数
            - ()：无参
            - (int)：一个整型参数
            - (int,int)：两个
            - (..)：参数任意
        - throws：可省略,一般不写
    - 示例:
        - execution(* website.hanson.spring.*.service..*.*())
        - <aop:pointcut expression="execution(* website.hanson.*WithCommit.*(..)) || execution(* website.hanson.*Service.*(..))" id="myPointCut"/>
- within：匹配包或子包中的方法
    - within(website.hanson.spring..*)
- this：匹配实现接口的代理对象中的方法
    - this(website.hanspn.aop.user.UserDao)
- target：匹配实现接口的目标对象中的方法
    - target(website.hanson.aop.user.UserDao)
- args：匹配参数格式符合标准的方法
    - args(int,int)
- bean(id)：对指定的bean所有的方法
    - bean("userService")


#### 3.3、AspectJ通知类型
- AOP联盟定义通知类型,具有特性接口,必须实现，从而确定方法名称
- AspectJ通知类型,只定义类型名称。以及方法格式
- 个数：6种
    - before：前置通知(应用:各种校验)
        - org.springframework.aop.aspectj.AspectJMethodBeforeAdvice
        - 在方法执行之前执行,如果通知抛出异常,则阻止目标方法运行
    - afterReturning：后置通知(应用：常规数据处理)
        - org.springframework.aop.aspectj.AspectJAfterAdvice
        - 方法正常返回后执行，如果方法中抛出异常，通知无法执行,必须在方法执行后才执行，所以可以获得方法的返回值
    - around：环绕通知(应用：十分强大，可以做任何事情)
        - org.springframework.aop.aspectj.AspectJAroundAdvice
        - 方法执行前后分别执行，可以阻止方法的执行，必须手动执行目标方法
    - afterThrowing:抛出异常通知(应用：包装异常信息)
        - org.springframework.aop.aspectj.AspectJAfterThrowingAdvice
        - 方法抛出异常后执行，如果方法没有抛出异常，无法执行
    - after:最终通知(应用：清理现场)
        - org.springframework.aop.aspectj.AspectJAfterAdvice
        - 方法执行完毕后执行，无论方法中是否出现异常
    - 引介通知(待补充)

```

环绕

try{
     //前置：before
    //手动执行目标方法
    //后置：afterRetruning
} catch(){
    //抛出异常 afterThrowing
} finally{
    //最终 after
}

```


#### 3.4基于XML方式开发AOP
> 程序路径： website.hanson.spring.d_aspect.a_xml

- 目标类：接口+实现类
    - 业务接口：CarService
    - 接口实现类：CarServiceImpl
- 切面类：CarAspect
    - 编写多个通知，采用aspectj 通知名称任意（方法名任意）
- 配置文件:spring.d_aspect.a_xml/beans.xml
- 测试
    - website.hanson.spring.d_aspect.a_xml.TestAspectBaseOnXML

#### 3.5基于注解方式来开发AOP

> 程序路径website.hanson.spring.d_aspect.b_ann

- 所有的Bean交给Spring管理
    - website.hanson.spring.d_aspect.b_ann.ItemServiceImpl
        - 添加@Service注解
    - website.hanson.spring.d_aspect.b_ann.ItemAspect
        - 添加@Aspect注解
        - 添加@Component注解
- 配置文件spring.d_aspect.b_ann/beans.xml
- 配置组件扫描器
    - <context:component-scan base-package="website.hanson.spring.d_aspect.b_ann"/>
- 切面类编写
    - website.hanson.spring.d_aspect.b_ann.ItemAspect
- 启动AOP配置方式
    - <aop:aspectj-autoproxy />
    - proxy-target-class="fasle"，默认为false即使用JDK动态代理,改为true则使用cglib代理
- 测试代码
    - website.hanson.spring.d_aspect.b_ann.TestAspectBaseOnAnnotation
