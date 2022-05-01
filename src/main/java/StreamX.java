import java.util.Scanner;

public class StreamX {
    static Validation validate = new Validation();
    Scanner input = new Scanner(System.in);

    public StreamX(){
        System.out.println("Please input the file directory of your XMDL file for test generation: ");
        String filePath = input.next();
        System.out.println(validate.XMDLValidator(filePath));
    }

    public StreamX(String filePath){
        System.out.println(validate.XMDLValidator(filePath));
    }
}
