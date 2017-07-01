package website.hanson.spring.a_proxy.a_jdk;

/**
 * Title: UserService
 * Description:User业务接口
 * Author:HanSon
 * Date:2017/6/29 23:35
 * Version:V1.0
 */
public interface UserService {
    void addUser() throws Exception;

    void updateUser() throws Exception;

    void deleteUser() throws Exception;
}
