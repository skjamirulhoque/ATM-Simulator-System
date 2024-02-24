import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;

public class Deposit extends JFrame implements ActionListener {
    JTextField t1;
    JButton b1,b2;
    String Pin;
    Deposit(String Pin) {
        this.Pin = Pin;
        String imagePath = "D:/Java Project/ATM/atm.java/src/Media/atm.jpg";
        ImageIcon i1 = new ImageIcon(imagePath);
        java.awt.Image i4 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i4);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        JLabel text = new JLabel("Enter the amount you want to deposit:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        label.add(text);

        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 18));
        t1.setBounds(170, 330, 320, 25);
        label.add(t1);

        b1 = new JButton("Deposit");
        b1.setBounds(355, 485, 150, 30);
        b1.addActionListener(this);
        label.add(b1);
        b2 = new JButton("Back");
        b2.setBounds(355, 520, 150, 30);
        b2.addActionListener(this);
        label.add(b2);

        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String amount = t1.getText();
            Date date = new Date();
            if (amount.equals("")) {
                JOptionPane.showMessageDialog(null,"Please Enter the amount");                
            }else{
                try{
                Jdbc_con cn = new Jdbc_con();
                String q1 = "insert into operation values('"+Pin+"','"+date+"','Deposit','"+amount+"')";
                cn.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                setVisible(false);
                new Transaction(Pin).setVisible(true);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
        else if(ae.getSource()==b2){
            setVisible(false);
            new Transaction(Pin).setVisible(true);
        }
}
}

