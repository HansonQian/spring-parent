package website.hanson.spring.c_inject.c_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import website.hanson.spring.c_inject.b_static_factory.StudentService;

/**
 * Title: TestFactory
 * Description:测试实例化bean方式之实例工厂方式
 * Author:HanSon
 * Date:2017/6/24 3:24
 * Version:V1.0
 */
public class TestFactory {

    @Test
    public void testDemo() {
        String xmlPath = "c_inject.c_factory/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        TeacherService teacherService = applicationContext.getBean(TeacherService.class);
        teacherService.addTeacher();
    }
}
