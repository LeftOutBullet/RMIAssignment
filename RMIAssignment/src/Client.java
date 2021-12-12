import java.rmi.Naming;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
           MyInterface service = (MyInterface) Naming.lookup("rmi://127.0.0.1:1250/server");
           Scanner sc = new Scanner(System.in);
            System.out.println("type in your string : ");
            String entered = sc.nextLine();
            System.out.println("your line inverted is : "+service.reverse(entered));
            System.out.println("your lowest character is : "+service.MinChar(entered));
            System.out.println("your casechanged string is : "+service.CaseChanger(entered));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
