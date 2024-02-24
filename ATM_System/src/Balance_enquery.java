import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balance_enquery extends JFrame implements ActionListener {
    JButton back;
    String Pin;

    Balance_enquery(String Pin) {
        this.Pin = Pin;
        String imagePath = "D:/Java Project/ATM/atm.java/src/Media/atm.jpg";
        ImageIcon i1 = new ImageIcon(imagePath);
        java.awt.Image i4 = i1.getImage().getScaledInstance(960, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i4);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 900, 900);
        add(label);

        back = new JButton("Back");
        back.setBounds(355, 500, 150, 30);
        back.addActionListener(this);
        label.add(back);

        int balance=0;
        try{
            Jdbc_con cn = new Jdbc_con();
        String query = "SELECT * FROM operation WHERE pin = '"+Pin+"'";
        ResultSet rs = cn.s.executeQuery(query);
        while(rs.next()){
            if (rs.getString("type").equals("Deposit")) {
                balance = balance+Integer.parseInt(rs.getString("amount"));
            }else{
                balance = balance - Integer.parseInt(rs.getString("amount"));
            }
        }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel t1 = new JLabel("Your Current Account Balance is Rs. "+balance);
        t1.setForeground(Color.WHITE);
        t1.setBounds(170, 300, 500, 50);
        label.add(t1);

        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        // setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(Pin).setVisible(true);
        }
    }
}