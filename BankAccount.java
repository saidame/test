import java.util.Scanner;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private double PIN;




    public BankAccount(String accountNumber, double balance, double PIN){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void setAccountNumber(int newBalance){
        balance = newBalance;
    }

    public void deposit(double amount){
        if(amount<0){
            System.out.println("do not enter a negative amount");
        }else{
            balance += amount;
            System.out.println("deposit");
            System.out.println(balance);
        }

    }



    public void withdraw(double amount){
        if(amount>balance){
            System.out.println("error: this amount is greater than balance");
        }else{
            balance-=amount;
        }
    }
    public double getBalance(){
        return balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void menu(){
        System.out.println("1. deposit");
        System.out.println("2. withdraw");
        System.out.println("3. getBalance");
        System.out.println("4. exit");
    }

    public boolean verifyPin(Double newPin){
        if(newPin == PIN){
            return true;
        }else{
           return false;
        }
    }


    public void check(){
        Scanner scanner =  new Scanner(System.in);
        System.out.println("ENTER your choice ");
        int newNum = scanner.nextInt();

        do{
            switch(newNum){
                case 1:
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    break;
                case 2:
                    System.out.println("Enter an amount to withdraw: ");
                    amount = scanner.nextInt();
                    withdraw(amount);
                    break;
                case 3:
                    System.out.println(getBalance());
                    break;
                case 4:
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("invalid");
                    break;

            }
        }while(newNum != 4);

    }

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("enter your pin: ");

        double newPin = scanner.nextDouble();
        BankAccount account = new BankAccount("1234", 100, 1111);
        account.menu();
        account.check();

        account.verifyPin(newPin);

        account.deposit(-1000);
        account.withdraw(80);
        System.out.println(account.getBalance());
    }
}
