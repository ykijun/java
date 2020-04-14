package lab5;
import java.util.Scanner;
import java.util.Random;
import java.util.Date;

import static java.lang.Character.isDigit;

public class StringLab{
    // use a static Scanner object shared by all the methods, close at the end of main()
    // Just like in lab2, if we create a new scanner object in each method and then close the object before leaving the method,
    // the input stream (System.in) will be closed, and there is no way to reopen it again.
    static Scanner sc=new Scanner(System.in);


    public static void numberPalindrome() {
        // Method Description:
        // Assume user inputs always correct
        // this method checks to see if the numerical digits in the input string forms a palindrome
        // - for example, the pure numerical string "12321" is a palindrome because whether you read it
        // from the left or from the right it is the same number. Your method should output
        // "The string is palindrome in its numerical digits [12321] !" in this case.
        // - Another example, the string "asdas1wekwe%@qk2ewqlwqe1" is also a palindrome in the numerical digits
        // because in the numerical digits it is "121". Your method should output
        // "The string is palindrome in its numerical digits [121] !" in this case.
        // some of the code is provided below, you can choose to use them, or not to use them.
        // - The third example, if the user enters the string "asdas", there is no numerical digits in it, your method
        // should output
        //"The string is not palindrome in its numerical digits [] !"
        System.out.println("<<<<<<Numerical Palindrome check>>>>>");
        System.out.println("Please enter your string:");

        Scanner reader = new Scanner(System.in); // Scanner is used for Java input
        String input="";      //init local variable String, this String obj holds the original user input
        String cleanInput=""; // init local variable String, this String obj holds the cleaned input containing only digits
        input = reader.next(); // read the user input as a String object
        boolean isPalindrome= true; // initialize the local boolean variable in this method

        // TODO 1:
        //       You need to finish the implementation of this method according to the method description above
        //       You can not write any helper functions/methods.
        //       everything must be self-contained in this numberPalindrom() method itself.
        //       hints:
        //       1. you may find the length() method of the string object useful in finding number of characters of the
        //          string object by using that length() method of a string and a for-loop you can transverse all the
        //          individual characters of a string object.
        //       2. if you wish to retrieve the i-th character of a string, you can use strObj.charAt(i), where strObj
        //          is a reference to a String
        //       3. there is a static method Character.isDigit() which is useful in checking whether a letter is a
        //           numerical digit. Character.isDigit('1') will return boolean true, while Character.isDigit('E')
        //           will return boolean false, a similar Character.isLetterOrDigit() method is used in the String
        //           note set slide 25.

        for (int i = 0; i < input.length(); i++){
            if (isDigit(input.charAt(i))){
                cleanInput = cleanInput + input.charAt(i);
            }
        }
        for(int i = 0; i < cleanInput.length()/2;i++){
            if (cleanInput.charAt(i) != cleanInput.charAt(cleanInput.length()-1-i)){
                isPalindrome = false;
            }
        }

        if (isPalindrome){
            System.out.println("The string is palindrome in its numerical digits [" + cleanInput + "] !");
        }
        else{
            System.out.println("The string is not palindrome in its numerical digits [" + cleanInput +"] !");
        }
    }


    public static void hexadecimalToBinary(){
        // Method Description:
        // Assume user inputs always correct, your method should be *case insensitive* to the entered string.
        // This method converts a user entered hexadecimal number to the corresponding binary number and outputs the
        // binary number. By default it assume all inputs are *hexadecimal numbers*
        // - For example input string "FF0A", it will be converted to the corresponding binary string and the method
        // output:
        // "The Hexadecimal string FF0A is the same as the Binary string: 1111 1111 0000 1010 "
        // - Another example, if the input string is "1234", it should output the following:
        // "The Hexadecimal string 1234 is the same as the Binary string: 0001 0010 0011 0100 "
        // - The third example, if the input string is "ab01", it should output:
        // "The Hexadecimal string ab01 is the same as the Binary string: 1010 1011 0000 0001 "
        // Provided binary string array for free you can use it or NOT to use it
        String [] binaryStrings={"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};

        System.out.println("<<<<<<Hexadecimal to Binary converter>>>>>>");
        System.out.println("Please enter your string:");

        String input=sc.nextLine();
        input=input.trim();         // clear the whitespaces at the left and at the right


        //TODO 2:
        //       You need to finish the implementation of the method according to the description above
        //       You can not write any helper functions/methods.
        //       everything must be self-contained in this hexadecimalToBinary() method itself.
        //       hints:
        //       1. each hexadecimal digit corresponds to exact *4 binary digits*.
        //       2. if converting a char to string is useful, you can use the static method of the String class:
        //          String.valueof(c), where c is a char variable holding a char. This method is being used on the
        //          4th line of the program shown on slide 21 of the strings note set.
        //       3. if converting a hexademcial digit to the corresponding decimal number would be helpful,
        //          then you can use the static method Integer.parseInt(h,16) useful, where h is a string
        //          holding a single hexadecimal digit. A similar method will be covered on slide 31 of the strings
        //          note set.
        String binary = "";
        for (int i = 0; i < input.length();i++){
            binary += binaryStrings[Integer.parseInt(String.valueOf(input.charAt(i)),16)];
            binary += " ";
        }
        System.out.println("The Hexadecimal string " + input + " is the same as the Binary string: " + binary +"\"");
    }


    public static void countMostFreqChar(){
        // Method Description:
        // Assume user inputs always correct and user only enters English letters [A-Z,a-z],
        // your method should be *case insensitive* to the entered string
        // This method read a user input string and outputs the most frequent character in the string.
        //
        // - For example if the input string is "aAaAba", it will output:
        // "The most frequent character is A and it appears for 5 times"
        // - Another example, if the input string is "abababababABcab", it should output:
        // "The most frequent character is A and it appears for 7 times"
        // in this example, in fact both 'A' and 'B' appear for 7 times, when they have the same frequency, this method
        // outputs the letter that is earlier in the alphabetical order (i.e. it displays 'A' instead of 'B' as the most
        // frequent character).
        // some of the code is provided below, you can choose to use them, or not to use them.
        int[] count=new int[26]; // count[0] frequency of character 'a', count[1] frequency of character 'b',...
        int mostFreq=0;
        int max;

        System.out.println("<<<<<<The most frequent character>>>>>>");
        System.out.println("Please enter your string:");
        String input=sc.nextLine();
        input=input.trim();


        //TODO 3:
        //       You need to finish the implementation of the method according to the description above
        //       You can not write any helper functions/methods.
        //       everything must be self-contained in this hexadecimalToBinary() method itself.
        //       hints:
        //       1.  You can convert all the characters of a string object to the upper case using the toUpperCase()
        //           method. For example input.toUpperCase() will convert all the english letters in the "input"
        //           string to upper case. if input is holding "abcd12", then after running the method, the string
        //           will be holding "ABCD12"
        //       2. to find the length of an array you use the length instance variable of the array (i.e. array.length,
        //          where array is the reference to an array).
        //          to find the length of a string, you use the length() instance method of the String class (i.e.
        //          str.length(), where str is a reference to a String.

        input = input.toUpperCase();
        for (int i = 0; i < input.length(); i++){
            int charVal = input.charAt(i);
            if(charVal> 64 && charVal< 91){
                count[charVal-65]++;
                System.out.println(count[charVal-65]);
            }

        }
        max = 0;
        for (int i = 0; i < 26; i++){
            if (mostFreq < count[i]){
                max = i + 65;
                mostFreq = count[i];
            }
        }
        char freqAlphabet = (char)max;
        System.out.println("The most frequent character is " + freqAlphabet + " and it appears for " + mostFreq + " times");
    }


    public static void runLengthDecode(){
        // Method Description:
        // Assume user inputs always correct,
        // assume there will never be a string such as "1a", with the exact value "1" at the left of the character 'a',
        // because if the character 'a' does not repeat, adding a "1" to the left of 'a' will use up more memory space
        // than just having "a".
        // This method gets a run length encoded string and decode it to show the complete original string.
        // - For example for the run length encoded string "12E5A7C", the number "12" in front of 'E' indicates there
        // are 12 E's in the original string, and "5" in front of 'A' indicates there are 5 A's in the original string.
        // Then this method should output the following:
        // "The original String is: EEEEEEEEEEEEAAAAACCCCCCC"
        // - Another example, if you input the string "ABC7D" to this method, it should output the following:
        //"The original String is: ABCDDDDDDD"
        // - The third example, if you input the string "a2b2Ac", it should output the following:
        //"The original String is: abbAAc"
        // You should assume in front of each character ('A' in the previous examples), there could be arbitrary number
        // of  digits (could be no digit in from of the character, or 1 digit, 2 digits, 3 digits, and so on...)
        // some of the code is provided below, you can choose to use them, or not to use them.
        System.out.println("<<<<<<Run Length Decoder>>>>>>");
        System.out.println("Please enter your string:");
        char[] input = sc.nextLine().toCharArray(); // putting the user input string into a char array
        int index=0;
        String temp="";

        // TODO 4:
        //       You need to finish the implementation of the method according to the description above
        //       You can not write any helper functions/methods.
        //       everything must be self-contained in this runLengthDecode() method itself.
        //       hints:
        //       1. the "input" reference provided above is an *array* of char, to find the length of an array, you need
        //          to use the length *instance variable* (the length() method is for string objects).
        //       2. there is a static method Character.isDigit() that will be useful in checking whether a character is a
        //          numerical digit. Character.isDigit('1') will return boolean true, while Character.isDigit('E')
        //          will return boolean false. A similar Characeter.isLetterOrDigit() method is used in the String
        //          note set slide 25.
        //       3. there is a static method Integer.parseInt() that will be useful to convert a string into the
        //          corresponding integer. You may want to use it to convert the numerical digit(s) in front of a
        //          character to Integers. And then use that to output the character for correct number of times.
        //       4. it is possible that a character is not preceded by any numerical digit, in that case you need to
        //          output the character once in this method.

        for (int i = 0; i < input.length; i++){
            if (isDigit(input[i])){
                index = index * 10 + Integer.parseInt(String.valueOf(input[i]));
            }
            else{
                if (index==0){
                    temp += input[i];
                }
                else {
                    for (int j = 0; j < index; j++) {
                        temp += input[i];
                    }
                    index = 0;
                }
            }
        }
        System.out.println(temp);
    }



    //You should not change any part of the code in this main() method
    //You can not add new methods to this class
    public static void main(String[] args){
        String input="";

        while (!input.equals("Q")) {
            System.out.println("=================String Operations================");
            System.out.println("1. Check whether all the numerical digits in a string form a palindrome");
            System.out.println("2. Convert a hexadecimal string to a binary string");
            System.out.println("3. Count the most frequent character in a string");
            System.out.println("4. RunLength decoding");
            System.out.println("=================String Operations=================");
            System.out.println("Please enter 1,2,3 or 4 to select an option");
            System.out.println("Enter \"Q\" to terminate the program");
            input = sc.nextLine();

            switch (input) {
                case "1":
                    numberPalindrome();
                    break;
                case "2":
                    hexadecimalToBinary();
                    break;
                case "3":
                    countMostFreqChar();
                    break;
                case "4":
                    runLengthDecode();
                    break;
                case "Q":
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }

}