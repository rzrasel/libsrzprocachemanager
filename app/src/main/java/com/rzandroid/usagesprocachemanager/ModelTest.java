package com.rzandroid.usagesprocachemanager;

import java.io.Serializable;

public class ModelTest implements Serializable {
    private int id;
    private String name;

    public ModelTest() {
    }

    public ModelTest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ModelTest setter(int id, String name) {
        return new ModelTest(id, name);
    }

    @Override
    public String toString() {
        return "ModelTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
