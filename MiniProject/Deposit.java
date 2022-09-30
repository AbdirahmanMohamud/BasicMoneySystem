import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Deposit {
  
        public static JTextField depositAmount = new JTextField();
        public static JTextField customerNameText = new JTextField();

    public Deposit(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);


        JLabel customerNameLabel = new JLabel("Enter Client Name");
        customerNameLabel.setBounds(450,20,165,25);
        panel.add(customerNameLabel);

        customerNameText.setBounds(600,20,165,25);
        panel.add(customerNameText);

        JLabel depositAmountLabel = new JLabel("Enter your amount");
        depositAmountLabel.setBounds(450,50,165,25);
        panel.add(depositAmountLabel);

        
        depositAmount.setBounds(600,50,165,25);
        panel.add(depositAmount);

        JButton button = new JButton("Submit");
        button.setBounds(600,80,80,25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final Integer user_Deposit_Amount = Integer.parseInt(depositAmount.getText());
                Boolean result = Admin.deposit(String.valueOf(customerNameText.getText()),user_Deposit_Amount);
            }
        });
        panel.add(button);

        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                ((Frame) (evt.getSource())).dispose();
            }
        });
    }
}
