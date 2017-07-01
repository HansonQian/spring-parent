package website.hanson.spring.d_scope;

/**
 * Title: Class
 * Description:TODO(描述一下该类的作用)
 * Author:HanSon
 * Date:2017/6/25 0:47
 * Version:V1.0
 */
public class Classroom {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "Classroom{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
