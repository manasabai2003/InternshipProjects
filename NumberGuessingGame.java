import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random random = new Random();

        // Set the range for the random number
        int minRange = 1;
        int maxRange = 100;

        // Generate a random number within the specified range
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between " + minRange + " and " + maxRange);

        int userGuess;
        int attempts = 0;

        do {
            System.out.print("Enter your guess: ");
            userGuess = s.nextInt();
            attempts++;

            // Provide feedback on the user's guess
            if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
            }

        } while (userGuess != randomNumber);

        s.close();
    }
}