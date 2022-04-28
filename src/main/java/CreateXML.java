import java.util.Scanner;
import java.io.File;
import java.io.StringWriter;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

public class CreateXML {
    static Validation validate = new Validation();
    Scanner input = new Scanner(System.in);
    // This will not accept maven projects!
    public CreateXML(){
        System.out.println("Please input the file directory of your Java file for XML creation: ");
        String filePath = input.next();
        if (validate.XMLValidator(filePath)){
            new CreateXML(filePath);
        }
    }

    public CreateXML(String filePath){
        System.out.println("123");
    }
}
