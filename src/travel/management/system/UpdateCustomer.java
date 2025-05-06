package travel.management.system;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;


public class UpdateCustomer extends JFrame implements ActionListener{
	JLabel labelusername,labelname,lbid,lbusername,lbnumber,lbgender,lbname,lbcountry,lbaddress,lbphone,lbemail,head;
	JTextField tfnumber,tfcountry,tfaddress,tfphone,tfemail,tfid,tfgender;
	JButton update,back;
	String username;
	UpdateCustomer(String username){
		this.username = username;
		
		
		setBounds(290,110,750,500);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel head=new JLabel("UPDATE CUSTOMER DETAILS");
		head.setBounds(50,5,300,25);
		head.setFont(new Font("Tahoma",Font.PLAIN,20));	
		add(head);
		
		lbusername=new JLabel("Username");
		lbusername.setBounds(30,20,100,60);
		add(lbusername);	
		labelusername = new JLabel();
		labelusername.setBounds(200,40,150,25);
		labelusername.setLayout(null);
		add(labelusername);
		
		
		lbid=new JLabel("Id");
		lbid.setBounds(30,60,100,60);
		add(lbid);	
		tfid = new JTextField();
		tfid.setBounds(200,80,150,25);
		tfid.setLayout(null);
		add(tfid);
		
		
		
		lbnumber=new JLabel("Number");
		lbnumber.setBounds(30,100,100,60);
		add(lbnumber);	
		tfnumber = new JTextField();
		tfnumber.setBounds(200,120,150,25);
		tfnumber.setLayout(null);
		add(tfnumber);
		
		lbname=new JLabel("Name");
		lbname.setBounds(30,140,100,60);
		add(lbname);		
		labelname = new JLabel();
		labelname.setBounds(200,160,150,25);
		labelname.setLayout(null);
		add(labelname);
		
		lbgender=new JLabel("Gender");
		lbgender.setBounds(30,180,100,60);
		add(lbgender);
		tfgender = new JTextField();
		tfgender.setBounds(200,200,150,25);
		tfgender.setLayout(null);
		add(tfgender);
		
		lbcountry=new JLabel("Country");
		lbcountry.setBounds(30,220,100,60);
		add(lbcountry);	
		tfcountry = new JTextField();
		tfcountry.setBounds(200,240,150,25);
		tfcountry.setLayout(null);
		add(tfcountry);
		
		lbaddress=new JLabel("Address");
		lbaddress.setBounds(30,260,100,60);
		add(lbaddress);		
		tfaddress = new JTextField();
		tfaddress.setBounds(200,280,150,25);
		tfaddress.setLayout(null);
		add(tfaddress);
		
		lbphone=new JLabel("Phone");
		lbphone.setBounds(30,300,100,60);
		add(lbphone);	
		tfphone = new JTextField();
		tfphone.setBounds(200,320,150,25);
		tfphone.setLayout(null);
		add(tfphone);
		
		lbemail=new JLabel("Email");
		lbemail.setBounds(30,340,100,60);
		add(lbemail);		
		tfemail = new JTextField();
		tfemail.setBounds(200,360,150,25);
		tfemail.setLayout(null);
		add(tfemail);
		
		update=new JButton("Update");
		update.setBounds(70,420,80,25);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.addActionListener(this);
		add(update);
		

		back=new JButton("Back");
		back.setBounds(220,420,80,25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
		Image i2=i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(320,30,400,500);
		add(image);
		
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from customer where username='"+username+"'");
			while(rs.next()) {
				
				labelusername.setText(rs.getString("username"));
				labelname.setText(rs.getString("name"));
				tfid.setText(rs.getString("id"));
				tfnumber.setText(rs.getString("number"));
				tfgender.setText(rs.getString("gender"));
				tfcountry.setText(rs.getString("country"));
				tfaddress.setText(rs.getString("address"));
				tfphone.setText(rs.getString("phone"));
				tfemail.setText(rs.getString("email"));

			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
		setVisible(true);	
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== update){
			String username=labelusername.getText();
			String Id = tfid.getText();
			String number = tfnumber.getText();
			String name = labelname.getText();
			String gender = tfgender.getText();
			String country=tfcountry.getText();
			String address=tfaddress.getText();
			String phone=tfphone.getText();
			String email=tfemail.getText();
			try {
				Conn c=new Conn();
				String query="update customer set username='"+username+"',id = '"+Id+"',number ='"+number+"',name='"+name+"',gender='"+gender+"',country='"+country+"',address='"+address+"',phone='"+phone+"',email='"+email+"'";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Updated  Details Successfully");
				setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}

		}else
		  {
				setVisible(false);
				new Dashboard("");
			}
	}
	
	public static void main(String[] args) {
		new UpdateCustomer("sindhu123");
	}

}
