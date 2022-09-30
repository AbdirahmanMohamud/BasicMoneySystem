public class Customer extends User{
    //new object from the Account class
    private final Account account;

    //use of inheritance with the super(name) line
    public Customer(String name){
        super(name);
        this.account = new Account();
    }
    //example of polymorphism
    public void deposit(double amount){
        this.account.deposit(amount);
    }

    public void withdraw(double amount){
        this.account.withdraw(amount);
    }

    public int getFunds(){
        return this.account.getCapital();
    }

}
