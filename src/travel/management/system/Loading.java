
package travel.management.system;
import javax.swing.*;
import java.awt.*; 


public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;
    
    public void run(){
        try{
            for(int i=1;i<=101;i++){
                int max=bar.getMaximum(); //100
                int value = bar.getValue();
                
                if(value<max){ // 101<100
                    bar.setValue(bar.getValue() + 1);
                }else{
                    setVisible(false);
                    new DashBoard(username);
                }
                Thread.sleep(50);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    Loading(String username){
        this.username =username;
        t=new Thread(this);
        setBounds(500, 200, 650, 400);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/loading.jpg"));
        Image i2=i1.getImage().getScaledInstance(650, 400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        image.setBounds(0,0,650,400);
        add(image);
        
        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(50, 20, 600,40);
        text.setForeground(Color.red);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        image.add(text);
        
        bar=new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar); // it will add 0% to the progressbar on the loading frame, now we are going to continue this from 0 to 100 percent 
        
        JLabel wait = new JLabel("Loading, Please Wait...");
        wait.setBounds(210, 130, 250,30);
        wait.setForeground(Color.red);
        wait.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(wait);
        
        JLabel lblusername = new JLabel("Welcome " + username);
        lblusername.setBounds(20, 310, 400,40);
        lblusername.setForeground(Color.black);
        lblusername.setFont(new Font("Raleway",Font.BOLD,20));
        image.add(lblusername);
        
        t.start(); // it will call run method
        setVisible(true);
    }
    
    
    public static void main(String[] args){
        new Loading("");
    }
}
