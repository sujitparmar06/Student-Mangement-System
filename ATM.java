import java.util.*;

class Account{
    String userId;
    String pin;
    double balance;
    ArrayList<String> transactions;

    Account(String userId,String pin,double balance)
    {
        this.userId=userId;
        this.pin=pin;
        this.balance=balance;
        this.transactions=new ArrayList<>();
    }

    public void addTransactions(String detail)
    {
        transactions.add(detail);
    }
}

public class ATM{
    static HashMap<String,Account> accounts=new HashMap<>();
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args)
    {
        accounts.put("user1",new Account("user1","1234",50000));
        accounts.put("user2",new Account("user2","123",70000));

        System.out.println("Enter userId");
        String userId=sc.nextLine();

        System.out.println("Enter pin");
        String pin=sc.nextLine();

        if(!accounts.containsKey(userId)||!accounts.get(userId).pin.equals(pin))
        {
            System.out.println("Invalid data");
            return;
        }

        Account currUser=accounts.get(userId);

        int choice;

        do{
            System.out.println("\n ATM Machine");
            System.out.println("\n 1. Check Balance");
            System.out.println("\n 2. Withdraw");
            System.out.println("\n 3. Deposit");
            System.out.println("\n 4. Transfer");
            System.out.println("\n 5. Transaction History");
            System.out.println("\n 6. Exit");
            System.out.println("\n Enter your choice:-");
            choice=sc.nextInt();
            sc.nextLine();

            switch(choice)
            {
                case 1:System.out.println(currUser.balance);
                break;
                case 2: Withdraw(currUser);
                break;
                case 3:Deposit(currUser);
                break;
                case 4:Transfer(currUser);
                break;
                case 5:ShowTransactions(currUser);
                break;
                case 6:System.out.println("Exit");
                break;
                default:System.out.println("Invalid choice");
            }
        }while(choice!=6);    
    }

    public static void Withdraw(Account currUser)
    {
        System.out.println("Enter amount to withdraw");
        double amount=sc.nextDouble();
        sc.nextLine();

        if(amount>currUser.balance)
        {
            System.out.println("Inefficient Balance");
            return;
        }
        else
        {
            currUser.balance-=amount;
            System.out.println("Current amount"+currUser.balance);
            currUser.addTransactions("Withdrawn"+amount);
        }
    }

    public static void Deposit(Account currUser)
    {
        System.out.println("Enter amount to deposit:");
        double amount=sc.nextDouble();
        sc.nextLine();

        currUser.balance+=amount;
        System.out.println("Current amount"+currUser.balance);
        currUser.addTransactions("Deposit"+amount);
    }

    public static void Transfer(Account currUser)
    {
        System.out.println("Enter reciever's id");
        String recieverId= sc.nextLine();
        
        System.out.println("Enter amount to transfer");
        double amount=sc.nextDouble();
        sc.nextLine();

        if(amount>currUser.balance)
        {
            System.out.println("Invalid balance");
        }
        else
        {
            Account reciever=accounts.get(recieverId);

            reciever.balance+=amount;
            currUser.balance-=amount;

            currUser.addTransactions("Transferrred "+amount+"to "+recieverId);
            reciever.addTransactions("Received "+amount+"from "+currUser.userId);

            System.out.println("\n Transaction successfull");
        }
    }

    public static void ShowTransactions(Account currUser)
    {
        if(currUser.transactions.isEmpty())
        {
            System.out.println("No transactions yet");
        }
        else{
            for(String s:currUser.transactions)
            {
                System.out.println(s);
            }
        }
    }
}


