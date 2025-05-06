package travel.management.system;


import java.sql.DriverManager;
import java.sql.Statement;

public class Conn{
    java.sql.Connection c;
    Statement s;

    public Conn() {
        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem", "root", "sindhu"); 
            
            // Create statementm
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

