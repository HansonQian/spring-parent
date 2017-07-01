package website.hanson.spring.e_lifecycle;

/**
 * Title: PersonServiceImpl
 * Description:TODO(描述一下该类的作用)
 * Author:HanSon
 * Date:2017/6/25 0:56
 * Version:V1.0
 */
public class PersonServiceImpl implements PersonService {

    public void myInitMethod(){
        System.out.println("myInitMethod - - - ");
    }

    @Override
    public void addPerson() {
        System.out.println("PersonServiceImpl - - - >fun - - addPerson");
    }


    public void myDestroyMethod(){
        System.out.println("myDestroyMethod - - - ");
    }
}
