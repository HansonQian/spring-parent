package website.hanson.spring.d_aspect.b_ann;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Title: ItemAspect
 * Description:切面类
 * Author:HanSon
 * Date:2017/7/1 13:09
 * Version:V1.0
 */
@Aspect
@Component
public class ItemAspect {

    /**
     * 声明一个共有的表达式,方法名任意
     */
    @Pointcut(value = "execution(* website.hanson.spring.d_aspect.b_ann.ItemService.*(..))")
    public void myPointCut() {
    }


    /**
     * 前置通知
     *
     * @param joinPoint
     * @see (org.springframework.aop.aspectj.AspectJMethodBeforeAdvice)
     */
    @Before(value = "execution(* website.hanson.spring.d_aspect.b_ann.ItemService.add*(..))", argNames = "joinPoint")
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
    @AfterReturning(value = "myPointCut()", returning = "ret")
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
    @Around(value = "myPointCut()")
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
    @AfterThrowing(value = "myPointCut()", throwing = "e")
    public void myAspectJAfterThrowingAdvice(JoinPoint joinPoint, Throwable e) {
        System.out.println("AspectJAfterThrowingAdvice = = >抛出异常通知 ： " + e.getMessage());
    }

    /**
     * 最终通知
     *
     * @param joinPoint
     * @see (org.springframework.aop.aspectj.AspectJAfterAdvice)
     */
    @After(value = "myPointCut()")
    public void myAspectJAfterAdvice(JoinPoint joinPoint) {
        System.out.println("AspectJAfterAdvice = = >最终通知");
    }
}
