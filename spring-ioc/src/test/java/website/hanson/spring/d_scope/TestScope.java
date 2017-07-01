package website.hanson.spring.d_scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: TestScope
 * Description:测试声明范围
 * Author:HanSon
 * Date:2017/6/25 0:49
 * Version:V1.0
 */
public class TestScope {
    @Test
    public void testScope() {
        String xmlPath = "d_scope/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Classroom bean1 = applicationContext.getBean(Classroom.class);
        Classroom bean2 = applicationContext.getBean(Classroom.class);

        //false
        System.out.println(bean1==bean2);
    }
}
