import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.security.PublicKey;
import java.util.Scanner;

public class JavaParser {
    static Validation validate = new Validation();
    Scanner input = new Scanner(System.in);

    public JavaParser() {
        System.out.println("Please input the file directory of your Java file for parsing: ");
        String filePath = input.next();
        if (validate.JavaValidator(filePath)) {
            new JavaParser(filePath);
        }
    }

    public JavaParser(String filePath){
        try {
            CompilationUnit cu = StaticJavaParser.parse(new File(filePath));
            System.out.println(cu);
            cu.findAll(ClassOrInterfaceDeclaration.class).stream().filter(c->!c.isInterface()&&c.isAbstract()&&!c.getNameAsString().startsWith("Abstract")).forEach(c->{
                String from = c.getNameAsString();
                String to = "Abstract" + from;
                System.out.println("Renaming class "+from+" into "+to);
                c.setName(to);
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
