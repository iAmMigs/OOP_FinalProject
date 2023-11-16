import java.util.Scanner;

public class Accounts {
    private String firstName;
    private String lastName;
    private String middleName;
    private String address;
    private String birthday;
    private String gender;
    private String accountType;
    private double balance;
    private int pin;

    public Accounts(String firstName, String lastName, String middleName, String address, String birthday,String gender, String accountType, double initialDeposit, int pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.address = address;
        this.birthday = birthday;
        this.gender = gender;
        this.accountType = accountType;
        this.balance = initialDeposit;
        this.pin = pin;
    }

    // Getter

    public String getFirstName() {
        return firstName;
    }

    
    public String getLastName() {
        return lastName;
    }

    public double getBalance() {
        return balance;
    }


    public int getPin() {
        return pin;
    }

    //Setter

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

}