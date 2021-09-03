package com.team.model;

import com.team.controller.Status;

/**
 * @Description:
 * @ClassName: Designer
 * @Author: Quanwei Tang
 * @Date: 2021/9/2 10:20
 * @Version: 1.0
 */
public class Designer extends Programmer {
    private double bonus;

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary,
                    Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails()+
               "\t设计师\t" +
               getMemberId() +"\t" +
               getStatus() +"\t" +
               getBonus()+"\t\t\t"+
               getEquipment().getDescription();
    }
}


