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
                        String fName = "" , add = "", bday = "", gen = "", accType = "", pin = "";
                        double bal = 0;
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
                        sc.nextLine();
                        while (true) {
                                String pinInput = sc.nextLine();
                                if (pinInput.matches("\\d{6}")) {
                                    pin = pinInput;
                                    break;
                                } else {
                                    System.out.println("Please enter a valid 6-digit pin.");
                                }
                        }

                        //Verify information

                        System.out.println("Please verify all information that you have provided: ");
                        System.out.println("Full Name: " + fName);
                        System.out.println("Address: " + add);
                        System.out.println("Birthday: " + bday);
                        System.out.println("Gender: " + gen);
                        System.out.println("Account Type: " + accType);
                        System.out.println("Initial Deposit: " + bal);
                        System.out.println("Pin: " + pin);

                        System.out.println("Is the information correct? (Y/N)");
                        String verify = sc.nextLine();
                        if (verify.equalsIgnoreCase("N")) {
                            System.out.println("Please try again.");
                            break;
                        }

                        //Inforrmation verified and creating account
                        accountNumber = AccountInterface.accId;

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

                        System.out.println("Account created successfully! Your account number is " + accountNumber);
                        pause();
                        break;
                    case 2: // Balance
                        
                        break;
                    case 3: // Deposit
                        
                        break;
                    case 4: // Witthdraw
                        
                        break;
                    case 5: // Account Info
                        System.out.println("Please enter account number: ");
                        String accNum = sc.nextLine();

                        //Add Pin verification

                        fr = new BufferedReader(new FileReader("Accounts\\" + accNum + ".txt"));
                        String chr;
                        int line = 1;

                        while ((chr = fr.readLine()) != null) {
                            if(line == 1) System.out.print("Account Number: ");
                            else if(line == 2) System.out.print("Name: ");
                            else if(line == 3) System.out.print("Address: ");
                            else if(line == 4) System.out.print("Birthday: ");
                            else if(line == 5) System.out.print("Gemder: ");
                            else if(line == 6) System.out.print("Account Type:");
                            else if(line == 7) System.out.print("Initial Deposit: ");
                            else if(line == 8) System.out.print("Current Balance: ");
                            System.out.println(chr);
                            line++;
                        }
                        fr.close();
                        break;
                    case 6: // Close/Delete Account
                        
                        break;
                    case 7: // Exit
                        System.out.println("Thank you for using WeLiveWeLoveWeLie Banking Corporation!");
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
        sc.close();
    }

}