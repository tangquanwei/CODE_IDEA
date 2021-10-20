package com.infosystem.view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Description:
 * @ClassName: Utility
 * @Author: QUANWEI
 * @Date: 2021/9/16 15:17
 * @Version: 1.0
 */
public class Utility {
    private static final Scanner in;

    static {
        in = new Scanner(System.in);
    }

    public static int readIntLength(int minLength, int maxLength) {
        String s;
        do {
            System.out.println("请输入数字" + (minLength == maxLength ? maxLength : minLength + "~" + maxLength) + "位数字");
            s = in.next();
        } while (s.length() < minLength || s.length() > maxLength);
        return Integer.parseInt(s);
    }

    public static int readIntRange(int min, int max) {
        int ret = -1;
        do {
            System.out.println("请输入范围为" + min + "~" + max + "的整数");
            try {
                ret = in.nextInt();
            } catch (InputMismatchException ignored) {
            }
        } while (ret < min || ret > max);
        return ret;
    }


}
