public class Accounts {
    private String fullName;
    private String address;
    private String birthday;
    private String gender;
    private String accountType;
    private double balance;
    private int pin;

    public Accounts(String fullName, String address, String birthday,String gender, String accountType, double initialDeposit, int pin) {
        this.fullName = fullName;
        this.address = address;
        this.birthday = birthday;
        this.gender = gender;
        this.accountType = accountType;
        this.balance = initialDeposit;
        this.pin = pin;
    }

    // Getter

    public String gefullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() { // Temporary to need ng exception handling pag nag input ng birthday.
        return birthday;
    }

    public String getGender(){
        return gender;
    }

    public String getAccountType() {
        return accountType;
    }

    public dobule getBalance(){
        return balance;
    }

    public int getPin() {
        return pin;
    }

    //Setter

    public void setFulltName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

}