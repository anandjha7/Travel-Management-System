
package travel.management.system;
import javax.swing.*;
import java.awt.*;

public class Splash {
    public static void main(String[] args) {
    SplashFrame f1 =new SplashFrame();
    f1.setVisible(true);
        int i;
        int x=1;
        for(i=2; i<=600; i+=10, x+=7){
            f1.setLocation(900 - ((i+x)/2), 500 - (i/2));
            f1.setSize(i+x,i);
            try{
                Thread.sleep(10);
            }catch(Exception e){}
        }
    }
}
    
    class SplashFrame extends JFrame implements Runnable {
    Thread t1;
    SplashFrame() { 
     setLayout(new FlowLayout());
     ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
     Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
     ImageIcon i3=new ImageIcon(i2);
     JLabel image=new JLabel(i3);
     add(image);
     setUndecorated(true);
     setVisible(true);
     t1=new Thread(this);
     t1.start(); // calling run() method using thread class
    }
    
    //implementation of abstract method of runnable class 
    public void run(){
        try{
            Thread.sleep(7000);
            this.setVisible(false);
            new Login();
          setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
    }

  }
}
