import java.util.Scanner;

public class TextAdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Text Adventure Game!");
        System.out.println("You find yourself in a dark cave. You see two paths ahead.");

        // Decision point 1
        System.out.println("1. Take the left path");
        System.out.println("2. Take the right path");

        int decision1 = getUserChoice(scanner, 2);

        if (decision1 == 1) {
            // Outcome for left path
            System.out.println("You find a treasure chest! Congratulations, you're rich!");
        } else {
            // Outcome for right path
            System.out.println("Uh-oh! A monster appears and chases you. You barely escape.");
        }

        // Decision point 2
        System.out.println("You continue your journey and reach a crossroads.");
        System.out.println("1. Go straight ahead");
        System.out.println("2. Turn back");

        int decision2 = getUserChoice(scanner, 2);

        if (decision2 == 1) {
            // Outcome for going straight
            System.out.println("You discover a hidden passage. It leads you to safety.");
        } else {
            // Outcome for turning back
            System.out.println("You encounter a dead-end. It's a trap! Game over.");
        }

        System.out.println("Thanks for playing the Text Adventure Game!");
    }

    // Function for getting user choice with error handling
    private static int getUserChoice(Scanner scanner, int maxChoice) {
        int userChoice = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                if (userChoice >= 1 && userChoice <= maxChoice) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and " + maxChoice + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }

        return userChoice;
    }
}
