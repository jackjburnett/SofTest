import com.google.common.io.Files;

import java.io.File;

public class Validation {
    public boolean FileValidator(String filePath){
        if(new File(filePath).exists()){
            //System.out.println(Files.getFileExtension(filePath));
            if(Files.getFileExtension(filePath).equals("java")) {
                return true;
            }
        }
        return false;
    }
}
