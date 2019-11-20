import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Mirror {

    public static String reverse(String s) {
        int i = s.length() - 1;
        String reverse = "";
        while (i >= 0) {
            reverse = reverse + s.charAt(i);
            i--;
        }
        return reverse;
    }

    public static void main(String[] args) {
        try {

            Scanner input = new Scanner(System.in);
            ArrayList<String> fileText = new ArrayList<>();

            System.out.println("Enter file name");
            String fileName = input.next();

            Scanner file = new Scanner(new FileReader(fileName+".txt"));
            while (file.hasNextLine()) {
                fileText.add(file.nextLine());
            }

            PrintWriter write = new PrintWriter(reverse(fileName)+".txt");
            for (int i = 0; i < fileText.size(); i++) {
                write.println(reverse(fileText.get(i)));
            }

            write.close();
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

}