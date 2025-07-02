public class SavingsAccount extends AbstractAccount{

    public SavingsAccount(String username, String userid, double balance) {
        super(username, userid, balance);
    }

//    public SavingsAccount(String username, String userid) {
//        super(username, userid);
//    }

    public boolean withdraw(double amount){
        if(this.getBalance() >= amount + 1000){
            this.deductBalance(amount);
            return true;
        }
        else{
            return false;
        }
    }


    public void deposit(double amount){
        this.addBalance(amount * 1.025);
    }

    public boolean transfer(double amount, AbstractAccount acc){
        if(this.getBalance() >= amount + 1000){
            this.deductBalance(amount);
            acc.addBalance(amount);
            return true;
        } else{
            return false;
        }

    }

    @Override
    public String toString() {
        return "username='" + getUsername() + '\'' +
                ", userid='" + getUserid() + '\'' +
                ", balance=" + getBalance() +
                '}';
    }


}
