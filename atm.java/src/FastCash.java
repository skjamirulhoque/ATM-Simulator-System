import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener{

    JButton b1, b2, b3, b4, b5, b6, back;
    String Pin;

    FastCash(String Pin) {
    this.Pin=Pin;
    String imagePath = "D:/Java Project/ATM/atm.java/src/Media/atm.jpg";
    ImageIcon i1 = new ImageIcon(imagePath);
    java.awt.Image i4 = i1.getImage().getScaledInstance(960, 1000, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i4);
    JLabel label = new JLabel(i3);
    label.setBounds(0, 0, 900, 900);
    add(label);
   
    JLabel text = new JLabel("Select Withdraw Amount");
    text.setBounds(220, 300, 700, 35);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD, 16));
    label.add(text);
    
    b1 = new JButton("Rs 500");
    b1.setBounds(140, 385, 150, 30);
    b1.addActionListener(this);
    label.add(b1);
    
    b2 = new JButton("Rs 1000");
    b2.setBounds(355, 385, 150, 30);
    b2.addActionListener(this);
    label.add(b2);
    
    b3 = new JButton("Rs 2000");
    b3.setBounds(140, 425, 150, 30);
    b3.addActionListener(this);
    label.add(b3);
    
    b4 = new JButton("Rs 2500");
    b4.setBounds(355, 425, 150, 30);
    b4.addActionListener(this);
    label.add(b4);
    
    b5 = new JButton("Rs 5000");
    b5.setBounds(140, 463, 150, 30);
    b5.addActionListener(this);
    label.add(b5);
    
    b6 = new JButton("Rs 10000");
    b6.setBounds(355, 463, 150, 30);
    b6.addActionListener(this);
    label.add(b6);
    
    back = new JButton("Back");
    back.setBounds(140, 500, 150, 30);
    back.addActionListener(this);
    label.add(back);
    setSize(900, 900);
    setLocation(300, 0);
    //setUndecorated(true);
    setVisible(true);
}

public void actionPerformed(ActionEvent ae){
    if (ae.getSource()==back) {
        setVisible(false);
        new Transaction(Pin).setVisible(true);
    }else{
        try{
        String amt = ((JButton)ae.getSource()).getText().substring(3);
        Jdbc_con cn = new Jdbc_con();
        try{
        String query = "SELECT * FROM operation WHERE pin = '"+Pin+"'";
        ResultSet rs = cn.s.executeQuery(query);
        int balance = 0;
        while(rs.next()){
            if (rs.getString("type").equals("Deposit")) {
                balance = balance+Integer.parseInt(rs.getString("amount"));
            }else{
                balance = balance - Integer.parseInt(rs.getString("amount"));
            }
        }
        if (balance<Integer.parseInt(amt)) {
            JOptionPane.showMessageDialog(null, "Insufficient Balance");
            return;
        }
        Date date = new Date();
        String q1 = "insert into operation values('"+Pin+"','"+date+"','withdraw','"+amt+"')";
        cn.s.executeUpdate(q1);
        JOptionPane.showMessageDialog(null, "Rs "+amt+" Debited Successfully");
        setVisible(false);
        new Transaction(Pin).setVisible(true);
    }catch(SQLException e){
        e.printStackTrace();
    }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
}

