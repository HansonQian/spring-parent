package website.hanson.spring.b_proxy_factory_bean;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Title: MyMethodBeforeAdvice
 * Description:前置通知,在执行目标方法之前执行
 * Author:HanSon
 * Date:2017/6/30 23:36
 * Version:V1.0
 */
public class MyMethodBeforeAdvice implements MethodBeforeAdvice {
    /**
     * Callback before a given method is invoked.
     *
     * @param method method being invoked
     * @param args   arguments to the method
     * @param target target of the method invocation. May be <code>null</code>.
     * @throws Throwable if this object wishes to abort the call.
     *                   Any exception thrown will be returned to the caller if it's
     *                   allowed by the method signature. Otherwise the exception
     *                   will be wrapped as a runtime exception.
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        before();
        System.out.println(target.getClass().getName());
    }

    private void before() {
        System.out.println(" 前置通知");
    }
}
