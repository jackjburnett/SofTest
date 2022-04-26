import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.PublicKey;
import java.util.Scanner;

public class JavaParser {
    static Validation validate = new Validation();
    Scanner input = new Scanner(System.in);

    public JavaParser() {
        // This will not accept maven projects!
        System.out.println("Please input the file directory of your Java program for parsing: ");
        String filePath = input.next();
        if (validate.FileValidator(filePath)) {
            new JavaParser(filePath);
        }
    }

    public JavaParser(String filePath){
        try {
            CompilationUnit cu = StaticJavaParser.parse(new File(filePath));
            System.out.println(cu);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
