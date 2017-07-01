package website.hanson.spring.a_ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: TestIoC
 * Description:测试IoC
 * Author:HanSon
 * Date:2017/6/24 0:02
 * Version:V1.0
 */
public class TestIoC {

    /**
     * 未使用Spring方式
     */
    @Test
    public void testDemo1() {
        //1、实例化一个对象
        UserService userService = new UserServiceImpl();
        //2、调用对象的方法
        userService.addUser();
    }


    /**
     * 使用spring方式
     */
    @Test
    public void testDemo2() {
        String xmlPath = "a_ioc/beans.xml";
        //构建Spring上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //从容器中获取对象
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.addUser();
    }
}
