package website.hanson.spring.d_aspect.b_ann;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: TestAspectBaseOnAnnotation
 * Description:测试基于注解的AspectJ的AOP编程
 * Author:HanSon
 * Date:2017/7/1 13:34
 * Version:V1.0
 */
public class TestAspectBaseOnAnnotation {
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
}
