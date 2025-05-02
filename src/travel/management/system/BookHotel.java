
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BookHotel extends JFrame implements ActionListener {
    String username;
    JTextField tfperson,tfdays;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    Choice chotel,cac,cfood;
    JButton checkprice,bookpack,back;
    BookHotel(String username){
        setTitle("Book hotel");
        setBounds(350,20,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text=new JLabel("BOOK HOTEL");
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
        
        JLabel lblpack = new JLabel("Select Hotel");
        lblpack.setBounds(40, 110, 150, 20);
        lblpack.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblpack);
        
        chotel = new Choice();
        chotel.setBounds(250,110,200,20);
        add(chotel);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblperson = new JLabel("Total Person");
        lblperson.setBounds(40, 150, 150, 20);
        lblperson.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblperson);
        
        tfperson = new JTextField("1");
        tfperson.setBounds(250, 150, 200, 20);
        tfperson.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(tfperson);
        
        JLabel lbldays = new JLabel("Total Days");
        lbldays.setBounds(40, 190, 150, 20);
        lbldays.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lbldays);
        
        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 20);
        tfdays.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(tfdays);
        
        JLabel lblac = new JLabel("AC/NON-AC");
        lblac.setBounds(40, 230, 150, 20);
        lblac.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("NON-AC");
        cac.setBounds(250,230,200,20);
        add(cac);
        
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(40, 270, 150, 20);
        lblfood.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblfood);
        
        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,270,200,20);
        add(cfood);
        
        JLabel lblid = new JLabel("ID Card");
        lblid.setBounds(40, 310, 150, 20);
        lblid.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(250, 310, 200, 20);
        labelid.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(labelid);
        
        JLabel lblnumber = new JLabel("ID Number");
        lblnumber.setBounds(40, 350, 150, 20);
        lblnumber.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 200, 20);
        labelnumber.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(40, 390, 150, 20);
        lblphone.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250, 390, 200, 20);
        labelphone.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(labelphone);
        
        JLabel lblprice = new JLabel("Total Price");
        lblprice.setBounds(40, 430, 150, 20);
        lblprice.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(lblprice);
        
        labelprice = new JLabel();
        labelprice.setBounds(250, 430, 200, 20);
        labelprice.setFont(new Font("TAHOMA",Font.PLAIN,16));
        add(labelprice);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username='"+username+"' ");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("idcard"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.black);
        checkprice.setForeground(Color.WHITE);
        checkprice.setFont(new Font("Tohama",Font.BOLD, 14));
        checkprice.setBounds(40,490,130,25);
        checkprice.addActionListener(this); // calling actionperformed method
        add(checkprice);
        
        bookpack = new JButton("Book Hotel");
        bookpack.setBackground(Color.black);
        bookpack.setForeground(Color.WHITE);
        bookpack.setFont(new Font("Tohama",Font.BOLD, 14));
        bookpack.setBounds(190,490,150,25);
        bookpack.addActionListener(this); // calling actionperformed method
        add(bookpack);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tohama",Font.BOLD, 14));
        back.setBounds(360,490,100,25);
        back.addActionListener(this); // calling actionperformed method
        add(back);
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2=i1.getImage().getScaledInstance(550, 400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(500,60,550,400);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel where name='"+chotel.getSelectedItem()+"'");
            while(rs.next()){
                int cost=Integer.parseInt(rs.getString("costperperson"));
                int food=Integer.parseInt(rs.getString("food"));
                int ac=Integer.parseInt(rs.getString("acroom"));
                
                int persons =Integer.parseInt(tfperson.getText());
                int days =Integer.parseInt(tfdays.getText());
                
                String acselected = cac.getSelectedItem();
                String foodselected = cfood.getSelectedItem();
                
                if(persons*days > 0){
                int totalprice =0;
                totalprice +=acselected.equals("AC") ? ac : 0; // total price if ac included (per person) 
                totalprice +=foodselected.equals("Yes") ? food : 0; // total price if food included (per person)
                totalprice+=cost; // total price for which hotel selected included (per person per day)
                totalprice=totalprice*persons*days; // total price (all person per day)
                labelprice.setText("RS : " + totalprice);
                }else{
                    JOptionPane.showMessageDialog(null, "please enter a valid number");
                }
                
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==bookpack){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfperson.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully ");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] ars){
        
        new BookHotel("");
        
    }
}
