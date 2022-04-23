import java.util.Scanner;

public class JavaExec {
    static Validation validate = new Validation();
    Scanner input = new Scanner(System.in);

    public JavaExec(){
        System.out.println("Please input the file directory of your Java program for execution: ");
        String filePath = input.next();
        System.out.println(validate.FileValidator(filePath));
    }

    public JavaExec(String filePath){
        System.out.println(validate.FileValidator(filePath));
    }
}
