package website.hanson.spring.f_xml.c_p;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import website.hanson.spring.f_xml.b_setter.City;

/**
 * Title: TestP
 * Description:测试P命名空间
 * Author:HanSon
 * Date:2017/6/26 0:29
 * Version:V1.0
 */
public class TestP {
    @Test
    public void testP() {
        String xmlPath = "f_xml.c_p/bean.xml";
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        Boy boy = (Boy) applicationContext.getBean("boy");
        System.out.println(boy);

        //要执行销毁方法,需要将容器关闭
        applicationContext.close();
    }
}
