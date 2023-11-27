import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

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
                        double bal = 0, initial = 0;
                        int accountNumber = 0;

                        //General information
                        System.out.println("Please enter your full name: ");
                        fName = sc.nextLine();
                        System.out.println("Please enter your address: ");
                        add = sc.nextLine();
                        System.out.println("Please enter your birthday (MM/DD/YYYY): ");
                        bday = sc.nextLine();
                        System.out.println("Please enter your gender: ");
                        gen = sc.nextLine();

                        //Account information
                        System.out.println("Please enter your account type ( SA - Savings | CA - Current Account): ");
                        while(true){
                            String accTypeInput = sc.nextLine();
                            if(accTypeInput.equalsIgnoreCase("SA") || accTypeInput.equalsIgnoreCase("CA")){
                                accType = accTypeInput;
                                break;
                            }
                            else{
                                System.out.println("Please enter a valid account type.");
                            }
                        }

                        //Initial Deposit
                        System.out.println("Please enter your initial deposit: ");
                        while(true){
                            try{
                                initial = sc.nextDouble();
                                if(accType.matches("SA")){
                                    if(initial >= 5000){
                                        bal = initial;
                                        break;
                                    }else{
                                    System.out.println("A Savings Account Requires a minimum amount of 5000.");
                                    }
                                }
                                
                                if(accType.matches("CA")){
                                    if(initial >= 10000){
                                        bal = initial;
                                        break;
                                    }else{
                                        System.out.println("A Current Account Requires a minimum amount of 10000.");
                                    }
                                }
                            }
                            catch(InputMismatchException e){
                                System.out.println("Please enter a valid amount.");
                                sc.nextLine();
                            }
                        }

                        //Pin
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
                        System.out.println("Initial Deposit: " + initial);
                        System.out.println("Pin: " + pin);

                        //Verification
                        System.out.println("Is the information correct? (Y/N)");
                        String verify = sc.nextLine();
                        if (verify.equalsIgnoreCase("N")) {
                            System.out.println("Please try again.");
                            break;
                        }

                        //Inforrmation verified and creating account
                        accountNumber = AccountInterface.accId;

                        Account account = new Account(fName, add, bday, gen, accType, initial, bal, pin, accountNumber);

                        fw = new FileWriter("Accounts\\" + accountNumber + ".txt");
                        fw.write(fName + "\n");
                        fw.write(add + "\n");
                        fw.write(bday + "\n");
                        fw.write(gen + "\n");
                        fw.write(accType + "\n");
                        fw.write(initial + "\n");
                        fw.write(bal + "\n");
                        fw.write(pin + "\n");
                        fw.close();

                        accounts.add(account);

                        System.out.println("Account created successfully! Your account number is " + accountNumber);
                        pause();
                        break;
                    case 2: // Balance
                        System.out.println("Please enter account number: ");
                        String accNum = sc.nextLine();
                        fr = new BufferedReader(new FileReader("Accounts\\" + accNum + ".txt"));
                        System.out.println("Please enter your pin: ");
                        String pinInput = sc.nextLine();
                        String pinTemp = "", BalTemp = "", chrTemp;
                        int lineTemp = 1;

                        while ((chrTemp = fr.readLine()) != null) {
                            if(lineTemp == 7){
                                BalTemp = chrTemp;
                            }
                            else if(lineTemp == 8){
                                pinTemp = chrTemp;
                            }
                            lineTemp++;
                        }
                        
                        if(pinTemp.matches(pinInput)){
                            System.out.println("Your balance is " + BalTemp);
                        }
                        else{
                            System.out.println("Invalid pin. Please try again.");
                        }
                        
                        fr.close();
                        pause();
                        break;
                    case 3: // Deposit
                        

                        break;
                    case 4: // Witthdraw
                        
                    
                        break;
                    case 5: // Account Info
                        System.out.println("Please enter account number: ");
                        String accInfo = sc.nextLine();

                        fr = new BufferedReader(new FileReader("Accounts\\"+ accInfo + ".txt"));

                        String chr;
                        int line = 1;
                        System.out.print("Account Number: " + accInfo + "\n");

                        while ((chr = fr.readLine()) != null) {
                            if(line == 1){
                                System.out.print("Name: ");
                            }
                            else if(line == 2){ 
                                System.out.print("\nAddress: ");
                                System.out.print(chr);
                            }
                            else if(line == 3){
                                System.out.print("\nBirthday: ");
                                System.out.print(chr);
                            }
                            else if(line == 4){
                                System.out.print("\nGender: ");
                                System.out.print(chr);
                            }
                            else if(line == 5){
                                System.out.print("\nAccount Type: ");
                                System.out.print(chr);
                            }
                            else if(line == 6){
                                System.out.print("\nInitial Deposit: ");
                                System.out.print(chr);
                            }
                            else if(line == 7){
                                System.out.print("\nBalance: ");
                                System.out.print(chr);
                            }
                            line++;
                        }
                        pause();
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
        sc.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pause() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nPress enter to continue...");
        sc.nextLine();
    }

}