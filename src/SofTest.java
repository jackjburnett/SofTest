import javax.print.DocFlavor;
import java.util.Locale;
import java.util.Scanner;

public class SofTest {
    static Validation validate = new Validation();
    public static void main(String[] args) {
        if(args.length==0) {
            System.out.println("Opening SofTest in Command Line mode");
            SofTestCMD();
        }else if(args[0].toLowerCase().equals("gui")){
            System.out.println("Opening SofTest in GUI mode");
            SofTestGUI();
        }else{
            System.out.println("Unknown argument, Opening SofTest in Command Line mode");
            SofTestCMD();
        }
    }

    public static void SofTestCMD(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the file directory of your Java program for testing: ");
        String filePath = input.next();
        System.out.println(validate.FileValidator(filePath));

    }

    public static void SofTestGUI(){
        System.exit(2);
    }
}
