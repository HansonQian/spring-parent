package website.hanson.spring.f_xml.b_setter;

/**
 * Title: Address
 * Description:地址
 * Author:HanSon
 * Date:2017/6/26 0:13
 * Version:V1.0
 */
public class Address {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "Address{" +
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
