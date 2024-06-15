import com.jdbc.beans.Employee;
import com.jdbc.controller.EmployeeController;
import com.jdbc.factory.ConnectionFactory;
import com.jdbc.factory.EmployeeControllerFactory;
import com.jdbc.factory.EmployeeDaoFactory;
import com.jdbc.factory.EmployeeServiceFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        /*
        static{
            ConnectionFactory.getConnection();
            EmployeeDaoFactory.getEmployeeDao();
            EmployeeControllerFactory.getEmployeeController();
            EmployeeServiceFactory.getEmployeeService();
        }
        */

        System.out.println("Welcome To Employee Management System");
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            EmployeeController employeeController= EmployeeControllerFactory.getEmployeeController();
            while(true)
            {
                System.out.println();
                System.out.println("1. ADD Employee");
                System.out.println("2. SEARCH Employee");
                System.out.println("3. GET All Employee");
                System.out.println("4. UPDATE Employee");
                System.out.println("5. DELETE Employee");
                System.out.println("6. EXIT");
                System.out.print("Your Option :");
                int userOption=Integer.parseInt(br.readLine());
                switch(userOption)
                {
                    case 1:
                        System.out.println("ADD Employee Module");
                        System.out.println("======================");
                        employeeController.addEmployee();
                        break;
                    case 2:
                        System.out.println("SEARCH Employee Module");
                        System.out.println("=========================");
                        employeeController.searchEmployee();
                        break;
                    case 3:
                        System.out.println("GET All Employee Module");
                        System.out.println("=========================");
                        employeeController.getAllEmployee();
                        break;
                    case 4:
                        System.out.println("UPDATE Employee Module");
                        System.out.println("======================");
                        employeeController.updateEmployee();
                        break;
                    case 5:
                        System.out.println("DELETE Employee Module");
                        System.out.println("==========================");
                        employeeController.deleteEmployee();
                        break;
                    case 6:
                        System.out.println("Thank You For Using Employee Management");
                        ConnectionFactory.cleanup();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Wrong Option ,plaese select the option between 1,2,3,4,5");
                        break;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}