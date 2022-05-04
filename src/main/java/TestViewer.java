import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public final class TestViewer {
    static Validation validate = new Validation();
    static Scanner input = new Scanner(System.in);

    public static void OpenTests(){
        System.out.println("Please input the file directory of your SofTest file containing test results: ");
        String filePath = input.next();
        if(validate.SofTestValidator(filePath)){
            ReadTests(filePath);
        }
        System.out.println("Returning to main menu.");
    }

    private static void ReadTests(String filePath){
        String[] MsState = new String[0];
        String[] ExState = new String[0];
        String[] MsTrans = new String[0];
        String[] ExTrans = new String[0];
        String[] MdTrans = new String[0];
        String[] FltFunc = new String[0];
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int lineNo = 0;
            for(String line; (line = br.readLine()) != null; ) {
                String[] TestLine = line.split(" ");
                switch (TestLine[0].toLowerCase()){
                    case "#missingstate":
                        System.out.println("");
                        break;
                    case "#extrastate":
                        System.out.println("");
                        break;
                    case "#missingtransition":
                        System.out.println("");
                        break;
                    case "#extratransition":
                        System.out.println("");
                        break;
                    case "#misdirecttransition":
                        System.out.println("");
                        break;
                    case "#faultyfunction":
                        System.out.println("");
                        break;
                    default:
                        System.out.println("");
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void OutputTests(String[] MsState, String[] ExState, String[] MsTrans, String[] ExTrans, String[] MdTrans, String[] FltFunc){

    }
    public static String SimplifyTests(String testResult){
        return null;
    }
}
