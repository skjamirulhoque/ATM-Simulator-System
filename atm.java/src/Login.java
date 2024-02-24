import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JButton b1,b2,b3; // For access every where..
    JTextField CR_text;
    JPasswordField Pin_text;
   // private AbstractButton pinnoTextFeild;
    // private AbstractButton cardnoTextFeild;
    Login(){
        setLayout(null);
        setTitle("AUTOMATED TELLER MACHINE");

        // Logo icon set..
        String imagePath = "D:/Java Project/ATM/atm.java/src/Media/logo.jpg" ;
        ImageIcon i1 = new ImageIcon(imagePath);
        java.awt.Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        //Add the text..Heading Text..
        JLabel l1 = new JLabel("Welcome To ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200,40,450,40);
        add(l1);

        // Add card no component
        JLabel l2 = new JLabel("Card No");
        l2.setFont(new Font("Osward", Font.BOLD, 28));
        l2.setBounds(125,150,375,30);
        add(l2);
        //Add card no texfield
        CR_text = new JTextField(15);
        CR_text.setBounds(300,150,230,30);
        CR_text.setFont(new Font("Arial", Font.BOLD, 14));
        add(CR_text);

        //Add Pin component
        JLabel l3 = new JLabel("PIN");
        l3.setFont(new Font("Osward", Font.BOLD, 28));
        l3.setBounds(125,220,375,30);
        add(l3);
        //Add textfield for Pin 
        Pin_text = new JPasswordField(15);
        Pin_text.setBounds(300, 220, 230, 30);
        Pin_text.setFont(new Font("Arial", Font.BOLD, 14));
        add(Pin_text);

        //creat button
        //add sign in button
        b1 = new JButton("SIGN IN");
        b1.setBounds(300,300,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        add(b1);

        //add sign up button
        b2 = new JButton("CLEAR");
        b2.setBounds(430,300,100,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        add(b2);

        //add clear button
        b3 = new JButton("SIGN UP");
        b3.setBounds(300,350,230,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        add(b3);


        //Creating the main frame...
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 150);
        getContentPane().setBackground(Color.WHITE);
    }

    //This method use to active the buttons
    public void actionPerformed(ActionEvent ae)
    {
        //this if is used for clear button
        if(ae.getSource()==b2){
            CR_text.setText("");//using this we can clear the values at login page
            Pin_text.setText("");
        }
       else if(ae.getSource()==b1){
                try{
                Jdbc_con c1 = new Jdbc_con();
                String Card_No  = CR_text.getText();
                String Pin  = Pin_text.getText();
                String q  = "select * from login where Card_No = '"+Card_No+"' and Pin = '"+Pin+"'";
                    ResultSet rs = c1.s.executeQuery(q);
                    if(rs.next()){
                        setVisible(false);
                        new Transaction(Pin).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
       }
        else if(ae.getSource()==b3){

            setVisible(false);
            new SignUpOne().setVisible(true);//Whenever the user click in signup button the the login frame of and sign up form is visible
        }
    }
}
