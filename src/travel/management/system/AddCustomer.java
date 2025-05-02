
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel labelusername, labelname;
    Choice id;
    JTextField tfnumber,tfaddress,tfdesh,tfemail,tfphone;
    JRadioButton rmale,rfemale;
    JButton add,back;
    AddCustomer(String username){
        setTitle("Add customer details");
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel lblusername = new JLabel("usrename");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        labelusername = new JLabel(); // data fetched from database
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
        id = new Choice();
        id.add("Passport");
        id.add("Aadhar card");
        id.add("PAN card");
        id.add("Drivery License");
        id.add("Voter ID card");
        id.setBounds(220,90,150,25);
        add(id);
        
        JLabel lblnumber = new JLabel("ID Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        
        labelname = new JLabel(); // data fetched from database
        labelname.setBounds(220,170,150,25);
        add(labelname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        
        rmale=new JRadioButton("Male");
        rmale.setBounds(220,210,70,25);
        rmale.setBackground(Color.white);
        add(rmale);
        
        rfemale=new JRadioButton("Female");
        rfemale.setBounds(300,210,70,25);
        rfemale.setBackground(Color.white);
        add(rfemale);
        
        // here both buttons are working independently so both are selecting at a same time, so to recover from this issue we have to group the buttons
        
        ButtonGroup bg =new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);
        
        
        JLabel lbldesh = new JLabel("Country");
        lbldesh.setBounds(30,250,150,25);
        add(lbldesh);
        
        tfdesh = new JTextField();
        tfdesh.setBounds(220,250,150,25);
        add(tfdesh);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30,330,150,25);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220,330,150,25);
        add(tfemail);
        
        JLabel lblphone = new JLabel("Contact Number");
        lblphone.setBounds(30,370,150,25);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220,370,150,25);
        add(tfphone);
        
        add = new JButton("Add");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(60,430,100,25);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i5=i4.getImage().getScaledInstance(400, 500,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(400,40,450,420);
        add(image);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username='"+username+"' ");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String username = labelusername.getText();
            String idcard=(String)id.getSelectedItem();
            String number=tfnumber.getText();
            String name=labelname.getText();
            String gender = null;
            if(rmale.isSelected()){
                gender="male";
            }else{
                gender="female";
            }
            String country = tfdesh.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            String address = tfaddress.getText();
            
            try{
                Conn c = new Conn();
                String query = "insert into customer values ('"+username+"','"+idcard+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+email+"','"+address+"','"+phone+"')";
                c.s.executeUpdate(query);
                
                
                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully ");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
         setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddCustomer("");
    }
}
