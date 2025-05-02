
package travel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    JButton login,signup,fpassword;
    JTextField tfpassword,tfusername;
    Login(){
        setTitle("Login");
        setSize(900,400); //dimesion of frame
        setLocation(350,200); // left se 400 and uper se 200
        setBackground(new Color(255, 255, 204));
        setLayout(null);
        JPanel p1=new JPanel();
        //p1.setBackground(Color.white); // changing background color of panel which is over frame
        p1.setBackground(new Color(131,193,233)); // object of color class which takes the args in form of rgb and change the background color of panel
        p1.setBounds(0,0,400,400); // x,y,width,height
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);
        
        JPanel p2 =new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300); // p2 frame pr kaha chahiye ye btata h setbounds method
        add(p2); // frame pr add ho gya p2
        
        JLabel lblusername = new JLabel("Username"); // jlabel text likhta h frame ya panel ke uper
        lblusername.setBounds(60, 20, 100, 25); // ye text kaha chahiye : 60 from left,20 from up,100 :lenght/width of text, height of text 25
        lblusername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20)); // text ka font style,font type,font size set kiye setfont class ke help se
        p2.add(lblusername); // p2 panel pr add kr diye text ko
        
        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30); // 60 from left, 60 (> 20 +25 = tab niche aayega username ke sahi se) from up, 300 = length/width of text, 30 =height of text
        tfusername.setBorder(BorderFactory.createEmptyBorder()); // remove the border 
        p2.add(tfusername);
        
        JLabel lblpassword = new JLabel("Password"); // jlabel text likhta h frame ya panel ke uper
        lblpassword.setBounds(60, 110, 100, 25); // ye text kaha chahiye : 60 from left,110 (> 60+25) from up,100 :lenght/width of text, height of text 25
        lblpassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 20)); // text ka font style,font type,font size set kiye setfont class ke help se
        p2.add(lblpassword); // p2 panel pr add kr diye text ko
        
        tfpassword = new JTextField();
        tfpassword.setBounds(60, 150, 300, 30); // 60 from left, 150 (> 110+25 = tab niche aayega username ke sahi se) from up, 300 = length/width of text, 30 =height of text
        tfpassword.setBorder(BorderFactory.createEmptyBorder()); // remove the border 
        p2.add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193, 233));
        login.setForeground(Color.white);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("Signup");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(133,193, 233));
        signup.setForeground(Color.white);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);
        
        fpassword = new JButton("Forget Password");
        fpassword.setBounds(150,250,130,30);
        fpassword.setBackground(new Color(133,193, 233));
        fpassword.setForeground(Color.white);
        fpassword.setBorder(new LineBorder(new Color(133, 193, 233)));
        fpassword.addActionListener(this);
        p2.add(fpassword);
        
        JLabel text =new JLabel("Trouble in LogIn");
        text.setBounds(300, 255, 150, 20);
        text.setForeground(Color.red);
        p2.add(text);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            try{
                String username =tfusername.getText();
                String password =tfpassword.getText();
                
                String query = "select * from account where username = '"+username+"' AND password = '"+password+"'";
                Conn c=new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Credentials");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==signup){
            setVisible(false);
            new Signup();
        }else{
            setVisible(false);
            new ForgetPassword();
        }
    }
    
    public static void main(String[] args){
        new Login(); //anonumos object
            
        }
    
}
