package Bank.Management.System;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fnameTextField, emailTextField, addressTextField, CityTextField, pincodeTextField, stateTextField;
    JButton next;
    JTextField dobTextField;
    JRadioButton male,female,other,married,unmarried;
    JLabel dob;

    public SignupOne(){
        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000) + 1000);
        

        JLabel application = new JLabel("Application No." + random);
        application.setBounds(250,10,400,50);
        application.setFont(new Font("Raleway",Font.BOLD,38));
        add(application);

        JLabel pagenum = new JLabel("Page No. 1");
        pagenum.setBounds(325,70,400,50);
        pagenum.setFont(new Font("Raleway",Font.BOLD,30));
        add(pagenum);
        
        JLabel name = new JLabel("Name:");
        name.setBounds(100,160,200,30);
        name.setFont(new Font("Arial",Font.BOLD,20));
        add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(300,160,400,30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(100,210,200,30);
        fname.setFont(new Font("Arial",Font.BOLD,20));
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setBounds(300,210,400,30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(100,260,200,30);
        dob.setFont(new Font("Arial",Font.BOLD,20));
        add(dob);
        
        // Replace the JDateChooser with a JTextField for date input


    // Inside the constructor, replace the JDateChooser setup
    dob = new JLabel("Date of Birth:");
    dob.setBounds(100, 260, 200, 30);
    dob.setFont(new Font("Arial", Font.BOLD, 20));
    add(dob);

    dobTextField = new JTextField();
    dobTextField.setBounds(300, 260, 400, 30);
    dobTextField.setFont(new Font("Arial", Font.PLAIN, 16));
    dobTextField.setToolTipText("Enter date in dd/MM/yyyy format");
    add(dobTextField);
        


        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100,310,200,30);
        gender.setFont(new Font("Arial",Font.BOLD,20));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,310,60,30);
        male.setBackground(Color.white);
        add(male);
        

        female = new JRadioButton("Female");
        female.setBounds(450,310,100,30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email:");
        email.setBounds(100,360,200,30);
        email.setFont(new Font("Arial",Font.BOLD,20));
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(300,360,400,30);
        add(emailTextField);

        
        JLabel marital = new JLabel("Marital Status:");
        marital.setBounds(100,410,200,30);
        marital.setFont(new Font("Arial",Font.BOLD,20));
        add(marital);

        married = new JRadioButton("married");
        married.setBounds(300,410,100,30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("unmarried");
        unmarried.setBounds(420,410,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        other = new JRadioButton("other");
        other.setBounds(540,410,100,30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup bgmartial = new ButtonGroup();
        bgmartial.add(married);
        bgmartial.add(unmarried);
        bgmartial.add(other);

        
        
        JLabel address = new JLabel("Address:");
        address.setBounds(100,460,200,30);
        address.setFont(new Font("Arial",Font.BOLD,20));
        add(address);

        addressTextField = new JTextField();
        addressTextField.setBounds(300,460,400,30);
        add(addressTextField);
        
        
        JLabel City = new JLabel("City:");
        City.setBounds(100,510,200,30);
        City.setFont(new Font("Arial",Font.BOLD,20));
        add(City);

        CityTextField = new JTextField();
        CityTextField.setBounds(300,510,400,30);
        add(CityTextField);
        
        JLabel state = new JLabel("State:");
        state.setBounds(100,560,200,30);
        state.setFont(new Font("Arial",Font.BOLD,20));
        add(state);

        stateTextField = new JTextField();
        stateTextField.setBounds(300,560,400,30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode:");
        pincode.setBounds(100,610,200,30);
        pincode.setFont(new Font("Arial",Font.BOLD,20));
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setBounds(300,610,400,30);
        add(pincodeTextField);


        next = new JButton("Next");
        next.setForeground(Color.white);
        next.setBackground(Color.black);
        next.setBounds(600,650,150,40);
        next.addActionListener(this);
        add(next);




        getContentPane().setBackground(Color.white);


        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = dobTextField.getText(); // Get the date from the JTextField
    
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
    
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }
    
        String address = addressTextField.getText();
        String city = CityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();
    
        // Validate the date format
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
    String formattedDob = null;
    try {
        formattedDob = dbFormat.format(inputFormat.parse(dob));
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(null, "Invalid date format. Please enter the date in dd/MM/yyyy format.");
        return;
    }
    
        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signup VALUES('"+formno+"','"+name+"','"+fname+"','"+formattedDob+"','"+gender+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                c.s.executeUpdate(query);
    
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    public static void main(String[] args){
        new SignupOne();
    }

}