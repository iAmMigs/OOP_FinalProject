import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<Account>();
        boolean exit = false;
        BufferedReader fr;
        FileWriter fw;
        while (!exit) {
            int input;
            clearScreen();
            System.out.println("$$$-----------------------------------------------$$$");
            System.out.println("Welcome to the WeLiveWeLoveWeLie Banking Corporation!");
            System.out.println("$$$-----------------------------------------------$$$");
            System.out.println("|||                      Menu                     |||");
            System.out.println("|||  1. Create Account        2. Balance Inquiry  |||");
            System.out.println("|||  3. Deposit               4. Withdraw         |||");
            System.out.println("|||  5. Account Information   6. Close Account    |||");
            System.out.println("|||  7. Exit                                      |||");
            System.out.println("$$$-----------------------------------------------$$$");
            System.out.println("What would you like to do today?");
            try {
                input = sc.nextInt();

                switch (input) {
                    case 1: // Create Account
                        String fullName, address, birthday, gender, accType;
                        double bal;
                        int pin;

                        System.out.println("Please enter your full name: ");
                        sc.nextLine();
                        fullName = sc.nextLine();

                        System.out.println("Please enter your address: ");
                        address = sc.nextLine();

                        System.out.println("Please enter your birthday (yyyy/MM/dd): ");
                        birthday = sc.nextLine();

                        System.out.println("Please enter your gender: ");
                        gender = sc.nextLine();

                        System.out.println("Please enter your account type: ");
                        accType = sc.nextLine();

                        System.out.println("Please enter your initial balance: ");
                        bal = sc.nextDouble();

                        System.out.println("Please enter your PIN: ");
                        pin = sc.nextInt();

                        Account newAccount = new Account(fullName, address, birthday, gender, accType, bal, pin);
                        accounts.add(newAccount);

                        System.out.println("Account created successfully!");

                        pause();

                        break;
                    case 2: // Balance
                        
                        break;
                    case 3: // Deposit
                        
                        break;
                    case 4: // Witthdraw
                        
                        break;
                    case 5: // Account Info
                    
                    System.out.println("Account Information:");

                    if (accounts.isEmpty()) {
                        System.out.println("No accounts found.");
                    } else {
                        for (Account account : accounts) {
                            System.out.println("Account Holder: " + account.getFullName());
                            System.out.println("Address: " + account.getAddress());
                            System.out.println("Birthday: " + account.getBirthday());
                            System.out.println("Gender: " + account.getGender());
                            System.out.println("Account Type: " + account.getAccountType());
                            System.out.println("Balance: $" + account.getBalance());
                            System.out.println("PIN: " + account.getPin());
                            System.out.println("-----------------------------");
                        }
                    }
            
                    pause();

                    break; 
                    case 6: // Close/Delete Account
                        
                        break;
                    case 7: // Exit
                        System.out.println("Thank you for using WeLiveWeLoveWeLie Banking Corporation!");
                        sc.next();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input. Please try again.");
                        break;
                }
            } catch (InputMismatchException /*| IOException*/ e) {
                System.out.println("Invalid input. Please try again.");
                sc.nextLine();
                pause();
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pause() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press enter to continue...");
        sc.nextLine();
    }
}