package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


	public class ViewPackage extends JFrame implements ActionListener{
		JButton back;
		String username;
		ViewPackage(String username){
			
			setBounds(250,100,800,450);
			getContentPane().setBackground(Color.WHITE);
			setLayout(null);
			
			JLabel text=new JLabel("VIEWPACKAGE DETAILS");
			text.setFont(new Font("Tahoma",Font.BOLD,20));
			text.setBounds(60,0,300,30);
			add(text);
			
			JLabel lbusername=new JLabel("Username");
			lbusername.setBounds(40,50,100,25);
			add(lbusername);
			JLabel labelusername=new JLabel();
			labelusername.setBounds(170,50,100,25);
			add(labelusername);
			
			JLabel lbid=new JLabel("Package");
			lbid.setBounds(40,90,100,25);
			add(lbid);
			JLabel labelpackage=new JLabel();
			labelpackage.setBounds(170,90,100,25);
			add(labelpackage);
			
			JLabel lbnumber=new JLabel("Total Persons");
			lbnumber.setBounds(40,130,100,25);
			add(lbnumber);	
			JLabel labelpersons=new JLabel();
			labelpersons.setBounds(170,130,100,25);
			add(labelpersons);
			
			JLabel lbname=new JLabel("Id");
			lbname.setBounds(40,170,100,25);
			add(lbname);	
			JLabel labelid=new JLabel();
			labelid.setBounds(170,170,100,25);
			add(labelid);
			
			JLabel lbgender=new JLabel("Number");
			lbgender.setBounds(40,210,100,25);
			add(lbgender);	
			JLabel labelnumber=new JLabel();
			labelnumber.setBounds(170,210,100,25);
			add(labelnumber);
			
			JLabel lbcountry=new JLabel("Phone");
			lbcountry.setBounds(40,250,100,25);
			add(lbcountry);	
			JLabel labelphone=new JLabel();
			labelphone.setBounds(170,250,100,25);
			add(labelphone);
			

			JLabel lbaddress=new JLabel("Price");
			lbaddress.setBounds(40,290,100,25);
			add(lbaddress);	
			JLabel labelprice=new JLabel();
			labelprice.setBounds(170,290,100,25);
			add(labelprice);
			

			
			back = new JButton("Back");
			back.setBackground(Color.BLACK);
			back.setForeground(Color.WHITE);
			back.setBounds(130,350,80,25);
			back.addActionListener(this);
			add(back);
			
			ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
			Image i2=i1.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			JLabel image=new JLabel(i3);
			image.setBounds(400,20,400,400);
			add(image);
			
			
			
			try {
				Conn c=new Conn();
				String query="select * from bookpackage where username='"+username+"'";
				ResultSet rs=c.s.executeQuery(query);
				while(rs.next()) {
					labelusername.setText(rs.getString("username"));
					labelid.setText(rs.getString("Id"));
					labelnumber.setText(rs.getString("number"));
					labelpackage.setText(rs.getString("package"));			
					labelprice.setText(rs.getString("price"));
					labelphone.setText(rs.getString("phone"));
					labelpersons.setText(rs.getString("persons"));
					
					
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
			new ViewPackage("sindhu123");
		}

	}



