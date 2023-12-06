import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String description;
    double amount;
    String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }
}

class ExpenseTracker {
    private ArrayList<Expense> expenses;

    public ExpenseTracker() {
        this.expenses = new ArrayList<>();
    }

    // Method to add a new expense to the list
    public void addExpense(String description, double amount, String category) {
        Expense newExpense = new Expense(description, amount, category);
        expenses.add(newExpense);
        System.out.println("Expense added successfully!");
    }

    // Method to view all recorded expenses
    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
        } else {
            System.out.println("----- Expense List -----");
            for (Expense expense : expenses) {
                System.out.println("Description: " + expense.description);
                System.out.println("Amount: Rs." + expense.amount);
                System.out.println("Category: " + expense.category);
                System.out.println("------------------------");
            }
        }
    }

    // Method to calculate the total expense for a specific category
    public double getExpenseTotalForCategory(String category) {
        double total = 0;
        for (Expense expense : expenses) {
            if (expense.category.equalsIgnoreCase(category)) {
                total += expense.amount;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        ExpenseTracker expenseTracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);

        // Menu-driven loop for user interaction
        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Expense Summaries");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add expense option
                    System.out.print("Enter Expense Description: ");
                    scanner.nextLine(); // consume newline
                    String description = scanner.nextLine();
                    System.out.print("Enter Expense Amount: Rs.");
                    double amount = scanner.nextDouble();
                    System.out.print("Enter Expense Category: ");
                    scanner.nextLine(); // consume newline
                    String category = scanner.nextLine();
                    expenseTracker.addExpense(description, amount, category);
                    break;
                case 2:
                    // View all expenses option
                    expenseTracker.viewExpenses();
                    break;
                case 3:
                    // View expense summary option
                    System.out.print("Enter Category for Summary: ");
                    scanner.nextLine(); // consume newline
                    String summaryCategory = scanner.nextLine();
                    double total = expenseTracker.getExpenseTotalForCategory(summaryCategory);
                    System.out.println("Total Expenses for Category " + summaryCategory + ": Rs." + total);
                    break;
                case 4:
                    // Exit option
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    // Invalid option
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
