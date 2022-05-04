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
        System.out.println((sxm.getDataTypes()).toString());
        System.out.println(Arrays.toString(sxm.getStates()));
        System.out.println(Arrays.toString(sxm.getInputs()));
        System.out.println(Arrays.toString(sxm.getOutput()));
        System.out.println(Arrays.toString(sxm.getMemory()));
        System.out.println(sxm.getInitState());
        System.out.println(Arrays.toString(sxm.getInitMemory()));
        System.out.println((sxm.getFunctions()).toString());
        System.out.println(sxm.getExtFunctions());
        System.out.println((sxm.getTransitions()).toString());
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
