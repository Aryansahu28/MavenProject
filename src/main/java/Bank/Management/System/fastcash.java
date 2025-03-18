package Bank.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class fastcash extends JFrame implements ActionListener{

    JButton deposit,exit,ministatement,fastcash,pinchange,withdrawal,balanceenquiry;
    String pinnumber;
    public fastcash(String string) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resources/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        
        withdrawal = new JButton("500");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);


        ministatement = new JButton("1000");
        ministatement.setBounds(170,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);


        fastcash = new JButton("2000");
        fastcash.setBounds(355,450,150,30);  
        fastcash.addActionListener(this);
        image.add(fastcash);


        pinchange = new JButton("5000");  
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("10000");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

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
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else{
            String amount = (((JButton)ae.getSource()).getText().substring(3));
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance  += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance-= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(ae.getSource() != exit && balance < Integer.parseInt(amount))
                
                {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                LocalDate date = LocalDate.now();
                String query = "Insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Sucessfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }

            
        }
    }

    public static void main(String[] args){
        new fastcash("");
    }

}
