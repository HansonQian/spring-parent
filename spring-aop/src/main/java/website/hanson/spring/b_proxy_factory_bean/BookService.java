package website.hanson.spring.b_proxy_factory_bean;

/**
 * Title: BookService
 * Description:目标类
 * Author:HanSon
 * Date:2017/6/30 23:07
 * Version:V1.0
 */
public interface BookService {
    void addBook() throws Exception;

    void updateBook() throws Exception;

    void deleteBook() throws Exception;

    void editBook() throws Exception;
}
