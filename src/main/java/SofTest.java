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
            System.out.println("Unknown argument, closing SofTest");
            System.exit(1);
        }
    }

    public static void SofTestCMD(){
        Scanner input = new Scanner(System.in);
        while(true){
            // http://jsxm.org/
            System.out.println("Would you like to Parse an XMDL file, Generate test cases for an XMDL file, View previous test cases, or Exit: ");
            String sofMode = input.next().toLowerCase();
            switch(sofMode) {
                case "parse":
                    new XMDLParser();
                    break;
                case "generate":
                case "test":
                    new StreamX();
                    break;
                case "view":
                    new TestViewer();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Unknown command, please enter a specified functionality.");
            }
        }
    }

    public static void SofTestGUI(){

        System.exit(2);
    }
}
