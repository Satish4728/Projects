package com.spring.controller;

import com.spring.beans.Student;
import com.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;

    }
    public void addStudent() {
        try{
            System.out.println("Enter Student Id:");
            String studentId=br.readLine();
            Student student=studentService.searchStudent(studentId);
            if(student==null)
            {
                System.out.println("Enter Student Name:");
                String studentName=br.readLine();
                System.out.println("Enter Student Age:");
                String studentAddress=br.readLine();
                 student=new Student();
                student.setStudentId(studentId);
                student.setStudentName(studentName);
                student.setStudentAddress(studentAddress);
                String status=studentService.addStudent(student);
                System.out.println("Status :"+status);
            }
            else {
                System.out.println("Status :Student Existed Already");
            }


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }


    public void searchStudent() {
        try{
            System.out.println("Enter Student Id:");
            String studentId=br.readLine();
            Student student=studentService.searchStudent(studentId);
            if(student!=null)
            {
                System.out.println("Student Id :"+student.getStudentId());
                System.out.println("Student Name :"+student.getStudentName());
                System.out.println("Student Address :"+student.getStudentAddress());
            }
            else {
                System.out.println("status=Student not Found");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public void getAllStudent()
    {
        List<Student> students=studentService.getAllStudents();
        if(students!=null)
        {
            for(Student student:students)
            {
                System.out.println(student);
            }
        }
        else{
            System.out.println("Status:Student Not Found");
        }

    }

    public void updateStudent() {
        String status="";
        try {
            System.out.println("Enter Student Id:");
            String sid = br.readLine();
            Student student=studentService.searchStudent(sid);
            if(student==null)
            {
                System.out.println("Status:Student Not Found");
            }
            else{
                System.out.println("Student Name:OLD:"+student.getStudentName()+" NEW :");
                String sname_New=br.readLine();
                System.out.println("Student Address OLD :"+student.getStudentAddress()+" NEW :");
                String saddr_New=br.readLine();
                Student studentNew=new Student();
                studentNew.setStudentId(sid);
                if(sname_New==null||sname_New.equals(""))
                {
                    studentNew.setStudentName(student.getStudentName());
                }
                else{
                    studentNew.setStudentName(sname_New);
                }

                if(saddr_New==null||saddr_New.equals(""))
                {
                    studentNew.setStudentAddress(student.getStudentAddress());
                }
                else{
                    studentNew.setStudentAddress(saddr_New);
                }
                status=studentService.updateStudent(studentNew);
                System.out.println("Status :"+status);

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }


    public void deleteStudent() {
        try{
            System.out.println("Student Id :");
            String studentId=br.readLine();
            Student student=studentService.searchStudent(studentId);
            if(student==null)
            {
                System.out.println("Status :Student Not Found");
            }
            else{
                String status=studentService.deleteStudent(studentId);
                System.out.println("Status :"+status);

            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
