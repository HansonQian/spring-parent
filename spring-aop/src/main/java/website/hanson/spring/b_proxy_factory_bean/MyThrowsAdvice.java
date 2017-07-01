package website.hanson.spring.b_proxy_factory_bean;

import org.springframework.aop.ThrowsAdvice;

/**
 * Title: MyThrowsAdvice
 * Description:异常抛出通知
 * Author:HanSon
 * Date:2017/6/30 23:40
 * Version:V1.0
 * 有几个需要注意的地方：
 * <p>
 * 1、就是原型对象的异常不能抓！一旦抓取就无法运行afterThrowing。也就是只有出异常了，且没被抓，才会运行这个方法。
 * <p>
 * 2、不能在运行的方法中直接new ThrowsAdvice然后实现afterThrowing方法，这样因为出异常，线程挂了，也会无法运行这个afterThrowing方法。
 */
public class MyThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception e) throws Throwable {
        System.out.println("出异常了..." + e);
    }
}
