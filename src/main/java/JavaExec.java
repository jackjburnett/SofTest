import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JavaExec {
    static Validation validate = new Validation();
    Scanner input = new Scanner(System.in);

    public JavaExec(){
        System.out.println("Please input the file directory of your Java program for execution: ");
        String filePath = input.next();
        if(validate.FileValidator(filePath)){
            new JavaExec(filePath);
        }
    }

    public JavaExec(String filePath){
        try {
            Process processCompile = Runtime.getRuntime().exec("javac "+filePath);
        } catch (IOException e) {

        }
        Process processRun = null;
        try {
            processRun = Runtime.getRuntime().exec("java "+filePath);
        } catch (IOException e) {

        }
        try {
            readCMD(" stdout:", processRun.getInputStream());
            readCMD(" stderr:", processRun.getErrorStream());
        } catch (Exception e) {

        }
    }

    private static void readCMD(String func, InputStream input) throws Exception{
        String currLine = null;
        BufferedReader CMDLine = new BufferedReader(new InputStreamReader(input));
        while ((currLine = CMDLine.readLine()) != null) {
            System.out.println(func + " " + currLine);
        }
    }
}
