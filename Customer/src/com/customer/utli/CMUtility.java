package com.customer.utli;

import com.customer.bean.Customer;

import java.util.Scanner;

/**
 * @Description: 工具类
 * @ClassName: CMUtility
 * @Author: QUANWEI
 * @Date: 2021/8/29 12:40
 * @Version: 1.0
 */

public class CMUtility {
    private static final Scanner scanner = new Scanner(System.in);

    public static int binarySearch(Customer[] arr, int start, int end, String key) {
        if (start > end){
            return -1;
        }
        int mid = (end + start) >>> 1;
        if(key.equals(arr[mid].getId())) {
            return mid;
        }else if(key.compareTo(arr[mid].getId())<0) {
            return binarySearch(arr, mid + 1, end, key);
        }else if(key.compareTo(arr[mid].getId())>0){
            return binarySearch(arr, start, mid - 1, key);
        }else {
            return -1;
        }
    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static boolean readChoice() {
        char c = readChar();
        return (c == 'Y' || c == 'y');
    }

    /**
     * 用于界面菜单的选择。该方法读取键盘，如果用户键入’1’-’5’中的任意字符，则方法返回。返回值为用户键入字符。
     */
    public static int readMenuSelection() {
        int c;
        lab:
        while (true) {
            c = scanner.nextInt();
            switch (c) {
                case 0, 1, 2, 3, 4, 5, 6 -> {
                    break lab;
                }
                default -> {
                    System.out.print("请输入(0-6):");
                }
            }
        }
        return c;
    }

    /**
     * 从键盘读取一个字符，并将其作为方法的返回值。
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /**
     * 从键盘读取一个字符，并将其作为方法的返回值。
     * 如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }

    /**
     * 从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。
     * 如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
     */
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, true);
            if (str.equals("")) {
                return defaultValue;
            }
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 从键盘读取一个长度不超过limit的字符串，并将其作为方法的返回值。
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * 从键盘读取一个长度不超过limit的字符串，并将其作为方法的返回值。
     * 如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("") ? defaultValue : str;
    }

    /**
     * 用于确认选择的输入。该方法从键盘读取‘Y’或’N’，并将其作为方法的返回值。
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }
            if (line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }
}
