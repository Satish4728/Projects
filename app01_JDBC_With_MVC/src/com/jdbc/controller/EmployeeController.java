package com.jdbc.controller;

import com.jdbc.beans.Employee;
import com.jdbc.factory.EmployeeServiceFactory;
import com.jdbc.service.EmployeeService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

public class EmployeeController {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    EmployeeService employeeService= EmployeeServiceFactory.getEmployeeService();
    public void addEmployee() {
       try{
           System.out.print("Employee Number:");
           int eno=Integer.parseInt(br.readLine());
           Employee emp=employeeService.searchEmployee(eno);
           if(emp==null) {
               System.out.print("Employee Name :");
               String ename = br.readLine();
               System.out.print("Employee Salary:");
               float esal = Float.parseFloat(br.readLine());
               System.out.print("Employee Address :");
               String eaddr = br.readLine();
               Employee employee = new Employee();
               employee.setEno(eno);
               employee.setEname(ename);
               employee.setEsal(esal);
               employee.setEaddr(eaddr);
               String status = employeeService.addEmployee(employee);
               System.out.println("Status :" + status);
           }
           else {
               System.out.println("Status :EXISTED");
           }

       }
       catch(Exception e)
       {
           e.printStackTrace();
       }

    }

    public void searchEmployee() {


        try{
            System.out.print("Employee Number :");
            int eno=Integer.parseInt(br.readLine());
            Employee employee=employeeService.searchEmployee(eno);
            if(employee==null)
            {
                System.out.println("Status :Employee Doesnot Exist");
            }
            else {
                System.out.println("Employee Details");
                System.out.println("====================");
                System.out.println("Employee Number :"+employee.getEno());
                System.out.println("Employee Name :"+employee.getEname());
                System.out.println("Employee Salary :"+employee.getEsal());
                System.out.println("Employee Address :"+employee.getEaddr());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public void getAllEmployee()
    {
        List<Employee> employeeList= employeeService.getAllEmployee();
        Iterator<Employee> iterator=employeeList.iterator();
        System.out.println("ENO\tENAME\tESAL\tEADDR");
        System.out.println("--------------------------");
        while(iterator.hasNext())
        {
            Employee employee=iterator.next();
            System.out.print(employee.getEno()+"\t");
            System.out.print(employee.getEname()+"\t");
            System.out.print(employee.getEsal()+"\t");
            System.out.print(employee.getEaddr()+"\n");

        }

    }

    public void updateEmployee(){
        try {
            System.out.print("Employee No :");
            int eno=Integer.parseInt(br.readLine());
            Employee employee= employeeService.searchEmployee(eno);
            if(employee==null)
            {
                System.out.println("Status : Employee Not Existed");
            }
            else
            {
                System.out.print("Employee Name :OLD :"+employee.getEname()+" NEW :");
                String ename_New=br.readLine();
                if(ename_New==null||ename_New.equals(""))
                {
                    ename_New=employee.getEname();
                }

                System.out.print("Employee Salary :OLD :"+employee.getEsal()+"NEW :");
                String sal=br.readLine();
                float esal_New=0.0f;
                if(sal==null||sal.equals(""))
                {
                    esal_New= employee.getEsal();
                }
                else {
                    esal_New=Float.parseFloat(sal);
                }

                //float esal_New=Float.parseFloat(br.readLine());


                System.out.print("Employee Address :OLD :"+employee.getEaddr()+" NEW :");
                String eaddr_New=br.readLine();
                if(eaddr_New==null||eaddr_New.equals(""))
                {
                    eaddr_New=employee.getEaddr();
                }

                Employee employeeUpdateDetails=new Employee();
                employeeUpdateDetails.setEno(eno);
                employeeUpdateDetails.setEname(ename_New);
                employeeUpdateDetails.setEsal(esal_New);
                employeeUpdateDetails.setEaddr(eaddr_New);

                String status=employeeService.updateEmployee(employeeUpdateDetails);
                System.out.println("Status :"+status);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void deleteEmployee()
    {
        try{
            System.out.println("Employee Number :");
            int eno=Integer.parseInt(br.readLine());
            Employee employee=employeeService.searchEmployee(eno);
            if(employee==null)
            {
                System.out.println(" Status :Employee Does Not Existed");
            }
            else {
                String status= employeeService.deleteEmployee(eno);
                System.out.println("Status :"+status);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
