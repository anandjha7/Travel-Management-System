
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Payment extends JFrame implements ActionListener {
    JButton pay,back;
    Payment(){
        setTitle("Payment");
        setBounds(500,200,800,600);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2=i1.getImage().getScaledInstance(800, 600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(0,0,800,600);
        add(icon);
        
        pay =new JButton("Pay"); // installed calculator will be use here
        pay.setBounds(100,500,80,30);
        pay.setBackground(Color.black);
        pay.setForeground(Color.WHITE);
        pay.setFont(new Font("Tohama",Font.BOLD, 14));
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        pay.addActionListener(this);
        icon.add(pay);
        
        back =new JButton("Back"); // installed calculator will be use here
        back.setBounds(620,500,80,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tohama",Font.BOLD, 14));
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        back.addActionListener(this);
        icon.add(back);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==pay){
            setVisible(false);
            new Paytm();
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Payment();
    }
}
