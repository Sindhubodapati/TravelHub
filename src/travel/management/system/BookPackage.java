package travel.management.system;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener{
	JLabel labelusername,lbusername,lblid,labelid,labelnumber,labelphone,labelprice;
	String username;
	JButton checkprice,back,bookpackage;
	JTextField tfpersons;
	Choice cpack;
	BookPackage(String username){
		this.username=username;
		setBounds(200,100,850,500);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel text=new JLabel("BOOK PACKAGE");
		text.setBounds(100,10,200,30);
		text.setFont(new Font("Tahoma",Font.BOLD,20));
		add(text);
		
		lbusername=new JLabel("Username");
		lbusername.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbusername.setBounds(40,70,100,20);
		add(lbusername);
		
		labelusername=new JLabel();
		labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
		labelusername.setBounds(250,70,200,20);
		add(labelusername);
		
		JLabel lblpackage=new JLabel("Select Package");
		lblpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
		lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblpackage.setBounds(40,110,110,20);
		add(lblpackage);
		
		cpack=new Choice();
		cpack.add("Gold Package");	
		cpack.add("Silver Package");
		cpack.add("Bronze Package");
		cpack.setBounds(250,110,150,20);
		add(cpack);
		
			
		
		JLabel lblpersons=new JLabel("Total Persons");
		lblpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblpersons.setBounds(40,150,150,25);
		add(lblpersons);
		
		tfpersons=new JTextField("1");
		tfpersons.setBounds(250,150,150,20);
		add(tfpersons);
		
		
		 lblid=new JLabel("Id");
		lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblid.setBounds(40,190,100,20);
		add(lblid);		
		labelid=new JLabel();
		labelid.setBounds(250,190,100,25);
		add(labelid);
			
		JLabel lbnumber=new JLabel("Number");
		lbnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbnumber.setBounds(40,230,100,20);
		add(lbnumber);			
		labelnumber=new JLabel();
		labelnumber.setBounds(250,230,100,25);
		add(labelnumber);
		
		JLabel lbphone=new JLabel("Phone");
		lbphone.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbphone.setBounds(40,270,100,20);
		add(lbphone);	
		labelphone=new JLabel();
		labelphone.setBounds(250,270,100,25);
		add(labelphone);
		
		
		
		JLabel lbltotal=new JLabel("Total Price");
		lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbltotal.setBounds(40,310,100,20);
		add(lbltotal);	
		labelprice=new JLabel();
		labelprice.setBounds(250,310,100,25);
		add(labelprice);
		

		try {
			Conn c=new Conn();
			String query="select * from customer where username='"+username+"'";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelid.setText(rs.getString("Id"));
				labelnumber.setText(rs.getString("number"));

				labelphone.setText(rs.getString("phone"));
				
			}		
		} catch(Exception e) {
			e.printStackTrace();
		}	
		
		checkprice=new JButton("Check Price");
		checkprice.setBounds(60,370,110,25);
		checkprice.setBackground(Color.BLACK);
		checkprice.setForeground(Color.WHITE);
		checkprice.addActionListener(this);
		add(checkprice);
		
		bookpackage=new JButton("Book Package");
		bookpackage.setBounds(150,420,120,25);
		bookpackage.setBackground(Color.BLACK);
		bookpackage.setForeground(Color.WHITE);
		bookpackage.addActionListener(this);
		add(bookpackage);
		
		back=new JButton("Back");
		back.setBounds(260,370,110,25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
		Image i2=i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l12=new JLabel(i3);
		l12.setBounds(450,50,350,300);
		add(l12);

		
		
		setVisible(true);
		
	}
      
public void actionPerformed(ActionEvent ae) {
	if(ae.getSource()==checkprice) {
		String pack=cpack.getSelectedItem();
		int cost=0;
		if(pack.equals("Gold Package")) {
			cost += 12000;
			
		}else if(pack.equals("Silver Package")) {
			cost += 25000;
			
		} else {
			cost += 32000;
		}
		int persons=Integer.parseInt(tfpersons.getText());
		cost *= persons;
		labelprice.setText("Rs "+ cost);	
		
	} else if(ae.getSource()==bookpackage) {
		try {
			Conn c=new Conn();
			c.s.executeUpdate("Insert into bookpackage values('"+labelusername.getText()+"','"+cpack.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
			
			JOptionPane.showMessageDialog(null, "Booked Successfully");
			setVisible(false);
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	} else {
		setVisible(false);
		new Dashboard("");
	}
	
}
	
	
	
	public static void main(String[] args) {
		new BookPackage("sindhu123");
	}
}
