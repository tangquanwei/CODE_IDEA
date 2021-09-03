package com.team.controller;

/**
 * @Description: 自定义异常
 * @ClassName: TeamException
 * @Author: Quanwei Tang
 * @Date: 2021/9/2 11:35
 * @Version: 1.0
 */
public class TeamException extends Exception{
    public  TeamException(){
        super();
    }
    public TeamException(String message){
        super(message);
    }
}
