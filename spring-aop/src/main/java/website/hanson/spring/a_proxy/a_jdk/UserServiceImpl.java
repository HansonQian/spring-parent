package website.hanson.spring.a_proxy.a_jdk;

/**
 * Title: UserServiceImpl
 * Description:User接口实现类
 * Author:HanSon
 * Date:2017/6/29 23:37
 * Version:V1.0
 */
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() throws Exception {
        System.out.println("基于JDK的动态代理实现。。。addUser");
    }

    @Override
    public void updateUser() throws Exception {
        System.out.println("基于JDK的动态代理实现。。。updateUser");
    }

    @Override
    public void deleteUser() throws Exception {
        System.out.println("基于JDK的动态代理实现。。。deleteUser");
    }
}
