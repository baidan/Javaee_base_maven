package com.baidan.dao;

import com.baidan.domain.Employee;

import java.util.List;

public interface IEmployee {

    List<Employee> findAll();

    Employee getEmployee(Integer id);

    void addEmployee(Employee getEmployee);
}
