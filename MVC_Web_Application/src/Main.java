import com.core.controller.StudentController;
import com.core.factory.StudentControllerFactory;


public class Main {
    public static void main(String[] args) {
        StudentController studentController= StudentControllerFactory.getStudentController();
        String status=studentController.addStudent();
        System.out.println(status);



    }
}