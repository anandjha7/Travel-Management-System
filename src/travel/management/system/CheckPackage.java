
package travel.management.system;
import javax.swing.*;
import java.awt.*;



public class CheckPackage extends JFrame {
    
    CheckPackage(){
        setTitle("Check package");
        setBounds(450,200,900,600);
        
        String[] pack1 = {"GOLD PACKAGE","Durations : 6 Days & 7 Nights","Airport Assistance","Night City Tour","Daily Buffet & Breakfast","Welcome Soft Drink","Full Day 3 Island Crise","Language Friendly Guide","Summer Special Package Price : ","RS. 12000/Person","package1.jpg"};
        String[] pack2 = {"SILVER PACKAGE","Durations : 4 Days & 5 Nights","Airport Assistance","Day-Night City Tour","Daily Buffet","Welcome Soft Drink","Full Day 2 Island Crise","Language Friendly Guide","Winter Special Package Price : ","RS. 9000/Person","package2.jpg"};
        String[] pack3 = {"BRONZE PACKAGE","Durations : 3 Days & 3 Nights","Airport Assistance","Half Day City Tour","Daily Buffet","Welcome Soft Drink","Full Day 1 Island Crise","Language Friendly Guide","Winter Special Package Price : ","RS. 7000/Person","package3.jpg"};
        
        JTabbedPane tab = new JTabbedPane();
        
        JPanel p1=createpackage(pack1);
        tab.addTab("GOLD PACKAGE",null,p1);
        
        JPanel p2=createpackage(pack2);
        tab.addTab("SILVER PACKAGE",null,p2);
        
        JPanel p3=createpackage(pack3);
        tab.addTab("BRONZE PACKAGE",null,p3);
        
        add(tab);
        
        setVisible(true);
    }
    public JPanel createpackage(String[] pack){
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);
        
        JLabel l0=new JLabel("The Benifits Of Choosing");
        l0.setBounds(50,10,300,30);
        l0.setForeground(Color.red);
        l0.setFont(new Font("TAHOMA",Font.PLAIN,16));
        p1.add(l0);
        
        JLabel l1=new JLabel(pack[0]);
        l1.setBounds(50,40,300,30);
        l1.setForeground(Color.yellow);
        l1.setFont(new Font("TAHOMA",Font.BOLD,30));
        p1.add(l1);
        
        JLabel l2=new JLabel(pack[1]);
        l2.setBounds(50,100,300,20);
        l2.setForeground(Color.black);
        l2.setFont(new Font("TAHOMA",Font.BOLD,18));
        p1.add(l2);
        
        JLabel l3=new JLabel(pack[2]);
        l3.setBounds(50,130,300,20);
        l3.setForeground(Color.black);
        l3.setFont(new Font("TAHOMA",Font.BOLD,18));
        p1.add(l3);
        
        JLabel l4=new JLabel(pack[3]);
        l4.setBounds(50,160,300,20);
        l4.setForeground(Color.black);
        l4.setFont(new Font("TAHOMA",Font.BOLD,18));
        p1.add(l4);
        
        JLabel l5=new JLabel(pack[4]);
        l5.setBounds(50,190,300,20);
        l5.setForeground(Color.black);
        l5.setFont(new Font("TAHOMA",Font.BOLD,18));
        p1.add(l5);
        
        JLabel l6=new JLabel(pack[5]);
        l6.setBounds(50,220,300,20);
        l6.setForeground(Color.black);
        l6.setFont(new Font("TAHOMA",Font.BOLD,18));
        p1.add(l6);
        
        JLabel l7=new JLabel(pack[6]);
        l7.setBounds(50,250,300,20);
        l7.setForeground(Color.black);
        l7.setFont(new Font("TAHOMA",Font.BOLD,18));
        p1.add(l7);
        
        JLabel l8=new JLabel(pack[7]);
        l8.setBounds(50,280,300,20);
        l8.setForeground(Color.black);
        l8.setFont(new Font("TAHOMA",Font.BOLD,18));
        p1.add(l8);
        
        JLabel l01=new JLabel("Facilities :");
        l01.setBounds(50,310,300,20);
        l01.setForeground(Color.black);
        l01.setFont(new Font("TAHOMA",Font.BOLD,18));
        p1.add(l01);
        
        JLabel bulletLabel=new JLabel("<html><ul>"+"<li>Free Wifi</li>"+"<li>Free Cancellation</li>"+"<li>Book Now, Pay Later </li>"+"</ul></html>");
        bulletLabel.setBounds(50,330,300,90);
        bulletLabel.setForeground(Color.red);
        bulletLabel.setFont(new Font("TAHOMA",Font.BOLD,18));
        p1.add(bulletLabel);
        
        JLabel l9=new JLabel(pack[8]);
        l9.setBounds(80,480,460,30);
        l9.setForeground(Color.blue);
        l9.setFont(new Font("TAHOMA",Font.BOLD,26));
        p1.add(l9);
        
        JLabel l10=new JLabel(pack[9]);
        l10.setBounds(560,480,300,30);
        l10.setForeground(Color.red);
        l10.setFont(new Font("TAHOMA",Font.BOLD,26));
        p1.add(l10);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[10]));
        Image i2=i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(350,80,500,300);
        p1.add(icon);
        
        return p1;
    }
    
    
    public static void main(String[] args){
        new CheckPackage();
    }
}
