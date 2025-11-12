
import java.util.Scanner;
public class atm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pin = 1234;
        int attempts = 3;
    
        boolean authenticated = false;
        while (attempts > 0 && !authenticated) {
            System.out.print("Enter your PIN: ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter numeric PIN.");
                sc.next();
                continue;
            }
            int inputPin = sc.nextInt();
            if (inputPin == pin) {
                authenticated = true;
            } else {
                attempts--;
                System.out.println("Incorrect PIN. Attempts left: " + attempts);
            }
        }
        if (authenticated) {
            System.out.println("Too many incorrect attempts. Card blocked.");
            sc.close();
            return;
        }
        double balance = 100000.00;
        while (true) {
            System.out.println();
            System.out.println("=== ATM MENU ===");
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw amount");
            System.out.println("3. Deposit amount");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            if (sc.hasNextInt()) {
                System.out.println("Invalid option. Please enter a number 1-4.");
                sc.next();
                continue;
            }
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.printf("Your balance is: %.2f%n", balance);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid amount.");
                        sc.next();
                        break;
                    }
                    double withdrawAmount = sc.nextDouble();
                    if (withdrawAmount <= 0) {
                        System.out.println("Enter an amount greater than 0.");
                    } else if (withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        System.out.printf("Please collect your cash. New balance: %.2f%n", balance);
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid amount.");
                        sc.next();
                        break;
                    }
                    double depositAmount = sc.nextDouble();
                    if (depositAmount <= 0) {
                        System.out.println("Enter an amount greater than 0.");
                    } else {
                        balance += depositAmount;
                        System.out.printf("Amount deposited successfully. New balance: %.2f%n", balance);
                    }                case 4:
                    System.out.println("Thank you for using the ATM. ");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}