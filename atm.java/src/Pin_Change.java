import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Pin_Change extends JFrame implements ActionListener{
    String Pin;
    JTextField t1,t2;
    JButton change, back;
    Pin_Change(String Pin) {

        this.Pin = Pin;
        String imagePath = "D:/Java Project/ATM/atm.java/src/Media/atm.jpg";
        ImageIcon i1 = new ImageIcon(imagePath);
        java.awt.Image i4 = i1.getImage().getScaledInstance(960, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i4);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        // Title
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        label.add(text);

        // new pin component
        JLabel text2 = new JLabel("New Pin : ");
        text2.setBounds(150, 350, 180, 25);
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("System", Font.BOLD, 16));
        label.add(text2);
        // textfeild for new pin lable
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 18));
        t1.setBounds(330, 350, 180, 25);
        label.add(t1);

        // re enter pin component..
        JLabel text3 = new JLabel("Re Enter New Pin : ");
        text3.setBounds(150, 400, 700, 25);
        text3.setForeground(Color.WHITE);
        text3.setFont(new Font("System", Font.BOLD, 16));
        label.add(text3);
        // textfeild for re enter new pin lable
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 18));
        t2.setBounds(330, 400, 180, 25);
        label.add(t2);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        label.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 525, 150, 30);
        back.addActionListener(this);
        label.add(back);

        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
        try{
            String npin = t1.getText();
            String rpin = t2.getText();
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            try{
            Jdbc_con cn = new Jdbc_con();
            String q1 = "update operation set pin = '"+rpin+"' where pin = '"+Pin+"'";
            String q2 = "update login set Pin = '"+rpin+"' where Pin = '"+Pin+"'";
            String q3 = "update signupthree set Pin_No = '"+rpin+"' where Pin_No = '"+Pin+"'";

            cn.s.executeUpdate(q1);
            cn.s.executeUpdate(q2);
            cn.s.executeUpdate(q3);

            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            setVisible(false);
            new Transaction(rpin).setVisible(true);
            }catch(SQLException e){
                e.printStackTrace();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        }else{
            setVisible(false);
            new Transaction(Pin).setVisible(true);
        }
    }
}
