package website.hanson.spring.b_di;

/**
 * Title: BookDaoImpl
 * Description:Book持久化接口实现类
 * Author:HanSon
 * Date:2017/6/24 2:23
 * Version:V1.0
 */
public class BookDaoImpl implements BookDao {
    @Override
    public void saveBook() {
        System.out.println("fun - - - > - - addBook()");
    }
}
