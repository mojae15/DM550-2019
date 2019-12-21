import java.util.ArrayList;

public class Client{


    /**
     * Calculates the sum of all elements in t
     */
    public static double sum(BinaryTree<Double> t){
        
        
        if (t.isEmpty()){
            return 0.0;
        } else {
            return t.root() + sum(t.left()) + sum(t.right());
        }


    }

    /**
     * Counts the number of 0's in s
     */
    public static int zeros(BinaryTree<Integer> s){


        if (s.isEmpty()){
            return 0;
        } else {
            int count = 0;
            if (s.root() == 0){
                count = 1;
            }
            return count + zeros(s.left()) + zeros(s.right());

        }

    }

    /**
     * Count the number of occurrences of s in t
     */
    public static int count(BinaryTree<String> t, String s){
        

        if (t.isEmpty()){
            return 0;
        } else {
            int count = 0;
            
            if (t.root().equals(s)){
                count = 1;
            }
            return count + count(t.left(), s) + count(t.right(), s);

        }

    }
    
    /**
     * Return a list containing all elements of t
     */
    public static ArrayList<Integer> toArrayList(BinaryTree<Integer> t){

        ArrayList<Integer> iList = new ArrayList<>();

        if (t.isEmpty()){
            return iList;
        } else {
            iList.add(t.root());
            iList.addAll(toArrayList(t.left()));
            iList.addAll(toArrayList(t.right()));
            return iList;
        }   

    }

    /**
     * Returns a list containing elements of t that are larger than n
     */
    public static ArrayList<Integer> selectLarger(BinaryTree<Integer> t, int n){

        ArrayList<Integer> iList = new ArrayList<>();

        if (t.isEmpty()){
            return iList;
        } else {

            if (t.root() > n){
                iList.add(t.root());
            }
            iList.addAll(toArrayList(t.left()));
            iList.addAll(toArrayList(t.right()));

            return iList;
        } 


    }
    
    public static <E> int mostLeftTurns(BinaryTree<E> t){


        if (t.size() <= 1){
            return 0;
        } else {
            int lCount = 0;
            int rCount = 0;
            BinaryTree<E> left = t.left();
            BinaryTree<E> right = t.right();

            if (!left.isEmpty()){
                lCount = 1 + mostLeftTurns(left);
            } 

            if (!right.isEmpty()){
                rCount = 0 + mostLeftTurns(right);
            }

            return Math.max(lCount, rCount);

        }


    }


    public static void main(String[] args) {

        BinaryTree<Double> dTree = new BinaryTree<>();

        for (double d = 0.0; d < 10.0; d++){
            dTree.add(d/2);
        }
        // System.out.println(sum(dTree));

        BinaryTree<Integer> iTree = new BinaryTree<>();
        
        for (int i = 0; i < 10; i++){
            int n = (i % 2) * i;
            iTree.add(n);

        }
        // System.out.println(zeros(iTree));

        BinaryTree<String> sTree = new BinaryTree<>();
        String s = "Hej";

        for (int i = 0; i < 10; i++){
            int n = (i % 2) * i;
            sTree.add(s + n);

        }

        // System.out.println(count(sTree, "Hej0"));

        // System.out.println(toArrayList(iTree));

        // System.out.println(selectLarger(iTree, 2));

        System.out.println(mostLeftTurns(dTree));






        


    }


}