package website.hanson.spring.f_xml.a_constructor;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

/**
 * Title: TestCycle
 * Description:属性注入之构造函数注入
 * Author:HanSon
 * Date:2017/6/25 0:55
 * Version:V1.0
 */
public class TestConstructor {

    /**
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void testConstructor() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String xmlPath = "f_xml.a_constructor/beans.xml";
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        User user = (User) applicationContext.getBean("user");
        System.out.println(user);

        //要执行销毁方法,需要将容器关闭
        applicationContext.close();

    }
}
