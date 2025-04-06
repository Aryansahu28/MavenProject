/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Bank.Management.System;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




public class login extends JFrame implements ActionListener{
    
    JButton login,clear,signup;
    JTextField CardTextField;
    JPasswordField pinTextField;
    public login(){

        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(getClass().getResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to the ATM");
        text.setFont(new Font("Oswald",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);


        JLabel CardNo = new JLabel("Card No:");
        CardNo.setFont(new Font("Raleway",Font.BOLD,25));
        CardNo.setBounds(120,150,150,30);
        add(CardNo);

        CardTextField = new JTextField();
        CardTextField.setFont(new Font("Arial",Font.PLAIN,15));
        CardTextField.setBounds(300,150,230,30);
        add(CardTextField);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(120,220,250,30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);

        login = new JButton("Sign In");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Sign Up");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        

        getContentPane().setBackground(Color.white);



        setSize(800, 500);
        setVisible(true);
        setLocation(350,200);
    }

    

    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == clear){
                CardTextField.setText("");
                pinTextField.setText("");

            } else if(ae.getSource() == login){
                Conn c = new Conn();
                String cardnumber = CardTextField.getText();
                char[] pinnumbers = pinTextField.getPassword();
                String pinnumber = new String(pinnumbers);
                String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
                try{
                   ResultSet rs = c.s.executeQuery(query);
                   if(rs.next()){
                    try{

                        setVisible(false);
                        Transactions trs =new Transactions(pinnumber);
                        trs.setVisible(true);
                    }catch(Exception e){
                        System.out.println(e);
                    }
                   }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card number or pin");
                   }
                }catch(SQLException e){
                    System.out.println(e);
                }
            } else if (ae.getSource()== signup){
                try {
                    
                    setVisible(false);

                    SignupOne sgone = new SignupOne();
                    sgone.setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            }
    }
    public static void main(String[] args){
        new login();
        System.out.println("Login working");
    }
}