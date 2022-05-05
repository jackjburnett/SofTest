import java.util.List;

public class ExecSXM {
    public void makeMinimal(XMachine sxm, List<String> inaccessibleStates){
        if(inaccessibleStates.size()>0){
            for(String state:inaccessibleStates){
                //Remove Inaccessible State from states
                //Remove all transitions containing inaccessbibleState in transitions
            }
        }
    }

    public String  ExecProcessingFunction(XMachine sxm){
        return null;
    }

    public static Boolean NextStateFunction(XMachine sxm){
        return false;
    }
}
