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
        for(String key: TestResults.keySet()){
            for(String result: TestResults.get(key)){
                System.out.print(TestTypes.get(key)+": ");
                System.out.println(result);
            }
        }
        System.out.println("Would you like to simplify these results?");
        String simplify = input.next();
        if((simplify.equalsIgnoreCase("y"))||(simplify.equalsIgnoreCase("yes"))){
            SimplifyTests(TestResults);
        }
    }

    public static void SimplifyTests(ListMultimap<String, String> TestResults){
        for(String key: TestResults.keySet()){
            for(String result: TestResults.get(key)){
                String [] states=result.split(">");
                switch (key) {
                    case "#missingstate" -> System.out.println("You need to implement the state '" + result + "'.");
                    case "#extrastate" -> System.out.println("You need to remove the state '" + result + "'.");
                    case "#missingtransition" -> System.out.println("You need to add a transition from '" + states[0] + "to" + states[1] + "'.");
                    case "#extratransition" -> System.out.println("You need to remove the transition from '" + states[0] + "to" + states[1] + "'.");
                    case "#misdirecttransition" -> System.out.println("You need fix the state transition from '" + states[0] + "to" + states[1] + "'.");
                    case "#faultyfunction" -> System.out.println("You need to fix the function '" + result + "'.");
                    case "#inaccessiblestate" -> System.out.println("You need to create a transition to the state '" + result + "'.");
                    default -> System.out.println("Test simplification not yet implemented for this result.");
                }
            }
        }
    }

    public static Map<String, String> GenerateTestTypes(){
        Map<String, String> TestTypes= new HashMap<>();
        TestTypes.put("#missingstate", "Missing state");
        TestTypes.put("#extrastate", "Extra state");
        TestTypes.put("#missingtransition", "Missing transition");
        TestTypes.put("#extratransition", "Extra transition");
        TestTypes.put("#misdirecttransition", "Misdirecting transition");
        TestTypes.put("#faultyfunction", "Faulty function/transition (I/O)");
        TestTypes.put("#inaccessiblestate", "Inaccessible state");
        TestTypes.put("#isminimal", "SXM is minimal");
        return TestTypes;
    }
}
