public abstract class User {
    //variable for the name of a customer
    private final String name;

    public User(String name){
        this.name = name;
    }
    //method to get the name of a user. Used later on.
    public String getName(){
        return this.name;
    }
}
