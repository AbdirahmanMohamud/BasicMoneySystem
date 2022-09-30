import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class SeePortfolio extends Frame {


    public SeePortfolio() {
        //Code to make the GUI window appear
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);
        //Array to add the data into the table
        String data[][]={ {Asset.firstCryptoType,"You have "+ Asset.firstCryptoAmount +" shares of Bitcoin"},
                {Asset.secondCryptoType,"You have "+ Asset.secondCryptoAmount +" shares of Ethereum"},
                {Asset.firstShareType,"You have "+ Asset.firstShareAmount +" shares of Google"},
                {Asset.secondShareType,"You have "+ Asset.secondShareAmount +" shares of Tesla"}};
        //The two columns which will appear at the top of the table
        String column[]={"Asset Type","Information"};
        JTable jt=new JTable(data,column);
        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);
        frame.add(sp);
        //Sending out your portfolio as an external file
        try {
            //New text file in folder
            File file = new File("C:\\Users\\offic\\Documents\\University\\Year 1\\Semester B\\Object-Oriented Programming\\Java Programs\\Mini Project\\Test\\ListOfTrades.txt");
            if(!file.exists()){
                //new file made if it doesn't exist
                file.createNewFile();
            }
            //code to write down all information from the table and to place it into the
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i=0;i<jt.getRowCount();i++){
                for(int j=0;j<jt.getColumnCount();j++){
                    bw.write((String)jt.getModel().getValueAt(i,j)+"");
                }
                bw.write("\n      \n");
            }
            bw.close();
            fw.close();
            JOptionPane.showMessageDialog(null,"Data Exported");
            //Exception being thrown if something is wrong
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
