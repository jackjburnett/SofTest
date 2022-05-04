import java.util.Scanner;

public class StreamX {
    static Validation validate = new Validation();
    Scanner input = new Scanner(System.in);


    public StreamX(){
        System.out.println("Please input the file directory of your XMDL file for test generation: ");
        String filePath = input.next();
        if(validate.XMDLValidator(filePath)){
            new StreamX(XMDLParser.ParseFile(filePath, false));
        }
        System.out.println("Returning to main menu.");
    }

    public StreamX(XMachine sxm){
        //sxm.OutputXMachine();
        TestViewer.OutputTests(MissingStates(sxm), ExtraStates(sxm), MissingStates(sxm), ExtraTransitions(sxm),MisdirectTransitions(sxm), FaultyFunctions(sxm));
    }

    public String[] MissingStates(XMachine sxm){
        return null;
    }

    public String[] ExtraStates(XMachine sxm){
        return null;
    }

    public String[] MissingTransitions(XMachine sxm){
        return null;
    }

    public String[] ExtraTransitions(XMachine sxm){
        return null;
    }

    public String[] MisdirectTransitions(XMachine sxm){
        return null;
    }

    public String[] FaultyFunctions(XMachine sxm){
        return null;
    }
}
