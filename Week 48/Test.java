import java.util.ArrayList;

public class Test{

    public static int calls = 0;
    public static void main(String[] args) {

        // ArrayList<String> sList = genPerm("Hej");


        // for(String perm: sList){
        //     System.out.println(perm);
        // }

        System.out.println(genPerm("Hej"));


    }

    public static ArrayList<String> genPerm(String s){
        ArrayList<String> res = new ArrayList<>();

        if (s.length() < 2){
            res.add(s);
        } else {

            for (int i = 0; i < s.length(); i++){

                // System.out.println("Looking at char "+i+": "+s.charAt(i));
                String s1 = s.substring(0, i);
                String s2 = s.substring(i+1, s.length());
                // System.out.println("Before: "+s1);
                // System.out.println("After: "+s2);
                String s3 = s1+s2;
                // System.out.println("Collected: "+s3+"\n");

                ArrayList<String> perms = genPerm(s3);

                // System.out.println("Perms:");
                for (String perm : perms){
                    res.add(s.charAt(i)+perm);
                    // System.out.println(s.charAt(i)+perm);
                }
            }
        }
        return res;
    }


}
