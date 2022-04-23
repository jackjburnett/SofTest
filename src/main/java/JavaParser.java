import java.security.PublicKey;
import java.util.Scanner;

public class JavaParser {
    static Validation validate = new Validation();
    Scanner input = new Scanner(System.in);

    public JavaParser(){
        System.out.println("Please input the file directory of your Java program for parsing: ");
        String filePath = input.next();
        System.out.println(validate.FileValidator(filePath));
    }

    public JavaParser(String filePath){
        System.out.println(validate.FileValidator(filePath));
    }
}
