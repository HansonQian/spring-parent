package website.hanson.spring.f_xml.d_spel;

/**
 * Title: Car
 * Description:Car类
 * Author:HanSon
 * Date:2017/6/26 23:41
 * Version:V1.0
 */
public class Car {
    private String name = "tom";

    private double pi;

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", pi=" + pi +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPi() {
        return pi;
    }

    public void setPi(double pi) {
        this.pi = pi;
    }
}
