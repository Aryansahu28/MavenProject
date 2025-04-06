package Bank.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Signupthree extends JFrame implements ActionListener{

    JButton submit,cancel;
    JRadioButton saving,fixedAccount,recurringAccount,currentAccount;
    JCheckBox declaration,atm,Mobile,internet,email,cheque,estatement;
    String formno;
    public Signupthree(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("ACCOUNT PAGE NO-3");
        
        JLabel heading = new JLabel("Page 3: Account Details");
        heading.setBounds(250,50,500,30);
        heading.setBackground(Color.white);
        heading.setFont(new Font("Arial",Font.BOLD,28));
        add(heading);
        
        JLabel type = new JLabel("Account type");
        type.setBounds(100,150,250,30);
        type.setFont(new Font("Arial",Font.BOLD,18));
        type.setBackground(Color.white);
        type.setForeground(Color.BLACK);
        add(type);

        saving = new JRadioButton("Saving Account");
        saving.setBackground(Color.white);
        saving.setBounds(100,180,250,30);
        add(saving); 


        fixedAccount = new JRadioButton("Fixed Deposit Account");
        fixedAccount.setBackground(Color.white);
        fixedAccount.setBounds(350,180,400,30);
        add(fixedAccount); 


        currentAccount = new JRadioButton("Current Account");
        currentAccount.setBackground(Color.white);
        currentAccount.setBounds(100,210,250,30);
        add(currentAccount); 


        recurringAccount = new JRadioButton("Recurring Deposit Account");
        recurringAccount.setBackground(Color.white);
        recurringAccount.setBounds(350,210,500,30);
        add(recurringAccount); 

        ButtonGroup bg = new ButtonGroup();
        bg.add(saving);
        bg.add(recurringAccount);
        bg.add(currentAccount);
        bg.add(fixedAccount);


        JLabel cardnum = new JLabel("Card Number");
        cardnum.setBounds(100,250,350,30);
        cardnum.setBackground(Color.white);
        cardnum.setFont(new Font("Arial",Font.BOLD,18));
        add(cardnum);


        JLabel card = new JLabel("XXXX-XXXX-XXXX-XXXX4188");
        card.setBounds(350,250,350,30);
        card.setBackground(Color.white);
        card.setFont(new Font("Arial",Font.BOLD,18));
        add(card);

        

        JLabel subcardnum = new JLabel("Your 16 Digit Card Number");
        subcardnum.setBounds(100,280,350,15);
        subcardnum.setBackground(Color.white);
        subcardnum.setFont(new Font("Arial",Font.BOLD,8));
        add(subcardnum);


        JLabel pin = new JLabel("PIN:");
        pin.setBounds(100,300,350,30);
        pin.setBackground(Color.white);
        pin.setFont(new Font("Arial",Font.BOLD,18));
        add(pin);


        JLabel pin_num = new JLabel("XXXX");
        pin_num.setBounds(350,300,350,30);
        pin_num.setBackground(Color.white);
        pin_num.setFont(new Font("Arial",Font.BOLD,18));
        add(pin_num);

        

        JLabel subpin = new JLabel("Your 4 Digit Password");
        subpin.setBounds(100,330,350,15);
        subpin.setBackground(Color.white);
        subpin.setFont(new Font("Arial",Font.BOLD,8));
        add(subpin);

        JLabel service = new JLabel("Services Required");
        service.setBounds(100,350,300,20);
        service.setFont(new Font("Arial",Font.BOLD,18));
        service.setForeground(Color.BLACK);
        add(service);

        atm = new JCheckBox("ATM Card");
        atm.setBounds(100,370,200,30);
        atm.setForeground(Color.black);
        add(atm);

        internet = new JCheckBox("Internet Banking");
        internet.setBounds(380,370,300,30);
        internet.setForeground(Color.black);
        add(internet);


        Mobile = new JCheckBox("Mobile Banking");
        Mobile.setBounds(100,400,200,30);
        Mobile.setForeground(Color.black);
        add(Mobile);


        email = new JCheckBox("EMAIL & SMS Alerts");
        email.setBounds(380,400,300,30);
        email.setForeground(Color.black);
        add(email);

        cheque = new JCheckBox("Cheque Book");
        cheque.setBounds(100,430,200,30);
        cheque.setForeground(Color.black);
        add(cheque);

        estatement = new JCheckBox("E-Statement");
        estatement.setBounds(380,430,300,30);
        estatement.setForeground(Color.black);
        add(estatement);

        

        declaration = new JCheckBox("I hereby declared that all the terms and conditions are accepted");
        declaration.setBounds(100,500,800,30);
        declaration.setForeground(Color.black);
        add(declaration);

        submit = new JButton("submit");
        submit.setBounds(450,650,100,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);


        cancel = new JButton("cancel");
        cancel.setBounds(550,650,100,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);



        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        
        
            String account_type = null;
                if(saving.isSelected()){
                    account_type = "Saving Account";

                }else if(fixedAccount.isSelected()){
                    account_type = "Fixed Account";
                }else if(recurringAccount.isSelected()){
                    account_type = "Recurring Account";
                }else if(currentAccount.isSelected()){
                    account_type = "Current Account";
                }
                
                Random ran = new Random();
                long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
                String cardnum =  "" + Math.abs(first7);
                System.out.println(cardnum);
                long first3 = (ran.nextLong() % 9000L) + 1000L;
                String pin_num =  "" + Math.abs(first3);

                String facility = "";
                if(atm.isSelected()){
                    facility = facility + "ATM Card";
                }else if(Mobile.isSelected()){
                    facility = facility + "Mobile Banking";
                }else if(email.isSelected()){
                    facility = facility + "EMAIL & SMS Alerts";
                }else if(internet.isSelected()){
                    facility = facility + "Internet Banking";
                }else if(cheque.isSelected()){
                    facility = facility + "Cheque Book";
                }else if(estatement.isSelected()){
                    facility = facility + "E-statement";
                }
            
                
                try{
                    if(ae.getSource()==submit){
                        
                        if(account_type.equals("")){
                            JOptionPane.showMessageDialog(null, "Fill all the required fields");
                        }else{
                            Conn c1 = new Conn();
                            String q1 = "INSERT INTO signupthree VALUES('"+formno+"','"+cardnum+"','"+pin_num+"','"+account_type+"','"+facility+"')";  
                            String q2 = "insert into login values('"+formno+"','"+cardnum+"','"+pin_num+"')";
                            c1.s.executeUpdate(q1);
                            c1.s.executeUpdate(q2);
                            JOptionPane.showMessageDialog(null, "Card Number: " + cardnum + "\n Pin:"+ pin_num);
                            
                            new deposit(pin_num).setVisible(true);
                            setVisible(false);
                            new BalanceEnquiry(pin_num);
                        }
                    
                    }else if(ae.getSource()==cancel){
                        System.exit(0);
                    }
                    
                }catch(Exception ex){
                    ex.printStackTrace();
                }

               
        
            }
    public static void main(String[] args){
            new Signupthree("");
    }
}
