import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
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
        ListMultimap<String, String> TestResults = ArrayListMultimap.create();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int lineNo = 0;
            for(String line; (line = br.readLine()) != null; ) {
                String[] TestLine = line.split(" ");
                String tempString= String.join(" ",Arrays.copyOfRange(TestLine,1, TestLine.length));
                TestResults.put(TestLine[0], tempString);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        OutputTests(TestResults);
    }

    public static void OutputTests(ListMultimap<String, String> TestResults){

    }
    public static String SimplifyTests(String testResult){
        return null;
    }
}
