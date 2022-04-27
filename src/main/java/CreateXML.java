import java.util.Scanner;
import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

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
