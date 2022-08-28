package com.guidence.pojo;

import java.util.List;

public class Employee {

    private int id;
    private String name;
    private int age;
    private String city;
    private List<String> phoneNumber;
    private Department department;

    public Employee(int id, String name, int age, String city, List<String> phoneNumber, Department departments) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.department = departments;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartments(Department departments) {
        this.department = departments;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(List<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", department=" + department +
                '}';
    }
}
