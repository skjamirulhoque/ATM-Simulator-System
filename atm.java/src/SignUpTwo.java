import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUpTwo extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10; //All the label that are used in Creatin the frame component
    JComboBox r1, r2, r3, r4, r5; //All the combobox that are used in Creatin the frame component
    JTextField t1, t2;
    JRadioButton eyes, sNo;
    String formno; //that refers the formo form the SignupOne class
    JButton n1;

    SignUpTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT FORM NO - PAGE 2");

        //Add Additional details component
        l1 = new JLabel("Additional Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 35));
        l1.setBounds(290, 80, 400, 30);
        add(l1);

        //Add Religion details component with Combobox
        l2 = new JLabel("Religion:");
        l2.setFont(new Font("Raleway", Font.BOLD, 20));
        l2.setBounds(100, 140, 100, 30);
        add(l2);
        String val_rili[] = { "Hindu", "Islam", "Sikh", "Christain", "Others" };
        r1 = new JComboBox(val_rili);
        r1.setBounds(300, 140, 400, 30);
        r1.setBackground(Color.WHITE);
        add(r1);

        //Add Category details component with Combobox
        l3 = new JLabel("Category:");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        l3.setBounds(100, 190, 200, 30);
        add(l3);
        String val_cat[] = { "General", "OBC", "SC", "ST", "Others" };
        r2 = new JComboBox(val_cat);
        r2.setBounds(300, 190, 400, 30);
        r2.setBackground(Color.WHITE);
        add(r2);

        //Add Income details component with Combobox
        l4 = new JLabel("Income:");
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        l4.setBounds(100, 240, 200, 30);
        add(l4);
        String val_Inc[] = { "Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000" };
        r3 = new JComboBox(val_Inc);
        r3.setBounds(300, 240, 400, 30);
        r3.setBackground(Color.WHITE);
        add(r3);

        //Add Education_Qualification details component with Combobox
        l5 = new JLabel("Educational");
        l5.setFont(new Font("Raleway", Font.BOLD, 20));
        l5.setBounds(100, 290, 200, 30);
        add(l5);
        l6 = new JLabel("Qualification:");
        l6.setFont(new Font("Raleway", Font.BOLD, 20));
        l6.setBounds(100, 315, 200, 30);
        add(l6);
        String val_Ed[] = { "Non-Graduation", "Graduate", "Post-Graduate", "Others" };
        r4 = new JComboBox(val_Ed);
        r4.setBounds(300, 315, 400, 30);
        r4.setBackground(Color.WHITE);
        add(r4);

        //Add Occupation details component with Combobox
        l7 = new JLabel("Occupation:");
        l7.setFont(new Font("Raleway", Font.BOLD, 20));
        l7.setBounds(100, 390, 200, 30);
        add(l7);
        String val_Oc[] = { "Salaried", "Self-Employed", "Bussiness", "Farmer", "Student", "Others" };
        r5 = new JComboBox(val_Oc);
        r5.setBounds(300, 390, 400, 30);
        r5.setBackground(Color.WHITE);
        add(r5);

        //Add Pan No details component with Textfeild
        l8 = new JLabel("PAN No:");
        l8.setFont(new Font("Raleway", Font.BOLD, 20));
        l8.setBounds(100, 440, 200, 30);
        add(l8);
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        t1.setBounds(300, 440, 400, 30);
        add(t1);

        //Add Addher No details component with Textfeild
        l9 = new JLabel("Addhar No:");
        l9.setFont(new Font("Raleway", Font.BOLD, 20));
        l9.setBounds(100, 490, 200, 30);
        add(l9);
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        t2.setBounds(300, 490, 400, 30);
        add(t2);

         //Add Existing Ac details component with JradioButton
        l10 = new JLabel("Existing Account:");
        l10.setFont(new Font("Raleway", Font.BOLD, 20));
        l10.setBounds(100, 540, 200, 30);
        add(l10);
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 540, 80, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        sNo = new JRadioButton("No");
        sNo.setBounds(450, 540, 80, 30);
        sNo.setBackground(Color.WHITE);
        add(sNo);

        ButtonGroup group = new ButtonGroup();
        group.add(eyes);
        group.add(sNo);

        //Add next component with Jbutton
        n1 = new JButton("Next");
        n1.setBackground(Color.WHITE);
        n1.setForeground(Color.BLACK);
        n1.setFont(new Font("Raleway",Font.BOLD,14));
        n1.setBounds(620, 660, 80, 30);
        n1.addActionListener(this);
        add(n1);

        getContentPane().setBackground(Color.WHITE);//Change the frame background color
        setSize(850, 800);//set the frame size
        setLocation(300, 0); // set the location of the frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        //Fatcht the valuess from the signuptwo form that fill up by the user and save in database
        String rili = (String) r1.getSelectedItem();
        String scat = (String) r2.getSelectedItem();
        String sInc = (String) r3.getSelectedItem();
        String sedu = (String) r4.getSelectedItem();
        String soccu = (String) r5.getSelectedItem();
        String sPan = t1.getText();
        String sAddh = t2.getText();
        String sexis = null;
        if (eyes.isSelected())
            sexis = "Yes";
        else if (sNo.isSelected())
            sexis = "No";

        try {
            if (t2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                Jdbc_con c1 = new Jdbc_con();//Connect with the Databes
                String q1 = "insert into signuptwo values('" + formno + "','" + rili + "','" + scat + "','" +sInc + "','" + sedu + "','" + sPan + "','" + sAddh + "','" + sexis +"','" + soccu + "')";
                c1.s.executeUpdate(q1);//fire the query

                setVisible(false);
                new SignUpThree(formno).setVisible(true);//whenever the signup one form fill up by user and press next button then the signuptwo form is open
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}