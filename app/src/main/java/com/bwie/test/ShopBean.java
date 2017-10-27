package com.bwie.test;

/**
 * 作者： 方冬冬
 * 时间： 2017/10/26 15:31
 * 功能：
 */

public class ShopBean {

    private boolean flag;
    private String name;
    private int price;
    private int num;

    public ShopBean(boolean flag, String name, int price, int num) {
        this.flag = flag;
        this.name = name;
        this.price = price;
        this.num = num;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
