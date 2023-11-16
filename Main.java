import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
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
                        
                        break;
                    case 2: // Balance
                        
                        break;
                    case 3: // Deposit
                        
                        break;
                    case 4: // Witthdraw
                        
                        break;
                    case 5: // Account Info
                        
                        break;
                    case 6: // Close/Delete Account
                        
                        break;
                    case 7: // Exit
                        System.out.println("Thank you for using WeLiveWeLoveWeLie Banking Corporation!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid input. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
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