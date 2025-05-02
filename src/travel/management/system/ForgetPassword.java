
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {
    
    JTextField tfusername,tfname,tfquestion,tfanswer,tfpassword;
    JButton search,retrieve,back;
    
    ForgetPassword(){
        setTitle("Forget Password");
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fp3.png"));
        Image i2=i1.getImage().getScaledInstance(280,280,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70,200, 200);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tohama",Font.BOLD, 14));
        lblusername.setBounds(50,30,130,30);
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(190, 30, 180,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        search = new JButton("Search");
        search.setBackground(Color.white);
        search.setForeground(new Color(133,193,233));
        search.setFont(new Font("Tohama",Font.BOLD, 14));
        search.setBounds(390,30,100,30);
        search.addActionListener(this); // calling actionperformed method
        p1.add(search);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tohama",Font.BOLD, 14));
        lblname.setBounds(50,70,130,30);
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(190, 70, 180,30);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblquestion = new JLabel("Security Question");
        lblquestion.setFont(new Font("Tohama",Font.BOLD, 14));
        lblquestion.setBounds(50,110,130,30);
        p1.add(lblquestion);
        
        tfquestion = new JTextField();
        tfquestion.setBounds(190, 110, 180,30);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Tohama",Font.BOLD, 14));
        lblanswer.setBounds(50,150,130,30);
        p1.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(190, 150, 180,30);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.white);
        retrieve.setForeground(new Color(133,193,233));
        retrieve.setFont(new Font("Tohama",Font.BOLD, 14));
        retrieve.setBounds(390,150,100,30);
        retrieve.addActionListener(this); // calling actionperformed method
        p1.add(retrieve);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tohama",Font.BOLD, 14));
        lblpassword.setBounds(50,190,130,30);
        p1.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(190, 190, 180,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Tohama",Font.BOLD, 14));
        back.setBounds(150,235,100,30);
        back.addActionListener(this); // calling actionperformed method
        p1.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            try{
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                Conn c =new Conn();
                
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==retrieve){
            try{
                String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfusername.getText()+"'";
                Conn c =new Conn();
                
                ResultSet rs=c.s.executeQuery(query);
                while(rs.next()){
                    tfpassword.setText(rs.getString("password"));
                    
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Login();
        }
        
    }
    public static void main(String[] args){
        new ForgetPassword();
    }
}
