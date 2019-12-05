import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Input a string:");
        String text = in.next();

        System.out.println(isPalindrome2(text));

    }

    /**
     * Check if String s is a palindrome, done recursively using the substring
     * method
     */
    public static boolean isPalindrome(String s) {

        if (s.length() > 2) {
            return ((s.charAt(0) == s.charAt(s.length() - 1)) && isPalindrome(s.substring(1, s.length() - 1)));
        }

        return true;

    }

    /**
     * Checks if String s is a palindrome, done recursively using the indexes
     */
    public static boolean isPalindrome2(String s){

        return palAux(s, 0, s.length()-1);
        
    }

    /**
     * Helper method for checking for palindromes
     */
    private static boolean palAux(String s, int start, int end){

        if (start < end){
            return ((s.charAt(start) == s.charAt(end)) && palAux(s, start+1, end-1));
        }
        return true;
        

    }

}