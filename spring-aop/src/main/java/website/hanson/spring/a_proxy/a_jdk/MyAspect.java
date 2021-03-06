package website.hanson.spring.a_proxy.a_jdk;

/**
 * Title: MyAspect
 * Description:切面类（封装各种通知）
 * Author:HanSon
 * Date:2017/6/29 23:43
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
