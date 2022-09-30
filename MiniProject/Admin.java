//imported statements necessary to the class
import java.util.ArrayList;
import java.util.Iterator;
//abstract class being used
public abstract class Admin {
    //arraylist of type customer to store new customers
    private static ArrayList<Customer> customers = new ArrayList<>();

    public Admin(){
        customers = new ArrayList<>();
    }

    public static int getNumOfCustomers(){
        return customers.size();
    }

    //method to get the name of the customer
    public static String getCustomerName(int customerNumber){
        Customer customer = customers.get(customerNumber);
        return customer.getName();
    }
    //method to get the funds of a customer at any time. Used in the checkBalance method
    public static int getCustomerFunds(int customerNumber){
        Customer customer = customers.get(customerNumber);
        return customer.getFunds();
    }

    //new customer method is made and used when the user logs in
    public static void addCustomer(Customer c){
        customers.add(c);
    }

    //example of polymorphism using method overloading with deposit method
    public static boolean deposit(String customerName, double amount){
        Iterator<Customer> iteration = customers.iterator();
        boolean found = false;
        while (iteration.hasNext()){
            Customer customer = iteration.next();
            if (customer.getName().equals(customerName)){
                found = true;
                customer.deposit(amount);
            }
        }
        return found;
    }

    //another example of polymorphism using method overloading with two parameters in withdraw method
    public static boolean withdraw(String customerName, double amount){
        Iterator<Customer> iteration = customers.iterator();
        boolean found = false;
        while (iteration.hasNext()){
            Customer customer = iteration.next();
            if (customer.getName().equals(customerName)){
                found = true;
                customer.withdraw(amount);
            }
        }
        return found;
    }

}
