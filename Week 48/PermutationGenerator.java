import java.util.Scanner;
import java.util.ArrayList;

public class PermutationGenerator{

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
    
        System.out.println("Input a string");

        String text = in.next();



        for (String s : genPermutations(text)){
            System.out.println(s);
        }




    }


    public static ArrayList<String> genPermutations(String s){
        ArrayList<String> res = new ArrayList<>();

        if (s.length() < 2){
            res.add(s);
        } else { 

            for(int i = 0; i < s.length(); i++){
                String s1 = s.substring(0, i);
                String s2 = s.substring(i+1, s.length());
                ArrayList<String> genPerm = genPermutations( s1 + s2);
                for (String perm : genPerm){
                    String temp = s.charAt(i) + perm;
                    res.add(temp);
                }

            }

        }

        return res;


    }



}