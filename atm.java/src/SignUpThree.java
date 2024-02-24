import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignUpThree extends JFrame implements ActionListener {
    JRadioButton r1, r2, r3, r4;
    JButton submit, cancle;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    String formno;

    SignUpThree(String formno) {
        this.formno = formno;
        setLayout(null);

        //heading text
        JLabel l1 = new JLabel("ACCOUNT DETAILS - PAGE 3");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        //add account type
        JLabel l2 = new JLabel("Account Type: ");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(100, 140, 200, 30);
        add(l2);
        //creating radio button for all account type
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 200, 20);
        add(r1);
        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 200, 20);
        add(r2);

        r3 = new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 200, 20);
        add(r3);
        r4 = new JRadioButton("Loan Acount");
        r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 200, 20);
        add(r4);

        ButtonGroup grpAc = new ButtonGroup();
        grpAc.add(r1);
        grpAc.add(r2);
        grpAc.add(r3);
        grpAc.add(r4);

        //add card number component
        JLabel l3 = new JLabel("Card Number: ");
        l3.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.setBounds(100, 300, 200, 30);
        add(l3);
        JLabel l4 = new JLabel("XXXX-XXXX-XXXX-4164");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(330, 300, 300, 30);
        add(l4);
        JLabel Card_details = new JLabel("Your 16 Digit Card Number");
        Card_details.setFont(new Font("Raleway", Font.BOLD, 12));
        Card_details.setBounds(100, 330, 300, 20);
        add(Card_details);

        //add pin no component
        JLabel l5 = new JLabel("PIN No: ");
        l5.setFont(new Font("Raleway", Font.BOLD, 22));
        l5.setBounds(100, 370, 200, 30);
        add(l5);
        JLabel l6 = new JLabel("XXXX");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        l6.setBounds(330, 370, 300, 30);
        add(l6);
        JLabel Pin_details = new JLabel("Your 4 Digit PIN Number");
        Pin_details.setFont(new Font("Raleway", Font.BOLD, 12));
        Pin_details.setBounds(100, 400, 300, 20);
        add(Pin_details);

        //add required services component and their check box
        JLabel l7 = new JLabel("Services Required: ");
        l7.setFont(new Font("Raleway", Font.BOLD, 22));
        l7.setBounds(100, 450, 300, 20);
        add(l7);
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 18));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Net Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 18));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 18));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 18));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 18));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 18));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declear that the above details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 650, 600, 30);
        add(c7);

        //add submit button
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        //add cancle button
        cancle = new JButton("Cancle");
        cancle.setBackground(Color.BLACK);
        cancle.setForeground(Color.WHITE);
        cancle.setFont(new Font("Raleway", Font.BOLD, 14));
        cancle.setBounds(420, 720, 100, 30);
        cancle.addActionListener(this);
        add(cancle);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 820);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        //fatch the data from the signupthree form
        if (ae.getSource() == submit) {
            String at = null;
            if (r1.isSelected()) {
                at = "Saving Account";
            } else if (r2.isSelected()) {
                at = "Current Account";
            } else if (r3.isSelected()) {
                at = "Fixed Deposit Account";
            } else {
                at = "Loan Account";
            }

            Random ran = new Random();
            String cardno = "" + Math.abs((ran.nextLong() % 90000000L) + 5040936000000000L);
            String pinno = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);

            String Facility = "";
            if (c1.isSelected()) {
                Facility = Facility + " ATM card";
            } else if (c2.isSelected()) {
                Facility = Facility + " Net Banking";
            } else if (c3.isSelected()) {
                Facility = Facility + " Mobile Banking";
            } else if (c4.isSelected()) {
                Facility = Facility + " Email & SMS Alerts";
            } else if (c5.isSelected()) {
                Facility = Facility + " Cheque Book";
            } else if (c6.isSelected()) {
                Facility = Facility + " E-Statement";
            }

             try {
                if (c7.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                Jdbc_con c1 = new Jdbc_con();//Connect with the Databes
                String q1 = "insert into signupthree values('" + formno + "','" + at + "','" + cardno + "','"+pinno + "','"+Facility+"')";
                String q2 = "insert into login values('" + formno + "','" + cardno + "','" + pinno+"')";

                c1.s.executeUpdate(q1);//fire the query
                c1.s.executeUpdate(q2);

                JOptionPane.showMessageDialog(null, "Card Number : "+cardno+"\n Pin : "+pinno);
                setVisible(false);
                new Deposit(pinno).setVisible(true);

                //setVisible(false);
                //new Login().setVisible(true);
            }
        } catch (Exception e){
            e.printStackTrace();
        }       
        }
    }
}
