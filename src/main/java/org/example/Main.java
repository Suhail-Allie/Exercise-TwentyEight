package org.example;
/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import java.util.Random;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"java", "hangman", "code", "game"};
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            String word = words[random.nextInt(words.length)];
            char[] displayWord = new char[word.length()];
            for (int i = 0; i < displayWord.length; i++) displayWord[i] = '*';

            int misses = 0;
            final int MAX_MISSES = 6;

            while (misses < MAX_MISSES && new String(displayWord).contains("*")) {
                System.out.println("Word: " + new String(displayWord));
                System.out.print("Guess a letter: ");
                char guess = scanner.next().charAt(0);
                boolean found = false;

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        displayWord[i] = guess;
                        found = true;
                    }
                }

                if (!found) misses++;
            }

            if (misses == MAX_MISSES) {
                System.out.println("Game over! The word was: " + word);
            } else {
                System.out.println("Congratulations! The word is: " + new String(displayWord));
            }

            System.out.print("Play again? (yes/no): ");
            scanner.nextLine(); // Clear the buffer
            playAgain = scanner.nextLine().trim().equalsIgnoreCase("yes");
        }

        scanner.close();
        System.out.println("Thanks for playing!");
    }
}
