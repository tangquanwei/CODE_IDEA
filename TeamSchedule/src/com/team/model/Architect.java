package com.team.model;

import com.team.controller.Status;

/**
 * @Description:
 * @ClassName: Architect
 * @Author: Quanwei Tang
 * @Date: 2021/9/2 10:22
 * @Version: 1.0
 */
public class Architect extends Designer {
    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary,
                     Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() +
               "\t架构师\t" +
               getMemberId() + "\t" +
               getStatus() + "\t" +
               getBonus() + "\t" +
               getStock() + "\t" +
               getEquipment().getDescription();
    }
}
