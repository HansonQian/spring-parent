package website.hanson.spring.e_lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Title: MyPostBeanProcessor
 * Description:TODO(描述一下该类的作用)
 * Author:HanSon
 * Date:2017/6/25 17:49
 * Version:V1.0
 */
public class MyPostBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization = = >前方法====beanName:" + s);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(final Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization = = >后方法====beanName:" + s);
        return Proxy.newProxyInstance(MyPostBeanProcessor.class.getClassLoader(), o.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开启事务");
                Object retObject = method.invoke(o, args);
                System.out.println("提交事务");
                return retObject;
            }
        });
    }
}
