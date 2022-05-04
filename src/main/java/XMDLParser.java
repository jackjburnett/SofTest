import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class XMDLParser {
    static Validation validate = new Validation();
    Scanner input = new Scanner(System.in);

    public XMDLParser(){
        System.out.println("Please input the file path of your XMDL file for parsing: ");
        String filePath = input.next();
        if(validate.XMDLValidator(filePath)){
            ParseFile(filePath, true);
        }
        System.out.println("Returning to main menu.");
    }

    public static XMachine ParseFile(String filePath, Boolean ParseMode){
        //X-Machine variables
        ListMultimap<String, String> DataTypes = ArrayListMultimap.create();
        String[] States = new String[0];
        String[] Inputs = new String[0];
        String[] Output = new String[0];
        String[] Memory = new String[0];
        String InitState = null;
        String[] InitMemory = new String[0];
        ListMultimap<String, String> Functions = ArrayListMultimap.create();
        Map<String, String> ExtFunctions = new HashMap<>();
        ListMultimap<String, String> Transitions = ArrayListMultimap.create();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int lineNo = 0;
            for(String line; (line = br.readLine()) != null; ) {
                String[] XMDLLine = line.split(" ");
                switch (XMDLLine[0].toLowerCase()){
                    case "#datatype":
                        XMDLLine=validate.removeSymbolsArray(XMDLLine);
                        if((XMDLLine.length == 1) || (XMDLLine.length == 3)){
                            if(ParseMode) {
                                System.out.println("Incomplete DataType entry on line " + lineNo + ".");
                            }
                        }else if(XMDLLine.length == 2){
                            //Code to create X-Machine here
                            DataTypes.put(XMDLLine[1],"");
                            if(ParseMode) {
                                System.out.println("DataType '" + XMDLLine[1] + "' parsed on line " + lineNo + ".");
                            }
                        }else {
                            String[] tempArray=Arrays.copyOfRange(XMDLLine,3, XMDLLine.length);
                            //Code to create X-Machine here
                            int i;
                            for(i=0;i<tempArray.length;i++){
                                DataTypes.put(XMDLLine[1], tempArray[i]);
                            }
                            if (ParseMode) {
                                System.out.println("DataType '" + XMDLLine[1] + "', with values "+ Arrays.toString(tempArray)+", parsed on line " + lineNo + ".");
                            }
                        }
                        break;
                    case "#state":
                        XMDLLine=validate.removeSymbolsArray(XMDLLine);
                        if(XMDLLine.length == 1){
                            if(ParseMode) {
                                System.out.println("Incomplete States entry on line " + lineNo + ".");
                            }
                        }else{
                            String[] tempArray=Arrays.copyOfRange(XMDLLine,1, XMDLLine.length);
                            //Code to create X-Machine here
                            States=tempArray;
                            if (ParseMode) {
                                System.out.println("States "+ Arrays.toString(tempArray)+" parsed on line " + lineNo + ".");
                            }
                        }
                        break;
                    case "#input":
                        if(XMDLLine.length == 1){
                            if(ParseMode) {
                                System.out.println("Incomplete Inputs entry on line " + lineNo + ".");
                            }
                        }else{
                            String[] tempArray=Arrays.copyOfRange(XMDLLine,1, XMDLLine.length);
                            //Code to create X-Machine here
                            Inputs=tempArray;
                            if (ParseMode) {
                                System.out.println("Inputs "+ Arrays.toString(tempArray)+" parsed on line " + lineNo + ".");
                            }
                        }
                        break;
                    case "#output":
                        XMDLLine=validate.removeSymbolsArray(XMDLLine);
                        if(XMDLLine.length == 1){
                            if(ParseMode) {
                                System.out.println("Incomplete Outputs entry on line " + lineNo + ".");
                            }
                        }else{
                            String[] tempArray=Arrays.copyOfRange(XMDLLine,1, XMDLLine.length);
                            //Code to create X-Machine here
                            Output=tempArray;
                            if (ParseMode) {
                                System.out.println("Outputs "+ Arrays.toString(tempArray)+" parsed on line " + lineNo + ".");
                            }
                        }
                        break;
                    case "#memory":
                        XMDLLine=validate.removeSymbolsArray(XMDLLine);
                        if(XMDLLine.length == 1){
                            if(ParseMode) {
                                System.out.println("Incomplete Memory values entry on line " + lineNo + ".");
                            }
                        }else{
                            String[] tempArray=Arrays.copyOfRange(XMDLLine,1, XMDLLine.length);
                            //Code to create X-Machine here
                            Memory=tempArray;
                            if (ParseMode) {
                                System.out.println("Memory values "+ Arrays.toString(tempArray)+" parsed on line " + lineNo + ".");
                            }
                        }
                        break;
                    case "#init_state":
                        XMDLLine=validate.removeSymbolsArray(XMDLLine);
                        if(XMDLLine.length == 1 || XMDLLine.length >=3){
                            if(ParseMode) {
                                System.out.println("Incomplete, or invalid, Initial State value entry on line " + lineNo + ".");
                            }
                        }else{
                            //Code to create X-Machine here
                            InitState=XMDLLine[1];
                            if (ParseMode) {
                                System.out.println("Initial State value '"+ XMDLLine[1]+"' parsed on line " + lineNo + ".");
                            }
                        }
                        break;
                    case "#init_memory":
                        XMDLLine=validate.removeSymbolsArray(XMDLLine);
                        if(XMDLLine.length == 1){
                            if(ParseMode) {
                                System.out.println("Incomplete Initial Memory values entry on line " + lineNo + ".");
                            }
                        }else{
                            String[] tempArray=Arrays.copyOfRange(XMDLLine,1, XMDLLine.length);
                            //Code to create X-Machine here
                            InitMemory=tempArray;
                            if (ParseMode) {
                                System.out.println("Initial Memory values "+ Arrays.toString(tempArray)+" parsed on line " + lineNo + ".");
                            }
                        }
                        break;
                    case "#fun":
                        if(XMDLLine.length == 1){
                            if(ParseMode) {
                                System.out.println("Incomplete Function entry on line " + lineNo + ".");
                            }
                        }else if(XMDLLine.length == 2){
                            //Code to create X-Machine here
                            Functions.put(XMDLLine[0],"");
                            if(ParseMode) {
                                System.out.println("Function '" + XMDLLine[1] + "' parsed on line " + lineNo + ".");
                            }
                        }else {
                            String[] tempArray=Arrays.copyOfRange(XMDLLine,1, XMDLLine.length);
                            String tempString=String.join(" ",tempArray);
                            XMDLLine=tempString.split(":");
                            tempArray=Arrays.copyOfRange(XMDLLine,1, XMDLLine.length);
                            tempString=String.join("", tempArray);
                            //Code to create X-Machine here
                            Functions.put(XMDLLine[0],tempString);
                            if (ParseMode) {
                                System.out.println("Function '" + XMDLLine[0] + "', with value '"+tempString+"', parsed on line " + lineNo + ".");
                            }
                        }
                        break;
                    case "#x_fun":
                        if((XMDLLine.length == 1) || (XMDLLine.length == 3)){
                            if(ParseMode) {
                                System.out.println("Incomplete External Function entry on line " + lineNo + ".");
                            }
                        }else if(XMDLLine.length == 2){
                            //Code to create X-Machine here
                            ExtFunctions.put(XMDLLine[1],"");
                            if(ParseMode) {
                                System.out.println("External Function '" + XMDLLine[1] + "' parsed on line " + lineNo + ".");
                            }
                        }else {
                            String[] tempArray=Arrays.copyOfRange(XMDLLine,3, XMDLLine.length);
                            String tempString=String.join("", tempArray);
                            //Code to create X-Machine here
                            ExtFunctions.put(XMDLLine[1],tempString);
                            if (ParseMode) {
                                System.out.println("External Function '" + XMDLLine[1] + "', with value '"+tempString+"', parsed on line " + lineNo + ".");
                            }
                        }
                        break;
                    case "#transition":
                        if((XMDLLine.length <= 3)){
                            if(ParseMode) {
                                System.out.println("Incomplete Transition entry on line " + lineNo + ".");
                            }
                        }else {
                            String[] tempArray=Arrays.copyOfRange(XMDLLine,1, XMDLLine.length);
                            String tranString=String.join("", tempArray);
                            XMDLLine = tranString.split("=");
                            //Code to create X-Machine here
                            Transitions.put(XMDLLine[0],XMDLLine[1]);
                            if (ParseMode) {
                                System.out.println("Transition from '" + XMDLLine[0] + "' to '"+ XMDLLine[1]+"', parsed on line " + lineNo + ".");
                            }
                        }
                        break;
                    case "":
                    case "\n":
                        break;
                    default:
                        if (ParseMode) {
                            System.out.println("Unknown, or Invalid, X-Machine terminology on line " + lineNo + ".");
                        }
                }
                lineNo=lineNo+1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new XMachine(DataTypes, States, Inputs, Output, Memory, InitState, InitMemory, Functions, ExtFunctions, Transitions);
    }
}