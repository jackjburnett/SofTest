import java.beans.XMLDecoder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class XMDLParser {
    static Validation validate = new Validation();
    Scanner input = new Scanner(System.in);

    public XMDLParser(){
        System.out.println("Please input the file directory of your XMDL file for test generation: ");
        String filePath = input.next();
        if(validate.XMDLValidator(filePath)){
            ParseFile(filePath, true);
        }else{
            System.out.println("Returning to main menu.");
        }
    }

    public XMachine ParseFile(String filePath, Boolean ParseMode){
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

                            if(ParseMode) {
                                System.out.println("DataType '" + XMDLLine[1] + "' parsed on line " + lineNo + ".");
                            }
                        }else {
                            String[] tempArray=Arrays.copyOfRange(XMDLLine,3, XMDLLine.length);
                            //Code to create X-Machine here

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

                            if (ParseMode) {
                                System.out.println("Initial Memory values "+ Arrays.toString(tempArray)+" parsed on line " + lineNo + ".");
                            }
                        }
                        break;
                    case "#fun":
                        System.out.println("fun");
                        break;
                    case "#x_fun":
                        if((XMDLLine.length == 1) || (XMDLLine.length == 3)){
                            if(ParseMode) {
                                System.out.println("Incomplete External Function entry on line " + lineNo + ".");
                            }
                        }else if(XMDLLine.length == 2){
                            //Code to create X-Machine here

                            if(ParseMode) {
                                System.out.println("External Function '" + XMDLLine[1] + "' parsed on line " + lineNo + ".");
                            }
                        }else {
                            String[] tempArray=Arrays.copyOfRange(XMDLLine,3, XMDLLine.length);
                            //Code to create X-Machine here

                            if (ParseMode) {
                                System.out.println("External Function '" + XMDLLine[1] + "', with value '"+ String.join("", tempArray)+"', parsed on line " + lineNo + ".");
                            }
                        }
                        break;
                    case "#transition":
                        System.out.println("transition");
                        break;
                    case "":
                    case "\n":
                        break;
                    default:
                        System.out.println("Unknown or Invalid X-Machine terminology");
                }
                lineNo=lineNo+1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new XMachine();
    }
}
