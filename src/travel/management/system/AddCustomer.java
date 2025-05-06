package travel.management.system;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;


public class AddCustomer extends JFrame implements ActionListener{
	JLabel labelusername,labelname,lbid,lbusername,lbnumber,lbgender,lbname,lbcountry,lbaddress,lbphone,lbemail;
	JTextField tfnumber,tfcountry,tfaddress,tfphone,tfemail;
	JComboBox cid;
	JButton add,back;
	JRadioButton rmale,rfemale;
	String username;
	AddCustomer(String username){
		this.username = username;
		
		
		setBounds(250,80,700,500);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
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
		
		cid = new JComboBox(new String[] {"Passport","Aadhaar Card","Pan Card","Ration Card"});
		cid.setBounds(200,80,150,25);
		cid.setBackground(Color.WHITE);
		add(cid);
		
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
		
		rmale=new JRadioButton("Male");
		rmale.setBounds(200, 200, 70, 25);
		rmale.setBackground(Color.WHITE);
		add(rmale);
		rfemale=new JRadioButton("Female");
		rfemale.setBounds(280, 200, 70, 25);
		rfemale.setBackground(Color.WHITE);
		add(rfemale);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rmale);
		bg.add(rfemale);
		
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
		
		add=new JButton("Add");
		add.setBounds(70,420,70,25);
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.addActionListener(this);
		add(add);
		

		back=new JButton("Back");
		back.setBounds(220,420,80,25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
		Image i2=i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(320,30,400,500);
		add(image);
		
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from account where username='sindhu123'");
			while(rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelname.setText(rs.getString("name"));
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
		setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== add){
			String username=labelusername.getText();
			String Id = (String) cid.getSelectedItem();
			String number = tfnumber.getText();
			String name = labelname.getText();
			String gender = null;
			if(rmale.isSelected()) {
				gender="Male";
			} else {
				gender="Female";
			}
			String country=tfcountry.getText();
			String address=tfaddress.getText();
			String phone=tfphone.getText();
			String email=tfemail.getText();
			try {
				Conn c=new Conn();
				String query="insert into customer values('"+username+"','"+Id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Customer Added Successfully");
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
		new AddCustomer("");
	}

}
