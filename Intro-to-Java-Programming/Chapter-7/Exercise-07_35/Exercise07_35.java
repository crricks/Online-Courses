
/*********************************************************************************
* (Game: hangman) Write a hangman game that randomly generates a word and        *
* prompts the user to guess one letter at a time, as shown in the sample run.    *
* Each letter in the word is displayed as an asterisk. When the user makes a     *
* correct guess, the actual letter is then displayed. When the user finishes a   *
* word, display the number of misses and ask the user whether to continue to     *
* play with another word. Declare an array to store words, as follows:           *
*********************************************************************************/

import java.util.Scanner;

public class Exercise07_35 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            String word = getWord();
            char[] progress = getStart(word);
            int wrong = 0;
            
            while (!word.equals(printGuess(progress))) {
                System.out.println("(Guess) Enter a letter in word " + printGuess(progress) + ">");
                char guess = sc.nextLine().charAt(0);
                if (correct(word, guess)) {
                    progress = updateWord(word, guess, progress);
                } else {
                    wrong++;
                    System.out.println(guess + " is not in the word");
                }
            }
            System.out.printf("The word is %s. ", word);
            System.out.println("You missed " + wrong + ((wrong == 1) ? " time." : " times."));
            System.out.println("Do you want to play again? y or n?");
            
            if (sc.nextLine().equals("n")) {
                break;
            }
        }
    }
    
    public static String getWord() {
        String[] words = {"test", "fun", "program"};
        int index = (int) Math.random() * words.length;
        return words[index];
    }
    
    public static char[] getStart(String word) {
        char[] progress = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            progress[i] = '*';
        }
        return progress;
    }
    
    public static String printGuess(char[] progress) {
        String print = "";
        for (char letter : progress) {
            print += letter;
        }
        return print;
    }
    
    public static boolean correct(String word, char guess) {
        if (word.indexOf(guess) > -1) {
            return true;
        }
        return false;
    }
    
    public static char[] updateWord(String word, char guess, char[] progress) {
        if (alreadyGuessed(progress, guess)) {
            System.out.println(guess + " is already in the word");
        } else {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    progress[i] = guess;
                }
            }
        }
        return progress;
    }
    
    public static boolean alreadyGuessed(char[] progress, char guess) {
        if (java.util.Arrays.binarySearch(progress, guess) > -1) {
            return true;
        } 
        return false;
    }
    
}
