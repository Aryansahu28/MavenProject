package Bank.Management.System;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;


public class Ministatement extends JFrame implements ActionListener{
    String pinnumber;
    public Ministatement(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        setTitle("Mini-Statement");

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bal = new JLabel();
        bal.setBounds(20,400,300,20);
        add(bal);


        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM login where pin ='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number : "+rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");
            
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("amount") + "<br><br><html>");
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        try{
            int balanced = 0;
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pinnumber='"+pinnumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balanced += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balanced -= Integer.parseInt(rs.getString("amount"));
                }
                bal.setText("Your account's Current Balance is :"+balanced);
            }

        }catch(Exception e){
            System.out.println(e);
        }


        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String[] args){
        new Ministatement("");
    }

}
