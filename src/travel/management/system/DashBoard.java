
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;


public class DashBoard extends JFrame implements ActionListener {
    String username;
    JButton calculator,notepad,about,deleteeperdetails,logout;
    JButton addperdetails,vieweperdetails,updateperdetails,checkpackage,bookpackage,viewpackage,viewhotels,destinations,bookhotels,viewbookedhotels,payments;
    DashBoard(String username){
        setTitle("Dashboard");
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH); // use this for full scren frame rather using setbounds mehod
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);
        
        JLabel heading = new JLabel("Dashboard");
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setBounds(80,10,300,40);
        p1.add(heading);
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);
        
        addperdetails =new JButton("Add Personal Details");
        addperdetails.setBounds(0,0,300,50);
        addperdetails.setBackground(new Color(0, 0, 102));
        addperdetails.setForeground(Color.white);
        addperdetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addperdetails.setMargin(new Insets(0,0,0,60));
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        addperdetails.addActionListener(this);
        p2.add(addperdetails);
        
        updateperdetails =new JButton("Update Personal Details");
        updateperdetails.setBounds(0,45,300,50);
        updateperdetails.setBackground(new Color(0, 0, 102));
        updateperdetails.setForeground(Color.white);
        updateperdetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updateperdetails.setMargin(new Insets(0,0,0,30));
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        updateperdetails.addActionListener(this);
        p2.add(updateperdetails);
        
        vieweperdetails =new JButton("View Personal Details");
        vieweperdetails.setBounds(0,90,300,50);
        vieweperdetails.setBackground(new Color(0, 0, 102));
        vieweperdetails.setForeground(Color.white);
        vieweperdetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        vieweperdetails.setMargin(new Insets(0,0,0,50));
        vieweperdetails.addActionListener(this);
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        p2.add(vieweperdetails);
        
        deleteeperdetails =new JButton("Delete Personal Details");
        deleteeperdetails.setBounds(0,135,300,50);
        deleteeperdetails.setBackground(new Color(0, 0, 102));
        deleteeperdetails.setForeground(Color.white);
        deleteeperdetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deleteeperdetails.setMargin(new Insets(0,0,0,35));
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        deleteeperdetails.addActionListener(this);
        p2.add(deleteeperdetails);
        
        checkpackage =new JButton("Check Package");
        checkpackage.setBounds(0,180,300,50);
        checkpackage.setBackground(new Color(0, 0, 102));
        checkpackage.setForeground(Color.white);
        checkpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkpackage.setMargin(new Insets(0,0,0,110));
        checkpackage.addActionListener(this);
        //checkpackage.setBorder(new LineBorder(new Color(0, 0, 102)));
        p2.add(checkpackage);
        
        bookpackage =new JButton("Book Package");
        bookpackage.setBounds(0,225,300,50);
        bookpackage.setBackground(new Color(0, 0, 102));
        bookpackage.setForeground(Color.white);
        bookpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookpackage.setMargin(new Insets(0,0,0,120));
        //bookpackage.setBorder(new LineBorder(new Color(0, 0, 102)));
        bookpackage.addActionListener(this);
        p2.add(bookpackage);
        
        viewpackage =new JButton("View Package");
        viewpackage.setBounds(0,270,300,50);
        viewpackage.setBackground(new Color(0, 0, 102));
        viewpackage.setForeground(Color.white);
        viewpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewpackage.setMargin(new Insets(0,0,0,120));
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        viewpackage.addActionListener(this);
        p2.add(viewpackage);
        
        viewhotels =new JButton("View Hotels");
        viewhotels.setBounds(0,315,300,50);
        viewhotels.setBackground(new Color(0, 0, 102));
        viewhotels.setForeground(Color.white);
        viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewhotels.setMargin(new Insets(0,0,0,140));
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);
        
        bookhotels =new JButton("Book Hotel");
        bookhotels.setBounds(0,360,300,50);
        bookhotels.setBackground(new Color(0, 0, 102));
        bookhotels.setForeground(Color.white);
        bookhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookhotels.setMargin(new Insets(0,0,0,150));
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        bookhotels.addActionListener(this);
        p2.add(bookhotels);
        
        viewbookedhotels =new JButton("View Booked Hotel");
        viewbookedhotels.setBounds(0,405,300,50);
        viewbookedhotels.setBackground(new Color(0, 0, 102));
        viewbookedhotels.setForeground(Color.white);
        viewbookedhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewbookedhotels.setMargin(new Insets(0,0,0,80));
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        viewbookedhotels.addActionListener(this);
        p2.add(viewbookedhotels);
        
        destinations =new JButton("Destinations");
        destinations.setBounds(0,450,300,50);
        destinations.setBackground(new Color(0, 0, 102));
        destinations.setForeground(Color.white);
        destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
        destinations.setMargin(new Insets(0,0,0,140));
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        destinations.addActionListener(this);
        p2.add(destinations);
        
        payments =new JButton("Payments");
        payments.setBounds(0,495,300,50);
        payments.setBackground(new Color(0, 0, 102));
        payments.setForeground(Color.white);
        payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
        payments.setMargin(new Insets(0,0,0,160));
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        payments.addActionListener(this);
        p2.add(payments);
        
        calculator =new JButton("Calculator"); // installed calculator will be use here
        calculator.setBounds(0,540,300,50);
        calculator.setBackground(new Color(0, 0, 102));
        calculator.setForeground(Color.white);
        calculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calculator.setMargin(new Insets(0,0,0,160));
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        calculator.addActionListener(this);
        p2.add(calculator);
        
        notepad =new JButton("Notepad"); // installed calculator will be use here
        notepad.setBounds(0,585,300,50);
        notepad.setBackground(new Color(0, 0, 102));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        notepad.setMargin(new Insets(0,0,0,170));
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        notepad.addActionListener(this);
        p2.add(notepad);
        
        about =new JButton("About"); // installed calculator will be use here
        about.setBounds(0,630,300,50);
        about.setBackground(new Color(0, 0, 102));
        about.setForeground(Color.white);
        about.setFont(new Font("Tahoma", Font.PLAIN, 20));
        about.setMargin(new Insets(0,0,0,190));
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        about.addActionListener(this);
        p2.add(about);
        
        logout =new JButton("LogOut"); // installed calculator will be use here
        logout.setBounds(0,675,300,50);
        logout.setBackground(new Color(0, 0, 102));
        logout.setForeground(Color.white);
        logout.setFont(new Font("Tahoma", Font.PLAIN, 20));
        logout.setMargin(new Insets(0,0,0,190));
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        logout.addActionListener(this);
        p2.add(logout);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5=i4.getImage().getScaledInstance(1650, 1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);
        
        JLabel text =new JLabel("Travel And Tourism Management System");
        text.setBounds(400, 70, 1200, 70);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,55));
        image.add(text);
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== addperdetails){
            new AddCustomer(username);
        }else if(ae.getSource()==vieweperdetails){
            new ViewCustomer(username);
        }else if(ae.getSource()==updateperdetails){
            new UpdateCustomer(username);
        }else if(ae.getSource()==deleteeperdetails){
            new DeleteDetails(username);
        }else if(ae.getSource()==checkpackage){
            new CheckPackage();
        }else if(ae.getSource()==bookpackage){
            new BookPackage(username);
        }else if(ae.getSource()==viewpackage){
            new ViewPackage(username);
        }else if(ae.getSource()==viewhotels){
            new CheckHotels();
        }else if(ae.getSource()==destinations){
            new Destinations();
        }else if(ae.getSource()==bookhotels){
            new BookHotel(username);
        }else if(ae.getSource()==viewbookedhotels){
            new ViewBookedHotel(username);
        }else if(ae.getSource()==payments){
            new Payment();
        }else if(ae.getSource()==calculator){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==about){
            new About();
        }else if(ae.getSource()==logout){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args){
        new DashBoard("");
    }
}
