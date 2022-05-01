import com.google.common.io.Files;

import java.io.File;

public class Validation {
    public boolean XMDLValidator(String filePath) {
        if (new File(filePath).exists()) {

            if (Files.getFileExtension(filePath).toLowerCase().equals("xmdl")) {
                return true;
            }
            else{
                System.out.println("Specified file is not of type 'XMDL'.");
                return false;
            }
        } else{
            System.out.println("File path does not exist, or does not lead to a file.");
            return false;
        }
    }
}

