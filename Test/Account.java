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


}