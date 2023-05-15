import java.util.Random;
import java.util.Scanner;

public class BankingApplication2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Bank bank =new Bank("LodchongPanish");
        int option = 0 , accountNumber;
        String accountName;
        double amount ,balance;
       // Account ac1 = new Account( 11111 , "Baimon" , 502.1);
        while (option !=6){
            System.out.println("Main Menu");
            System.out.println("1. Display all account");
            System.out.println("2. Open New Account");
            System.out.println("3. Close Existing Account");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdrew Money");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            option = scan.nextInt();
            scan.nextLine();

            switch (option){
                case 1:
                    bank.listAccount();
                    break;
                case 2:
                   accountNumber = genAccNumber();
//                    System.out.print("Enter your Account Number: ");
//                    accountNumber = scan.nextInt();
                   // scan.nextLine();
                    System.out.print("Enter your Account Name: ");
                    accountName = scan.nextLine();
                    System.out.print("Enter Initial Balance");
                    balance = scan.nextDouble();
                    bank.openAccount(accountNumber ,  accountName , balance);
                    break;
                case 3:
                    System.out.print("Enter your Account Number: ");
                    accountNumber = scan.nextInt();
                    scan.nextLine();
                    bank.closeAccount(accountNumber );
                    break;
                case 4:
                    System.out.print("Enter your Account Number: ");
                    accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter Amount for deposit money: ");
                    amount = scan.nextDouble();
                    bank.depositMoney(accountNumber ,  amount);
                    break;
                case 5:
                    System.out.print("Enter your Account Number: ");
                    accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter Amount for withdrew money: ");
                    amount = scan.nextDouble();
                    bank.withdrewMoney(accountNumber ,  amount);
                    break;
            }
            System.out.println();


        }

    }
    public static int genAccNumber(){
        Random rand = new Random();
        int accNumber = 10000 + rand.nextInt(9000);
        return accNumber;

    }
}
