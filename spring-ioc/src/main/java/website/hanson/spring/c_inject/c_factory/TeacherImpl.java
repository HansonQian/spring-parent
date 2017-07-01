package website.hanson.spring.c_inject.c_factory;

/**
 * Title: TeacherImpl
 * Description:Teacher接口实现
 * Author:HanSon
 * Date:2017/6/25 0:05
 * Version:V1.0
 */
public class TeacherImpl implements TeacherService {
    @Override
    public void addTeacher() {
        System.out.println("TeacherImpl - - - >fun - -addTeacher ");
    }
}
