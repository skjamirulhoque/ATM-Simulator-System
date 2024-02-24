import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame {
    String Pin;
    MiniStatement(String Pin){
        this.Pin = Pin;

        setTitle("Mini Statement");
        JLabel text = new JLabel();
        add(text);

        
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        try{
            Jdbc_con cn = new Jdbc_con();
            String q1 = "SELECT * FROM login WHERE Pin='"+Pin+"'";
            ResultSet rs = cn.s.executeQuery(q1);
            while (rs.next()) {
                card.setText("Card Number: "+ rs.getString("Card_No").substring(0,4)+ "XXXXXXXX"+rs.getString("Card_No").substring(12));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            Jdbc_con cn = new Jdbc_con();
            String q2 = "SELECT * FROM operation WHERE pin='"+Pin+"'";
            ResultSet rs = cn.s.executeQuery(q2);
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp:&nbsp:&nbsp:&nbsp:&nbsp:" + rs.getString("type") + "&nbsp:&nbsp:&nbsp:&nbsp:&nbsp:&nbsp:&nbsp:&nbsp:&nbsp:&nbsp:" + rs.getString("amount") + "<br><br><html>");
       
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel bank = new JLabel("UCO Bank");
        bank.setBounds(150, 20, 100, 30);
        add(bank);



        setLayout(null);
        setSize(400, 600);
        setLocation(30, 30);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
}
