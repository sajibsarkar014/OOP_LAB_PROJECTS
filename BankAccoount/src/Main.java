import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Vector<PremiumAccount> premiumVec = new Vector<>(10);
        Vector<SavingsAccount> savingsVec = new Vector<>(10);
        Vector<UserAccount> userVec = new Vector<>(10);

        premiumVec.addElement(new PremiumAccount("Kevin", "12345", 15000));
        savingsVec.addElement(new SavingsAccount("John", "00987", 5000));
        userVec.addElement(new UserAccount("Terry", "45678", 1200));

        while (true) {
            System.out.println("\nAccount Options:");
            System.out.println("1. Create new account");
            System.out.println("2. Check balance");
            System.out.println("3. Transfer");
            System.out.println("4. Withdraw");
            System.out.println("5. Deposit");
            System.out.println("6. Show all User Accounts");
            System.out.println("7. Exit");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 7) break;

            int accType = 0;
            if (choice >= 1 && choice <= 5) {
                System.out.println("Enter the type of account:");
                System.out.println("1. User Account");
                System.out.println("2. Savings Account");
                System.out.println("3. Premium Account");
                accType = input.nextInt();
                input.nextLine();
            }

            switch (choice) {
                case 1:
                    accCreation(accType, premiumVec, savingsVec, userVec);
                    break;
                case 2:
                    checkBalance(accType, premiumVec, savingsVec, userVec);
                    break;
                case 3:
                    transfer(accType, premiumVec, savingsVec, userVec);
                    break;
                case 4:
                    withdraw(accType, premiumVec, savingsVec, userVec);
                    break;
                case 5:
                    deposit(accType, premiumVec, savingsVec, userVec);
                    break;
                case 6:
                    System.out.println("User Accounts:");
                    for (UserAccount acc : userVec) System.out.println(acc);
                    System.out.println("Savings Accounts:");
                    for (SavingsAccount acc : savingsVec) System.out.println(acc);
                    System.out.println("Premium Accounts:");
                    for (PremiumAccount acc : premiumVec) System.out.println(acc);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        input.close();
    }

    public static void accCreation(int accType, Vector<PremiumAccount> acc3, Vector<SavingsAccount> acc2, Vector<UserAccount> acc1) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your username");
        String username = input.nextLine();
        System.out.println("Enter your id");
        String id = input.nextLine();
        System.out.println("Enter your balance");
        double balance = input.nextDouble();

        switch (accType) {
            case 1:
                for (UserAccount userAcc : acc1) {
                    if (userAcc.getUserid().equals(id)) {
                        System.out.println("The id is already present.");
                        return;
                    }
                }
                acc1.addElement(new UserAccount(username, id, balance));
                break;
            case 2:
                for (SavingsAccount userAcc : acc2) {
                    if (userAcc.getUserid().equals(id)) {
                        System.out.println("The id is already present.");
                        return;
                    }
                }
                acc2.addElement(new SavingsAccount(username, id, balance));
                break;
            case 3:
                for (PremiumAccount userAcc : acc3) {
                    if (userAcc.getUserid().equals(id)) {
                        System.out.println("The id is already present.");
                        return;
                    }
                }
                acc3.addElement(new PremiumAccount(username, id, balance));
                break;
        }
    }

    public static void checkBalance(int accType, Vector<PremiumAccount> acc3, Vector<SavingsAccount> acc2, Vector<UserAccount> acc1) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your id:");
        String id = input.nextLine();
        switch (accType) {
            case 1:
                for (UserAccount acc : acc1) {
                    if (acc.getUserid().equals(id)) {
                        System.out.println("Balance: " + acc.getBalance());
                        return;
                    }
                }
                break;
            case 2:
                for (SavingsAccount acc : acc2) {
                    if (acc.getUserid().equals(id)) {
                        System.out.println("Balance: " + acc.getBalance());
                        return;
                    }
                }
                break;
            case 3:
                for (PremiumAccount acc : acc3) {
                    if (acc.getUserid().equals(id)) {
                        System.out.println("Balance: " + acc.getBalance());
                        return;
                    }
                }
                break;
        }
        System.out.println("Account not found.");
    }

    public static void transfer(int accType, Vector<PremiumAccount> acc3, Vector<SavingsAccount> acc2, Vector<UserAccount> acc1) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your id:");
        String fromId = input.nextLine();
        System.out.println("Enter recipient id:");
        String toId = input.nextLine();
        System.out.println("Enter amount to transfer:");
        double amount = input.nextDouble();

        AbstractAccount fromAcc = null, toAcc = null;

        switch (accType) {
            case 1:
                for (UserAccount acc : acc1) if (acc.getUserid().equals(fromId)) fromAcc = acc;
                break;
            case 2:
                for (SavingsAccount acc : acc2) if (acc.getUserid().equals(fromId)) fromAcc = acc;
                break;
            case 3:
                for (PremiumAccount acc : acc3) if (acc.getUserid().equals(fromId)) fromAcc = acc;
                break;
        }
        for (UserAccount acc : acc1) if (acc.getUserid().equals(toId)) toAcc = acc;
        for (SavingsAccount acc : acc2) if (acc.getUserid().equals(toId)) toAcc = acc;
        for (PremiumAccount acc : acc3) if (acc.getUserid().equals(toId)) toAcc = acc;

        if (fromAcc == null || toAcc == null) {
            System.out.println("Account(s) not found.");
            return;
        }

        if (fromAcc instanceof PremiumAccount) {
            System.out.println("Transfer not allowed from Deposit Premium Account.");
            return;
        }

        boolean success = false;
        if (fromAcc instanceof UserAccount) {
            success = ((UserAccount) fromAcc).transfer(amount, toAcc);
        } else if (fromAcc instanceof SavingsAccount) {
            success = ((SavingsAccount) fromAcc).transfer(amount, toAcc);
        }
        System.out.println(success ? "Transfer successful." : "Transfer failed.");
    }

    public static void withdraw(int accType, Vector<PremiumAccount> acc3, Vector<SavingsAccount> acc2, Vector<UserAccount> acc1) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your id:");
        String id = input.nextLine();
        System.out.println("Enter amount to withdraw:");
        double amount = input.nextDouble();

        boolean success = false;
        switch (accType) {
            case 1:
                for (UserAccount acc : acc1) {
                    if (acc.getUserid().equals(id)) {
                        success = acc.withdraw(amount);
                        break;
                    }
                }
                break;
            case 2:
                for (SavingsAccount acc : acc2) {
                    if (acc.getUserid().equals(id)) {
                        success = acc.withdraw(amount);
                        break;
                    }
                }
                break;
            case 3:
                for (PremiumAccount acc : acc3) {
                    if (acc.getUserid().equals(id)) {
                        success = acc.withdraw(amount);
                        break;
                    }
                }
                break;
        }
        System.out.println(success ? "Withdrawal successful." : "Withdrawal failed.");
    }

    public static void deposit(int accType, Vector<PremiumAccount> acc3, Vector<SavingsAccount> acc2, Vector<UserAccount> acc1) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your id:");
        String id = input.nextLine();
        System.out.println("Enter amount to deposit:");
        double amount = input.nextDouble();

        boolean found = false;
        switch (accType) {
            case 1:
                for (UserAccount acc : acc1) {
                    if (acc.getUserid().equals(id)) {
                        acc.deposit(amount);
                        found = true;
                        break;
                    }
                }
                break;
            case 2:
                for (SavingsAccount acc : acc2) {
                    if (acc.getUserid().equals(id)) {
                        acc.deposit(amount);
                        found = true;
                        break;
                    }
                }
                break;
            case 3:
                for (PremiumAccount acc : acc3) {
                    if (acc.getUserid().equals(id)) {
                        acc.deposit(amount);
                        found = true;
                        break;
                    }
                }
                break;
        }
        System.out.println(found ? "Deposit successful." : "Account not found.");
    }
}
