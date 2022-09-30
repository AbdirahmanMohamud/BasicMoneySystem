public class Account {
    //variable which stores a user's funds
    private int capital;

    public Account(){
        this.capital = 0;
    }
    //method to get the funds of a user
    public int getCapital(){
        return this.capital;
    }
    //method to add money to a user's account
    public void deposit(double amount){
        this.capital += amount;
    }
    //method to take money away from a user's account
    public void withdraw(double amount){
        this.capital -= amount;
    }
}
