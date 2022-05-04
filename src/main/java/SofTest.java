import java.util.Scanner;

public class SofTest {
    public static void main(String[] args) {
        if(args.length==0) {
            System.out.println("Opening SofTest in Command Line mode");
            SofTestCMD();
        }else if(args[0].equalsIgnoreCase("gui")){
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
            switch (sofMode) {
                case "parse" -> new XMDLParser();
                case "generate", "test" -> new StreamX();
                case "view" -> new TestViewer();
                case "exit" -> System.exit(0);
                default -> System.out.println("Unknown command, please enter a specified functionality.");
            }
        }
    }

    public static void SofTestGUI(){

        System.exit(2);
    }
}
