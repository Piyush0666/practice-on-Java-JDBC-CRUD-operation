package day14.com.bridgelabz.Mysql.bookShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    Connection con = null;

    public static Connection connectDB()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "admin123");
            return con;
        }
        catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            return null;
        }
    }
}
