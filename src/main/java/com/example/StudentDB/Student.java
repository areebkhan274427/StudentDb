package com.example.StudentDB;

public class Student {
    private String name;
    private double marks;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, double marks, int age) {
        this.name = name;
        this.marks = marks;
        this.age = age;
    }

    public Student() {
    }

}
