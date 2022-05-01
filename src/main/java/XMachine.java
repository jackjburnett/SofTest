public class XMachine {
    private String[][] DataTypes;
    private String[] States;
    private String[] Inputs;
    private String[] Output;
    private String InitState;
    private String[] InitMemory;
    private String[] Functions;
    private String[] ExtFunctions;
    private String[] Transitions;

    public XMachine() {
        System.out.println("Test XMachine");
    }

    public XMachine(String[][] dataTypes, String[] states, String[] inputs, String[] output, String initState, String[] initMemory, String[] functions, String[] extFunctions, String[] transitions) {
        DataTypes = dataTypes;
        States = states;
        Inputs = inputs;
        Output = output;
        InitState = initState;
        InitMemory = initMemory;
        Functions = functions;
        ExtFunctions = extFunctions;
        Transitions = transitions;
    }

    public String[][] getDataTypes() {
        return DataTypes;
    }

    public void setDataTypes(String[][] dataTypes) {
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

    public String[] getFunctions() {
        return Functions;
    }

    public void setFunctions(String[] functions) {
        Functions = functions;
    }

    public String[] getExtFunctions() {
        return ExtFunctions;
    }

    public void setExtFunctions(String[] extFunctions) {
        ExtFunctions = extFunctions;
    }

    public String[] getTransitions() {
        return Transitions;
    }

    public void setTransitions(String[] transitions) {
        Transitions = transitions;
    }
}
