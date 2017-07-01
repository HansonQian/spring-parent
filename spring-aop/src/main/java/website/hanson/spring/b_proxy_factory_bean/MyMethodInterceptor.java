package website.hanson.spring.b_proxy_factory_bean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Title: MyMethodInterceptor
 * Description:环绕通知实现
 * Author:HanSon
 * Date:2017/6/30 23:12
 * Version:V1.0
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        //执行目标方法
        Object object = methodInvocation.proceed();
        after();
        return object;
    }

    public void before() {
        System.out.println("环绕通知 = = = before");
    }

    public void after() {
        System.out.println("环绕通知 = = = after");
    }
}
