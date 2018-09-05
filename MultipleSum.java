import java.util.Scanner;

public class MultipleSum {

    public static void main(String[] args) {

        while(true) {

            //To take input from user
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter a number: 10 ");


            //
            // Check to see if the user input a valid number.
            //
            if (sc.hasNextInt()) {

                int x = sc.nextInt(); //Get number from user, 10, 100, or 1000

                System.out.println("[First] Sum of multiple of 3 or 5 = " + sum_first(x));
                System.out.println("[Second] Sum of multiple of 3 or 5 = " + sum_second(x));

            //
            // User input a string instead..
            //
            } else {

                System.out.println("Not a valid number, try again!");

                //System.out.println(PigLatinTranslator.pigLatin(sc.nextLine()));
                System.out.println(pigLatin(sc.nextLine()));


            }

        }

    }

    //Here we want to test the loop approach
    //O(n) - > time complexity or run time complexity
    private static int sum_first(int x) {

        int total = 0;
        int ctr = 0;

        //loop through all numbers from 1 to x
        for(int i = 1; i < x; i++) {

            //i = 1, 1 % 3 = 1
            //i = 2, 2 % 3 =2
            //i = 3, 3 % 3 = 0
            //i = 4,
            //i = 5, 5 % 3 = 2, 5 % 5 = 0
            //..
            //i = 9
            ctr++;

            if(i % 3 == 0 || i % 5 == 0) { //if number is divisible by 3 or 5

                total = total + i; //Add it to total

            }

        }

        System.out.println(ctr);

        return total;

    }

// Here we want to test a math approach
    //3,6,9 => sum = 3 * 3 * 4 / 2 = 18
    //3 + 6 + 9 = 18
    //10 / 3 = 3
    //10 / 5 = 2
    //O(1) - > time complexity or run time complexity
    private static int sum_second(int x) {
        int total = 0;
        //Number of divisibles of 3

        int numberOfMultipleOf3 = x / 3;
        if(x % 3 == 0) {
            //As we want less than given number
            numberOfMultipleOf3--;
        }

        int sumOfMultipleof3 = 3 * numberOfMultipleOf3 * (numberOfMultipleOf3 + 1) / 2;
        //Number of divisibles of 5

        int numberOfMultipleOf5 = x / 5;
        if(x % 5 == 0) {
            //As we want less than given number
            numberOfMultipleOf5--;
        }
        int sumOfMultipleof5 = 5 * numberOfMultipleOf5 * (numberOfMultipleOf5 + 1) / 2;

        //Number of divisibles of 15

        int numberOfMultipleOf15 = x / 15;
        if(x % 15 == 0) {
            //As we want less than given number
            numberOfMultipleOf15--;
        }
        //If the number is a multiple of both 3 and 5, only count it once so that it does not repeat as 15 is both a multiple of 3 and 5

        int sumOfMultipleof15 = 15 * numberOfMultipleOf15 * (numberOfMultipleOf15 + 1) / 2;
        total = sumOfMultipleof3 + sumOfMultipleof5 - sumOfMultipleof15;
        return total;
    }



    public static String pigLatin(String englishSentence) {
        StringBuilder latin = new StringBuilder();
        //Split sentence into words
        String [] words = englishSentence.split(" ");
        //["Hey,", "how", "are",  "you?",  "I'm",  "fine."]
        //["Beautiful", "21"] these are tests



        //Loop over all the words, and convert each word one-by-one into latin
        for(String word : words) {
            //Finding last character of the word
            //word = 21
            char lastChar = word.charAt(word.length() - 1); //1
            //Finding first character of the word
            char firstChar = word.charAt(0); //2

            //If first character is digit, it means it is a number.
            //Append it to string, without modifying
            if(Character.isDigit(firstChar)) {//true
                latin.append(word + " "); //21
                continue;
            }

            //If last character is string, then remove first character
            //and append it to end with "ay" as suffix
            if(Character.isLetter(lastChar)) { //true
                //word = "Beautiful"
                //word.substring(1) = "eautiful"
                ///eautiful + B  + ay + " " = eautifulBay
                latin.append(word.substring(1) + firstChar + "ay" + " ");
                continue;
            }

            //If last character is special symbol like ? , etc.
            //Take substring from second to last - 1 character
            //As last character is special symbol
            //Append first character with "ay" and special symbol at the end.
            //word.substring(1, word.length() - 1) = ey
            //word = Hey,
            //eyHay,
            //Hey, => ,yeH
            latin.append(word.substring(1, word.length() - 1) + firstChar + "ay" + lastChar + " ");
        }

        //Return converted word.
        return latin.toString().trim();
    }

}


