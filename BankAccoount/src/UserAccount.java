public class UserAccount extends AbstractAccount{
    public UserAccount(String username, String userid, double balance) {
        super(username, userid, balance);
    }

//    public UserAccount(String username, String userid) {
//        super(username, userid);
//    }

    public boolean withdraw(double amount){
        if(this.getBalance() >= amount){
            this.deductBalance(amount);
            return true;
        }
        else{
            return false;
        }
    }

    public void deposit(double amount){
        this.addBalance(amount);
    }

    public boolean transfer(double amount, AbstractAccount acc){
        if(this.getBalance() >= amount){
            this.deductBalance(amount);
            acc.addBalance(amount);
            return true;
        } else{
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
