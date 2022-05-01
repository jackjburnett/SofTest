import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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

    public StreamX ParseFile(String filePath, Boolean ParseMode){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            for(String line; (line = br.readLine()) != null; ) {
                String[] XDMLLine = line.split(" ");
                switch (XDMLLine[0]){
                    case "#datatype":
                        System.out.println("datatype");
                        break;
                    case "state":
                        System.out.println("state");
                        break;

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
