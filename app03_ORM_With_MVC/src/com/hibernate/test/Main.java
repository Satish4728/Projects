package com.hibernate.test;

import com.hibernate.controller.EmployeeController;
import com.hibernate.factory.EmployeeControllerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        EmployeeController employeeController= EmployeeControllerFactory.getEmployeeController();
        System.out.println("Employee Management System");
        System.out.println("============================");
        while(true)
        {
            System.out.println("1.ADD EMPLOYEE");
            System.out.println("2.SEARCH EMPLOYEE");
            System.out.println("3.UPDATE EMPLOYEE");
            System.out.println("4.DELETE EMPLOYEE");
            System.out.println("5.EXIT");
            int UserOption=Integer.parseInt(br.readLine());
            switch(UserOption)
            {
                case 1:
                    System.out.println("Employee ADD MODULE");
                    System.out.println("=====================");
                    employeeController.add();
                    break;
                case 2:
                    System.out.println("Employee SEARCH MODULE");
                    System.out.println("=====================");
                    employeeController.search();
                    break;
                case 3:
                    System.out.println("Employee UPDATE MODULE");
                    System.out.println("=====================");
                    employeeController.update();
                    break;
                case 4:
                    System.out.println("Employee DELETE MODULE");
                    System.out.println("=====================");
                    employeeController.delete();
                    break;
                case 5:
                    System.out.println("THN Q FOR USING THIS APPLICATION");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter number between the 1 2 3 4 5");
                    break;
            }
        }

    }
}