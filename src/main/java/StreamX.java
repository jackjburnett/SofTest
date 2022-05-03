import java.util.Arrays;
import java.util.Scanner;

public class StreamX {
    static Validation validate = new Validation();
    Scanner input = new Scanner(System.in);


    public StreamX(){
        System.out.println("Please input the file directory of your XMDL file for test generation: ");
        String filePath = input.next();
        if(validate.XMDLValidator(filePath)){
            XMDLParser parser = new XMDLParser(filePath);
            new StreamX(parser.ParseFile(filePath, false));
        }else{
            System.out.println("Returning to main menu.");
        }
    }

    public StreamX(XMachine sxm){
        System.out.println(Arrays.toString(sxm.getDataTypes()));
        System.out.println(Arrays.toString(sxm.getStates()));
        System.out.println(Arrays.toString(sxm.getInputs()));
        System.out.println(Arrays.toString(sxm.getOutput()));
        System.out.println(Arrays.toString(sxm.getMemory()));
        System.out.println(sxm.getInitState());
        System.out.println(Arrays.toString(sxm.getInitMemory()));
        System.out.println(Arrays.toString(sxm.getFunctions()));
        System.out.println(Arrays.toString(sxm.getExtFunctions()));
        System.out.println(Arrays.toString(sxm.getTransitions()));
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

    public String[] FaultyTransitions(XMachine sxm){
        return null;
    }
}
