public class Account extends Info{

    public Account(){
        this.fullName = "";
        this.address = "";
        this.birthday = "";
        this.gender = "";
        this.accountType = "";
        this.balance = 0;
        this.pin = 0;
    }

    public Account(String fullName, String address, String birthday,String gender, String accountType, double initialDeposit, int pin) {
        this.fullName = fullName;
        this.address = address;
        this.birthday = birthday;
        this.gender = gender;
        this.accountType = accountType;
        this.balance = initialDeposit;
        this.pin = pin;
    }

    public double getBalance() {
        return balance;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getAccountType() {
        return accountType;
    }

    public int getPin() {
        return pin;
    }


}