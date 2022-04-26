import com.google.common.io.Files;

import java.io.File;

public class Validation {
    public boolean JavaValidator(String filePath) {
        if (new File(filePath).exists()) {

            if (Files.getFileExtension(filePath).toLowerCase().equals("java")) {
                return true;
            }
            else{
                System.out.println("Specified file is not of type 'java'.");
                return false;
            }
        } else{
            System.out.println("File path does not exist, or lead to a file.");
            return false;
        }
    }

    public boolean XMLValidator(String filePath) {
        if (new File(filePath).exists()) {
            if (Files.getFileExtension(filePath).toLowerCase().equals("xml")) {
                return true;
            }
            else{
                System.out.println("Specified file is not of type 'xml'.");
                return false;
            }
        } else{
            System.out.println("File path does not exist, or lead to a file.");
            return false;
        }
    }
}

