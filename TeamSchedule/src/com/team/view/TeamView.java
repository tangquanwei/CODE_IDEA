package com.team.view;

import com.team.controller.NameListService;
import com.team.controller.TeamException;
import com.team.controller.TeamService;
import com.team.model.Architect;
import com.team.model.Designer;
import com.team.model.Employee;
import com.team.model.Programmer;

import java.util.ArrayList;

/**
 * @Description: 与用户交互
 * @ClassName: TeamView
 * @Author: Quanwei Tang
 * @Date: 2021/9/3 9:04
 * @Version: 1.0
 */
public class TeamView {
    private final NameListService listService = new NameListService();
    private final TeamService teamService = new TeamService();

    public void enterMainMenu() {
        lab_loop:
        while (true) {
            listEmployees();
            System.out.println("\n1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 (请输入1-4)");
            char menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    listTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    TSUtility.readReturn();
                    break lab_loop;

            }
        }
    }

    private void listEmployees() {
        ArrayList<Employee> employees = listService.getEmployees();
        String columns = "ID\t姓名\t\t年龄\t薪水\t\t职位\t\tTID\t状态\t\t奖金\t\t股份\t\t设备";
        System.out.println(columns);
        for (Employee e : employees) {
            System.out.println(e.toString());
        }
    }

    private void listTeam() {
        ArrayList<Employee> team = teamService.getTeam();
        if (team.isEmpty()) {
            System.out.println("团队还没有成员");
            return;
        }
        System.out.println("ID/TID\t姓名\t\t年龄\t职位\t\t薪水");
        for (Employee e : team) {
            Programmer p = (Programmer) e;
            String position;
            if (e instanceof Architect)
                position = "架构师";
            else if (e instanceof Designer)
                position = "设计师";
            else
                position = "程序员";
            System.out.println(p.getId() + "/" +
                               p.getMemberId() + "\t\t" +
                               p.getName() + "\t" +
                               p.getAge() + "\t" +
                               position + "\t" +
                               p.getSalary());
        }
        TSUtility.readReturn();
    }

    private void addMember() {
        System.out.println("添加成员:\n请输入要添加的成员ID:");
        int id = TSUtility.readInt();
        try {
            Employee e = listService.getEmployee(id);
            teamService.addEmpolyee(e);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        TSUtility.readReturn();
    }

    private void deleteMember() {
        System.out.println("删除成员:\n请输入需要删除的成员TID:");
        int TID = TSUtility.readInt();
        System.out.println("确认是否删除?(Y/N)");
        char selection = TSUtility.readConfirmSelection();
        if (selection == 'N')
            return;
        try {
            teamService.removeTeamMember(TID);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }

}
