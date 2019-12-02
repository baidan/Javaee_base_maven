package com.baidan.domain;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private  String username;
    private Date birthday;
    private Date entry_date;
    private  String job;
    private String salary;
    private String resume;
    private  String imgs;
    private  String gender;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getEntry_date(int i) {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "username='" + username + '\'' +
                ", birthday=" + birthday +
                ", entry_date=" + entry_date +
                ", job='" + job + '\'' +
                ", salary='" + salary + '\'' +
                ", resume='" + resume + '\'' +
                ", imgs='" + imgs + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
