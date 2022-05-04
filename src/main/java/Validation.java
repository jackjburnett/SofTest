import com.google.common.io.Files;

import java.io.File;

public class Validation {
    public boolean XMDLValidator(String filePath) {
        return FileChecker(filePath, "XMDL");
    }

    public boolean SofTestValidator(String filePath) {
        return FileChecker(filePath, "SofTest");
    }

    public boolean FileChecker(String filePath, String fileExtension){
        if (new File(filePath).exists()) {
            if (Files.getFileExtension(filePath).equalsIgnoreCase(fileExtension)) {
                return true;
            }
            else{
                System.out.println("Specified file is not of type '"+fileExtension+"'.");
                return false;
            }
        } else{
            System.out.println("File path does not exist, or does not lead to a file.");
            return false;
        }
    }

    public String[] removeSymbolsArray(String[] arr){
        for (int n = 0; n < arr.length; n++) {
            arr[n] = removeSymbolsLine(arr[n]);
        }
        return arr;
    }

    public String removeSymbolsLine(String line){
        return line.replaceAll("[{}(),]", "");
    }

}

