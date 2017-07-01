package website.hanson.spring.d_aspect.a_xml;

/**
 * Title: CarServiceImpl
 * Description:Car接口实现类
 * Author:HanSon
 * Date:2017/7/1 13:06
 * Version:V1.0
 */
public class CarServiceImpl implements CarService {
    @Override
    public void addCar() throws Exception {
        System.out.println("基于xml的AspectJ的AOP编程 = = = >addCar");
    }

    @Override
    public void updateCar() throws Exception {
        System.out.println("基于xml的AspectJ的AOP编程 = = = >updateCar");
    }

    @Override
    public void deleteCar() throws Exception {
        System.out.println("基于xml的AspectJ的AOP编程 = = = >deleteCar");
    }
}
