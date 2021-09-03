package com.team.model;

/**
 * @Description: JavaBean for NoteBook
 * @ClassName: NoteBook
 * @Author: Quanwei Tang
 * @Date: 2021/9/2 9:54
 * @Version: 1.0
 */
public class NoteBook implements Equipment{
    private String model;
    private String price;

    public NoteBook(){}
    public NoteBook(String model,String price) {
        this.model = model;
        this.price=price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model+"("+price+")";
    }
}
