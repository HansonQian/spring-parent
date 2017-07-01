package website.hanson.spring.c_inject.b_static_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: TestStaticFactory
 * Description:测试实例化bean方式之静态工厂方式
 * Author:HanSon
 * Date:2017/6/24 3:23
 * Version:V1.0
 */
public class TestStaticFactory {

    @Test
    public void testDemo() {
        String xmlPath = "c_inject.b_static_factory/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        StudentService studentService1 = (StudentService) applicationContext.getBean("studentService");
        StudentService studentService2 = (StudentService) applicationContext.getBean("studentService");
        System.out.println(studentService1==studentService2);
        studentService1.addStudent();
    }
}
