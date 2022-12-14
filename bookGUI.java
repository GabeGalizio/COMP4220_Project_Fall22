import javax.swing.*;
import javax.swing.border.Border;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;



public class bookGUI{
    private static Bookstore bs = new Bookstore("UWindsor", 100);
    private static Book b1 = new Book("Intro to agile 1", 0);
    private static Book b2 = new Book("Intro to physics 1", 0);
    private static Book b3 = new Book("Agility Intro", 13);
    private static Book b4 = new Book("Mechanics and power", 10);
    private static Book b5 = new Book("Cells in animals", 5);
    private static Book b6 = new Book("Intro to Java", 8);
    private static Book b7 = new Book("Fundamentals of OOP", 3);
    private static Book b8 = new Book("Web Developement", 36);
    private static Book b9 = new Book("Database Design", 17);
    private static Book b10 = new Book("Business Management", 0);
    private static Book b11 = new Book("Intro to Latin 1", 30);
    private static Book b12 = new Book("Mathematical Foundations", 1);
    private static Book b13 = new Book("Forensic Science 101", 0);
    private static Book b14 = new Book("Human Anatomy 1", 24);
    private static Book b15 = new Book("Human Anatomy 2", 60);
    public static void main(String[] args) {
        bs.add(b1);
        bs.add(b2);
        bs.add(b3);
        bs.add(b4);
        bs.add(b5);
        bs.add(b6);
        bs.add(b7);
        bs.add(b8);
        bs.add(b9);
        bs.add(b10);
        bs.add(b11);
        bs.add(b12);
        bs.add(b13);
        bs.add(b14);
        bs.add(b15);


        JFrame f = new JFrame();//creating instance of JFrame
        JLabel l = new JLabel("Welcome to the Bookstore");

        JButton b1 = new JButton("Add Book");//creating instance of JButton
        JButton b2 = new JButton("Update Book");//creating instance of JButton
        JButton b3 = new JButton("Request Book");//creating instance of JButton
        JButton b4 = new JButton("View Books");//creating instance of JButton
        JButton b5 = new JButton("Exit");//creating instance of JButton
        JButton b6 = new JButton("Search");
        JButton b7 = new JButton("Create Order"); // Creates a new JButton

        b1.setBounds(140, 50, 115, 40);//x axis, y axis, width, height
        b2.setBounds(140, 100, 115, 40);//x axis, y axis, width, height
        b3.setBounds(140, 150, 115, 40);//x axis, y axis, width, height
        b4.setBounds(140, 200, 115, 40);//x axis, y axis, width, height
        b5.setBounds(140, 250, 115, 40);//x axis, y axis, width, height
        b7.setBounds(140, 300, 115, 40);//x axis, y axis, width, height
        b6.setBounds(140, 350, 115, 40);

        f.add(l);
        l.setBounds(120,-225,115,40);
        l.setSize(400,500);
        l.setVisible(true);
        l.setLayout(null);//using no layout managers

        f.add(b1);//adding button in JFrame
        f.add(b2);//adding button in JFrame
        f.add(b3);//adding button in JFrame
        f.add(b4);//adding button in JFrame
        f.add(b5);//adding button in JFrame
        f.add(b7);
        f.add(b6);

        f.setSize(400, 500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
        f.setLocationRelativeTo(null);//sets the frame in the center of screen

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBookPage();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBookPage();
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requestBookPage();
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewBookPage();
            }
        });

        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitProg();
            }
        });

        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {searchPage();}
        });

        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createOrder();
            }
        });

    }
    public static void addBookPage(){
        JFrame f = new JFrame();//creating instance of JFrameJLabel message = new JLabel();
        JLabel inputbook = new JLabel("Input Book Name");
        JLabel inputquantity = new JLabel("Input Quantity");
        JTextField bookid = new JTextField();
        JTextField quantity = new JTextField();
        JButton addbook = new JButton("Add Book");
        JButton bmain1 =new JButton("Back to Main Menu");//creating instance of JButton
        JLabel message = new JLabel();

        bmain1.setBounds(130,350,150, 20);//x axis, y axis, width, height
        f.add(bmain1);//adding button in JFrame


        message.setBounds(25,30,350,50);
        message.setForeground(Color.red);
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setVerticalAlignment(JLabel.CENTER);


        inputbook.setBounds(150,100,150,20);//x axis, y axis, width, height
        bookid.setBounds(130,120,150,30);//x axis, y axis, width, height
        inputquantity.setBounds(160,160,150,20);//x axis, y axis, width, height
        quantity.setBounds(130,180,150,30);//x axis, y axis, width, height
        addbook.setBounds(155,250,100,20);//x axis, y axis, width, height
        bmain1.setBounds(130,350,150, 20);//x axis, y axis, width, height

        f.add(message);
        f.add(inputbook);
        f.add(bookid);//adding text field in JFrame
        f.add(inputquantity);
        f.add(quantity);//adding text field in JFrame
        f.add(addbook);
        f.add(bmain1);//adding button in JFrame

        addbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String book = bookid.getText();
                String bquantity = quantity.getText();
                Boolean numeric = true;

                try {
                    int bookquantity = Integer.parseInt(bquantity);
                } catch (NumberFormatException e1) {
                    numeric = false;
                }

                if(numeric && !book.isEmpty()) {
                    String pmessage = bs.addBook(book, Integer.parseInt(bquantity));

                    message.setForeground(Color.blue);
                    message.setText(pmessage);
                }
                else {
                    message.setText("Input must be a string and integer!");
                }
            }
        });

        bmain1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
        f.setLocationRelativeTo(null);//sets the frame in the center of screen
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void updateBookPage() {
        JFrame f = new JFrame();//creating instance of JFrame
        JButton bmain1 = new JButton("Back to Main Menu");//creating instance of JButton
        JLabel message = new JLabel();

        JLabel inputbook = new JLabel("Input Book Name");
        JLabel inputquantity = new JLabel("Input Quantity");
        JTextField bookid = new JTextField();
        JTextField quantity = new JTextField();
        JButton updatebook = new JButton("Update");

        message.setBounds(25,30,350,50);
        message.setForeground(Color.red);
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setVerticalAlignment(JLabel.CENTER);


        inputbook.setBounds(150,100,150,20);//x axis, y axis, width, height
        bookid.setBounds(130,120,150,30);//x axis, y axis, width, height
        inputquantity.setBounds(160,160,150,20);//x axis, y axis, width, height
        quantity.setBounds(130,180,150,30);//x axis, y axis, width, height
        updatebook.setBounds(155,250,100,20);//x axis, y axis, width, height
        bmain1.setBounds(130,350,150, 20);//x axis, y axis, width, height

        f.add(message);
        f.add(inputbook);
        f.add(bookid);//adding text field in JFrame
        f.add(inputquantity);
        f.add(quantity);//adding text field in JFrame
        f.add(updatebook);
        f.add(bmain1);//adding button in JFrame

        updatebook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String book = bookid.getText();
                String bquantity = quantity.getText();
                Boolean numeric = true;

                try {
                    int bookquantity = Integer.parseInt(bquantity);
                } catch (NumberFormatException e1) {
                    numeric = false;
                }

                if(numeric  && !book.isEmpty()) {
                    String pmessage = bs.updateavailability(book, Integer.parseInt(bquantity));

                    message.setForeground(Color.blue);
                    message.setText(pmessage);
                }
                else {
                    message.setText("Input must be a string and integer!");
                }
            }
        });

        bmain1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
        f.setLocationRelativeTo(null);//sets the frame in the center of screen
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void requestBookPage(){
        JFrame f = new JFrame();//creating instance of JFrame
        JLabel message = new JLabel();
        JLabel inputbook = new JLabel("Input Book Name");
        JLabel inputquantity = new JLabel("Input Quantity");
        JTextField bookid = new JTextField();
        JTextField quantity = new JTextField();
        JButton requestbook = new JButton("Submit Request ");

        message.setBounds(0,30,600,20);
        message.setForeground(Color.red);
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setVerticalAlignment(JLabel.CENTER);



        inputbook.setBounds(150,100,150,20);//x axis, y axis, width, height
        bookid.setBounds(130,120,150,30);//x axis, y axis, width, height
        inputquantity.setBounds(160,160,150,20);//x axis, y axis, width, height
        quantity.setBounds(130,180,150,30);//x axis, y axis, width, height
        requestbook.setBounds(100,250,200,20);//x axis, y axis, width, height


        f.add(message);
        f.add(inputbook);
        f.add(bookid);//adding text field in JFrame
        f.add(inputquantity);
        f.add(quantity);//adding text field in JFrame
        f.add(requestbook);

        requestbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String book = bookid.getText();
                String bquantity = quantity.getText();
                Boolean numeric = true;

                try {
                    int bookquantity = Integer.parseInt(bquantity);
                } catch (NumberFormatException e1) {
                    numeric = false;
                }

                if(numeric  && !book.isEmpty()) {
                    String pmessage = bs.requestBooks(book, Integer.parseInt(bquantity));

                    message.setForeground(Color.blue);
                    message.setText(pmessage);
                }
                else {
                    message.setText("Input must be a string and integer!");
                }
            }
        });


        JButton bmain1 =new JButton("Back to Main Menu");//creating instance of JButton

        bmain1.setBounds(130,350,150, 20);//x axis, y axis, width, height
        f.add(bmain1);//adding button in JFrame

        bmain1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
        f.setLocationRelativeTo(null);//sets the frame in the center of screen
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void viewBookPage(){
        JFrame f = new JFrame();//creating instance of JFrame
        JPanel p = new JPanel(new BorderLayout());//creating instance of JPanel
        JButton bmain1 = new JButton("Back to Main Menu");//creating instance of JButton
        ArrayList<Book> booksInfo = new ArrayList<>();

        booksInfo = bs.getBooks();
        
        String[][] books = new String[booksInfo.size()][2];
        String[] columns = new String[] {"Name", "Quantity"};
        
        for(int i = 0; i < books.length; i++) {
        	for(int j = 0; j < books[0].length; j++) {
        		if(j == 0) {
        			books[i][j] = booksInfo.get(i).getName().toString();
        		}
        		else {
        			books[i][j] = String.valueOf(booksInfo.get(i).getQuantity());
        		}
        	}
        }
        
        JTable table = new JTable(books, columns);
        JScrollPane sp = new JScrollPane(table); // adding it to JScrollPane
        
        Border padding = BorderFactory.createEmptyBorder(50, 50, 50, 50);

        p.setBorder(padding);  
       
        bmain1.setBounds(130,350,150, 20);//x axis, y axis, width, height
        p.add(bmain1, BorderLayout.PAGE_END);//adding button in JFrame
        p.add(sp, BorderLayout.CENTER);        
        f.setContentPane(p);
        
        bmain1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        f.setSize(400,500);//400 width and 500 height
        f.setVisible(true);//making the frame visible
        f.setLocationRelativeTo(null);//sets the frame in the center of screen
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void exitProg(){
        System.exit(0);
    }

    public static void createOrder(){
        JFrame f = new JFrame();//creating instance of JFrameJLabel message = new JLabel();
        JLabel inputbook = new JLabel("Input book name");
        JLabel inputquantity = new JLabel("Input Quantity");
        JLabel invoiceName = new JLabel("Input invoice Name");
        JTextField bookid = new JTextField();
        JTextField quantity = new JTextField();
        JTextField title = new JTextField();
        JButton createOrder = new JButton("Create Order");
        JButton bmain1 =new JButton("Back to Main Menu");//creating instance of JButton
        JLabel message = new JLabel();

        bmain1.setBounds(130,350,150, 20);//x axis, y axis, width, height
        f.add(bmain1);//adding button in JFrame


        message.setBounds(25,30,350,50);
        message.setForeground(Color.red);
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setVerticalAlignment(JLabel.CENTER);

        invoiceName.setBounds(150,40,150,20);//x axis, y axis, width, height
        title.setBounds(130,60,150,30);//x axis, y axis, width, height
        inputbook.setBounds(150,100,150,20);//x axis, y axis, width, height
        bookid.setBounds(130,120,150,30);//x axis, y axis, width, height
        inputquantity.setBounds(160,160,150,20);//x axis, y axis, width, height
        quantity.setBounds(130,180,150,30);//x axis, y axis, width, height
        createOrder.setBounds(150,250,150,20);//x axis, y axis, width, height
        bmain1.setBounds(130,350,150, 20);//x axis, y axis, width, height

        f.add(message);
        f.add(inputbook);
        f.add(bookid);//adding text field in JFrame
        f.add(inputquantity);
        f.add(quantity);//adding text field in JFrame
        f.add(createOrder);
        f.add(bmain1);//adding button in JFrame
        f.add(invoiceName);
        f.add(title);

        createOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String book = bookid.getText();
                String title2 = title.getText();
                String bquantity = quantity.getText();
                Boolean numeric = true;
                Boolean inBookstore = bs.inStore(book);
                //bs.addBook(book, Integer.parseInt(bquantity));
                System.out.println(bs.inStore(book));
                System.out.println(book);
                System.out.println(title2);
                System.out.println(bquantity);

                try {
                    int bookquantity = Integer.parseInt(bquantity);
                } catch (NumberFormatException e1) {
                    numeric = false;
                }



                if(numeric && !book.isEmpty() && inBookstore) {
                    Book temp = bs.getBook(book);
                    //bs.createInvoice(book, );
                    String pmessage = bs.createInvoice(temp, Integer.parseInt(bquantity),title2);
                    message.setForeground(Color.blue);
                    message.setText(pmessage);
                }
                else if(numeric && !book.isEmpty() && !inBookstore){
                    message.setText("Must be an item in the book store");
                }else {
                    message.setText("Input must be a string and integer!");
                }
            }
        });

        bmain1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
        f.setLocationRelativeTo(null);//sets the frame in the center of screen
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void searchPage(){
        JFrame f = new JFrame();//creating instance of JFrame
        JLabel message = new JLabel();
        JLabel inputbook = new JLabel("Search BookStore");
        JTextField search = new JTextField();
        JButton submitsearch = new JButton("Submit");

        message.setBounds(25,30,350,50);
        message.setForeground(Color.red);
        message.setHorizontalAlignment(JLabel.CENTER);
        message.setVerticalAlignment(JLabel.CENTER);

        inputbook.setBounds(150,100,150,20);//x axis, y axis, width, height
        search.setBounds(130,120,150,30);//x axis, y axis, width, height
        submitsearch.setBounds(150,250,100,20);//x axis, y axis, width, height

        f.add(message);
        f.add(inputbook);
        f.add(search);//adding text field in JFrame
        f.add(submitsearch);

        submitsearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!search.getText().isEmpty()) {
                    JFrame f = new JFrame();//creating instance of JFrame
                    JLabel viewsearch = new JLabel("BOOKSTORE SEARCH:");
                    JPanel view = new JPanel(new BorderLayout());
                    JButton bmain1 = new JButton("Back");
                    ArrayList<Book> booksInfo = new ArrayList<>();
                    viewsearch.setBounds(0,10,150,40);

                    booksInfo = bs.searchResult(search.getText());

                    String[][] books = new String[booksInfo.size()][2];
                    String[] columns = new String[] {"Name", "Quantity"};

                    for(int i = 0; i < books.length; i++) {
                        for(int j = 0; j < books[0].length; j++) {
                            if(j == 0) {
                                books[i][j] = booksInfo.get(i).getName().toString();
                            }
                            else {
                                books[i][j] = String.valueOf(booksInfo.get(i).getQuantity());
                            }
                        }
                    }

                    JTable table = new JTable(books, columns);
                    JScrollPane sp = new JScrollPane(table); // adding it to JScrollPane

                    Border padding = BorderFactory.createEmptyBorder(50, 50, 50, 50);

                    view.setBorder(padding);

                    bmain1.setBounds(130,350,150, 20);//x axis, y axis, width, height
                    view.add(bmain1, BorderLayout.PAGE_END);//adding button in JFrame
                    view.add(sp, BorderLayout.CENTER);

                    bmain1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            f.dispose();
                        }
                    });

                    f.setContentPane(view);
                    f.setSize(400, 500);//400 width and 500 height
                    f.setVisible(true);//making the frame visible
                    f.setLocationRelativeTo(null);//sets the frame in the center of screen
                    f.setContentPane(view);
                }
            }
        });

        JButton bmain1 =new JButton("Back to Main Menu");//creating instance of JButton

        bmain1.setBounds(130,350,150, 20);//x axis, y axis, width, height
        f.add(bmain1);//adding button in JFrame

        bmain1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
        f.setLocationRelativeTo(null);//sets the frame in the center of screen
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
