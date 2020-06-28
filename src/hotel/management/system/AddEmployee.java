
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddEmployee  extends JFrame implements ActionListener{

    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox c1;
    JButton b1;
    
    AddEmployee()
    {
        JLabel name=new JLabel("NAME");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(60,30,120,30);
        add(name);
    
        t1=new JTextField();
        t1.setBounds(200,30,150,30);
        add(t1);
        
        JLabel age=new JLabel("AGE");
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        age.setBounds(60,80,120,30);
        add(age);
    
        t2=new JTextField();
        t2.setBounds(200,80,150,30);
        add(t2);
        
        
        JLabel gender=new JLabel("GENDER");
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        gender.setBounds(60,130,120,30);
        add(gender);
        
        
        r1=new JRadioButton("MALE");
        r1.setFont(new Font("Tahoma",Font.PLAIN,12));
        r1.setBackground(Color.WHITE);
        r1.setBounds(200,130,70,30);
        add(r1);
        
         
        r2=new JRadioButton("FEMALE");
        r2.setFont(new Font("Tahoma",Font.PLAIN,12));
        r2.setBackground(Color.WHITE);
        r2.setBounds(280,130,70,30);
        add(r2);
        
        JLabel job=new JLabel("JOB");
        job.setFont(new Font("Tahoma",Font.PLAIN,17));
        job.setBounds(60,180,120,30);
        add(job);
        
        String str[]={"Front Desk Clerk","Porters","Housekeeping","Kitchen Staff","Room Setvice","Waiter/Waitress","Manager","Accountant","Chef"};
        c1=new JComboBox(str);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200,180,150,30);
        add(c1);
        
        
        JLabel salary=new JLabel("SALARY");
        salary.setFont(new Font("Tahoma",Font.PLAIN,17));
        salary.setBounds(60,230,120,30);
        add(salary);
        
        t3=new JTextField();
        t3.setBounds(200,230,150,30);
        add(t3);
        
        JLabel phone=new JLabel("PHONE");
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        phone.setBounds(60,280,120,30);
        add(phone);
        
        t4=new JTextField();
        t4.setBounds(200,280,150,30);
        add(t4);
        
        JLabel aadhar=new JLabel("AADHAR");
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        aadhar.setBounds(60,330,120,30);
        add(aadhar);
        
        t5=new JTextField();
        t5.setBounds(200,330,150,30);
        add(t5);
        
        JLabel email=new JLabel("EMAIL");
        email.setFont(new Font("Tahoma",Font.PLAIN,17));
        email.setBounds(60,380,120,30);
        add(email);
        
        t6=new JTextField();
        t6.setBounds(200,380,150,30);
        add(t6);
        
        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(200,430,150,30);
        b1.setFont(new Font("Tahoma",Font.PLAIN,17));
        b1.addActionListener(this);
        add(b1);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(440,460,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(360,70,440,460);
        add(l1);
        
        JLabel l2=new JLabel("ADD EMPLOYEE DETAILS");
        l2.setForeground(Color.BLUE);
        l2.setBounds(390,30,350,30);
        l2.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(l2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(465,220,850,560);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        
        String name=null;
        String namePattern;
        namePattern = "^[A-Z][a-z]{1,30}$";
        Pattern pattern=Pattern.compile(namePattern);
        Matcher regexMatcher=pattern.matcher(t1.getText());
        if(!regexMatcher.matches())
        {
            JOptionPane.showMessageDialog(null,"Invalid Formate of Name, First letter in Captical and rest are in small format");
            t1.setText("");
            return;
        }
        else
        {
            name=t1.getText();
        }
        
        String age=null;
        int ageNumber = 0;
        try{
            ageNumber=Integer.parseInt(t2.getText());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Invalid Age, Age Must be in Range of 18 years to 60 years and In number format");
            t2.setText("");
            return;
        }
        
        if(ageNumber<18 || ageNumber>60)
        {
            JOptionPane.showMessageDialog(null,"Invalid Age, Age Must be in Range of 18 years to 100 years");
            t2.setText("");
            return;
        }
        else
        {
            age=Integer.toString(ageNumber);
        }
        
        String salary=null;
        int salaryNumber;
        int flag=0;
        try
        {
            salaryNumber=Integer.parseInt(t3.getText());
            flag=1;
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null,"Invalid Salary, In number format");
             t3.setText("");
             return;
        }
        
        if(flag==1)
        salary=t3.getText();
        
        
        String phone=null;
        String phonePattern="^[7-9][0-9]{9}$";
        Pattern pattern1=Pattern.compile(phonePattern);
        Matcher regexMatcher1=pattern1.matcher(t4.getText());
        if(!regexMatcher1.matches())
        {
            JOptionPane.showMessageDialog(null,"Invalid Formate of Phone Number");
            t4.setText("");
            return;
        }
        else
        {
            phone=t4.getText();
        }
        
        String aadhar=null;  
        String aadharPattern="^[0-9]{12}$";
        Pattern patternAadhar=Pattern.compile(aadharPattern);
        Matcher regexMatcherAadhar=patternAadhar.matcher(t5.getText());
        if(!regexMatcherAadhar.matches())
        {
            JOptionPane.showMessageDialog(null,"Invalid Formate of Aadhar Number");
            t5.setText("");
            return;
        }
        else
        {
            aadhar=t5.getText();
        }
         
         String email=null;
        String emailPattern="^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[a-z]{2,4}$";
        Pattern patternEmail=Pattern.compile(emailPattern);
        Matcher regexMatcherEmail=patternEmail.matcher(t6.getText());
        if(!regexMatcherEmail.matches())
        {
            JOptionPane.showMessageDialog(null,"Invalid Formate of Email");
            t6.setText("");
            return;
        }
        else
        {
            email=t6.getText();
        }
         
        String gender=null;
        
        if(r1.isSelected())
        {
            gender="Male";
        }
        if(r2.isSelected())
        {
            gender="Female";
        }
        
        String job=(String)c1.getSelectedItem();
     
        
        conn c=new conn();
        
        String str="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
        try
        {
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"Successfully New Employee Added");
            this.setVisible(false);
        }
        catch(Exception e)
        {
           System.out.println(e);
        }
    }
    
    public static void main(String [] args)
    {
        new AddEmployee().setVisible(true);
    }
    
}
