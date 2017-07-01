package website.hanson.spring.f_xml.b_setter;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import website.hanson.spring.f_xml.a_constructor.User;

import java.lang.reflect.InvocationTargetException;

/**
 * Title: TestSetter
 * Description:测试属性注入之setter注入
 * Author:HanSon
 * Date:2017/6/26 0:26
 * Version:V1.0
 */
public class TestSetter {

    @Test
    public void testConstructor() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String xmlPath = "f_xml.b_setter/bean.xml";
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        City city = (City) applicationContext.getBean("city");
        System.out.println(city);

        //要执行销毁方法,需要将容器关闭
        applicationContext.close();

    }
}
