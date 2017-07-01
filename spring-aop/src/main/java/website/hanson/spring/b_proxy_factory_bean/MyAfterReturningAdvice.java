package website.hanson.spring.b_proxy_factory_bean;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Title: MyMethodAfterAdvice
 * Description:后置通知,在目标方法成功执行后执行
 * Author:HanSon
 * Date:2017/6/30 23:38
 * Version:V1.0
 */
public class MyAfterReturningAdvice implements AfterReturningAdvice {
    /**
     * Callback after a given method successfully returned.
     *
     * @param returnValue the value returned by the method, if any
     * @param method      method being invoked
     * @param args        arguments to the method
     * @param target      target of the method invocation. May be <code>null</code>.
     * @throws Throwable if this object wishes to abort the call.
     *                   Any exception thrown will be returned to the caller if it's
     *                   allowed by the method signature. Otherwise the exception
     *                   will be wrapped as a runtime exception.
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(method.getGenericReturnType());
        after();
    }

    private void after() {
        System.out.println(" 后置通知 ");
    }
}
