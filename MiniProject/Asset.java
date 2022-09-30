import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Asset {

    protected static int firstShareAmount;
    protected static String firstShareType;
    protected static int firstCryptoAmount;
    protected static String firstCryptoType;
    protected static int secondShareAmount;
    protected static String secondShareType;
    protected static int secondCryptoAmount;
    protected static String secondCryptoType;


    static double shareCostRandomizer(double min, double max) {

        if (min >= max) {
            throw new IllegalArgumentException("The maximum must be greater than the minimum");
        }

        Random r = new Random();
        double random = min + (max - min) * r.nextDouble();
        return random;
    }

    public static void addBuyAsset(final String firstAssetName, int area_of_screen, double min_price, double max_price, final String secondAssetName, int second_Area_of_screen, double second_min_price, double second_max_price){
        //code needed to make the GUI window
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);

        //first share being made
        Asset.firstShareType = firstAssetName;
        JLabel firstShare = new JLabel("First Share");
        firstShare.setBounds(350,area_of_screen,80,25);
        panel.add(firstShare);

        JLabel firstShareValue = new JLabel(firstAssetName);
        firstShareValue.setBounds(450,area_of_screen,80,25);
        panel.add(firstShareValue);

        //use of randomizer method to get a new value of the crypto every time
        // it opens the window to simulate real-world changes in value
        final double firstShareCostValue = shareCostRandomizer(min_price, max_price);
        JLabel firstShareCost = new JLabel("Cost: £"+firstShareCostValue);
        firstShareCost.setBounds(550,area_of_screen,80,25);
        panel.add(firstShareCost);

        //Button to register user's input for a crypto purchase
        JButton firstSharePurchase = new JButton("Buy Crypto");
        firstSharePurchase.setBounds(650,area_of_screen,165,25);
        panel.add(firstSharePurchase);
        firstSharePurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //When the button is clicked, the terminal prints a message registering the purchase
                //The variable in the Shares class increments
                //The cost of the share is withdrawn from the user's funds
                System.out.println("You purchased a share of "+firstAssetName);
                Boolean result = Admin.withdraw(Main.userLogin, firstShareCostValue);
                if(firstAssetName=="Bitcoin"){
                    firstCryptoAmount++;
                    firstCryptoType=firstAssetName;
                }
                else if(firstAssetName=="Google"){
                    firstShareAmount++;
                    firstShareType=firstAssetName;
                }
                else{

                }
            }
        });

        Asset.secondShareType = secondAssetName;
        JLabel secondShare = new JLabel("Second Share");
        secondShare.setBounds(350,second_Area_of_screen,80,25);
        panel.add(secondShare);

        JLabel secondShareValue = new JLabel(secondAssetName);
        secondShareValue.setBounds(450,second_Area_of_screen,165,25);
        panel.add(secondShareValue);

        final double secondShareCostValue = Asset.shareCostRandomizer(second_min_price, second_max_price);
        JLabel secondShareCost = new JLabel("Cost: £"+secondShareCostValue);
        secondShareCost.setBounds(550,second_Area_of_screen,80,25);
        panel.add(secondShareCost);

        JButton secondSharePurchase = new JButton("Buy Crypto");
        secondSharePurchase.setBounds(650,second_Area_of_screen,165,25);
        panel.add(secondSharePurchase);
        secondSharePurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You purchased a share of "+secondAssetName);
                Boolean result = Admin.withdraw(Main.userLogin,secondShareCostValue);
                if(secondAssetName=="Ethereum"){
                    secondCryptoAmount++;
                    secondCryptoType=secondAssetName;
                }
                else if(secondAssetName=="Tesla"){
                    secondShareAmount++;
                    secondShareType=secondAssetName;
                }
                else{

                }
            }
        });
    }

    public static void addSellAsset(final String firstAssetName, int area_of_screen, double min_price, double max_price, final String secondAssetName, int second_Area_of_screen, double second_min_price, double second_max_price){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);

        Asset.firstShareType = firstAssetName;
        JLabel firstShare = new JLabel("First Crypto");
        firstShare.setBounds(350,area_of_screen,80,25);
        panel.add(firstShare);

        JLabel firstShareValue = new JLabel(firstAssetName);
        firstShareValue.setBounds(450,area_of_screen,80,25);
        panel.add(firstShareValue);

        final double firstShareCostValue = Asset.shareCostRandomizer(min_price, max_price);
        JLabel firstShareCost = new JLabel("Cost: £"+firstShareCostValue);
        firstShareCost.setBounds(550,area_of_screen,80,25);
        panel.add(firstShareCost);


        JButton firstSharePurchase = new JButton("Sell Crypto");
        firstSharePurchase.setBounds(650,area_of_screen,165,25);
        panel.add(firstSharePurchase);
        firstSharePurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You sold your share of "+firstAssetName);
                Boolean result = Admin.deposit(Main.userLogin,firstShareCostValue);
                if(firstAssetName=="Bitcoin"){
                    firstCryptoAmount--;
                    firstCryptoType=firstAssetName;
                }
                else if(firstAssetName=="Google"){
                    firstShareAmount--;
                    firstShareType=firstAssetName;
                }
            }
        });

        Asset.secondShareType = secondAssetName;
        JLabel secondShare = new JLabel("Second Crypto");
        secondShare.setBounds(350,second_Area_of_screen,80,25);
        panel.add(secondShare);

        JLabel secondShareValue = new JLabel(secondAssetName);
        secondShareValue.setBounds(450,second_Area_of_screen,165,25);
        panel.add(secondShareValue);

        final double secondShareCostValue = Asset.shareCostRandomizer(second_min_price, second_max_price);
        JLabel secondShareCost = new JLabel("Cost: £"+secondShareCostValue);
        secondShareCost.setBounds(550,second_Area_of_screen,80,25);
        panel.add(secondShareCost);

        JButton secondSharePurchase = new JButton("Sell Crypto");
        secondSharePurchase.setBounds(650,second_Area_of_screen,165,25);
        panel.add(secondSharePurchase);
        secondSharePurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You sold a share of "+secondAssetName);
                Boolean result = Admin.deposit(Main.userLogin,secondShareCostValue);
                if(secondAssetName=="Ethereum"){
                    secondCryptoAmount--;
                    secondCryptoType=secondAssetName;
                }
                else if(secondAssetName=="Tesla"){
                    secondShareAmount--;
                    secondShareType=secondAssetName;
                }
            }
        });
    }
}
