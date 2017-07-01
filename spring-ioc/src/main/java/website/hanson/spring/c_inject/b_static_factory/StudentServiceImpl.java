package website.hanson.spring.c_inject.b_static_factory;

/**
 * Title: StudentServiceImpl
 * Description:学生业务接口实现
 * Author:HanSon
 * Date:2017/6/24 3:17
 * Version:V1.0
 */
public class StudentServiceImpl implements StudentService {

    @Override
    public void addStudent() {
        System.out.println("fun - - -> - - addStudent");
    }
}
