package day14.com.bridgelabz.Mysql.NewClass;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookShop extends Frame
{
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/ebookshop";
    public static final String UNAME = "root";
    public static final String PASSWORD = "admin123";
    String insertQuery;

    Label bookid,bookName,bookAurthor,bookPrice,bookqty;//for defining labels of the text field;
    TextField bookidField,bookNamefield,bookAurthorfield,bookPriceField, bookqtyfield;//defining text field
    //text field is the block where the user enters the input;
    Button saveButton;

    //constructor
    BookShop()
    {
        prepareGUI(); //calling method;
    }

    public static void main(String[] args)
    {
        BookShop obj = new BookShop();
        obj.dataBaseFunction();
    }
    public void prepareGUI()
    {
        this.setTitle("Book Registration System");
        this.setSize(500,500);
        this.setVisible(true);
        this.setLayout(new FlowLayout());

        this.addWindowListener(new WindowAdapter()
        {
            @Override public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });
        bookid = new Label("id:");
        bookidField = new TextField("Enter the name of Field",50);

        bookName = new Label("name:");
        bookNamefield = new TextField("Enter the name of Name",50);

        bookAurthor = new Label("aurthor:");
        bookAurthorfield = new TextField("Enter the name of Book",50);

        bookPrice = new Label("price:");
        bookPriceField = new TextField("Enter the name of field",50);

        bookqty = new Label("qty:");
        bookqtyfield = new TextField("Enter the name of qty",50);

        saveButton = new Button("SAVE");

        this.add(bookid);
        this.add(bookidField);
        this.add(bookName);
        this.add(bookNamefield);
        this.add(bookAurthor);
        this.add(bookAurthorfield);
        this.add(bookPrice);
        this.add(bookPriceField);
        this.add(bookqty);
        this.add(bookqtyfield);
        this.add(saveButton);

        bookidField.addFocusListener(new FocusListener()
        {
            public void focusGained(FocusEvent f)
            {
                bookidField.setText("");
            }

            public void focusLost(FocusEvent f)
            {
                if(bookidField.getText().equals(""))
                    bookidField.setText("Enter the id");
            }
        });
        bookNamefield.addFocusListener(new FocusListener()
        {
            public void focusGained(FocusEvent f)
            {
                bookNamefield.setText("");
            }

            public void focusLost(FocusEvent f)
            {
                if(bookNamefield.getText().equals(""))
                    bookNamefield.setText("Enter the name of field");
            }
        });
        bookAurthorfield.addFocusListener(new FocusListener()
        {
            public void focusGained(FocusEvent f)
            {
                bookAurthorfield.setText("");
            }

            public void focusLost(FocusEvent f)
            {
                if(bookAurthorfield.getText().equals(""))
                    bookAurthorfield.setText("Enter the name of aurthor");
            }
        });
        bookPriceField.addFocusListener(new FocusListener()
        {
            public void focusGained(FocusEvent f)
            {
                bookPriceField.setText("");
            }

            public void focusLost(FocusEvent f)
            {
                if(bookPriceField.getText().equals(""))
                    bookPriceField.setText("Enter the name of price");
            }
        });
        bookqtyfield.addFocusListener(new FocusListener()
        {
            public void focusGained(FocusEvent f)
            {
                bookqtyfield.setText("");
            }

            public void focusLost(FocusEvent f)
            {
                if(bookqtyfield.getText().equals(""))
                    bookqtyfield.setText("Enter the name of qty");
            }
        });
    }
    public void dataBaseFunction()
    {
        saveButton.addActionListener(new ActionListener()
        {
            @Override public void actionPerformed(ActionEvent e)
            {
                try
                {
                    insertQuery = "insert into books values(?,?,?,?,?)";

                    Class.forName(JDBC_DRIVER);

                    Connection con = DriverManager.getConnection(DB_URL,UNAME,PASSWORD);

                    PreparedStatement pst = con.prepareStatement(insertQuery);
                    pst.setString(1,bookidField.getText());
                    pst.setString(2,bookNamefield.getText());
                    pst.setString(3,bookAurthorfield.getText());
                    pst.setString(4,bookPriceField.getText());
                    pst.setString(5,bookqtyfield.getText());
                    pst.executeUpdate();

                    pst.close();
                    con.close();
                }
                catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

}