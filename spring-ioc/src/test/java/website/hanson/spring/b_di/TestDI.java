package website.hanson.spring.b_di;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Title: TestDI
 * Description:测试依赖注入
 * Author:HanSon
 * Date:2017/6/24 2:29
 * Version:V1.0
 */
public class TestDI {

    /**
     * 配置文件一旦加载完成bean就创建好了
     */
    @Test
    public void testDemo1() {
        String xmlPath = "b_di/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        BookService bookService = (BookService) applicationContext.getBean("bookService");
        bookService.addBook();
    }


    /**
     * 使用BeanFactory
     * 第一次使用对象时才会被调用
     */
    @Test
    public void testDemo2() {
        String xmlPath = "b_di/beans.xml";
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(xmlPath));
        BookService bookService = (BookService) beanFactory.getBean("bookService");
        bookService.addBook();
    }
}
