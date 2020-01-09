public class section5{

    public static void main(String[] args){
        String testString = "Hello World";
        String s1 = "Hello";
        String s2 = "Hello World";
        String s3 = "World";

        String perm1 = "dWolr";
        String perm2 = "World";
        char[] code = {'P', 'Y', 'K', 'U', 'N', 'M', 'R', 'H', 'V', 'G', 'A', 'D', 'L', 'C', 'O', 'Q', 'X', 'J', 'E', 'I', 'B', 'W', 'S', 'Z', 'F', 'T'};


        // //Task 1
        // System.out.println(count('l', testString));

        // //Task 2
        // System.out.println(member('l', testString));

        // //Task 3
        // System.out.println(isPrefix(s1, s2));

        // //Task 4
        // System.out.println(isSuffix(s2, s3));

        // //Task 5
        // System.out.println(isSubstring(s1, s2));

        // //Task 6
        // System.out.println(contains(s1, s2));

        // //Task 7
        // System.out.println(toUpperCaseEasy("This is test nr. 1"));
        // System.out.println(toUpperCase("This is test nr. 2"));

        // //Task 8
        // System.out.println(toLowerCase("AAZZ"));

        // //Task 9
        // System.out.println(toCamelCase("This is test String 1"));

        // //Task 10
        // System.out.println(equals(testString, s2));

        // //Task 11
        // System.out.println(equalsIgnoreCase("this is a test", "THIS IS A TEST"));

        // //Task 12
        // System.out.println(firstPosition('l', s2));

        // //Task 13
        // System.out.println(lastPosition('l', s2));

        // //Task 14
        // System.out.println(toString(positions('l', s2)));

        // //Task 15
        // System.out.println(isPermutation(perm1, perm2));

        // //Task 16
        // System.out.println(reverse(s2));

        // //Task 17
        // System.out.println(reverseWords(s2));

        // //Task 18
        // System.out.println(removeVowels(s2));

        // //Task 19
        // System.out.println(respace("Hello World!", 4));

        // //Task 20
        // System.out.println(shift(s2, 4));

        // //Task 21
        // System.out.println(shiftWords(s2, 2));

        // //Task 22
        // System.out.println(caesarCode(s2, 2));

        // //Task 23
        // System.out.println(encodeWithKey("a b c d", code));

        // //Task 24
        // System.out.println(encodeWithKey(encodeWithKey(s2, code), decode(code)));

        // //Task 25
        // System.out.println(toString(histogram("abcABC 123")));

        // //Task 26
        // System.out.println(replicate("abcde", new int[]{0,1,2,3,4}));

    }

    //Task 1
    public static int count(char c, String s){
        int i = 0;
        int count = 0;
        while (i < s.length()){
            if (s.charAt(i) == c){
                count++;
            }
            i++;
        }
        return count;
    }

    //Task 2
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

    //Task 3
    public static boolean isPrefix(String s1, String s2){
        boolean isPrefix = true;
        int i = 0;
        while (i < s1.length() && isPrefix){
            if (s1.charAt(i) != s2.charAt(i)){
                isPrefix = false;
            }
            i++;

        }
        return isPrefix;
    }

    //Task 4 - Luis solution, I do not think it works properly
    public static boolean isSuffixTest(String s1, String s2){
        boolean isSuffix = true;
        int i = s1.length()-1;
        while ((i > 0) && isSuffix){
            if (s1.charAt(i) != s2.charAt(i)){
                isSuffix = false;
            }
            i--;
        }
        return isSuffix;
    }

    //Task 4
    public static boolean isSuffix(String s1, String s2){
        boolean isSuffix = true;
        int i = 1;
        while (i < s2.length() && isSuffix){
            if (s1.charAt(s1.length()-i) != s2.charAt(s2.length()-i)){
                isSuffix = false;
            }
            i++;
        }
        return isSuffix;

    }

    //Task 5
    public static boolean isSubstring(String s1, String s2){
        boolean isSubstring = false;
        int i = 0;
        int j = 0;
        while (i < s2.length() && !isSubstring){
            if (j == s1.length()){
                isSubstring = true;
            } else if (s1.charAt(j) == s2.charAt(i)){
                j++;
            } else {
                j = 0;
            }
            i++;

        }
        return isSubstring;
    }

    //Task 6
    public static boolean contains(String s1, String s2){
        int i = 0;
        int j = 0;
        while ((i < s1.length()) && (j < s2.length())){
            if (s1.charAt(i) == s2.charAt(j)){
                j++;
            }
            i++;
        }
        return (j == s2.length());
    }

    //Task 7 - Easy way
    public static String toUpperCaseEasy(String s){
        return s.toUpperCase();
    }

    //Task 7 - The way the exercise is supposed to be solved
    public static String toUpperCase(String s){
        String upperCase = "";
        int i = 0;
        while (i < s.length()){
            if (('a' < s.charAt(i)) && (s.charAt(i) < 'z')){
                upperCase = upperCase + (char)(s.charAt(i)-32);
            } else {
                upperCase = upperCase + s.charAt(i);
            }
            i++;
        }
        return upperCase;
    }

    //Task 8
    public static String toLowerCase(String s){
        String lowerCase = "";
        int i = 0;
        while (i < s.length()){
            if (('A' <= s.charAt(i)) && (s.charAt(i) <= 'Z')){
                lowerCase = lowerCase + (char)(s.charAt(i)+32);
            } else {
                lowerCase = lowerCase + s.charAt(i);
            }
            i++;
        }
        return lowerCase;
    }

    //Task 9
    public static String toCamelCase(String s){
        String camelCase = "";
        int i = 0;
        boolean removedSpace = false;
        while (i < s.length()){
            if (s.charAt(i) == ' '){
                removedSpace = true;
            } else if (removedSpace){
                if (('a' < s.charAt(i)) && (s.charAt(i) < 'z')){
                    camelCase = camelCase + (char)(s.charAt(i)-32);
                } else {
                    camelCase = camelCase + s.charAt(i);
                }
                removedSpace = false;
            } else {
                camelCase = camelCase + s.charAt(i);
            }
            i++;

        }
        return camelCase;
    }

    //Task 10
    public static boolean equals(String s1, String s2){
        boolean equal = (s1.length() == s2.length());
        int i = 0;
        while (i < s1.length() && equal){
            if (s1.charAt(i) != s2.charAt(i)){
                equal = false;
            }
            i++;
        }
        return equal;
    }

    //Task 11
    public static boolean equalsIgnoreCase(String s1, String s2){
        return equals(toUpperCase(s1), toUpperCase(s1));
    }

    //Task 12
    public static int firstPosition(char c, String s){
        int i = 0;
        int pos = -1;
        boolean found = false;
        while (i < s.length() && !found){
            if (s.charAt(i) == c){
                pos = i;
                found = true;
            }
            i++;
        }
        return pos;

    }

    //Task 13
    public static int lastPosition(char c, String s){
        int i = s.length()-1;
        int pos = -1;
        boolean found = false;
        while (i >= 0 && !found){
            if (s.charAt(i) == c){
                pos = i;
                found = true;
            }
            i--;
        }

        return pos;
    }

    //Copied over from section4.java
    public static String toString(int[] v){
        String res = "";
        int i = 0;
        while (i < v.length-1){
            res = res + v[i] + ", ";
            i++;
        } 
        res = res + v[i];
        return res;
    }

    //Task 14
    public static int[] positions(char c, String s){
        int i = 0;
        int[] positions = new int[s.length()];
        int j = 0;

        while (i < s.length()){
            if (s.charAt(i) == c){
                positions[j] = i;
                j++;
            }
            i++;

        }

        i = 0;
        int[] res = new int[j];

        while (i < j){
            res[i] = positions[i];
            i++;
        }
        return res;
    }

    //Task 15
    public static boolean isPermutation(String s1, String s2){
        int i = 0;
        boolean isPermutation = true;
        while (i < s1.length() && isPermutation){
            if (!member(s1.charAt(i), s2)){
                isPermutation = false;
            } else {
                s2 = removeChar(s1.charAt(i), s2);
            }
            i++;
        }

        return isPermutation;

    }

    //Support function for task 15 - Removes one instance of a character
    public static String removeChar(char c, String s){
        int i = 0;
        String res = "";
        boolean removed = false;
        while (i < s.length()){
            if (!removed && s.charAt(i) == c){
                removed = true;
            } else {
                res = res + s.charAt(i);
            }

            i++;
        }
        return res;
    }

    //Task 16
    public static String reverse(String s){
        int i = s.length()-1;
        String reverse = "";
        while (i >= 0){
            reverse = reverse + s.charAt(i);
            i--;
        }
        return reverse;
    }

    //Task 17
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

    //Support function for task 17 - Splits string into multiple strings at a specific character
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

    //Task 18
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

    //Task 19
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

    //Task 20
    public static String shift(String s, int n){
        int shift = n % s.length();
    
        return s.substring(s.length()-n, s.length()) + s.substring(0, shift) + s.substring(shift, s.length()-n);
    }

    //Task 21
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

    //Task 22
    public static String caesarCode(String s, int n){
        int i = 0;
        String caesar = "";

        while (i < s.length()){
            caesar = caesar + (char)(s.charAt(i)+n);
            i++;
        }
        return caesar;

    }

    //Task 23
    public static String encodeWithKey(String s, char[] code){
        int i = 0;
        String encoded = "";

        while (i < s.length()){
            if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z'){
                encoded = encoded + code[s.charAt(i)-'A'];
            } else if ('a' <= s.charAt(i) && s.charAt(i) <= 'z'){
                encoded = encoded + (char)(code[s.charAt(i)-'a']+32);
            } else {
                encoded = encoded + s.charAt(i);
            }
            i++;
        }
        return encoded;
    }

    //Task 24
    public static char[] decode(char[] code){
        char[] decode = new char[26];
        int i = 0;

        while (i < code.length){
            // System.out.println(code[i]+" "+(code[i]-'A')+" "+((char)('A'+i)));
            decode[code[i]-'A'] = (char)('A'+i);

            i++;
        }

        return decode;

    }

    //Task 25
    public static int[] histogram(String s){
        int i = 0;
        int[] res = new int[27];

        s = toLowerCase(s);

        while (i < s.length()){
            if ('a' <= s.charAt(i) && s.charAt(i) <= 'z'){
                res[s.charAt(i)-'a'+1]++;
            } else {
                res[0]++;
            }
            i++;
        }
        return res;

    }

    //Task 26
    public static String replicate(String s, int[] v){
        int i = 0;
        int j = 0;
        String replicate = "";
        while (i < s.length()){

            while (j < v[i]){
                replicate = replicate + s.charAt(i);
                j++;
            }
            j = 0;
            i++;
        }
        return replicate;
    }

}