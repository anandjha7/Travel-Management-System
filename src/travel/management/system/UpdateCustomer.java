

package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener{
    
    JLabel labelusername, labelname;
    Choice id;
    JTextField tfnumber,tfaddress,tfdesh,tfemail,tfphone,tfid,tfgender;
    JRadioButton rmale,rfemale;
    JButton update,back;
    UpdateCustomer(String username){
        setTitle("Update customer details");
        setBounds(500, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text=new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,10,300,25);
        text.setFont(new Font("TAHOMA",Font.BOLD,20));
        add(text);
        
        JLabel lblusername = new JLabel("usrename");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        labelusername = new JLabel(); // data fetched from database
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        
        tfid = new JTextField();
        tfid.setBounds(220,90,150,25);
        add(tfid);
        
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
        
        tfgender = new JTextField();
        tfgender.setBounds(220,210,150,25);
        add(tfgender);
        
        
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
        
        update = new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(60,430,100,25);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/updated.jpeg"));
        Image i5=i4.getImage().getScaledInstance(400, 300,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(400,100,450,300);
        add(image);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username='"+username+"' ");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("idcard"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfdesh.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==update){
            String username = labelusername.getText();
            String idcard=tfid.getText();
            String number=tfnumber.getText();
            String name=labelname.getText();
            String gender = tfgender.getText();
            String country = tfdesh.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            String address = tfaddress.getText();
            
            try{
                Conn c = new Conn();
                String query = "update customer set username= '"+username+"',idcard = '"+idcard+"',number = '"+number+"',name = '"+name+"',gender= '"+gender+"',country= '"+country+"',email= '"+email+"',address= '"+address+"',phone= '"+phone+"'";
                c.s.executeUpdate(query);
                
                
                JOptionPane.showMessageDialog(null,"Customer Details Updated Successfully ");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
         setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new UpdateCustomer("");
    }
}


