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
            System.out.println("Unknown argument, closing SofTest in Command Line mode");
            System.exit(1);
        }
    }

    public static void SofTestCMD(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Would you like to Run a Java project, Parse a Java project, Analyse a Java project, or exit: ");
            String sofMode = input.next().toLowerCase();
            switch(sofMode) {
                case "run":
                    new JavaExec();
                    break;
                case "parse":
                    new JavaParser();
                    break;
                case "analyse":
                    new StreamX();
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
