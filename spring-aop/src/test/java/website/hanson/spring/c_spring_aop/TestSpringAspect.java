package website.hanson.spring.c_spring_aop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: TestSpringAspect
 * Description:测试spring的使用aspect完成aop编程
 * Author:HanSon
 * Date:2017/7/1 12:15
 * Version:V1.0
 */
public class TestSpringAspect {
    private AbstractApplicationContext applicationContext = null;

    private static final String XML_PATH = "spring.c_spring_aop/beans.xml";

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
     * 测试环绕通知
     *
     * @throws Exception
     */
    @Test
    public void testMethodInterceptor() throws Exception {
        //org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor
        PersonService personService = (PersonService) applicationContext.getBean("personService");
        personService.addPerson();
    }


}
