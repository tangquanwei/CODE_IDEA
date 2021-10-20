package com.infosystem.controller;

import com.infosystem.model.Person;

import java.io.*;
import java.util.ArrayList;

/**
 * @Description:
 * @ClassName: StudentList
 * @Author: QUANWEI
 * @Date: 2021/9/16 11:24
 * @Version: 1.0
 */
public class StudentList {
    private ArrayList<Person> list;
    File file = new File("D:\\workspaceFolder\\CODE_IDEA\\InfoSystem\\src\\info.data");


    public StudentList() {
        if (file.exists()) {
            read();
            System.out.println("exist");
        }
        else {
            System.out.println("not exist");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.list = new ArrayList<>();
        }    }

    public boolean add(Person p) {
        return list.add(p);
    }

    public boolean remove(Person p) {
        return list.remove(p);
    }

    public boolean modify(Person old, Person neo) {
        list.remove(old);
        return list.add(neo);
    }

    public int find(Person p) {
        return list.indexOf(p);
    }

    public void show() {
        list.sort((a, b) -> {
            return a.getId() - b.getId();
        });
        for (var i : list) {
            System.out.println(i);
        }
    }

    public void write() {
        try (FileOutputStream fileOutputStreams = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStreams)) {
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        try (var ois = new ObjectInputStream(new FileInputStream(file))) {
            var obj = ois.readObject();
            if (obj instanceof ArrayList) list = (ArrayList) obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
