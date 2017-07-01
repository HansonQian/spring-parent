package website.hanson.spring.e_lifecycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

/**
 * Title: TestCycle
 * Description:测试声明周期
 * Author:HanSon
 * Date:2017/6/25 0:55
 * Version:V1.0
 */
public class TestCycle {

    @Test
    public void testScope() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String xmlPath = "e_lifecycle/beans.xml";
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        PersonService personService = applicationContext.getBean(PersonService.class);

        personService.addPerson();

        //要执行销毁方法,需要将容器关闭
        applicationContext.close();

    }
}
