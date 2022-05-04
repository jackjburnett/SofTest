import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import java.util.Map;

public class XMachine {
    private ListMultimap<String, String> DataTypes;
    private String[] States;
    private String[] Inputs;
    private String[] Output;
    private String[] Memory;
    private String InitState;
    private String[] InitMemory;
    private String[][] Functions;
    private Map<String, String> ExtFunctions;
    private String[][] Transitions;

    public XMachine(ListMultimap<String, String> dataTypes, String[] states, String[] inputs, String[] output, String[] memory, String initState, String[] initMemory, String[][] functions, Map<String, String> extFunctions, String[][] transitions) {
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

    public String[][] getFunctions() {
        return Functions;
    }

    public void setFunctions(String[][] functions) {
        Functions = functions;
    }

    public Map<String, String> getExtFunctions() {
        return ExtFunctions;
    }

    public void setExtFunctions(Map<String, String> extFunctions) {
        ExtFunctions = extFunctions;
    }

    public String[][] getTransitions() {
        return Transitions;
    }

    public void setTransitions(String[][] transitions) {
        Transitions = transitions;
    }
}
