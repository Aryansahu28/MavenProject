package Bank.Management.System;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public  class SignupTwo extends JFrame implements ActionListener{
    
    JTextField panTextField, aadharTextField;
    @SuppressWarnings("rawtypes")
    JComboBox religionBox,categoryBox,incomeBox,qualificationBox,educationBox,occupationBox;
    JButton next;
    JRadioButton Yes,No,Existed,Not_Existed;
    String formNo;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public SignupTwo(String formNo){
        this.formNo = formNo;
         setLayout(null);
         setTitle("NEW ACCOUNTS APPLICATION FORM - PAGE 2");

        

        

        JLabel pagenum = new JLabel("Page No. 2");
        pagenum.setBounds(325,70,400,50);
        pagenum.setFont(new Font("Raleway",Font.BOLD,30));
        add(pagenum);
        
        JLabel religion = new JLabel("Religion:");
        religion.setBounds(100,160,200,30);
        religion.setFont(new Font("Arial",Font.BOLD,20));
        add(religion);

        String Religion[] = {"Hindu","Muslim","Sikh","Christanity","Other"};
        religionBox = new JComboBox(Religion);
        religionBox.setBounds(300,160,400,30);
        religionBox.setBackground(Color.white);
        add(religionBox);

        JLabel Category = new JLabel("Category:");
        Category.setBounds(100,210,200,30);
        Category.setFont(new Font("Arial",Font.BOLD,20));
        add(Category);

        String category[] = {"General","OBC","SC","ST","Others"};
        categoryBox = new JComboBox(category);
        categoryBox.setBounds(300,210,400,30);
        categoryBox.setBackground(Color.white);
        add(categoryBox);

        JLabel income = new JLabel("Income:");
        income.setBounds(100,260,200,30);
        income.setFont(new Font("Arial",Font.BOLD,20));
        add(income);
        
        String Income[] = {"<1,50,000","<2,50,000","<5,00,000","upto 10,000"};
        incomeBox = new JComboBox(Income);
        incomeBox.setBounds(300,260,400,30);
        incomeBox.setBackground(Color.white);
        add(incomeBox);
        


        JLabel educational = new JLabel("Educational:");
        educational.setBounds(100,310,200,30);
        educational.setFont(new Font("Arial",Font.BOLD,20));
        add(educational);

        String Education[] = {"Undergraduate","Postgraduate","Diploma","PHD","Others"};
        educationBox = new JComboBox(Education);
        educationBox.setBounds(300,310,400,30);
        educationBox.setBackground(Color.white);
        add(educationBox);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setBounds(100,360,200,30);
        qualification.setFont(new Font("Arial",Font.BOLD,20));
        add(qualification);


        String Qualification[] = {"Undergraduate","Postgraduate","Diploma","PHD","Others"};
        qualificationBox = new JComboBox(Qualification);
        qualificationBox.setBounds(300,360,400,30);
        qualificationBox.setBackground(Color.white);
        add(qualificationBox);

        

        
        JLabel occupation = new JLabel("Occupational:");
        occupation.setBounds(100,410,200,30);
        occupation.setFont(new Font("Arial",Font.BOLD,20));
        add(occupation);

        String Occupation[] = {"Student","Businessman","Salaried","Self-employed","Others"};
        occupationBox = new JComboBox(Occupation);
        occupationBox.setBounds(300,410,400,30);
        occupationBox.setBackground(Color.white);
        add(occupationBox);

        
        
        JLabel pan = new JLabel("PAN Number:");
        pan.setBounds(100,460,200,30);
        pan.setFont(new Font("Arial",Font.BOLD,20));
        add(pan);

        panTextField = new JTextField();
        panTextField.setBounds(300,460,400,30);
        add(panTextField);
        
        
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setBounds(100,510,200,30);
        aadhar.setFont(new Font("Arial",Font.BOLD,20));
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setBounds(300,510,400,30);
        add(aadharTextField);
        
        JLabel Senior = new JLabel("Senior Citizen:");
        Senior.setBounds(100,560,200,30);
        Senior.setFont(new Font("Arial",Font.BOLD,20));
        add(Senior);

        Yes = new JRadioButton("Yes");
        Yes.setBounds(300,560,100,30);
        Yes.setBackground(Color.white);
        add(Yes);

        No = new JRadioButton("No");
        No.setBounds(450,560,100,30);
        No.setBackground(Color.white);
        add(No);

        ButtonGroup bg = new ButtonGroup();
        bg.add(Yes);
        bg.add(No);
             
        
        JLabel existing = new JLabel("Existing Account:");
        existing.setBounds(100,610,200,30);
        existing.setFont(new Font("Arial",Font.BOLD,20));
        add(existing);

        Existed = new JRadioButton("Existed");
        Existed.setBounds(300,610,100,30);
        Existed.setBackground(Color.white);
        add(Existed);

        Not_Existed = new JRadioButton("Not Existed");
        Not_Existed.setBounds(450,610,100,30);
        Not_Existed.setBackground(Color.white);
        add(Not_Existed);

        ButtonGroup bng = new ButtonGroup();
        bng.add(Existed);
        bng.add(Not_Existed);


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

    @Override
    public void actionPerformed(ActionEvent ae){
        String sreligion =(String)religionBox.getSelectedItem();
        String scategory = (String)categoryBox.getSelectedItem();
        String sincome = (String)incomeBox.getSelectedItem();

        String seducation = (String)educationBox.getSelectedItem();

        String squalification = (String)qualificationBox.getSelectedItem();

        String soccupation = (String)occupationBox.getSelectedItem();

        String Senior = null;
        if(Yes.isSelected()){
            Senior = "Yes";
        }else if(No.isSelected()){
            Senior = "No";
        }

        String existing = null;
        if(Existed.isSelected()){
            existing = "Existed";
        }else if(Not_Existed.isSelected()){
            existing = "NO";
        }

        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();
        


        try{
            if(religionBox == null ){
                JOptionPane.showMessageDialog(null, "Name is required");
            }
            else{
                Conn c = new Conn();
                String query = "INSERT INTO signuptwo VALUES('"+formNo+"','"+scategory+"','"+sincome+"','"+seducation+"','"+squalification+"','"+soccupation+"','"+pan+"','"+aadhar+"','"+Senior+"','"+existing+"','"+sreligion+"')";
                System.out.println("Query : " + query);
            try {
                c.s.executeUpdate(query);
                
            } catch (SQLException e) {
                System.out.println(e);
            }

                setVisible(false);
                new Signupthree(formNo).setVisible(true);
               


            }
        }catch(HeadlessException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        new SignupTwo("");
        
    }
}