package Bank.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposit,exit;
    String pinnumber;
    public deposit(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resources/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please enter an amount to deposit");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);

        amount = new JTextField();
        amount.setBounds(200,350,300,25);
        amount.setBackground(Color.white);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        String number = amount.getText();
        if(ae.getSource()==deposit){
           LocalDate date = LocalDate.now();
            Conn c = new Conn();
            String query = "INSERT INTO bank VALUES('pinnumber','"+date+"','Deposit','"+number+"')";
            try{
                c.s.executeUpdate(query);
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == exit){
            setVisible(false);
            new login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new deposit("");
    }
}
