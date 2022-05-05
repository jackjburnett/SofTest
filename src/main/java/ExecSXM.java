import com.google.common.collect.Multiset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExecSXM {
    public XMachine makeMinimal(XMachine sxm){
        String[] inaccessibleStates=StreamX.isAccessible(sxm);
        List<String> states = new ArrayList<>(Arrays.asList(sxm.getStates()));
        if(inaccessibleStates.length>0){
            for(String state:inaccessibleStates){
                states.remove(state);
                //Remove all transitions
            }
        }
        sxm.setStates(states.toArray(new String[0]));
        return sxm;
    }

    public String  ExecProcessingFunction(XMachine sxm){
        return null;
    }

    public static Boolean NextStateFunction(XMachine sxm){
        return false;
    }
}
