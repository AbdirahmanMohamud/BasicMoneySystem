import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main extends Frame{

    public static String userLogin;
    public static String password;
    public static JTextField userText = new JTextField();
    public static JTextField passwordText = new JTextField();
    public static JLabel success = new JLabel("");
    public static JButton button = new JButton("Login");


    public Main(){

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(500,20,80,25);
        panel.add(userLabel);

        userText.setBounds(600,20,165,25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(500,50,80,25);
        panel.add(passwordLabel);

        passwordText.setBounds(600,50,165,25);
        panel.add(passwordText);

        success.setBounds(600,110,300,25);
        panel.add(success);


        button.setBounds(600,80,80,25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = passwordText.getText();
                if(user.equals(userText.getText()) && password.equals(passwordText.getText()) && e.getSource() == button){
                    success.setText("Login Successful");
                    userLogin = user;
                    Home Home = new Home();
                    MessageDigest md = null;
                    try {
                        md = MessageDigest.getInstance("MD5");
                        byte[] bytes = md.digest();
                        md.update(password.getBytes());
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < bytes.length; i++) {
                            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                        }
                        String hashedPassword = sb.toString();
                        String filename = "usersdata.txt";
                        try{
                            PrintWriter outputStream = new PrintWriter(filename);
                            outputStream.println(user);
                            outputStream.println(hashedPassword);
                            outputStream.close();
                        }catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        } {

                        }

                    } catch (NoSuchAlgorithmException ex) {
                        ex.printStackTrace();
                    }


                }
            }
        });
        panel.add(button);



    }

    public static void main(String[] args){
        new Main();
    }
}
