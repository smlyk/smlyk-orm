package com.smlyk.orm.framework;

/**
 * @author yekai
 */
public class Order {

    /**
     * 是否是升序
     */
    private boolean ascending;

    private String propertyName;

    @Override
    public String toString() {
        return propertyName + " " + (ascending ? "asc" : "desc");
    }

    public Order(boolean ascending, String propertyName) {
        this.ascending = ascending;
        this.propertyName = propertyName;
    }

    /**
     * 升序
     * @param propertyName
     * @return
     */
    public static Order asc(String propertyName){
        return new Order(true, propertyName);
    }

    /**
     * 降序
     * @param propertyName
     * @return
     */
    public static Order desc(String propertyName){
        return new Order(false, propertyName);
    }

}
