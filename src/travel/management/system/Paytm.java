
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Paytm extends JFrame implements ActionListener {
    
    Paytm(){
        setTitle("Paytm");
        setBounds(500, 200, 800, 600);
        
        JEditorPane pane =new JEditorPane();
        pane.setEditable(false);
        
        try{
            pane.setPage("https://paytm.com/rent-paytm");
        }catch(Exception e){
           pane.setContentType("text.html");
           pane.setText("<html>could not loaded, error 404</html>");
        }
        
        JScrollPane sp =new JScrollPane(pane);
        getContentPane().add(sp);
        
        JButton back =new JButton("Back"); // installed calculator will be use here
        back.setBounds(620,500,80,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tohama",Font.BOLD, 14));
        //addperdetails.setBorder(new LineBorder(new Color(0, 0, 102)));
        back.addActionListener(this);
        pane.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        setVisible(false);
        new Payment();
        
    }
    
    public static void main(String[] args){
        new Paytm();
    }
}
