 import java.util.Scanner;


    public class PigLatinTranslator {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in); //To take input from user
            System.out.println("Enter english sentence to translate: Hey Jenn. How are you? ");
            String englishSentence = sc.nextLine(); //english sentence reading from console
            System.out.println("Translated to:\n" + pigLatin(englishSentence)); //Tranlating into piglatin
        }

        /*
        * englishSentence = "Hey, how are you? I'm fine."
        * */

        public static String pigLatin(String englishSentence) {
            StringBuilder latin = new StringBuilder();
            //Split sentence into words
            String [] words = englishSentence.split(" ");
            //["Hey,", "how", "are",  "you?",  "I'm",  "fine."]
            //["Beautiful", "21"]



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
