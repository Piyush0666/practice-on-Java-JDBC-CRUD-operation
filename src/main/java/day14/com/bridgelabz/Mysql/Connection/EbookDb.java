package day14.com.bridgelabz.Mysql.Connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class EbookDb {
    static Connection con;
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/ebookshop";
    static String uname = "root";
    static String pass = "admin123";

    public static Connection getConnection() throws Exception {
        if (con == null) {
            Class.forName(driver);
            con = DriverManager.getConnection(url, uname, pass);
        }
        return con;
    }

}