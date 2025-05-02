
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;



public class ViewPackage extends JFrame implements ActionListener{
    JButton back;
    
    ViewPackage(String username){
        setTitle("View package details");
        setBounds(450, 200,900, 450);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text=new JLabel("VIEW PACKAGE DETAILS");
        text.setBounds(60,10,300,30);
        text.setFont(new Font("TAHOMA",Font.BOLD,20));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);
        
        JLabel lblpack = new JLabel("Package");
        lblpack.setBounds(30, 90, 150, 25);
        add(lblpack);
        
        JLabel labelpack = new JLabel();
        labelpack.setBounds(220, 90, 150, 25);
        add(labelpack);
        
         JLabel lblperson = new JLabel("Persons");
        lblperson.setBounds(30, 130, 150, 25);
        add(lblperson);
        
        JLabel labelperson = new JLabel();
        labelperson.setBounds(220, 130, 150, 25);
        add(labelperson);
        
        JLabel lblid = new JLabel("Id Card");
        lblid.setBounds(30, 170, 150, 25);
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220, 170, 150, 25);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 210, 150, 25);
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 210, 150, 25);
        add(labelnumber);
        
       
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 250, 150, 25);
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 250, 150, 25);
        add(labelphone);
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(30, 290, 150, 25);
        add(lblprice);
        
        JLabel labelprice = new JLabel();
        labelprice.setBounds(220, 290, 150, 25);
        add(labelprice);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tohama",Font.BOLD, 14));
        back.setBounds(130,360,100,25);
        back.addActionListener(this); // calling actionperformed method
        add(back);
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);
        
        
        
        try{
            Conn c =new Conn();
            String query = "select * from bookpackage where username = '"+username+"'";
            ResultSet rs =c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelpack.setText(rs.getString("package"));
                labelperson.setText(rs.getString("person"));
                labelid.setText(rs.getString("idcard"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String[] args){
        new ViewPackage("");
    }
    
}
