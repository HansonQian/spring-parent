package website.hanson.spring.b_proxy_factory_bean;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Title: TestProxyFactoryBean
 * Description:测试Spring半自动实现的动态代理
 * Author:HanSon
 * Date:2017/6/30 23:24
 * Version:V1.0
 */
public class TestProxyFactoryBean {
    private AbstractApplicationContext applicationContext = null;

    private static final String XML_PATH = "spring.b_proxy_factory_bean/beans.xml";

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
     */
    @Test
    public void testAroundAdvice() throws Exception {
        BookService bookService = (BookService) applicationContext.getBean("proxyBookServiceAroundAdvice");
        bookService.addBook();
    }

    /**
     * 测试前置通知
     * 前置通知可以阻止目标方法执行
     *
     * @throws Exception
     */
    @Test
    public void testBeforeAdvice() throws Exception {
        BookService bookService = (BookService) applicationContext.getBean("proxyBookServiceBeforeAdvice");
        bookService.deleteBook();
    }

    /**
     * 测试后置通知
     * 可以获取目标方法的返回值
     *
     * @throws Exception
     */
    @Test
    public void testAfterAdvice() throws Exception {
        BookService bookService = (BookService) applicationContext.getBean("proxyBookServiceAfterReturningAdvice");
        bookService.updateBook();
    }

    /**
     * 测试抛出异常通知
     *
     * @throws Exception
     */
    @Test
    public void testThrowExceptionAdvice() throws Exception {
        BookService bookService = (BookService) applicationContext.getBean("proxyBookServiceThrowsAdvice");
        bookService.editBook();
    }


}
