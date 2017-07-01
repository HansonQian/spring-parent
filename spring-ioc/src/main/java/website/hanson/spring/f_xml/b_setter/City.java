package website.hanson.spring.f_xml.b_setter;

/**
 * Title: City
 * Description:TODO(描述一下该类的作用)
 * Author:HanSon
 * Date:2017/6/26 0:13
 * Version:V1.0
 */
public class City {
    private Address address;

    private String cityName;

    @Override
    public String toString() {
        return "City{" +
                "address=" + address +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
