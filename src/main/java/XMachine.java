import com.google.common.collect.ListMultimap;

import java.util.Arrays;
import java.util.Map;

public class XMachine {
    private ListMultimap<String, String> DataTypes;
    private String[] States;
    private String[] Inputs;
    private String[] Output;
    private String[] Memory;
    private String InitState;
    private String[] InitMemory;
    private ListMultimap<String, String> Functions;
    private Map<String, String> ExtFunctions;
    private ListMultimap<String, String> Transitions;

    public XMachine(ListMultimap<String, String> dataTypes, String[] states, String[] inputs, String[] output, String[] memory, String initState, String[] initMemory, ListMultimap<String, String> functions, Map<String, String> extFunctions, ListMultimap<String, String> transitions) {
        DataTypes = dataTypes;
        States = states;
        Inputs = inputs;
        Output = output;
        Memory = memory;
        InitState = initState;
        InitMemory = initMemory;
        Functions = functions;
        ExtFunctions = extFunctions;
        Transitions = transitions;
    }

    public void OutputXMachine(){
        System.out.println(DataTypes.toString());
        System.out.println(Arrays.toString(States));
        System.out.println(Arrays.toString(Inputs));
        System.out.println(Arrays.toString(Output));
        System.out.println(Arrays.toString(Memory));
        System.out.println(InitState);
        System.out.println(Arrays.toString(InitMemory));
        System.out.println((Functions).toString());
        System.out.println(ExtFunctions);
        System.out.println((Transitions).toString());
    }

    public ListMultimap<String, String> getDataTypes() {
        return DataTypes;
    }

    public void setDataTypes(ListMultimap<String, String> dataTypes) {
        DataTypes = dataTypes;
    }

    public String[] getStates() {
        return States;
    }

    public void setStates(String[] states) {
        States = states;
    }

    public String[] getInputs() {
        return Inputs;
    }

    public void setInputs(String[] inputs) {
        Inputs = inputs;
    }

    public String[] getOutput() {
        return Output;
    }

    public void setOutput(String[] output) {
        Output = output;
    }

    public String[] getMemory() {
        return Memory;
    }

    public void setMemory(String[] memory) {
        Memory = memory;
    }

    public String getInitState() {
        return InitState;
    }

    public void setInitState(String initState) {
        InitState = initState;
    }

    public String[] getInitMemory() {
        return InitMemory;
    }

    public void setInitMemory(String[] initMemory) {
        InitMemory = initMemory;
    }

    public ListMultimap<String, String> getFunctions() {
        return Functions;
    }

    public void setFunctions(ListMultimap<String, String> functions) {
        Functions = functions;
    }

    public Map<String, String> getExtFunctions() {
        return ExtFunctions;
    }

    public void setExtFunctions(Map<String, String> extFunctions) {
        ExtFunctions = extFunctions;
    }

    public ListMultimap<String, String> getTransitions() {
        return Transitions;
    }

    public void setTransitions(ListMultimap<String, String> transitions) {
        Transitions = transitions;
    }
}
