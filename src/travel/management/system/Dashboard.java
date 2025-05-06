package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class Dashboard extends JFrame implements ActionListener{
	String  username;
	JButton addPersonalDetails,viewPersonalDetails,updatePersonalDetails,checkpackage,bookpackage,viewpackage,viewhotels,destinations;
	JButton viewbookedhotel,bookhotel,payments,calc,notepad,about;
	Dashboard(String username){
		this.username=username;
		//setBounds(0,0,1400,800);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		
		
		JPanel p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(0,0,1400,55);
		p1.setBackground(new Color(0,0,102));
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
		Image i2=i1.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel icon=new JLabel(i3);
		icon.setBounds(5, 0, 70, 70);
		p1.add(icon);
		
		JLabel heading=new JLabel("Dashboard");
		heading.setBounds(80,10,300,40);
		heading.setFont(new Font("Tahoma",Font.BOLD,20));
		heading.setForeground(Color.WHITE);
		p1.add(heading);
		
		JPanel p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(0,55,250,800);
		p2.setBackground(new Color(0,0,102));
		add(p2);
		
		addPersonalDetails = new JButton("Add Personal Details");
		addPersonalDetails.setBounds(0, 0, 300,40);
		addPersonalDetails.setForeground(Color.WHITE);
		addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,15));
		addPersonalDetails.setBackground(new Color(0,0,102));
		addPersonalDetails.setMargin(new Insets(0,0,0,100));
		addPersonalDetails.addActionListener(this);
		p2.add(addPersonalDetails);
		

		updatePersonalDetails = new JButton("Update Personal Details");
		updatePersonalDetails.setBounds(0, 40, 300,40);
		updatePersonalDetails.setForeground(Color.WHITE);
		updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,15));
		updatePersonalDetails.setBackground(new Color(0,0,102));
		updatePersonalDetails.setMargin(new Insets(0,0,0,80));
		updatePersonalDetails.addActionListener(this);
		p2.add(updatePersonalDetails);
		
		viewPersonalDetails = new JButton("View Personal Details");
		viewPersonalDetails.setBounds(0, 80, 300,40);
		viewPersonalDetails.setForeground(Color.WHITE);
		viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,15));
		viewPersonalDetails.setBackground(new Color(0,0,102));
		viewPersonalDetails.setMargin(new Insets(0,0,0,100));
	    viewPersonalDetails.addActionListener(this);
		p2.add(viewPersonalDetails);
		
		JButton deletePersonalDetails = new JButton("Delete Personal Details");
		deletePersonalDetails.setBounds(0, 120, 300,40);
		deletePersonalDetails.setForeground(Color.WHITE);
		deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,15));
		deletePersonalDetails.setBackground(new Color(0,0,102));
		deletePersonalDetails.setMargin(new Insets(0,0,0,90));
		p2.add(deletePersonalDetails);
		
		checkpackage = new JButton("Check Package");
		checkpackage.setBounds(0, 160, 300,40);
		checkpackage.setForeground(Color.WHITE);
		checkpackage.setFont(new Font("Tahoma",Font.PLAIN,15));
		checkpackage.setBackground(new Color(0,0,102));
		checkpackage.setMargin(new Insets(0,0,0,140));
		p2.add(checkpackage);
		
		 bookpackage = new JButton("Book Package");
		bookpackage.setBounds(0, 200, 300,40);
		bookpackage.setForeground(Color.WHITE);
		bookpackage.setFont(new Font("Tahoma",Font.PLAIN,15));
		bookpackage.setBackground(new Color(0,0,102));
		bookpackage.setMargin(new Insets(0,0,0,150));
		p2.add(bookpackage);
		
		viewpackage = new JButton("View Package");
		viewpackage.setBounds(0, 240, 300,40);
		viewpackage.setForeground(Color.WHITE);
		viewpackage.setFont(new Font("Tahoma",Font.PLAIN,15));
		viewpackage.setBackground(new Color(0,0,102));
		viewpackage.setMargin(new Insets(0,0,0,150));
		viewpackage.addActionListener(this);
		p2.add(viewpackage);
		
		 viewhotels= new JButton("View Hotels");
		viewhotels.setBounds(0, 280, 300,40);
		viewhotels.setForeground(Color.WHITE);
		viewhotels.setFont(new Font("Tahoma",Font.PLAIN,15));
		viewhotels.setBackground(new Color(0,0,102));
		viewhotels.setMargin(new Insets(0,0,0,160));
		viewhotels.addActionListener(this);

		p2.add(viewhotels);
		
		 bookhotel= new JButton("Book Hotel");
		bookhotel.setBounds(0, 320, 300,40);
		bookhotel.setForeground(Color.WHITE);
		bookhotel.setFont(new Font("Tahoma",Font.PLAIN,15));
		bookhotel.setBackground(new Color(0,0,102));
		bookhotel.setMargin(new Insets(0,0,0,170));
		bookhotel.addActionListener(this);
		p2.add(bookhotel);
		
		 viewbookedhotel= new JButton("View Booked Hotel");
		viewbookedhotel.setBounds(0, 360, 300,40);
		viewbookedhotel.setForeground(Color.WHITE);
		viewbookedhotel.setFont(new Font("Tahoma",Font.PLAIN,15));
		viewbookedhotel.setBackground(new Color(0,0,102));
		viewbookedhotel.setMargin(new Insets(0,0,0,115));
		viewbookedhotel.addActionListener(this);
		p2.add(viewbookedhotel);
		

		 destinations= new JButton("Destinations");
		destinations.setBounds(0, 400, 300,40);
		destinations.setForeground(Color.WHITE);
		destinations.setFont(new Font("Tahoma",Font.PLAIN,15));
		destinations.setBackground(new Color(0,0,102));
		destinations.setMargin(new Insets(0,0,0,155));
		destinations.addActionListener(this);
		p2.add(destinations);
		
		payments= new JButton("Payments");
		payments.setBounds(0, 440, 300,40);
		payments.setForeground(Color.WHITE);
		payments.setFont(new Font("Tahoma",Font.PLAIN,15));
		payments.setBackground(new Color(0,0,102));
		payments.setMargin(new Insets(0,0,0,175));
		payments.addActionListener(this);
		p2.add(payments);
		
		calc= new JButton("Calculator");
		calc.setBounds(0, 480, 300,40);
		calc.setForeground(Color.WHITE);
		calc.setFont(new Font("Tahoma",Font.PLAIN,15));
		calc.setBackground(new Color(0,0,102));
		calc.setMargin(new Insets(0,0,0,175));
		calc.addActionListener(this);

		p2.add(calc);
		
		notepad =new JButton("NotePad");
		notepad.setBounds(0, 520, 300,40);
		notepad.setForeground(Color.WHITE);
		notepad.setFont(new Font("Tahoma",Font.PLAIN,15));
		notepad.setBackground(new Color(0,0,102));
		notepad.setMargin(new Insets(0,0,0,185));
	    notepad.addActionListener(this);
		p2.add(notepad);
		
		about= new JButton("About");
		about.setBounds(0, 560, 300,40);
		about.setForeground(Color.WHITE);
		about.setFont(new Font("Tahoma",Font.PLAIN,15));
		about.setBackground(new Color(0,0,102));
		about.setMargin(new Insets(0,0,0,195));
		about.addActionListener(this);
		p2.add(about);
		

		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
		Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);	
		ImageIcon i6=new ImageIcon(i5);
		JLabel image=new JLabel(i6);
		//setBounds(x-horizontal increase,y-vertical increase,width-increase size of content(left-right),height-narrowing or increasing content
		image.setBounds(0,0,1650,1000);
		add(image);	
		
		JLabel txt=new JLabel("Travel and Tourism Management System");
		txt.setBounds(350,70,1000,70);
		txt.setForeground(Color.WHITE);
		txt.setFont(new Font("Raleway",Font.PLAIN,45));
		image.add(txt);
				
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==addPersonalDetails) {
			setVisible(false);
			new AddCustomer(username);
		} else if(ae.getSource()== viewPersonalDetails) {
			setVisible(false);
			new viewCustomer(username);
	} else if(ae.getSource()== updatePersonalDetails) {
		setVisible(false);
		new UpdateCustomer(username);
	}else if(ae.getSource()==checkpackage) {
		setVisible(false);
		new CheckPackage();
	} else if(ae.getSource()==bookpackage) {
		setVisible(false);
        new  BookPackage(username);
	} else if(ae.getSource()==viewpackage) {
		setVisible(false);
		new ViewPackage(username);
	}else if(ae.getSource()==viewhotels) {
		setVisible(false);
		new CheckHotels();
	}else if(ae.getSource()==destinations) {
		setVisible(false);
		new Destinations();
	} else if(ae.getSource()==bookhotel) {
		setVisible(false);
		new BookHotel(username);
	}else if(ae.getSource()==viewbookedhotel) {
		setVisible(false);
		new ViewBookedHotel(username);
	}else if(ae.getSource()==payments) {
		setVisible(false);
		new Payment();
	}else if(ae.getSource()==calc) {
		try {
			Runtime.getRuntime().exec("calc.exe");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}else if(ae.getSource()==notepad) {
		try {
			Runtime.getRuntime().exec("notepad.exe");
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}else if(ae.getSource()==about) {
		new About();
	
	}
		
		
	}
	public static void main(String[] args) {
		new Dashboard("");
	}

}
