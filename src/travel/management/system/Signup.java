
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Signup extends JFrame implements ActionListener {
    
    JButton b1,b2; // globally defined these buttons to access from outside the cunstructor and used by abstract method of actionlisener class (actionperformed)
    JTextField tfusername,tfname,tfpassword,tfanswer;
    Choice security; // same concept as button
    Signup(){
        setTitle("Create Account");
        setBounds(350, 200, 900, 360); // setBounds is method which is intrigated versio of setSize() and setLocation()
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400); // x=0,y=0,width=500, height=400
        p1.setLayout(null);
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tohama",Font.BOLD, 14));
        lblusername.setBounds(50,30,130,30);
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(190, 30, 180,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tohama",Font.BOLD, 14));
        lblname.setBounds(50,70,130,30);
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(190, 70, 180,30);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tohama",Font.BOLD, 14));
        lblpassword.setBounds(50,110,130,30);
        p1.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(190, 110, 180,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font("Tohama",Font.BOLD, 14));
        lblsecurity.setBounds(50,150,130,30);
        p1.add(lblsecurity);
        
        security = new Choice();
        security.add("your lucky number");
        security.add("your lucky person");
        security.add("your first school");
        security.add("your pet name");
        security.add("your fav criketer");
        security.setBounds(190,150,180,30);
        p1.add(security);
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Tohama",Font.BOLD, 14));
        lblanswer.setBounds(50,190,130,30);
        p1.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(190, 190, 180,30);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        b1 = new JButton("Create");
        b1.setBackground(Color.white);
        b1.setForeground(new Color(133,193,233));
        b1.setFont(new Font("Tohama",Font.BOLD, 14));
        b1.setBounds(80,250,100,30);
        b1.addActionListener(this); // calling actionperformed method
        p1.add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.white);
        b2.setForeground(new Color(133,193,233));
        b2.setFont(new Font("Tohama",Font.BOLD, 14));
        b2.setBounds(250,250,100,30);
        b2.addActionListener(this); // calling actionperformed method
        p1.add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup3.jpg"));
        Image i2=i1.getImage().getScaledInstance(300,310,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50,250, 250);
        add(image);
        
        
        setVisible(true);
    }
    
    //abstract class of actionlistener
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String username = tfusername.getText(); // tfusernamr.getText() will get the value of username which is of string type. 
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();
            
            String query = "Insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')"; //sql query to store those entities in database
            try{
                Conn c=new Conn(); // object of conn class which make connection with mysql 
                c.s.executeUpdate(query); // dml ststement to execute the sql query with the help of statement class 
                JOptionPane.showMessageDialog(null, "Account created successfully");
                setVisible(false);
                new Login();
               }catch(Exception e){
                   e.printStackTrace();
               }
        }else if(ae.getSource()==b2){
            setVisible(false); // after pressing back button, signup page will not be visible.
            new Login(); // it will open login class
        }
         
       }
    
    public static void main(String[] args){
        new Signup();
    }
}
