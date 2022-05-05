import com.sun.source.tree.WhileLoopTree;

public final class StateCounting {
    public static String[] isAccessible(XMachine sxm){
        String[] accessibleStates = {sxm.getInitState()};
        String[] inaccessibleStates = sxm.getStates();

        while (accessibleStates.length>0){
            int countChecked=0;

        }
        return inaccessibleStates;
    }

    public static Boolean isMinimal(XMachine sxm){
        return false;
    }

    public String  ExecProcessingFunction(XMachine sxm){
        return null;
    }

    public static Boolean NextStateFunction(XMachine sxm){
        return false;
    }
}
