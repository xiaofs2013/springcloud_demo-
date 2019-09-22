package com.kgc.springcould.springcould_consumer.pojo;

public class Student {

    private Integer num;

    private String name;

    private Integer age;

    public Student(){}

    public Student(Integer num, String name, Integer age) {
        this.num = num;
        this.name = name;
        this.age = age;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
