package travel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Forgotpassword extends JFrame implements ActionListener{
	JButton search,retrieve,back;
	JTextField tfusername,tfname,tfans,tfsecurity,tfpassword;
	Forgotpassword(){
		setBounds(250,150,700,350);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(20,20,450,270);
		p1.setBackground(Color.LIGHT_GRAY);
		add(p1);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
		Image i2= i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(470,30,200,200);
		add(image);
		
		JLabel lbusername=new JLabel("Username");
		lbusername.setBounds(30,20,100,30);
		lbusername.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(lbusername);
		
	    tfusername=new JTextField();
		tfusername.setBounds(150,20,150,25);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfusername);

		search=new JButton("Search");
	    search.setBounds(320,20,100,25);
		search.setForeground(Color.WHITE);
		search.setBackground(Color.GRAY);
		search.setFont(new Font("Tahoma",Font.BOLD,14));
		search.addActionListener(this);
		p1.add(search);
		
		JLabel lbname=new JLabel("Name");
		lbname.setBounds(30,60,100,30);
		lbname.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(lbname);
		
	    tfname=new JTextField();
		tfname.setBounds(150,60,150,25);
		tfname.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfname);
		
		JLabel lbsecurity=new JLabel("Security Question");
		lbsecurity.setBounds(30,100,100,30);
		lbsecurity.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(lbsecurity);
		
	    tfsecurity=new JTextField();
		tfsecurity.setBounds(150,100,150,25);
		tfsecurity.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfsecurity);
		

		JLabel lbans=new JLabel("Answer");
		lbans.setBounds(30,140,100,30);
		lbans.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(lbans);
		
	    tfans=new JTextField();
		tfans.setBounds(150,140,150,25);
		tfans.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfans);
		
		retrieve=new JButton("Retrieve");
	    retrieve.setBounds(320,140,100,25);
		retrieve.setForeground(Color.WHITE);
		retrieve.setBackground(Color.GRAY);
		retrieve.setFont(new Font("Tahoma",Font.BOLD,14));
		retrieve.addActionListener(this);
		p1.add(retrieve);
		
		JLabel lbpassword=new JLabel("Password");
		lbpassword.setBounds(30,180,100,30);
		lbpassword.setFont(new Font("Tahoma",Font.BOLD,14));
		p1.add(lbpassword);
		
	    tfpassword=new JTextField();
		tfpassword.setBounds(150,180,150,25);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfpassword);
		
		back=new JButton("Back");
	    back.setBounds(180,220,100,25);
		back.setForeground(Color.WHITE);
		back.setBackground(Color.GRAY);
		back.setFont(new Font("Tahoma",Font.BOLD,14));
		back.addActionListener(this);
		p1.add(back);
		
		
		
		
		
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==search) {
				try {
				
				String query= "select * from account where username = '"+tfusername.getText()+"'";
				Conn c=new Conn();
				
				ResultSet rs=c.s.executeQuery(query);
				while(rs.next()) {
					tfname.setText(rs.getString("name"));
					tfsecurity.setText(rs.getString("security"));
				}			
			} catch(Exception e) {
			e.printStackTrace();
		}
	} else if(ae.getSource()==retrieve) {
		try {
			String query="select * from account where username='"+tfusername.getText()+"' and answer='"+tfans.getText()+"'";
			Conn c=new Conn();
			
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next()) {
				tfpassword.setText(rs.getString("password"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
			
		} else {
			setVisible(false);
			new Login();
		}
	}
		
	public static void main(String[] args) {
		new Forgotpassword();
	}

}
