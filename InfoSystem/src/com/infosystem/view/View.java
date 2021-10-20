package com.infosystem.view;

import com.infosystem.controller.StudentList;

import static com.infosystem.view.Utility.*;

/**
 * @Description:
 * @ClassName: View
 * @Author: QUANWEI
 * @Date: 2021/9/16 11:37
 * @Version: 1.0
 */
public class View {
    StudentList studentList = new StudentList();
    public void showMenu(){
        loop:while (true){
            printMenu();
            int choice= readIntLength(1,1);
            switch (choice){
                case 0 -> {
                    break loop;
                }
                case 1->{}
            }
        }
    }
    private  void printMenu(){
        System.out.println("""
                欢迎使用信息管理系统
                
                0)退出
                1)查看所有信息
                2)添加
                3)删除
                4)修改
                5)查找
                
                """);
    }

}
