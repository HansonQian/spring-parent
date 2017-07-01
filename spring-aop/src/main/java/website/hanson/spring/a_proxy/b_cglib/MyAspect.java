package website.hanson.spring.a_proxy.b_cglib;

/**
 * Title: MyAspect
 * Description:切面类
 * Author:HanSon
 * Date:2017/6/30 22:07
 * Version:V1.0
 */
public class MyAspect {
    public void beforeAdvice() {
        System.out.println("执行目标方法之前");
    }

    public void afterAdvice() {
        System.out.println("执行目标方法之后");
    }
}
