package day14.com.bridgelabz.Mysql.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EbookDAOIm implements EbookIF
{
    Connection con;
    PreparedStatement ps;
    String sql;
    public void save(Ebook ebooks) {
        try {
            con = EbookDb.getConnection();
            sql = "INSERT INTO ebooks(id,title,aurthor,price,qty) VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, ebooks.getId());
            ps.setString(2, ebooks.getTitle());
            ps.setString(3, ebooks.getAurthor());
            ps.setFloat(4, ebooks.getPrice());
            ps.setInt(5, ebooks.getQty());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void update(Ebook ebooks) {
        try {
            Connection con = EbookDb.getConnection();
            String sql = "UPDATE book SET title=?,aurthor=?,price=?,qty=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ebooks.getId());
            ps.setString(2, ebooks.getTitle());
            ps.setString(3, ebooks.getAurthor());
            ps.setFloat(4, ebooks.getPrice());
            ps.setInt(5, ebooks.getQty());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Ebook ebooks) {
        try {
            Connection con = EbookDb.getConnection();
            String sql = "delete from books  WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ebooks.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Ebook get(int id) {
        Ebook st = new Ebook();
        try {
            Connection con = EbookDb.getConnection();
            String sql = "SELECT * FROM ebook WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                st.setId(rs.getInt("id"));
                st.setTitle(rs.getString("title"));
                st.setAurthor(rs.getString("aurthor"));
                st.setPrice(rs.getFloat("price"));
                st.setQty(rs.getInt("qty"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }

    public List<Ebook> list()
    {
        List<Ebook> list = new ArrayList<Ebook>();
        try
        {
            Connection con = EbookDb.getConnection();
            String sql = "SELECT * FROM ebook ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Ebook st = new Ebook();
                st.setId(rs.getInt("id"));
                st.setTitle(rs.getString("title"));
                st.setAurthor(rs.getString("aurthor"));
                st.setPrice(rs.getFloat("price"));
                st.setQty(rs.getInt("qty"));
                list.add(st);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

}