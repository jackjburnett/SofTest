import java.util.Scanner;

public class StreamX {
    static Validation validate = new Validation();
    Scanner input = new Scanner(System.in);

    public StreamX(){
        System.out.println("Please input the file directory of your Java program for analysis: ");
        String filePath = input.next();
        System.out.println(validate.FileValidator(filePath));
    }

    public StreamX(String filePath){
        System.out.println(validate.FileValidator(filePath));
    }
}
