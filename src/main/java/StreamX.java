import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StreamX {
    static Validation validate = new Validation();
    Scanner input = new Scanner(System.in);


    public StreamX(){
        System.out.println("Please input the file path of your XMDL file for test generation: ");
        String filePath = input.next();
        if(validate.XMDLValidator(filePath)){
            new StreamX(XMDLParser.ParseFile(filePath, false));
        }
        System.out.println("Returning to main menu.");
    }

    public StreamX(XMachine sxm){
        ListMultimap<String, String> TestResults = ArrayListMultimap.create();
        for(String missingState:MissingStates(sxm)){
            TestResults.put("#missingstate", missingState);
        }
        for(String extraState:ExtraStates(sxm)){
            TestResults.put("#extrastate", extraState);
        }
        for(String missingTransition:MissingTransitions(sxm)){
            TestResults.put("#missingtransition", missingTransition);
        }
        for(String extraTransition:ExtraTransitions(sxm)){
            TestResults.put("#extratransition",extraTransition);
        }
        for(String misdirectTransition:MisdirectTransitions(sxm)){
            TestResults.put("#misdirecttransition",misdirectTransition);
        }
        for(String faultyFunctions:FaultyFunctions(sxm)){
            TestResults.put("#faultyfunction", faultyFunctions);
        }
        String[] inaccessibleStates=isAccessible(sxm);
        for(String inaccessibleState:inaccessibleStates){
            TestResults.put("#inaccessiblestate", inaccessibleState);
        }
        if(inaccessibleStates.length>0){
            TestResults.put("#isminimal","false");
        }else{
            TestResults.put("#isminimal","true");
        }
        TestViewer.OutputTests(TestResults);
    }

    public String[] MissingStates(XMachine sxm){
        List<String> states = new ArrayList<>(Arrays.asList(sxm.getStates()));
        for (String transition : sxm.getTransitions().keys()) {
            String transitionStates = transition.replace("(", ",");
            transitionStates = transitionStates.replace(")", ",");
            transitionStates = transitionStates.replace(" ", "");
            String[] startTransitionStates = transitionStates.split(",");
            String[] endTransitionStates= sxm.getTransitions().get(transition).toArray(new String[0]);
            
        }

        return sxm.getStates();
    }

    public String[] ExtraStates(XMachine sxm){
        return sxm.getStates();
    }

    public String[] MissingTransitions(XMachine sxm){
        return sxm.getStates();
    }

    public String[] ExtraTransitions(XMachine sxm){
        return sxm.getStates();
    }

    public String[] MisdirectTransitions(XMachine sxm){
        return sxm.getStates();
    }

    public String[] FaultyFunctions(XMachine sxm){
        return sxm.getStates();
    }

    public static String[] isAccessible(XMachine sxm){
        List<String> accessibleStates = new ArrayList<>();
        accessibleStates.add(sxm.getInitState());
        List<String> inaccessibleStates = new ArrayList<>(Arrays.asList(sxm.getStates()));

        while (accessibleStates.size()>0){
            int countChecked=0;
            List<String> statesToBeCheckedNextLoop = new ArrayList<>();

            for (String accessibleState : accessibleStates) {
                if (inaccessibleStates.contains(accessibleState)) {
                    for (String transition : sxm.getTransitions().keys()) {
                        transition = transition.replace("(", ",");
                        transition = transition.replace(")", ",");
                        transition = transition.replace(" ", "");
                        String[] transitionStates = transition.split(",");
                        if (Arrays.asList(transitionStates).contains(accessibleState)) {
                            statesToBeCheckedNextLoop.add(accessibleState);
                        }
                    }
                    inaccessibleStates.remove(accessibleState);
                } else {
                    countChecked++;
                }
            }
            if(statesToBeCheckedNextLoop.size()>0){
                accessibleStates=statesToBeCheckedNextLoop;
            }
            if(accessibleStates.size()==countChecked&&inaccessibleStates.size()>0){
                break;
            }
        }
        return inaccessibleStates.toArray(new String[0]);
    }
}
