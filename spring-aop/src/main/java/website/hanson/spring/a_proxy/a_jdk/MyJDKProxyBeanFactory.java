package website.hanson.spring.a_proxy.a_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Title: MyJDKProxyBeanFactory
 * Description:bean工厂
 * Author:HanSon
 * Date:2017/6/29 23:44
 * Version:V1.0
 */
public class MyJDKProxyBeanFactory {

    //1、目标类
    private Object target;

    // 2、切面类(Advice的集合)
    private MyAspect myAspect = new MyAspect();

    public <T> T getProxyBean() {
        /**
         * 3、代理类：将目标类（切入点）和切面类（通知）结合-->切面
         *      Proxy.newProxyInstance
         *          参数1：loader,类加载器，动态代理类 运行时创建，任何类都需要类加载器将其加载到内存当中
         *              要求：传递的是被代理的类加载器ClassLoader
         *              类加载器怎样获取？
         *                  一般情况下：当前类.class.getClassLoader获取加载器
         *                          目标类实例.getClass().getClassLoader获取加载器
         *          参数2：Class[] interfaces:代理类需要实现的所有接口
         *              要求：得到被代理对象所实现的接口的所有Class对象
         *                 方式1：目标类实例.getClass().getInterfaces();注意只能获得自己的接口，不能获得父元素接口
         *                 方式2：new Class[]{UserService.class}
         *                例如：jdbc驱动-->DriverManager 获得接口Connection
         *          参数3：InvocationHandler 处理类，接口，必须进行实现，一般采用匿名内部类
         *                  提供了一个invoke方法，代理类的每一个方法执行时，都将调用一次invoke
         *                      参数 3.1、Object proxy：代理对象
         *                      参数 3.2、Method method：代理对象当前执行的方法的描述对象（反射）
         *                      参数 3.3、Object[] args：方法的实际参数
         */
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                myAspect.beforeAdvice();
                Object object = method.invoke(target, args);
                myAspect.afterAdvice();
                return object;
            }
        });
    }


    private static MyJDKProxyBeanFactory myJDKProxyBeanFactory = null;

    private MyJDKProxyBeanFactory() {
    }

    public static MyJDKProxyBeanFactory getMyJDKProxyBeanFactory() {
        if (null == myJDKProxyBeanFactory) {
            synchronized (MyJDKProxyBeanFactory.class) {
                if (null == myJDKProxyBeanFactory) {
                    return new MyJDKProxyBeanFactory();
                }
            }
        }
        return myJDKProxyBeanFactory;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
