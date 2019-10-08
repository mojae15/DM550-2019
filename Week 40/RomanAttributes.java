import java.util.Scanner;

public class RomanAttributes{

    /**
     * This solution uses "class attributes"
     * In this program, the "class attributes" are the two arrays below called "letters" and "values"
     * The elements in the "letters" array is the letters in our alphabet
     * The elements in the "values" array is the values for the dirrerent letters
     * The arrays are set up so the character in "letters" at index "i", has the value of "values" at index "i"
     */

    private static char[] letters = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
    private static int[] values = new int[]{1000, 500, 100, 50, 10, 5, 1};

    /**
     * The "class attributes" can be thought of as global variables, meaning that they ar accessible from everywhere else in the class
     * Usage of this can be seen in the methods of the program
     */

    public static void main(String[] args){

        operationController();

    }

    /**
     * Method to handle the input of the program
     */
    public static void operationController(){


        //Number used to determine what method to call
        int method = 0;

        Scanner input = new Scanner(System.in);

        //This loop runs until the user inputs a "0" to the program
        do {

            String num1, num2;
            int value;

            showMenu();

            method = input.nextInt();

            //Switch on the input number - Could also be done with a bunch of "if - else if" statements
            switch (method){

                case (0):
                    break;

                //User inputs "1", convert a roman numeral to integer
                case (1):
                    System.out.println("Enter Roman Numeral:");
                    num1 = input.next();

                    if (!isRomanNum(num1)){
                        System.out.println("Error - Input was not a valid Roman Numeral");
                    } else {
                        System.out.println(num1 + " represents: "+ romanToNum(num1));
                    }
                    break;
                
                //User inputs "2", convert a number to roman numeral
                case (2):
                    System.out.println("Enter Number to convert:");
                    value = input.nextInt();

                    if (value < 1 || value > 4000){
                        System.out.println("Error - Can only convert numbers between 1 and 4000");
                    } else {
                        System.out.println(value + " represents: "+numToRoman(value));
                    }
                    break;

                //User inputs "3", add to roman numerals together   
                case (3):
                    System.out.println("Enter two Roman Numerals to add together:");
                    num1 = input.next();
                    num2 = input.next();
                    
                    if (!isRomanNum(num1) || !isRomanNum(num2)){
                        System.out.println("Error - Input was not a Roman Numeral(s)");
                    } else {
                        System.out.println("The Sum is:  "+add(num1, num2));
                    }
                    break;

                //User inputs "3", subtract two roman numerals
                case (4):
                    System.out.println("Enter two Roman Numerals to subtract. The first must be the largest:");
                    num1 = input.next();
                    num2 = input.next();

                    if (!isRomanNum(num1) || !isRomanNum(num2)){
                        System.out.println("Error - Input was not a Roman Numeral(s)");
                    } else if (romanToNum(num1) <= romanToNum(num2)){
                        System.out.println("Error - The first Roman Numeral must be the largest of the two");
                    } else {
                        System.out.println("The Difference is:  "+ diff(num1, num2));
                    }
                    break;

                //If the input is not one of the legal numbers, print an error and stop the program
                default:
                    System.out.println("Error - Input was not recognized");
                    break;
        
            }

            System.out.println();

        } while (method != 0);

        input.close();
    }

    /**
     * Prints the menu to the user
     */
    public static void showMenu(){
        System.out.println("Choose a method by writing the corresponding number, and pressing \"enter\":");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("1. Convert Roman Numeral to a Number");
        System.out.println("2. Convert a Number to Roman Numerals");
        System.out.println("3. Add two Roman Numerals together");
        System.out.println("4. Subtract two Roman Numerals");
        System.out.println("0. Exit");
    }

    

    /**
     * Converts a Roman Numeral "num" to an integer value
     */
    public static int romanToNum(String num){
        int sum = 0;

        int i = 0;

        while (i < num.length()){
            sum = sum + charToVal(num.charAt(i));
            i++;
        }

        return sum;

    }

    /**
     * Support function for the function "romanToNum"
     * Converts a character 'c' to its value
     */
    public static int charToVal(char c){

        int i = 0;
        boolean found = false;

        /**
         * Go through the "letters" array (one of the "class attributes"), and search for a specific character
         * When we find the character, we stop the while loop, as to save the index of that character
         * We then use that index to access the "values" array (the other "class attribute") at the index, and return the corresponding value
         * F.x. if we are looking for the character 'C'
         * In the array "letters", 'C' is the third element in the list, meaning that it has index "2"
         * We now return the value in the "values" array at index "2", which is 100
         */

        while(!found){

            if (letters[i] == c){
                found = true;
            } else {
                i++;
            }

        }

        return values[i];
    }

    /**
     * Converts an integer value to a Roman Numeral
     */
    public static String numToRoman(int n){

        String num = "";

        int i = 0;

        /**
         * In each iteration we subtract one instance of the largest value we can, otherwise we move on to the next value
         * Using the same logic as in the function "romanToNum", only the other way around
         */
        while (n > 0){

            if (n >= values[i]){
                num = num + letters[i];
                n = n - values[i];
            } else {
                i++;
            }

        }

        return num;

    }

    /**
     * Adds to roman numerals "num1" and "num2" together.
     */
    public static String add(String num1, String num2){
        String res = "";

        //Build up a new string using the support function
        for(char c:letters){
            res = res + createCharString(c, num1, num2);
        }

        //Replace all illegal instances of numbers
        res = res.replaceAll("IIIII", "V");
        res = res.replaceAll("VV", "X");
        res = res.replaceAll("XXXXX", "L");
        res = res.replaceAll("LL", "C");
        res = res.replaceAll("CCCCC", "D");
        res = res.replaceAll("DD", "M");


        return res;
        

    }

    /**
     * Calculates the difference between "num1" and "num2", by adding "I" to "num2" until it becomes as large as "num1"
     * We use the following formula:
     * num1 - num2 = count
     * Where count is the only number satisfying:
     * num2 + count = num1
     */
    public static String diff(String num1, String num2){
        //Since num1 is STRICTLY larger than num2, it is at least one "I" larger
        String count = "I";
        num2 = add(num2, count);

        //Add one "I" to num2 at a time, until it is equal to num1. Also count the number of "I"'s we add with the string count
        while (!num2.equals(num1)){

            num2 = add(num2, "I");
            count = add(count, "I");

        }

        return count;

    }

    /**
     * Support function for "add". Returns a string containing "c" as many times as it appears in "s1" and "s2"
     */
    public static String createCharString(char c, String s1, String s2){
        String res = "";
        int count = countOccurences(c, s1) + countOccurences(c, s2);
        
        for(int i = 0; i < count; i++){
            res = res + c; 
        }

        return res;
    }

    /**
     * Support function for "createCharString". Counts occurences of char "c" in string "s"; 
     */
    public static int countOccurences(char c, String s){
        
        int count = 0;

        //Showcase of using a for-each loop to go over a string. Here we conver the string to an actual array of characters, using the "toCharArray()" method
        for(char ch:s.toCharArray()){
            if (ch == c){
                count++;
            }
        }
        return count;
    }

    /**
     * Checks whether or not "s" is a valid roman numeral
     * This function is can be pretty complicated to look at, but take it one line at a time
     */
    public static boolean isRomanNum(String s){

        boolean isValid = true;
        int i = 0;
        int count = 0;

        //Count 'M's, not limit to the amount of these
        while ((i < s.length()) && (s.charAt(i) == 'M')){
            i++;
        }

        //Count 'D's, can only contain one of these
        while ((i < s.length()) && (s.charAt(i) == 'D')){
            i++;
            count++;
        }
        
        //If we have counted more than one 'D', set isValid to false
        isValid = !(count > 1);

        //Reset count;
        count = 0;

        //Count 'C's, can only contain four of these
        while ((i < s.length()) && (s.charAt(i) == 'C')){
            i++;
            count++;
        }

        //If we have counted more than four 'C's, set isValid to false
        isValid = !(count > 4);

        //Reset count
        count = 0;

        //Count 'L's, can only contain one of these
        while ((i < s.length()) && (s.charAt(i) == 'L')){
            i++;
            count++;
        }
        
        //If we have counted more than one 'L', set isValid to false
        isValid = !(count > 1);

        //Reset count;
        count = 0;
        
        //Count 'X's, can only contain four of these
        while ((i < s.length()) && (s.charAt(i) == 'X')){
            i++;
            count++;
        }

        //If we have counted more than four 'X's, set isValid to false
        isValid = !(count > 4);

        //Reset count
        count = 0;

        //Count 'V's, can only contain one of these
        while ((i < s.length()) && (s.charAt(i) == 'V')){
            i++;
            count++;
        }
        
        //If we have counted more than one 'V', set isValid to false
        isValid = !(count > 1);

        //Reset count;
        count = 0;

        //Count 'I's, can only contain four of these
        while ((i < s.length()) && (s.charAt(i) == 'I')){
            i++;
            count++;
        }

        //If we have counted more than four 'I's, set isValid to false
        isValid = !(count > 4);

        return (isValid && (i == s.length()));
        
    }

}