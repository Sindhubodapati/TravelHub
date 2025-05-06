package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class viewCustomer extends JFrame implements ActionListener{
	JButton back;
	String username;
	viewCustomer(String username){
		
		setBounds(250,100,800,500);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lbusername=new JLabel("Username");
		lbusername.setBounds(40,30,100,25);
		add(lbusername);
		JLabel labelusername=new JLabel();
		labelusername.setBounds(170,30,100,25);
		add(labelusername);
		
		JLabel lbid=new JLabel("Id");
		lbid.setBounds(40,80,100,25);
		add(lbid);
		JLabel labelid=new JLabel();
		labelid.setBounds(170,80,100,25);
		add(labelid);
		
		JLabel lbnumber=new JLabel("Number");
		lbnumber.setBounds(40,130,100,25);
		add(lbnumber);	
		JLabel labelnumber=new JLabel();
		labelnumber.setBounds(170,130,100,25);
		add(labelnumber);
		
		JLabel lbname=new JLabel("Name");
		lbname.setBounds(40,180,100,25);
		add(lbname);	
		JLabel labelname=new JLabel();
		labelname.setBounds(170,180,100,25);
		add(labelname);
		
		JLabel lbgender=new JLabel("Gender");
		lbgender.setBounds(40,230,100,25);
		add(lbgender);	
		JLabel labelgender=new JLabel();
		labelgender.setBounds(170,230,100,25);
		add(labelgender);
		
		JLabel lbcountry=new JLabel("Country");
		lbcountry.setBounds(450,30,100,25);
		add(lbcountry);	
		JLabel labelcountry=new JLabel();
		labelcountry.setBounds(600,30,100,25);
		add(labelcountry);
		

		JLabel lbaddress=new JLabel("Address");
		lbaddress.setBounds(450,80,100,25);
		add(lbaddress);	
		JLabel labeladdress=new JLabel();
		labeladdress.setBounds(600,80,100,25);
		add(labeladdress);
		

		JLabel lbphone=new JLabel("Phone");
		lbphone.setBounds(450,130,100,25);
		add(lbphone);	
		JLabel labelphone=new JLabel();
		labelphone.setBounds(600,130,100,25);
		add(labelphone);
		

		JLabel lbemail=new JLabel("Email");
		lbemail.setBounds(450,180,100,25);
		add(lbemail);	
		JLabel labelemail=new JLabel();
		labelemail.setBounds(600,180 ,100,25);
		add(labelemail);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(300,270,80,25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
		Image i2=i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(10,230,550,300);
		add(image);
		
		ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
		Image i5=i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		ImageIcon i6=new ImageIcon(i5);
		JLabel image1=new JLabel(i6);
		image1.setBounds(570,230,550,300);
		add(image1);
		
		try {
			Conn c=new Conn();
			String query="select * from customer where username='"+username+"'";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelid.setText(rs.getString("Id"));
				labelnumber.setText(rs.getString("number"));
				labelname.setText(rs.getString("Name"));			
				labelgender.setText(rs.getString("gender"));
				labelcountry.setText(rs.getString("country"));
				labeladdress.setText(rs.getString("address"));
				labelphone.setText(rs.getString("phone"));
				labelemail.setText(rs.getString("email"));
				
			}		
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
		setVisible(true);
		
		
		
	}
	public void actionPerformed(ActionEvent ae) {
			setVisible(false);
			new Dashboard("");
		
	}
	public static void main(String[] args) {
		new viewCustomer("sindhu123");
	}

}
