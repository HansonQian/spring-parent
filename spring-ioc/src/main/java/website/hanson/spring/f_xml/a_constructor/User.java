package website.hanson.spring.f_xml.a_constructor;

/**
 * Title: User
 * Description:User对象
 * Author:HanSon
 * Date:2017/6/25 23:55
 * Version:V1.0
 */
public class User {
    private int uid;
    private String userName;
    private int age;


    public User(Integer uid, String userName) {
        super();
        this.uid = uid;
        this.userName = userName;
    }

    public User(String userName, Integer age) {
        super();
        this.userName = userName;
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
