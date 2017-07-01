package website.hanson.spring.a_proxy.a_jdk;

import org.junit.Test;

/**
 * Title: TestJdkProxy
 * Description:测试JDK动态代理
 * Author:HanSon
 * Date:2017/6/29 23:48
 * Version:V1.0
 */
public class TestJdkProxy {

    @Test
    public void testJdkProxy() throws Exception {
        //1、实例化ProxyBean工厂
        MyJDKProxyBeanFactory myJDKProxyBeanFactory = MyJDKProxyBeanFactory.getMyJDKProxyBeanFactory();
        //2、目标类实例化
        UserService userService = new UserServiceImpl();
        //3、将目标类传入给代理类工厂
        myJDKProxyBeanFactory.setTarget(userService);
        //4、从工厂中获取代理类实例
        userService = myJDKProxyBeanFactory.getProxyBean();
        //5、执行目标方法
        userService.addUser();
    }
}
