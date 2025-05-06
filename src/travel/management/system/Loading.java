package travel.management.system;
import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
	Thread t;
	JLabel text,loading,lbusername;
	JProgressBar bar;
	String username;
	public void run() {
		try {
		
		for(int i=1;i<=101;i++) {
			int max=bar.getMaximum();//100
			int val=bar.getValue();
		
			if(max>val) {
				bar.setValue(bar.getValue()+1);
			} else {
				setVisible(false);
				new Dashboard(username);
			}
			Thread.sleep(50);
		}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
      	Loading(String username){
      	this.username=username;
		t=new Thread(this);
		setBounds(300,150,650,400);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		text=new JLabel("Travel and Tourism Application ");
		text.setBounds(50,20,600,40);
		text.setFont(new Font("Rayie",Font.BOLD,35));
		text.setForeground(Color.BLUE);
		add(text);
		
		bar=new JProgressBar();
		bar.setBounds(150,100,300,35);
		bar.setStringPainted(true);
		add(bar);
		

		loading=new JLabel("Loading, please wait...");
		loading.setBounds(200,140,200,25);
		loading.setFont(new Font("Rayie",Font.BOLD,15));
		loading.setForeground(Color.RED);
		add(loading);
		

		lbusername=new JLabel("Welcome "+username);
		lbusername.setBounds(20,310,200,30);
		lbusername.setFont(new Font("Rayie",Font.BOLD,16));
		lbusername.setForeground(Color.RED);
		add(lbusername);
	
		
		t.start();
		setVisible(true);
		
	}
	
    public static void main(String[] args) {
    	new Loading("");
    }
}
