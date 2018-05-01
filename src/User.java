public class User {
    private String mail;
    private String userCreditCard;
    private int balance;
    private String driverLicense ="";

    public User( String mail) {
        this.mail = mail;
    }
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserCreditCard() {
        return userCreditCard;
    }

    public void setUserCreditCard(String userCreditCard) {
        this.userCreditCard = userCreditCard;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }
}
