package website.hanson.spring.a_proxy.b_cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Title: MyCGLibProxyBeanFactory
 * Description:没有接口,只有实现类,才有字节码增强框架cglib,在运行时 创建目标类的子类,从而对目标类进行增强。
 * Author:HanSon
 * Date:2017/6/30 22:07
 * Version:V1.0
 */
public class MyCGLibProxyBeanFactory {


    private MyCGLibProxyBeanFactory() {
    }

    private static  final MyCGLibProxyBeanFactory singleton = null;


    public static MyCGLibProxyBeanFactory createCGLibProxyBeanFactory() {
        if (null == singleton) {
            synchronized (MyCGLibProxyBeanFactory.class) {
                if (null == singleton) {
                    return new MyCGLibProxyBeanFactory();
                }
            }
        }
        return singleton;
    }

    //目标类
    private Object target;
    //切面类
    private MyAspect myAspect = new MyAspect();

    /**
     * 返回目标类的代理类
     *
     * @param <T>
     * @return
     */
    public <T> T getProxyBean() {
        // 1、代理类，采用cglib,底层原理是创建目标类的子类
        //1.1、核心类
        Enhancer enhancer = new Enhancer();
        //1.2、确定父类(即目标类)
        enhancer.setSuperclass(target.getClass());
        /**
         * 1.3、设置回调函数,MethodInterceptor接口等效InvocationHandler接口
         * 		intercept()方法等效JDK中的invoke方法
         * 		参数1、参数2、参数3与invoke一样
         * 		参数4：methodProxy：方法的代理
         *
         */
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                myAspect.beforeAdvice();

                // 执行代理类的父类，就是目标类，因为目标类和代理类是父子关系
                // methodProxy.invokeSuper(o, args);

                // 执行目标类方法
                Object obj = method.invoke(target, objects);


                myAspect.afterAdvice();
                return obj;
            }
        });
        // 1.4 创建代理
        return (T) enhancer.create();
    }


    public void setTarget(Object target) {
        this.target = target;
    }
}
