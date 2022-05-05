import com.sun.source.tree.WhileLoopTree;

import java.util.Arrays;

public final class StateCounting {
    public static String[] isAccessible(XMachine sxm){
        String[] accessibleStates = {sxm.getInitState()};
        String[] inaccessibleStates = sxm.getStates();

        while (accessibleStates.length>0){
            int countChecked=0;
            String[] statesToBeCheckedNextLoop = new String[0];

            for(int i=0; i<accessibleStates.length;i++){
                if(Arrays.stream(inaccessibleStates).anyMatch(accessibleStates[i]::equals)){
                    //finish this
                }else{
                    countChecked++;
                }
            }
            if(statesToBeCheckedNextLoop.length>0){
                accessibleStates=statesToBeCheckedNextLoop;
            }
            if(accessibleStates.length==countChecked&&inaccessibleStates.length>0){
                break;
            }
        }
        return inaccessibleStates;
    }

    public String  ExecProcessingFunction(XMachine sxm){
        return null;
    }

    public static Boolean NextStateFunction(XMachine sxm){
        return false;
    }
}
