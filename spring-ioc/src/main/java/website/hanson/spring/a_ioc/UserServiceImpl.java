package website.hanson.spring.a_ioc;

/**
 * Title: UserServiceImpl
 * Description:UserService接口实现类
 * Author:HanSon
 * Date:2017/6/23 23:48
 * Version:V1.0
 */
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("UserService - - - >fun - - > addUser()");
    }
}
