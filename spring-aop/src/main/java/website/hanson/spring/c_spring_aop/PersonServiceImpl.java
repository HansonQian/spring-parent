package website.hanson.spring.c_spring_aop;

/**
 * Title: PersonServiceImpl
 * Description:接口实现类
 * Author:HanSon
 * Date:2017/7/1 11:55
 * Version:V1.0
 */
public class PersonServiceImpl implements PersonService {
    @Override
    public void addPerson() throws Exception {
        System.out.println(" Spring使用AspectJ完成全自动AOP编程 = = >addPerson");
    }

    @Override
    public void updatePerson() throws Exception {
        System.out.println(" Spring使用AspectJ完成全自动AOP编程 = = >updatePerson");
    }

    @Override
    public void deletePerson() throws Exception {
        System.out.println(" Spring使用AspectJ完成全自动AOP编程 = = >deletePerson");
    }
}
