package day14.com.bridgelabz.Mysql.Connection;

public class main
{
        public static void main(String[] args) {
                EbookDAOIm obj1 = new EbookDAOIm();
                Ebook obj = new Ebook(6,"parshant","zyz",22.08f,22);
                obj1.save(obj);
                obj1.update(obj);
                obj1.delete(obj);
        }
}
