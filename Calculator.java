import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Input two numbers
        System.out.print("Enter the first number: ");
        double n1 = s.nextDouble();
        System.out.print("Enter the second number: ");
        double n2 = s.nextDouble();

        // Choose the operation
        System.out.println("Choose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        System.out.print("Enter the operation number: ");
        int operation = s.nextInt();

        // Perform the operation and display the result
        double result = 0;
        switch (operation) {
            case 1:
                result = n1 + n2;
                break;
            case 2:
                result = n1 - n2;
                break;
            case 3:
                result = n1 * n2;
                break;
            case 4:
                if (n2 != 0) {
                    result = n1 / n2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    return;
                }
                break;
            default:
                System.out.println("Error: Invalid operation choice.");
                return;
        }

        System.out.println("Result: " + result);
    }
}