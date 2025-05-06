package travel.management.system;
import javax.swing.*;//For JFrame
import java.awt.*; //for color
import java.awt.event.*;


public class Signup extends JFrame implements ActionListener{
	JButton create,back;
	JTextField tfusername,tfname,tfpassword,tfans;
	Choice security;
	Signup(){
		setBounds(250,150,800,350);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel p1=new JPanel();
		p1.setBounds(0,0,450,400);
		p1.setBackground(new Color(133,193,233));
		p1.setLayout(null);
		add(p1);
		
		JLabel lbusername=new JLabel("Username : ");
		lbusername.setBounds(50,20,100,20);
		lbusername.setFont(new Font("Tahoma",Font.BOLD,14));//ususally fontsize-12
		p1.add(lbusername);
		
		tfusername = new JTextField();
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		tfusername.setBounds(170, 20, 200, 20);
		tfusername.setLayout(null);
		p1.add(tfusername);
		
		
		JLabel lbname=new JLabel("Name : ");
		lbname.setBounds(50,60,100,20);
		lbname.setFont(new Font("Tahoma",Font.BOLD,14));//ususally fontsize-12
		p1.add(lbname);
		
		tfname = new JTextField();
		tfname.setBorder(BorderFactory.createEmptyBorder());
		tfname.setBounds(170, 60, 200, 20);
		tfname.setLayout(null);
		p1.add(tfname);
		
		
		JLabel lbpassword=new JLabel("Password : ");
		lbpassword.setBounds(50,100,100,20);
		lbpassword.setFont(new Font("Tahoma",Font.BOLD,14));//ususally fontsize-12
		p1.add(lbpassword);
		
		tfpassword = new JTextField();
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		tfpassword.setBounds(170, 100, 200, 20);
		tfpassword.setLayout(null);
		p1.add(tfpassword);
		
		JLabel lbsecurity=new JLabel("Security Question : ");
		lbsecurity.setBounds(50,140,105,20);
		lbsecurity.setFont(new Font("Tahoma",Font.BOLD,14));//ususally fontsize-12
		p1.add(lbsecurity);
		
		security=new Choice();
		security.add("Fav Marvel superhero?");
		security.add("Your Fav Hero?");
		security.add("Your Lucky number?");
		security.setBounds(170, 140, 200, 20);
		p1.add(security);
		
		JLabel lbans=new JLabel("Answer : ");
		lbans.setBounds(50,180,100,20);
		lbans.setFont(new Font("Tahoma",Font.BOLD,14));//ususally fontsize-12
		p1.add(lbans);
		
		tfans = new JTextField();
		tfans.setBorder(BorderFactory.createEmptyBorder());
		tfans.setBounds(170, 180, 200, 20);
		tfans.setLayout(null);
		p1.add(tfans);
		
		create=new JButton("Create");
		create.setBounds(70,250,100,30);
		create.setForeground(new Color(133,193,233));
		create.setBackground(Color.WHITE);
		create.setFont(new Font("Tahoma",Font.BOLD,14));
		create.addActionListener(this);
		//create.setLayout(null);
		p1.add(create);
		
		
		back=new JButton("Back");
		back.setBounds(300,250,100,30);
		back.setForeground(new Color(133,193,233));
		back.setBackground(Color.WHITE);
		back.setFont(new Font("Tahoma",Font.BOLD,14));
		//create.setLayout(null);
		back.addActionListener(this);
		p1.add(back);
		
		

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		//setBounds(x-horizontal increase,y-vertical increase,width-increase size of content(left-right),height-narrowing or increasing content
		image.setBounds(500,50,200,200);
		add(image);	
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==create) {
			String username = tfusername.getText();
			String name = tfname.getText();
			String password = tfpassword.getText();
			String question = security.getSelectedItem();
			String answer = tfans.getText();
			
			String query="Insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
			try {
				Conn c=new Conn();
				c.s.executeUpdate(query);	
				JOptionPane.showMessageDialog(null,"Account created Succefully");
				setVisible(false);
				new Login();
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(ae.getSource()==back){
			setVisible(false);
			new Login();
			
		}
		
	}

	public static void main(String[] args) {
		new Signup();
	}
}
