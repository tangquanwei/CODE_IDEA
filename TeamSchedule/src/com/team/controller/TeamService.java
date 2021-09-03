package com.team.controller;

import com.team.model.Architect;
import com.team.model.Designer;
import com.team.model.Employee;
import com.team.model.Programmer;

import java.util.ArrayList;

/**
 * @Description: 团队成员的增删改查
 * @ClassName: TeamService
 * @Author: Quanwei Tang
 * @Date: 2021/9/2 18:38
 * @Version: 1.0
 */
public class TeamService {
    private static final int MAX_MEMBER = 5;
    private static int counter = 1;
    private final ArrayList<Employee> team = new ArrayList<>();
    private int numberOfProgrammer = 0;
    private int numberOfDesigner = 0;
    private int numberOfArchitect = 0;

    public TeamService() {
    }

    public ArrayList<Employee> getTeam() {
        return team;
    }

    /**
     * add the very employee to the team
     *
     */
    public void addEmpolyee(Employee e) throws TeamException {
        if (team.size() == MAX_MEMBER) {
            throw new TeamException("成员已满,无法添加");
        } else if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员,无法添加");
        } else if (team.contains(e)) {
            throw new TeamException("该成员已经存在,无法添加");
        } else if (((Programmer) e).getStatus().equals(Status.BUSY)) {
            throw new TeamException("该成员已在别的团队,无法添加");
        } else if (((Programmer) e).getStatus().equals(Status.VOCATION)) {
            throw new TeamException("该成员正在休假,无法添加");
        } else if (numberOfArchitect == 1 && e instanceof Architect) {
            throw new TeamException("每个团队最多1位架构师,无法添加");
        } else if (numberOfDesigner == 2 && e instanceof Designer) {
            throw new TeamException("每个团队最多2位设计师,无法添加");
        } else if (numberOfProgrammer == 3) {
            throw new TeamException("每个团队最多3位程序员,无法添加");
        }
        if (e instanceof Architect)
            ++numberOfDesigner;
        else if (e instanceof Designer)
            ++numberOfArchitect;
        else
            ++numberOfProgrammer;
        ((Programmer) e).setMemberId(counter++);
        ((Programmer) e).setStatus(Status.BUSY);
        team.add(e);
    }

    public void removeTeamMember(int TID) throws TeamException {
        if (TID > MAX_MEMBER || TID <= 0)
            throw new TeamException("TID范围错误");
//        for (int i = 0; i < team.size(); ++i) {
//            Programmer p = (Programmer) team.get(i);
//            if (p.getMemberId() == TID) {
//                p.setStatus(Status.FREE);
//                p.setMemberId(0);
//                team.remove((Employee) p);
//                System.out.println("删除成功");
//                return ;
//            }
//        }

        for (Employee e : team) {//foreach 属于迭代器的一种，在foreach循环中不要通过集合修改元素
            if (((Programmer) e).getMemberId() == TID) {
                ((Programmer) e).setStatus(Status.FREE);
                ((Programmer) e).setMemberId(0);
                team.remove(e);
                System.out.println("删除成功");
                return;//没有return 会出错
            }
        }
        throw new TeamException("该成员不存在");
    }
}
