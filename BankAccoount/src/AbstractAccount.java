public abstract class AbstractAccount {
    private final String username;
    private final String userid;
    private double balance;

    public AbstractAccount(String username, String userid, double balance) {
        this.username = username;
        this.userid = userid;
        this.balance = balance;
    }


//    public AbstractAccount(String username, String userid) {
//        this.username = username;
//        this.userid = userid;
//        this.balance = 0;
//    }

    public String getUsername() {
        return username;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public void deductBalance(double amount){
        this.balance -= amount;

    }



    public String getUserid() {
        return userid;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "AbstractAccount{" +
                "username='" + username + '\'' +
                ", userid='" + userid + '\'' +
                ", balance=" + balance +
                '}';
    }
}
