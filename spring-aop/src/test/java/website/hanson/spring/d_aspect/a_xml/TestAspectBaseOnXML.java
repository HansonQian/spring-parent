package website.hanson.spring.d_aspect.a_xml;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import website.hanson.spring.c_spring_aop.PersonService;

/**
 * Title: TestAspectBaseOnXML
 * Description:测试基于xml的AspectJ的AOP编程
 * Author:HanSon
 * Date:2017/7/1 13:33
 * Version:V1.0
 */
public class TestAspectBaseOnXML {

    private AbstractApplicationContext applicationContext = null;

    private static final String XML_PATH = "spring.d_aspect.a_xml/beans.xml";

    @Before
    public void before() {
        if (null == applicationContext) {
            applicationContext = new ClassPathXmlApplicationContext(XML_PATH);
        }
    }

    @After
    public void after() {
        applicationContext.close();
    }

    /**
     * @throws Exception
     */
    @Test
    public void testAspectBaseOnXML() throws Exception {
        CarService carService = (CarService) applicationContext.getBean("carService");
        carService.addCar();
    }
}
