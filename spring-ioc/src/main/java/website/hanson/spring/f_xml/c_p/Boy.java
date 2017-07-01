package website.hanson.spring.f_xml.c_p;

/**
 * Title: Boy
 * Description:Boy对象
 * Author:HanSon
 * Date:2017/6/26 0:25
 * Version:V1.0
 */
public class Boy {

    private String name;

    private int age;

    @Override
    public String toString() {
        return "Boy{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
