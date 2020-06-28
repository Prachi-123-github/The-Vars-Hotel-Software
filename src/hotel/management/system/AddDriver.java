
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddDriver extends JFrame implements ActionListener {
    
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1,c2;
    JButton b1,b2;
    
    AddDriver()
    {
        JLabel l1=new JLabel("Add Driver");
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l1.setBounds(150,20,150,30);
        add(l1);
        
        JLabel name=new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,14));
        name.setBounds(60,70,100,30);
        add(name);
        
        t1=new JTextField();
        t1.setBounds(200,70,150,30);
        add(t1);
        
        JLabel age=new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.PLAIN,14));
        age.setBounds(60,110,100,30);
        add(age);
        
        t2=new JTextField();
        t2.setBounds(200,110,150,30);
        add(t2);
        
        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.PLAIN,14));
        gender.setBounds(60,150,100,30);
        add(gender);
        
        c1=new JComboBox(new String[]{"Male","Female"});
        c1.setBounds(200,150,150,30);
        c1.setBackground(Color.WHITE);
        add(c1);
        
         
        JLabel car=new JLabel("Car Company");
        car.setFont(new Font("Tahoma",Font.PLAIN,14));
        car.setBounds(60,190,100,30);
        add(car);
        
        
        t3=new JTextField();
        t3.setBounds(200,190,150,30);
        add(t3);
        
        JLabel model=new JLabel("Car Model");
        model.setFont(new Font("Tahoma",Font.PLAIN,14));
        model.setBounds(60,230,100,30);
        add(model);
        
        
        t4=new JTextField();
        t4.setBounds(200,230,150,30);
        add(t4);
        
        JLabel available=new JLabel("Available");
        available.setFont(new Font("Tahoma",Font.PLAIN,14));
        available.setBounds(60,270,100,30);
        add(available);
        
        c2=new JComboBox(new String[]{"Available","Busy"});
        c2.setBounds(200,270,150,30);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        JLabel location=new JLabel("Location");
        location.setFont(new Font("Tahoma",Font.PLAIN,14));
        location.setBounds(60,310,100,30);
        add(location);
        
        
        t5=new JTextField();
        t5.setBounds(200,310,150,30);
        add(t5);
        
        b1=new JButton("Add Driver");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60,370,130,30);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(210,370,130,30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l2=new JLabel(i3);
        l2.setBounds(400,80,500,300);
        add(l2);
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(435,200,1000,490);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String name=null;
            String namePattern="^[A-Z][a-z]{1,30}$";
            Pattern pattern=Pattern.compile(namePattern);
            Matcher regexMatcher=pattern.matcher(t1.getText());
            if(!regexMatcher.matches())
            {
                JOptionPane.showMessageDialog(null,"Invalid Formate of Name");
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
            String gender=(String)c1.getSelectedItem();
            String company=t3.getText();
            String brand=t4.getText();
            String available=(String)c2.getSelectedItem();
            String location=t5.getText();
            if(t3.getText().trim().isEmpty()||t4.getText().trim().isEmpty()||t5.getText().trim().isEmpty())
            {
                JOptionPane.showMessageDialog(null,"All the data must compulsory");
               
                return;
            }
            conn c=new conn();
            
            
            String str="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
            
            try
            {
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Successfully Driver Added");
                setVisible(false);
            }
            catch(Exception e)
            {
                  System.out.println(e);
            }
        }
        else if(ae.getSource()==b2)
        {
            System.exit(0);
        }
    }
    
    public static void main(String args[])
    {
        new AddDriver().setVisible(true);
    }
}
