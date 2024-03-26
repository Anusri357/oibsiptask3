package task3;

import java.util.Scanner;

class BankAccount 
{
    String fullName;
    String username;
    String password;
    float accountBalance = 50000f; //initial account balance
    String transactionHistory = ""; //storing transaction history

 //Method for Registering a new account
    public void register() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Full Name: ");
        this.fullName = sc.nextLine();
        System.out.print("Enter Your Username: ");
        this.username = sc.nextLine();
        System.out.print("Enter Your Password:");
        this.password = sc.nextLine();
        System.out.println("\nRegistration completed! Kindly login!");
    }

//Method for logging into an existing account
    public boolean login()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Username:");
        String inputUsername = sc.nextLine();
        System.out.print("Enter Your Password:");
        String inputPassword = sc.nextLine();
        if (inputUsername.equals(username) && inputPassword.equals(password))
        {
            System.out.println("\nLogin successful!");
            return true;
        } 
        else 
        {
            System.out.println("\nIncorrect Username or Password");
            return false;
        }
    }
    
//Method for withdrawing money from the account
    public void withdraw()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter amount to withdraw:");
        float amount = sc.nextFloat();
        if (amount > accountBalance) 
        {
            System.out.println("\nInsufficient Balance");
        } 
        else 
        {
            accountBalance = accountBalance-amount; //Updating account balance after withdrawal
            transactionHistory = transactionHistory+amount + " Rupees Withdrawn\n"; //Adding transaction details to history
            System.out.println("\nWithdraw Successful!");
        }
    }
    
//Method for depositing money into the account
    public void deposit() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter amount to deposit: ");
        float amount = sc.nextFloat();
        accountBalance = accountBalance + amount; // Updating account balance after deposit
        transactionHistory = transactionHistory+amount + " Rupees deposited\n"; //Adding transaction details to history
        System.out.println("\nDeposit Successful!");
    }

//Method for transferring money to another account
    public void transfer() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Recipient's Name: ");
        String recipient = sc.nextLine();
        System.out.print("Enter amount to transfer:");
        float amount = sc.nextFloat();
        if (amount > accountBalance) 
        {
            System.out.println("\n Oops!! Insufficient Balance!");
        } 
        else 
        {
            accountBalance =  accountBalance-amount; //Updating account balance after transfer
            transactionHistory = transactionHistory+amount + " Rupees transferred to " + recipient + "\n"; //Adding transaction details to history
            System.out.println("\nTransfer Successful!");
        }
    }

 //Method to display current account balance
    public void checkBalance()
    {
        System.out.println("\nAccount Balance: " + accountBalance + " Rupees");
    }

//Method to display transaction history
    public void transactionHistory() 
    {
        if (transactionHistory.isEmpty()) 
        {
            System.out.println("\nNo Transaction History!");
        } 
        else 
        {
            System.out.println("\nTransaction History:");
            System.out.println(transactionHistory);
        }
    }
}

//Main program
class ATMInterface 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n<< WELCOME TO ANU's ATM >>\n");
        System.out.println("1. Register \n2. Exit");
        System.out.print("Enter Your Choice:");
        int choice = sc.nextInt();

        if (choice == 1) 
        {
            BankAccount bankAccount = new BankAccount(); //object creation
            bankAccount.register();
            System.out.println("\n<< LOGIN >>\n");
            if (bankAccount.login()) 
            {
                System.out.println("\n\n<< WELCOME BACK " + bankAccount.fullName + " >>\n");
                boolean isFinished = false;
                while (!isFinished) 
                {
                    System.out.println("\n1. Withdraw \n2. Deposit \n3. Transfer \n4. Check Balance \n5. Transaction History \n6. Exit");
                    System.out.print("\nEnter Your Choice: ");
                    int option = sc.nextInt();
                    switch (option) {
                        case 1:
                            bankAccount.withdraw();
                            break;
                        case 2:
                            bankAccount.deposit();
                            break;
                        case 3:
                            bankAccount.transfer();
                            break;
                        case 4:
                            bankAccount.checkBalance();
                            break;
                        case 5:
                            bankAccount.transactionHistory();
                            break;
                        case 6:
                            isFinished = true;
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                }
            }
        } 
        else if (choice == 2) 
        {
            System.out.println("\n<< Thank you for using ANU's ATM >>");
        } 
        else 
        {
            System.out.println("\nInvalid choice!, please select 1 or 2 ");
        }
    }
}
