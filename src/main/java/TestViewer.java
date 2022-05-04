import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public final class TestViewer {
    static Validation validate = new Validation();
    static Scanner input = new Scanner(System.in);

    public static void OpenTests(){
        System.out.println("Please input the file path of your SofTest file containing test results: ");
        String filePath = input.next();
        if(validate.SofTestValidator(filePath)){
            ReadTests(filePath);
        }
        System.out.println("Returning to main menu.");
    }

    private static void ReadTests(String filePath){
        Map<String, String> TestTypes = GenerateTestTypes();
        ListMultimap<String, String> TestResults = ArrayListMultimap.create();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
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

        //Clean the input
        Set<String> keys = TestResults.keySet();
        Object[] keyArray= keys.toArray();
        for (Object o : keyArray) {
            String keyString = String.valueOf(o);
            if (!(TestTypes.containsKey(keyString))) {
                TestResults.removeAll(keyString);
            }
        }
        OutputTests(TestResults);
    }

    public static void OutputTests(ListMultimap<String, String> TestResults){
        Map<String, String> TestTypes = GenerateTestTypes();
        System.out.println(TestResults);
        for(String key: TestResults.keySet()){
            for(String result: TestResults.get(key)){
                System.out.print(TestTypes.get(key)+": ");
                System.out.println(result);
            }
        }
    }

    public static String SimplifyTests(String testResult){
        return null;
    }

    public static Map<String, String> GenerateTestTypes(){
        Map<String, String> TestTypes= new HashMap<>();
        TestTypes.put("#missingstate", "Missing state");
        TestTypes.put("#extrastate", "Extra state");
        TestTypes.put("#missingtransition", "Missing transition");
        TestTypes.put("#extratransition", "Extra transition");
        TestTypes.put("#misdirecttransition", "Misdirecting transition");
        TestTypes.put("#faultyfunction", "Faulty function/transition (I/O)");
        return TestTypes;
    }
}
