package com.team.model;

/**
 * @Description: JavaBean for Printer
 * @ClassName: Printer
 * @Author: Quanwei Tang
 * @Date: 2021/9/2 9:59
 * @Version: 1.0
 */
public class Printer implements Equipment {
    private String name;
    private String type;

    public Printer() {
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return getName() + "(" + getType() + ")";
    }
}
