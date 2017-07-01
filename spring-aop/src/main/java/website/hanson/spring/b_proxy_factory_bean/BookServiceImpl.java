package website.hanson.spring.b_proxy_factory_bean;

/**
 * Title: BookServiceImpl
 * Description:业务接口实现类
 * Author:HanSon
 * Date:2017/6/30 23:10
 * Version:V1.0
 */
public class BookServiceImpl implements BookService {
    @Override
    public void addBook() throws Exception {
        System.out.println("基于Spring提供的ProxyFactoryBean(半自动) = = = >addBook");
    }

    @Override
    public void updateBook() throws Exception {
        System.out.println("基于Spring提供的ProxyFactoryBean(半自动) = = = >updateBook");
    }

    @Override
    public void deleteBook() throws Exception {
        System.out.println("基于Spring提供的ProxyFactoryBean(半自动) = = = >deleteBook");
    }

    @Override
    public void editBook() throws Exception {
        int i = 1 / 0;
        System.out.println("基于Spring提供的ProxyFactoryBean(半自动) = = = >editBook");
    }
}
