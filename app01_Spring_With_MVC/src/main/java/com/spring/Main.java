package com.spring;

import com.spring.config.AppConfig;
import com.spring.controller.StudentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws Exception {
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.scan("com.spring.*");
        StudentController studentController = (StudentController) context.getBean("studentController");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome To Student Management System");
        System.out.println("=======================================");

        while(true)
        {
            System.out.println("1.ADD STUDENT:");
            System.out.println("2.SEARCH STUDENT:");
            System.out.println("3.SHOW ALL STUDENTS:");
            System.out.println("4.UPDATE STUDENT:");
            System.out.println("5.DELETE STUDENT:");
            System.out.println("6.EXIT STUDENT:");

            System.out.println("Enter your Option:");
            int option=Integer.parseInt(br.readLine());
            switch(option)
            {
                case 1:
                    studentController.addStudent();
                    break;
                case 2:
                    studentController.searchStudent();
                    break;
                case 3:
                    studentController.getAllStudent();
                    break;
                case 4:
                    studentController.updateStudent();
                    break;
                case 5:
                    studentController.deleteStudent();
                    break;
                case 6:
                    System.out.println("THANQ FOR USING THIS APPLICATION");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice Please Provide The Valid Option between 1 to 6 ");
                    break;
            }
        }
    }
}