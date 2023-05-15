public class Account {
    private int accountNumber ;
    private String accountName ;
    private double balanced;
    public Account(int accountNumber, String accountName , double balanced) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balanced= balanced;
    }
    public void withdrew(double amount){
        this.balanced -= amount;
    }
    public void deposit(double amount){
       this.balanced += amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalanced() {
        return balanced;
    }
}
