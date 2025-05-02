
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BookPackage extends JFrame implements ActionListener {
    String username;
    JTextField tfperson;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    Choice cpack;
    JButton checkprice,bookpack,back;
    BookPackage(String username){
        setTitle("Book package");
        setBounds(350,20,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text=new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("TAHOMA",Font.BOLD,20));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 70, 100, 20);
        lblusername.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(250, 70, 200, 20);
        labelusername.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(labelusername);
        
        JLabel lblpack = new JLabel("Select Package");
        lblpack.setBounds(40, 110, 150, 20);
        lblpack.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblpack);
        
        cpack = new Choice();
        cpack.add("GOLD PACKAGE");
        cpack.add("SILVER PACKAGE");
        cpack.add("BRONZE PACKAGE");
        cpack.setBounds(250,110,200,20);
        add(cpack);
        
        JLabel lblperson = new JLabel("Total Person");
        lblperson.setBounds(40, 150, 150, 20);
        lblperson.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblperson);
        
        tfperson = new JTextField();
        tfperson.setBounds(250, 150, 200, 20);
        tfperson.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(tfperson);
        
        JLabel lblid = new JLabel("ID Card");
        lblid.setBounds(40, 190, 150, 20);
        lblid.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(250, 190, 200, 20);
        labelid.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(labelid);
        
        JLabel lblnumber = new JLabel("ID Number");
        lblnumber.setBounds(40, 230, 150, 20);
        lblnumber.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250, 230, 200, 20);
        labelnumber.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(40, 270, 150, 20);
        lblphone.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250, 270, 200, 20);
        labelphone.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(labelphone);
        
        JLabel lblprice = new JLabel("Total Price");
        lblprice.setBounds(40, 310, 150, 20);
        lblprice.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblprice);
        
        labelprice = new JLabel();
        labelprice.setBounds(250, 310, 200, 20);
        labelprice.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(labelprice);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username='"+username+"' ");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("idcard"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.black);
        checkprice.setForeground(Color.WHITE);
        checkprice.setFont(new Font("Tohama",Font.BOLD, 14));
        checkprice.setBounds(40,390,130,25);
        checkprice.addActionListener(this); // calling actionperformed method
        add(checkprice);
        
        bookpack = new JButton("Book Package");
        bookpack.setBackground(Color.black);
        bookpack.setForeground(Color.WHITE);
        bookpack.setFont(new Font("Tohama",Font.BOLD, 14));
        bookpack.setBounds(190,390,150,25);
        bookpack.addActionListener(this); // calling actionperformed method
        add(bookpack);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tohama",Font.BOLD, 14));
        back.setBounds(360,390,100,25);
        back.addActionListener(this); // calling actionperformed method
        add(back);
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(550, 400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(500,30,550,400);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            String pack = cpack.getSelectedItem();
            int cost=0;
            if(pack.equals("GOLD PACKAGE")){
                cost=cost+12000;
            }else if(pack.equals("SILVER PACKAGE")){
                cost=cost+9000;
            }else{
               cost=cost+7000; 
            }
            
            int persons = Integer.parseInt(tfperson.getText());
            cost=cost*persons;
            labelprice.setText(" RS. "+ cost);
        }else if(ae.getSource()==bookpack){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpack.getSelectedItem()+"','"+tfperson.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null,"Package Booked Successfully ");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] ars){
        
        new BookPackage("");
        
    }
}
