import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bank {
    private String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }
    public void listAccount(){
        Connection connection = BankingConnection.connect();
        String sql = "select * from account2 ";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
             System.out.println(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));

        } catch (SQLException e) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE,null,e);
        }
        System.out.println("listAccount");
    }

    public void openAccount(int accountNumber ,String accountName , double balance){
        System.out.println("openAccount");
        Connection connection = BankingConnection.connect();
        String sql = "INSERT INTO account2 (accountNumber,accountName,balance) " + "VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setInt(1 ,accountNumber);
            preparedStatement.setString(2 ,accountName);
            preparedStatement.setDouble(3 ,balance);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    public void closeAccount(int accountNumber){
        System.out.println("closeAccount");
        Connection connection = BankingConnection.connect();
        String sql = "delete from account2 where accountNumber = ?";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setInt(1 ,accountNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    public void depositMoney(int accountNumber,double amount){
        Account account = getAccount(accountNumber);
        account.deposit(amount);
        Connection connection = BankingConnection.connect();
        String sql = "update account2 set balance = ?  where accountNumber =?  ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1,account.getBalanced());
            preparedStatement.setInt(2,account.getAccountNumber()); // or accountNumber
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE,null,e);
        }
        System.out.println("depositMoney");
    }
    public void withdrewMoney(int accountNumber,double amount){
        Account account = getAccount(accountNumber);
        account.withdrew(amount);
        Connection connection = BankingConnection.connect();
        String sql = "update account2 set balance = ?  where accountNumber =?  ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1,account.getBalanced());
            preparedStatement.setInt(2,account.getAccountNumber()); // or accountNumber
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE,null,e);
        }
        System.out.println("withdrewMoney");
    }
    public Account getAccount(int accountNumber) {
        Account account = null;
        Connection connection = BankingConnection.connect();
        String sql = "select * from account2 where accountNumber = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1 ,accountNumber);
            preparedStatement.executeQuery();
            ResultSet results = preparedStatement.executeQuery();

            results.next();
            account = new Account(results.getInt(1),results.getString(2),results.getDouble(3));

        } catch (SQLException e) {
            Logger.getLogger(Bank.class.getName()).log(Level.SEVERE,null,e);
        }

        return account;
    }
}
