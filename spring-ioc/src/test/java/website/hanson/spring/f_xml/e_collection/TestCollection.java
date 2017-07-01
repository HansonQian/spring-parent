package website.hanson.spring.f_xml.e_collection;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import website.hanson.spring.f_xml.d_spel.Car;

/**
 * Title: TestCollection
 * Description:测试集合属性注入
 * Author:HanSon
 * Date:2017/6/26 23:59
 * Version:V1.0
 */
public class TestCollection {

    @Test
    public void testCollection() {
        String xmlPath = "f_xml.e_collection/bean.xml";
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        CollectionData collData = (CollectionData) applicationContext.getBean("collData");
        System.out.println(collData);

        //要执行销毁方法,需要将容器关闭
        applicationContext.close();
    }
}
