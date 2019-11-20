import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Excep{

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(new File("t.txt"));

        } catch (FileNotFoundException e){
            System.out.println(e);
        } 

    }


}
