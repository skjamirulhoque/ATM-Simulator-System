import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.AncestorListener;

public class Transaction extends JFrame implements ActionListener {
    JButton Deposit, withdrawl, mini, fastcash, pin, Balance, exit;
    String Pin;

    Transaction(String Pin) {
        this.Pin = Pin;
        String imagePath = "D:/Java Project/ATM/atm.java/src/Media/atm.jpg";
        ImageIcon i1 = new ImageIcon(imagePath);
        java.awt.Image i4 = i1.getImage().getScaledInstance(960, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i4);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        JLabel text = new JLabel("Plese Select Your Transaction");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        label.add(text);

        Deposit = new JButton("Deposit");
        Deposit.setBounds(140, 385, 150, 30);
        Deposit.addActionListener(this);
        label.add(Deposit);

        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(355, 385, 150, 30);
        withdrawl.addActionListener(this);
        label.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(140, 425, 150, 30);
        fastcash.addActionListener(this);
        label.add(fastcash);

        mini = new JButton("Mini Statement");
        mini.setBounds(355, 425, 150, 30);
        mini.addActionListener(this);
        label.add(mini);

        pin = new JButton("PIN Change");
        pin.setBounds(140, 463, 150, 30);
        pin.addActionListener(this);
        label.add(pin);

        Balance = new JButton("Balance Enquiry");
        Balance.setBounds(355, 463, 150, 30);
        Balance.addActionListener(this);
        label.add(Balance);

        exit = new JButton("Exit");
        exit.setBounds(140, 500, 150, 30);
        exit.addActionListener(this);
        label.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        // setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == Deposit) {
            setVisible(false);
            new Deposit(Pin).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new withdraw(Pin).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(Pin).setVisible(true);
        } else if (ae.getSource() == pin) {
            setVisible(false);
            new Pin_Change(Pin).setVisible(true);
        } else if (ae.getSource() == Balance) {
            setVisible(false);
            new Balance_enquery(Pin).setVisible(true);
        } else if (ae.getSource() == mini) {
            new MiniStatement(Pin).setVisible(true);
        }
    }
}
