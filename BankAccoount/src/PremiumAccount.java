public class PremiumAccount extends AbstractAccount{

    private int noOfDeposit;

//    public PremiumAccount(String username, String userid) {
//        super(username, userid);
//        this.noOfDeposit = 0;
//    }

    public PremiumAccount(String username, String userid, double balance) {
        super(username, userid, balance);
        this.noOfDeposit = 0;
    }

    public void deposit(double amount){
        this.addBalance(amount * 1.07);
        this.noOfDeposit++;
    }

    public boolean withdraw(double amount){
        if(this.getBalance() >= amount && this.noOfDeposit >=5){
            this.deductBalance(amount);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return
                "username='" + getUsername() + '\'' +
                ", userid='" + getUserid() + '\'' +
                ", balance=" + getBalance() +
                '}';
    }


}
