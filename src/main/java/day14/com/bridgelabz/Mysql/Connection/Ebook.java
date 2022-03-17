package day14.com.bridgelabz.Mysql.Connection;


public class Ebook {

    private int id;
    private String title;
    private String aurthor;
    private Float price;

    public Ebook() {
    }

    public Ebook(int id, String title, String aurthor, Float price, int qty) {
        this.id = id;
        this.title = title;
        this.aurthor = aurthor;
        this.price = price;
        this.qty = qty;
    }

    private int qty;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAurthor() {
        return aurthor;
    }

    public void setAurthor(String aurthor) {
        this.aurthor = aurthor;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}