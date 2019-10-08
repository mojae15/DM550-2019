import java.util.Scanner;

public class Roman{

    /**
     * This program is the "simple" version of solving the lab exercise for week 40
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

                //User inputs "0", end program
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
     * Converts roman numerals "num" to a decimal number
     */
    public static int romanToNum(String num){

        int i = 0;
        int sum = 0;

        //Check each character of the roman numeral, and add the corresponding number to the sum
        while (i < num.length()){
            switch (num.charAt(i)){
                case ('M'):
                    sum = sum + 1000;
                    break;

                case ('D'):
                    sum = sum + 500;
                    break;

                case ('C'):
                    sum = sum + 100;
                    break;

                case ('L'):
                    sum = sum + 50;
                    break;

                case ('X'):
                    sum = sum + 10;
                    break;

                case ('V'):
                    sum = sum + 5;
                    break;
                
                case ('I'):
                    sum = sum + 1;
                    break;

            }
            i++;
        }
        
        return sum;

    }

    /**
     * Converts a decimal number "n" to roman numerals
     */
    public static String numToRoman(int n){

        String num = "";

        while (n > 0){

            if (n >= 1000){
                num = num + 'M';
                n = n-1000;
            } else if (n >= 500){
                num = num + 'D';
                n = n-500;
            } else if (n >= 100){
                num = num + 'C';
                n = n-100;
            } else if (n >= 50){
                num = num + 'L';
                n = n-50;
            } else if (n >= 10){
                num = num + 'X';
                n = n-10;
            } else if (n >= 5){
                num = num + 'V';
                n = n-5;
            } else {
                num = num + 'I';
                n = n-1;
            }

        }

        return num;

    }


    /**
     * Adds to roman numerals "num1" and "num2" together.
     */
    public static String add(String num1, String num2){
        String res = "";
        char[] letters = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};

        //Build up a new string using the support function
        for(char c:letters){
            res = res + createCharString(c, num1, num2);
        }

        //Replace all illegal instances of numbers

        //Hard but fun way of doing it
        res = replaceString(res, "IIIII", "V");
        res = replaceString(res, "VV", "X");
        res = replaceString(res, "XXXXX", "L");
        res = replaceString(res, "LL", "C");
        res = replaceString(res, "CCCCC", "D");
        res = replaceString(res, "DD", "M");


        //Easy way of doing it
        // res = res.replaceAll("IIIII", "V");
        // res = res.replaceAll("VV", "X");
        // res = res.replaceAll("XXXXX", "L");
        // res = res.replaceAll("LL", "C");
        // res = res.replaceAll("CCCCC", "D");
        // res = res.replaceAll("DD", "M");

        return res;
        

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
     * Takes a string and replaces the given pattern with a replacement string
     */
    public static String replaceString(String s1, String pattern, String rep){

        String res = "";
        String temp = "";
        boolean isSubtring = false;
        int j = 0;

    
        for (int i = 0; i < s1.length(); i++) {
            //If we have seen the whole pattern, replace it with rep
            if (j == pattern.length()) {
                System.out.println("Case 1");
                temp = "";
                res = res + rep;
                res = res + s1.charAt(i);
                isSubtring = false;
                j = 0;
            } else if (s1.charAt(i) == pattern.charAt(j)){

                //Found a character that matches the pattern, so isSubstring is true. Save the missing characters in temp
                isSubtring = true;
                temp = temp + s1.charAt(i);
                j++;
            } else {
                //If we see a character that does not match the pattern, but isSubstring is true, we insert the missing characters
                if (isSubtring){
                    res = res + temp;
                } 

                res = res + s1.charAt(i);
            
                temp = "";
                j = 0;
                isSubtring = false;
            }
        }

        //If isSubtring is true here, s1 have been run through, but nothing have been replaced, so we add the missing characters to the result
        if (isSubtring){
            res = res + temp;
        }

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