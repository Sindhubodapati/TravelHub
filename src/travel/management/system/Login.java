package travel.management.system;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{ 
	JButton login,signup,password;
	JTextField tfusername,tfpassword;
	Login(){
		setSize(800,400);
		setLocation(250,150);
		setLayout(null);
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(131,193,213));
		p1.setBounds(0, 0, 350, 400);
		p1.setLayout(null);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		//setBounds(x-horizontal increase,y-vertical increase,width-increase size of content(left-right),height-narrowing or increasing content
		image.setBounds(70,100,200,200);
		p1.add(image);
		
		JPanel p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(350,30,450,300);
		add(p2);
		
		JLabel lb1username = new JLabel("Username:");
		lb1username.setBounds(50,20,100,25);
		lb1username.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
		p2.add(lb1username);
		
		tfusername = new JTextField();
		tfusername.setBounds(50,60,300,30);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tfusername);
		
		JLabel lb1password = new JLabel("Password:");
		lb1password.setBounds(50,110,100,25);
		lb1password.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
		p2.add(lb1password);
		
		tfpassword = new JTextField();
		tfpassword.setBounds(50,150,300,30);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tfpassword);
		
		login=new JButton("Login");
		login.setBounds(50,200,130,30);
		login.setBackground(new Color(133,193,213));
		login.setForeground(Color.WHITE);
		login.setBorder(new LineBorder(new Color(133,193,233)));
		login.addActionListener(this);
		p2.add(login);
		
		signup=new JButton("Signup");
		signup.setBounds(220,200,130,30);
		signup.setBackground(new Color(133,193,213));
		signup.setForeground(Color.WHITE);
		signup.setBorder(new LineBorder(new Color(133,193,233)));
		signup.addActionListener(this);
		p2.add(signup);
		
		password=new JButton("Forget Password");
		password.setBounds(130,250,150,30);
		password.setBackground(new Color(133,193,213));
		password.setForeground(Color.WHITE);
		password.setBorder(new LineBorder(new Color(133,193,233)));
		password.addActionListener(this);
		p2.add(password);
		
		JLabel text=new JLabel("Trouble in login...");
		text.setBounds(300,250,200,20);
		text.setForeground(Color.RED);
		p2.add(text);
				
		setVisible(true);
		
	}
	
   public void actionPerformed(ActionEvent ae) {
	   if(ae.getSource()==login) {
		   try {
			   String username=tfusername.getText();
			   String password=tfpassword.getText();
			   String query="select * from account where username='"+username+"' AND password='"+password+"'";
			   Conn c=new Conn();
			   ResultSet rs=c.s.executeQuery(query);
			   if(rs.next()) {
				   setVisible(false);
				   new Loading(username);
				   } else {
					   JOptionPane.showMessageDialog(null,"Invalid username or password");
				   }
			   
		   } catch(Exception e) {
			   e.printStackTrace();
		   }
			  
		   
	   } else if(ae.getSource()==signup) {
		  
			   setVisible(false);
			   new Signup();
	   } else {
		   setVisible(false);
		   new Forgotpassword();	   
	   }
		
	}
	
	
	
	public static void main(String[] args) {
		new Login();
	}

}
