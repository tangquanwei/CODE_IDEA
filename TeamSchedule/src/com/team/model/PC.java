package com.team.model;

/**
 * @Description:
 * @ClassName: PC
 * @Author: Quanwei Tang
 * @Date: 2021/9/2 9:49
 * @Version: 1.0
 */
public class PC implements Equipment {
    private String model;// type
    private String display;


    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }

    public PC() {
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
