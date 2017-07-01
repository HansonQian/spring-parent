package website.hanson.spring.c_inject.b_static_factory;

/**
 * Title: StaticFactory
 * Description:实例化Bean方式之静态工厂
 * Author:HanSon
 * Date:2017/6/24 3:16
 * Version:V1.0
 */
public class StaticFactory {
    public static StudentService createStudentService() {
        return new StudentServiceImpl();
    }
}
