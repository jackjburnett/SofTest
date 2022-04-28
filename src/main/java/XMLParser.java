import java.util.Scanner;

public class XMLParser {
    public class CreateXML {
        static Validation validate = new Validation();
        Scanner input = new Scanner(System.in);
        // This will not accept maven projects!
        public CreateXML(){
            System.out.println("Please input the file directory of your XML for parsing: ");
            String filePath = input.next();
            if (validate.XMLValidator(filePath)){
                new CreateXML(filePath);
            }
        }

        public CreateXML(String filePath){
            System.out.println("123");
        }
    }

}
