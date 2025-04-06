package Bank.Management.System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
public class BalanceEnquiry extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;

    public BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        Conn c = new Conn();
        int balance = 0;
        try{ 
            System.out.println(pinnumber);
            ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
                if ((rs.getString("type")).equals("Deposit")){
                    String am = rs.getString("amount");
                    balance  += Integer.parseInt(rs.getString("amount"));
                    System.out.println(am);
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        System.out.println(balance);
        JLabel text = new JLabel("Balance of your Bank Account is : " + balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,15));
        text.setBounds(170,300,400,30);
        image.add(text);
        

        back = new JButton("Back");
        // back.setForeground(Color.WHITE);
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){

            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        }
    }

    public static void main(String[] args){
        new BalanceEnquiry("");
    }
    
}
