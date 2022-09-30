import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends Frame {

    public void addCustomer(String name){
        Admin.addCustomer(new Customer(name));
    }

    public Home() {

        this.addCustomer(Main.userLogin);
        JFrame mainMenu = new JFrame("Investment Banking App");
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        JPanel tab1 = new JPanel();
        JPanel tab2 = new JPanel();
        JPanel tab3 = new JPanel();
        tab1.setLayout(null);
        JLabel text = new JLabel();
        text.setBounds(600,20,165,25);
        JButton checkBalance = new JButton("Check Balance");
        checkBalance.setBounds(600,50,165,25);
        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(600,80,165,25);
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(600,110,165,25);
        JButton buyCryptoButton = new JButton("Buy Crypto");
        buyCryptoButton.setBounds(600,20,165,25);
        JButton sellCryptoButton = new JButton("Sell Crypto");
        sellCryptoButton.setBounds(600,50,165,25);
        JButton buySharesButton = new JButton("Buy Shares");
        buySharesButton.setBounds(600,80,165,25);
        JButton sellSharesButton = new JButton("Sell Shares");
        sellSharesButton.setBounds(600,110,165,25);
        JButton seePortfolioButton = new JButton("See Portfolio");
        JTabbedPane tabs = new JTabbedPane();
        tabs.setBounds(200, 30, 1000, 1000);
        tabs.add("Home", tab1);
        tab1.add(text);
        text.setText("Welcome Home "+Admin.getCustomerName(Admin.getNumOfCustomers()-1));
        tab1.add(checkBalance);
        checkBalance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBalance checkBalance = new checkBalance();
            }
        });
        tab1.add(depositButton);
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deposit deposit = new Deposit();
            }
        });
        tab1.add(withdrawButton);
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Withdraw withdraw = new Withdraw();
            }
        });
        tabs.add("Sales", tab2);
        tab2.add(buyCryptoButton);
        buyCryptoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuyCrypto buyCrypto = new BuyCrypto();
            }
        });
        tab2.add(sellCryptoButton);
        sellCryptoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SellCrypto sellCrypto = new SellCrypto();
            }
        });
        tab2.add(buySharesButton);
        buySharesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuyShares buyShares = new BuyShares();
            }
        });
        tab2.add(sellSharesButton);
        sellSharesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SellShares sellShares = new SellShares();
            }
        });
        tabs.add("Production Figures", tab3);
        tab3.add(seePortfolioButton);
        seePortfolioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeePortfolio seePortfolio = new SeePortfolio();
            }
        });
        mainMenu.add(tabs);
        mainMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainMenu.setLocationRelativeTo(null);
        mainMenu.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                ((Frame) (evt.getSource())).dispose();
            }
        });
    }
    public Home(String[] args){
        new Home();
    }
}
