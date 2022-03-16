package day14.com.bridgelabz.Mysql.Connection;

import java.util.List;

public interface EbookIF {
    public void save(Ebook ebooks);
    public void update(Ebook ebooks);
    public void delete(Ebook ebooks);
    public Ebook get(int id );
    public List<Ebook> list();
}

