package website.hanson.spring.c_spring_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Title: PersonAspect
 * Description:切面类
 * Author:HanSon
 * Date:2017/7/1 11:57
 * Version:V1.0
 */
public class PersonAspect implements MethodInterceptor {

    public void before() {
        System.out.println("PersonAspect = =  目标方法执行之前 ");
    }

    public void after() {
        System.out.println("PersonAspect = =  目标方法执行之后 ");
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object obj = methodInvocation.proceed();
        after();
        return obj;
    }
}
