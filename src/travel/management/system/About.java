package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
	About(){
		setBounds(200,100,700,500);
		setLayout(null);
		setBackground(Color.WHITE);
		
		JLabel l1=new JLabel("ABOUT");
		l1.setBounds(250,10,100,40);
		l1.setForeground(Color.RED);
		l1.setFont(new Font("Tahoma",Font.PLAIN,20)); 
		add(l1);
		
		TextArea area = new TextArea("Hello",10,40,Scrollbar.VERTICAL);
		area.setEditable(false);
		area.setBounds(10,50,650,300);
		add(area);
		
		JButton back=new JButton("Back");
		back.setBounds(250,400,80,40);
		back.addActionListener(this);
		add(back);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Dashboard("");
	}
	
	
	public static void main(String[] args) {
		new About();
	}

}
