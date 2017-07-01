package website.hanson.spring.a_proxy.b_cglib;

import org.junit.Test;

/**
 * Title: TestCGLibProxy
 * Description:测试字节码增强代理
 * Author:HanSon
 * Date:2017/6/30 22:05
 * Version:V1.0
 */
public class TestCGLibProxy {

    @Test
    public void testCGLibProxy() {
        CustomerService customerService = new CustomerService();
        MyCGLibProxyBeanFactory cgLibProxyBeanFactory = MyCGLibProxyBeanFactory.createCGLibProxyBeanFactory();
        cgLibProxyBeanFactory.setTarget(customerService);
        customerService = cgLibProxyBeanFactory.getProxyBean();
        customerService.addCustomer();
        customerService.updateCustomer();
        customerService.deleteCustomer();
    }
}
