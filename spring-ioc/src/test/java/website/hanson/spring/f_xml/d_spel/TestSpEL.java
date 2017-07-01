package website.hanson.spring.f_xml.d_spel;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import website.hanson.spring.f_xml.c_p.Boy;

/**
 * Title: TestSpEL
 * Description:测试SpEL
 * Author:HanSon
 * Date:2017/6/26 23:43
 * Version:V1.0
 */
public class TestSpEL {

    @Test
    public void testSpEL() {
        String xmlPath = "f_xml.d_spel/bean.xml";
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);

        //要执行销毁方法,需要将容器关闭
        applicationContext.close();
    }
}
