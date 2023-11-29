import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.io.File;

public class Account extends Info{

    public Account(){
        this.fullName = "";
        this.address = "";
        this.birthday = "";
        this.gender = "";
        this.accountType = "";
        this.balance = 0;
        this.pin = "";
        this.accountNumber = 0;
    }

    public Account(String fullName, String address, String birthday,String gender, String accountType, double initialDeposit, double balance, String pin, int accountNumber) {
        this.fullName = fullName;
        this.address = address;
        this.birthday = birthday;
        this.gender = gender;
        this.accountType = accountType;
        this.initialDeposit = initialDeposit;
        this.balance = initialDeposit;
        this.pin = pin;
        this.accountNumber = generateAccNum();
    }

    private int generateAccNum(){
        Random random = new Random();
        return random.nextInt(90000) + 10000;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposit successful. New balance: " + this.balance);
            updateFile(); // Update the file after deposit
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + this.balance);
            updateFile(); // Update the file after withdrawal
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a valid amount.");
        }
    }

    private void updateFile() {
        try (FileWriter fw = new FileWriter("Accounts\\" + this.accountNumber + ".txt")) {
            fw.write(this.fullName + "\n");
            fw.write(this.address + "\n");
            fw.write(this.birthday + "\n");
            fw.write(this.gender + "\n");
            fw.write(this.accountType + "\n");
            fw.write(this.initialDeposit + "\n");
            fw.write(this.balance + "\n");
            fw.write(this.pin + "\n");
        } catch (IOException e) {
            System.out.println("Error updating the file: " + e.getMessage());
        }
    }

    public void deleteAccount() {
        // Delete the file associated with this account
        File file = new File("Accounts\\" + this.accountNumber + ".txt");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Account file deleted successfully.");
            } else {
                System.out.println("Unable to delete account file.");
                return;
            }
        } else {
            System.out.println("Account file not found.");
            return;
        }
    
        System.out.println("Account deleted successfully.");
    }
    

}