package com.hibernate.dao;

import com.hibernate.beans.Employee;

public interface EmployeeDao {
    public String add(Employee employee);
    public Employee search(int eno);
    public String update(Employee employee);
    public String delete(int eno);
}
