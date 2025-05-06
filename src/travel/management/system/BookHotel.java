package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener{
	JLabel labelusername,lbusername,lblid,labelid,labelnumber,labelphone,labelprice,lblac,lblfood;
	String username;
	JButton checkprice,back,bookpackage;
	JTextField tfdays,tfpersons;
	Choice chotel,cac,cfood;
	BookHotel(String username){
		this.username=username;
		setBounds(200,100,850,600);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel text=new JLabel("BOOK HOTEL");
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
		
		JLabel lblpackage=new JLabel("Select Hotel");
		lblpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
		lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblpackage.setBounds(40,110,110,20);
		add(lblpackage);
		
		chotel=new Choice();
		
		chotel.setBounds(250,110,150,20);
		add(chotel);
		
		try {
			
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("Select * from hotel");
			while(rs.next()) {
				chotel.add(rs.getString("name"));
				
			}		
			
		} catch(Exception e) {
			e.printStackTrace();	
		}
			
		
		JLabel lblpersons=new JLabel("Total Persons");
		lblpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblpersons.setBounds(40,150,150,25);
		add(lblpersons);
		
		tfpersons=new JTextField("1");
		tfpersons.setBounds(250,150,150,20);
		add(tfpersons);
		
		JLabel lbldays=new JLabel("No. of Days");	
		lbldays.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbldays.setBounds(40,190,150,25);
		add(lbldays);
		
		tfdays=new JTextField("1");
		tfdays.setBounds(250,190,150,20);
		add(tfdays);
		
		JLabel lblac=new JLabel("AC/ Non-AC");	
		lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblac.setBounds(40,230,150,25);
		add(lblac);
	
		cac=new Choice();
		cac.add("AC");
		cac.add("Non-AC");	
		cac.setBounds(250,230,150,20);
		add(cac);
		

		JLabel lblfood=new JLabel("Food Included");	
		lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblfood.setBounds(40,270,150,25);
		add(lblfood);
		
		cfood=new Choice();
		cfood.add("Yes");
		cfood.add("No");	
		cfood.setBounds(250,270,150,20);
		add(cfood);
		
				
		 lblid=new JLabel("Id");
		lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
		lblid.setBounds(40,310,100,20);
		add(lblid);		
		labelid=new JLabel();
		labelid.setBounds(250,310,100,25);
		add(labelid);
			
		JLabel lbnumber=new JLabel("Number");
		lbnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbnumber.setBounds(40,350,100,20);
		add(lbnumber);			
		labelnumber=new JLabel();
		labelnumber.setBounds(250,350,100,25);
		add(labelnumber);
		
		JLabel lbphone=new JLabel("Phone");
		lbphone.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbphone.setBounds(40,390,100,20);
		add(lbphone);	
		labelphone=new JLabel();
		labelphone.setBounds(250,390,100,25);
		add(labelphone);
		
		
		
		JLabel lbltotal=new JLabel("Total Price");
		lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
		lbltotal.setBounds(40,430,100,20);
		add(lbltotal);	
		labelprice=new JLabel();
		labelprice.setBounds(250,430,100,25);
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
		checkprice.setBounds(60,470,110,25);
		checkprice.setBackground(Color.BLACK);
		checkprice.setForeground(Color.WHITE);
		checkprice.addActionListener(this);
		add(checkprice);
		
		bookpackage=new JButton("Book Hotel");
		bookpackage.setBounds(200,470,120,25);
		bookpackage.setBackground(Color.BLACK);
		bookpackage.setForeground(Color.WHITE);
		bookpackage.addActionListener(this);
		add(bookpackage);
		
		back=new JButton("Back");
		back.setBounds(340,470,110,25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
		Image i2=i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l12=new JLabel(i3);
		l12.setBounds(450,50,400,300);
		add(l12);

		
		
		setVisible(true);
		
	}
      
public void actionPerformed(ActionEvent ae) {
	if(ae.getSource()==checkprice) {
		try {
		Conn c=new Conn();
		ResultSet rs= c.s.executeQuery("select * from hotel where name='"+chotel.getSelectedItem()+"'");
		while(rs.next()) {
			int cost = Integer.parseInt(rs.getString("costperperson"));
			int food = Integer.parseInt(rs.getString("foodincluded"));
			int ac = Integer.parseInt(rs.getString("acroom"));
			
			int persons = Integer.parseInt(tfpersons.getText());
			int days=Integer.parseInt(tfdays.getText());
			
			String acselected = cac.getSelectedItem();
			String foodselected = cfood.getSelectedItem();
			
			if(persons * days>0) {
				int total=0;
				total+= acselected.equals("AC") ? ac:0;
				total+= foodselected.equals("Yes") ? food:0;
                total += cost;
                total = total * persons * days;
				labelprice.setText("Rs "+total);
				
			} else {
				JOptionPane.showMessageDialog(null,"Please enter a valid number");
			}

			
			
		}
		String pack=chotel.getSelectedItem();
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
		}
		catch(Exception e){
			e.printStackTrace();
			}			
	} 
		else if(ae.getSource()==bookpackage) {
		try {
			Conn c=new Conn();
			c.s.executeUpdate("Insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
			
			JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
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
		new BookHotel("sindhu123");
	}
}
