package Bank.Management.System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Pinchange extends JFrame implements ActionListener{
    JPasswordField pinTextField;
    JPasswordField repinTextField;
    JButton change;
    JButton back;
    String pinnumber;

    public Pinchange(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel pinText = new JLabel("New Pin:");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("Raleway",Font.BOLD,16));
        pinText.setBounds(165,320,180,25);
        image.add(pinText);

        pinTextField = new JPasswordField();
        pinTextField.setBackground(Color.WHITE);
        pinTextField.setFont(new Font("System",Font.BOLD,16));
        pinTextField.setBounds(330,320,180,25);
        pinTextField.addActionListener(this);
        image.add(pinTextField);

        JLabel repinText = new JLabel("Re-Enter New Pin:");
        repinText.setForeground(Color.WHITE);
        repinText.setFont(new Font("Raleway",Font.BOLD,16));
        repinText.setBounds(165,360,180,25);
        image.add(repinText);

        repinTextField = new JPasswordField();
        repinTextField.setBackground(Color.WHITE);
        repinTextField.setFont(new Font("System",Font.BOLD,16));
        repinTextField.setBounds(330,360,180,25);
        repinTextField.addActionListener(this);
        image.add(repinTextField);

        change = new JButton("change");
        change.setBounds(355,485,150,25);
        change.addActionListener(this);
        image.add(change);


        back = new JButton("Back");
        back.setBounds(355,520,150,25);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try {
                char[] pinstext = pinTextField.getPassword();
                String pintext = new String(pinstext);
                char[] repinstext = repinTextField.getPassword();
                String repintext = new String(repinstext);
                if(pintext.equals("")){
                    JOptionPane.showMessageDialog(null,"Pin empty");
                    return;
                }
                
                if(!pintext.equals(repintext)){
                    JOptionPane.showMessageDialog(null,"New Pin and Reenter pin is not matching");
                    return;
                }

                if(pinTextField.equals("")){
                    JOptionPane.showMessageDialog(null,"Pin empty");
                    return;
                }
                if(repinTextField.equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Pin empty");
                    return;
                }

                Conn c = new Conn();
                String query1 = "update bank set pinnumber = '"+repintext+"' where pinnumber ='"+pinnumber+"'";
                String query2 = "update login set pin = '"+repintext+"' where pin ='"+pinnumber+"'";
                String query3 = "update signupthree set pin_num = '"+repintext+"' where pin_num ='"+pinnumber+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Pin Change Sucessfully");
                setVisible(false);
                new Transactions(repintext).setVisible(true);



            } catch (Exception e) {
                System.out.println(e);
            }
        }else{

        }

    }

    public static void main(String[] args){
        new Pinchange("");
    }
}
