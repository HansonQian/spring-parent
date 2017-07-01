package website.hanson.spring.a_proxy.b_cglib;

/**
 * Title: CustomerService
 * Description:customer业务类没有接口
 * Author:HanSon
 * Date:2017/6/30 22:03
 * Version:V1.0
 */
public class CustomerService {

    public void addCustomer() {
        System.out.println("基于CGLIB的字节码增强实现代理。。。addCustomer");
    }


    public void updateCustomer() {
        System.out.println("基于CGLIB的字节码增强实现代理。。。updateCustomer");
    }

    public void deleteCustomer() {
        System.out.println("基于CGLIB的字节码增强实现代理。。。deleteCustomer");
    }
}
