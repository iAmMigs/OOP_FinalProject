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
                sc.nextLine();
                switch (input) {
                    case 1: // Create Account
                        String fName = "" , add = "", bday = "", gen = "", accType = "";
                        double bal = 0;
                        Integer pin = 0;
                        int accountNumber = 0;

                        System.out.println("Please enter your full name: ");
                        fName = sc.nextLine();
                        System.out.println("Please enter your address: ");
                        add = sc.nextLine();
                        System.out.println("Please enter your birthday: ");
                        bday = sc.nextLine();
                        System.out.println("Please enter your gender: ");
                        gen = sc.nextLine();
                        System.out.println("Please enter your account type: ");
                        accType = sc.nextLine();

                        //Lagyan ng if statement para sa account type
                        System.out.println("Please enter your initial deposit: ");
                        bal = sc.nextDouble();
                        System.out.println("Please enter your pin: ");
                        
                        while (pin < 100000 || pin > 999999) {
                            try {
                                String pinInput = sc.nextLine();
                                if (pinInput.matches("\\d{6}")) {
                                    pin = Integer.parseInt(pinInput);
                                } else {
                                    System.out.println("Please enter a valid 6-digit pin.");
                                }
                            } catch (NumberFormatException | InputMismatchException e) {
                                System.out.println("Please enter a valid 6-digit pin.");
                            }
                        }
                        
                        //Lagyan ng if statement para sa pin

                        //More statements hanggang verified lahat

                        accountNumber = AccountInterface.accdId;

                        Account account = new Account(fName, add, bday, gen, accType, bal, pin, accountNumber);

                        fw = new FileWriter("Accounts\\" + accountNumber + ".txt");
                        fw.write(fName + "\n");
                        fw.write(add + "\n");
                        fw.write(bday + "\n");
                        fw.write(gen + "\n");
                        fw.write(accType + "\n");
                        fw.write(bal + "\n");
                        fw.write(pin + "\n");
                        fw.close();

                        accounts.add(account);
                        //System.out.println("Account created successfully!");
                        //sc.next();
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
                        sc.next();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input. Please try again.");
                        break;
                }
            } catch (InputMismatchException | IOException e) {
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