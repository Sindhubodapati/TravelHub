package travel.management.system;
import javax.swing.*;
import java.awt.*;


public class Splash extends JFrame implements Runnable{
	
	Splash(){
		//setSize(1100,600);
		//setLocation(100,50);
		Thread thread;
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1100,500,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		add(image);
		setVisible(true);
		thread=new Thread(this);
		thread.start();
		
	}
	public void run() {
		try {
			Thread.sleep(7000);
			//new login
			setVisible(false);
			
			
		} catch(Exception e) {
			
		}
		
	}
	public static void main(String[] args) {
		Splash frame = new Splash();
		int x=1;
		for(int i=1;i<=400;x+=7,i+=6) {
			frame.setSize(x+i,i);
			frame.setLocation(600-((x+i)/2),350-(i/2));
			try {
				Thread.sleep(10);
			}
			catch(Exception e){}
		}
	}

}
