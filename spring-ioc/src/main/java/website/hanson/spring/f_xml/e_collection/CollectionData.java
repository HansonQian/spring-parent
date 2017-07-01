package website.hanson.spring.f_xml.e_collection;

import java.util.*;

/**
 * Title: CollectionData
 * Description:TODO(描述一下该类的作用)
 * Author:HanSon
 * Date:2017/6/26 23:58
 * Version:V1.0
 */
public class CollectionData {
    private String[] arrayData;

    private List<String> listData;

    private Set<String> setData;

    private Map<String, String> mapData;

    private Properties propsData;


    public String[] getArrayData() {
        return arrayData;
    }

    public void setArrayData(String[] arrayData) {
        this.arrayData = arrayData;
    }

    public List<String> getListData() {
        return listData;
    }

    public void setListData(List<String> listData) {
        this.listData = listData;
    }

    public Set<String> getSetData() {
        return setData;
    }

    public void setSetData(Set<String> setData) {
        this.setData = setData;
    }

    public Map<String, String> getMapData() {
        return mapData;
    }

    public void setMapData(Map<String, String> mapData) {
        this.mapData = mapData;
    }

    public Properties getPropsData() {
        return propsData;
    }

    public void setPropsData(Properties propsData) {
        this.propsData = propsData;
    }

    @Override
    public String toString() {
        return "CollectionData{ " +
                " arrayData=" + Arrays.toString(arrayData) +
                ",listData=" + listData +
                ", setData=" + setData +
                ", mapData=" + mapData +
                ",propsData=" + propsData +
                '}';
    }
}
