package website.hanson.spring.d_aspect.a_xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Title: CarAspect
 * Description:切面类
 * Author:HanSon
 * Date:2017/7/1 13:07
 * Version:V1.0
 */
public class CarAspect {

    /**
     * 前置通知
     *
     * @param joinPoint
     * @see (org.springframework.aop.aspectj.AspectJMethodBeforeAdvice)
     */
    public void myAspectJMethodBeforeAdvice(JoinPoint joinPoint) {
        System.out.println(" AspectJMethodBeforeAdvice = = >前置通知：" + joinPoint.getSignature().getName());
    }

    /**
     * 后置通知
     *
     * @param joinPoint
     * @param ret
     * @see (org.springframework.aop.aspectj.AspectJAfterAdvice)
     */
    public void myAspectJAfterAdvice(JoinPoint joinPoint, Object ret) {
        System.out.println("AspectJAfterAdvice = = >后置通知 ： " + joinPoint.getSignature().getName()
                + " , == >" + ret);
    }

    /**
     * @param joinPoint
     * @return
     * @throws Throwable
     * @see (org.springframework.aop.aspectj.AspectJAroundAdvice)
     */
    public Object myAspectJAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("AspectJAroundAdvice = = >目标方法执行前");
        // 手动执行目标方法
        Object obj = joinPoint.proceed();
        System.out.println("AspectJAroundAdvice = = >目标方法执行后");
        return obj;
    }

    /**
     * 抛出异常通知
     *
     * @param joinPoint
     * @param e
     * @see (org.springframework.aop.aspectj.AspectJAfterThrowingAdvice)
     */
    public void myAspectJAfterThrowingAdvice(JoinPoint joinPoint, Throwable e) {
        System.out.println("AspectJAfterThrowingAdvice = = >抛出异常通知 ： " + e.getMessage());
    }

    /**
     * 最终通知
     *
     * @param joinPoint
     * @see (org.springframework.aop.aspectj.AspectJAfterAdvice)
     */
    public void myAspectJAfterAdvice(JoinPoint joinPoint) {
        System.out.println("AspectJAfterAdvice = = >最终通知");
    }
}
