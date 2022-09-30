import javax.swing.*;

public class checkBalance {


    public checkBalance(){
        //Code needed for the GUI to work
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);

        //Where the name will be in the window
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(500,20,80,25);
        panel.add(nameLabel);
        JLabel name = new JLabel();
        name.setBounds(600,20,80,25);
        panel.add(name);

        //Where the funds will be in the window
        JLabel fundsLabel = new JLabel("Funds");
        fundsLabel.setBounds(500,50,80,25);
        panel.add(fundsLabel);
        JLabel funds = new JLabel();
        funds.setBounds(600,50,80,25);
        panel.add(funds);

        //Using the Admin class earlier to get the name and the funds of the user currently registered
        int numCustomers = Admin.getNumOfCustomers();
        name.setText(Admin.getCustomerName(numCustomers - 1));
        funds.setText(String.valueOf(Admin.getCustomerFunds(numCustomers-1)));


    }
}
