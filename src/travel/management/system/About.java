
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    String s;
    About(){
        setTitle("about");
        setBounds(600,200,500,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel heading = new JLabel("About");
        heading.setForeground(Color.red);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setBounds(200,20,100,40);
        add(heading);
        
        s = "                          About Projects          \n  "
                + "\nThe objective of the Travel and Tourism Management System"
                + "project is to develop a system that automates the processes "
                + "and activities of a travel and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n"
                + "This application will help in accessing the information related "
                + "to the travel to the particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n"
                + "Advantages of Project:"
                + "\nGives accurate information"
                + "\nSimplifies the manual work"
                + "\nIt minimizes the documentation related work"
                + "\nProvides up to date information"
                + "\nFriendly Environment by providing warning messages."
                + "\ntravelers details can be provided"
                + "\nbooking confirmation notification"
                ;
        
        TextArea text = new TextArea(s,20,40,Scrollbar.VERTICAL);
        text.setEditable(false);
        text.setBackground(Color.white);
        text.setBounds(30,100,430,300);
        text.setFont(new Font("TAHOMA",Font.PLAIN,18));
        add(text);
        
        JButton back =new JButton("Back"); // installed calculator will be use here
        back.setBounds(200,450,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tohama",Font.BOLD, 14));
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        back.addActionListener(this);
        add(back);
        
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String[] args){
        new About();
    }
    
}
