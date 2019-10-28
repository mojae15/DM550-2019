import java.util.Arrays;
import java.util.Scanner;

public class ScrambleIt{


    public static void main(String[] args){

        // System.out.println(removeVowels("Hello World"));
        operationController();

    }

    public static void operationController(){


        Scanner input = new Scanner(System.in);
        int mode = 1;

        int spaces;
        int blocks;
        int shift;
        int cont;
        int newText;
        boolean reUse = true;

        String text;
        System.out.println("Input text to be scrambled:");
        text = input.nextLine();

        do {

            if (!reUse){

                System.out.println("Input text to be scrambled:");
                text = input.nextLine();
            }

            showOptions();

            mode = input.nextInt();

            switch (mode){

                case (1):
                    text = removeVowels(text);
                    System.out.println("Resulting output:\n"+text);
                    break;

                case (2):
                    System.out.println("Enter the length between the spaces");
                    spaces = input.nextInt();
                    text = respace(text, spaces);
                    System.out.println("Resulting output:\n"+text);
                    break;
                
                case (3):
                    text = reverseWords(text);
                    System.out.println("Resulting output:\n"+text);
                    break;

                case (4):
                    System.out.println("Enter block length:");
                    blocks = input.nextInt();
                    text = reverseBlocks(text, blocks);
                    System.out.println("Resulting output:\n"+text);
                    break;

                case (5):
                    System.out.println("Enter amount to be shifted:");
                    shift = input.nextInt();
                    text = shiftWords(text, shift);
                    System.out.println("Resulting output:\n"+text);
                    break;
                
                case (0):
                    input.close();
                    System.exit(0);
                    break;
            }

            askContinue();

            cont = input.nextInt();

            switch (cont){
                
                case (1):
                    askNewText();
                    newText = input.nextInt();

                    switch (newText){

                        case (1):
                            reUse = true;
                            break;

                        case (2):
                            reUse = false;
                            break;

                    }


                    break;

                case (2):
                    mode = 0;
                    break;
                
                default:
                    break;

            }


            
        } while (mode != 0);

        input.close();



    }

    public static void showOptions(){

        System.out.println("Choose a method by writing the corresponding number, and pressing \"enter\":");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("1. Remove all vowels from words, except those words that consists of only vowels");
        System.out.println("2. Remove all space from the text and add a new space after every n-th character");
        System.out.println("3. Reverse every induvidual word");
        System.out.println("4. Divide the test into blocks of length m, and reverse each block individually");
        System.out.println("5. Shift each individual word in the text by a given number of characters");
        System.out.println("0. Exit");

    }

    public static void askContinue(){

        System.out.println("Do you want to continue?");
        System.out.println("1. Yes");
        System.out.println("2. No");
    }

    public static void askNewText(){

        System.out.println("Do you wish to continue using the same scrambled text, or input something new instead");
        System.out.println("1. Use the same");
        System.out.println("2. Input new");

    }

    /**
     * Remove all vowels from a string, unless it only consists of vowels
     */
    public static String removeVowels(String s){

        String[] words = split(' ', s);
        String res = "";

        for(String w: words){
            if (!checkForVowels(w)){
                w = removeVowels(w);
            }

            res = res + w + ' ';
        }

    
        return res;
    }
    
    /**
     * Check if a string consists of only vowels, returns true if it does
     */
    public static boolean checkForVowels(String s){
        int i = 0;
        String vowels = "aeiouyAEIOUY";

        boolean onlyVowels = true;

        while (i < s.length() && onlyVowels){
            if (!member(s.charAt(i), vowels)){
                onlyVowels = false;
            }
            i++;
        }

        return onlyVowels;

    }

    /**
     * Split a string 's' into blocks of size m, and then reverses them
     */
    public static String reverseBlocks(String s, int m){

        String[] blocks = splitStringIntoBlocks(s, m);
        String res = "";

        for (int i = 0; i < blocks.length; i++) {
            res = res + reverse(blocks[i]);
        }

        return res;

    }

    /**
     * Splits a string 's' into blocks of size 'm'
     */
    public static String[] splitStringIntoBlocks(String s, int m){
        
        //Calcualte amount of blocks we are going to get
        int length = (int) Math.ceil( (double) s.length() / m);


        String[] blocks = new String[length];
        int i = 0;
        int b = 0;
        

        while (i < s.length()){

            //Choose a substring from the text given from an index i, to either 'm' characters more, or the end of the string
            blocks[b] = s.substring(i, Math.min(s.length(), i+m));
            b++;
            i = i + m;

        }
        
        return blocks;

	}   
	/**
	 * Checks if a given character c occurs in a String s
	 */
	public static boolean member(char c, String s){
        int i = 0;
        boolean member = false;
        while (i < s.length() && !member){
            if (s.charAt(i) == c){
                member = true;
            }
            i++;
        }
        return member;
	}
	

	/**
	 * Remove all vowels from a String s
	 */
	public static String removeVowels(String s){
        int i = 0;
        String res = "";
        String vowels = "aeiouyAEIOUY";
        
        while (i < s.length()){
            if (!member(s.charAt(i), vowels)){
                res = res + s.charAt(i);
            }
            i++;
        }
        return res;
	}
	
	/**
	 * Split a String s on character c, could also be done using the build in split method
	 */
	public static String[] split(char c, String s){
        int splits = count(c, s)+1;
        String[] split = new String[splits];
        int i = 0;
        int j = 0;
        split[0] = "";
        
        while (i < s.length()){
            if (s.charAt(i) == c){
                j++;
                split[j] = "";
            } else {
                split[j] = split[j] + s.charAt(i);
            }
            i++;
        }
        return split;
	}
	
	/**
	 * Insert a space in String s after n characters
	 */
	public static String respace(String s, int n){
        int i = 0;
        String res = "";
        
        while (i < s.length()){
            if (res.length() % n == 0){ //We have added n characters, and should insert a space now
                res = res + ' ';
            }
            if (s.charAt(i) != ' '){
                res = res + s.charAt(i);
            }
            i++;
        }
        return res;
	}
	
	/**
	 * Reverse every word in a String s
	 */
	public static String reverseWords(String s){
        int i = 0;
        String reverse = "";
        String[] split = split(' ', s);

        while (i < split.length){
            reverse = reverse + reverse(split[i]) + ' ';
            i++;
        }
        return reverse;

	}

	/**
	 * Shift a given String s by n characters
	 */
	public static String shift(String s, int n){
        int shift = n % s.length();
    
        return s.substring(s.length()-n, s.length()) + s.substring(0, shift) + s.substring(shift, s.length()-n);
    }
	
	/**
	 * Shifts every word in a String s by n characters
	 */
	public static String shiftWords(String s, int n){
        String[] split = split(' ', s);
        String shift = "";
        int i = 0;

        while (i < split.length-1){
            shift = shift + shift(split[i], n) + ' ';
            i++;

        }
        
        //Got this and the split.length-1 from Luis solution, don't want to add a space after the last word
        shift = shift + shift(split[i], n);

        return shift;

    }


}