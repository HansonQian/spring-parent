package website.hanson.spring.d_aspect.b_ann;

/**
 * Title: ItemServiceImpl
 * Description:item接口实现类
 * Author:HanSon
 * Date:2017/7/1 13:08
 * Version:V1.0
 */
public class ItemServiceImpl implements ItemService {
    @Override
    public void addItem() throws Exception {
        System.out.println("基于注解的AspectJ的AOP编程 = = = >addCar");
    }

    @Override
    public void updateItem() throws Exception {
        System.out.println("基于注解的AspectJ的AOP编程 = = = >updateItem");
    }

    @Override
    public void deleteItem() throws Exception {
        System.out.println("基于注解的AspectJ的AOP编程 = = = >deleteItem");
    }
}
