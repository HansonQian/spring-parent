package website.hanson.spring.c_inject.c_factory;

/**
 * Title: MyBeanFactory
 * Description:实例工厂,所有方法非静态
 * Author:HanSon
 * Date:2017/6/25 0:11
 * Version:V1.0
 */
public class MyBeanFactory {
    /**
     * 创建实例
     *
     * @return
     */
    public TeacherService createService() {
        return new TeacherImpl();
    }

}
