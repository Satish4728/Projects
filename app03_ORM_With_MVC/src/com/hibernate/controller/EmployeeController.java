package com.hibernate.controller;

import com.hibernate.beans.Employee;
import com.hibernate.factory.EmployeeServiceFactory;
import com.hibernate.service.EmployeeService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EmployeeController {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    EmployeeService employeeService= EmployeeServiceFactory.getEmployeeService();


    public void add()
    {

        try{
            System.out.print("Employee No :");
            int eno=Integer.parseInt(br.readLine());
            System.out.print("Employee Name :");
            String ename=br.readLine();
            System.out.print("Employee Salary :");
            float esal=Float.parseFloat(br.readLine());
            System.out.print("Employee Address :");
            String eaddr=br.readLine();
            Employee employee=new Employee();
            employee.setEno(eno);
            employee.setEname(ename);
            employee.setEsal(esal);
            employee.setEaddr(eaddr);

            String status=employeeService.addEmployee(employee);
            System.out.println("Status :"+status);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public void search()
    {

    }
    public void update(){

    }
    public void delete(){

    }

}
