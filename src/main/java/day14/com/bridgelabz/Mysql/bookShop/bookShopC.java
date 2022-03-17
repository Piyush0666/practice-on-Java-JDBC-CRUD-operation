package day14.com.bridgelabz.Mysql.bookShop;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class bookShopC {
    public static void main(String[] args)
    {
        Connection con = null;
        PreparedStatement ps = null;
        con = connection.connectDB();
        try {
            String sql = "insert into books values(11,'nitesh madan ','xyz',10.5,30)";
            ps = con.prepareStatement(sql);
            ps.execute();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}