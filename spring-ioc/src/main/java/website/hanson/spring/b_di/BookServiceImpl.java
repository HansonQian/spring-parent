package website.hanson.spring.b_di;

/**
 * Title: BookServiceImpl
 * Description:Book业务接口实现类
 * Author:HanSon
 * Date:2017/6/24 2:23
 * Version:V1.0
 */
public class BookServiceImpl implements BookService {


    public BookServiceImpl() {
        System.out.println("被实例化了>>>>>>");
    }

    private BookDao bookDao;


    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void addBook() {
        bookDao.saveBook();
    }
}
