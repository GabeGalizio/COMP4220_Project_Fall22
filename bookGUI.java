import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;


public class bookGUI{
    public static void main(String[] args) {


        JFrame f = new JFrame();//creating instance of JFrame
        JLabel l = new JLabel("Welcome to the Bookstore");

        JButton b1 = new JButton("Add Book");//creating instance of JButton
        JButton b2 = new JButton("Update Book");//creating instance of JButton
        JButton b3 = new JButton("Request Book");//creating instance of JButton
        JButton b4 = new JButton("View Books");//creating instance of JButton
        JButton b5 = new JButton("Exit");//creating instance of JButton

        b1.setBounds(140, 50, 115, 40);//x axis, y axis, width, height
        b2.setBounds(140, 100, 115, 40);//x axis, y axis, width, height
        b3.setBounds(140, 150, 115, 40);//x axis, y axis, width, height
        b4.setBounds(140, 200, 115, 40);//x axis, y axis, width, height
        b5.setBounds(140, 250, 115, 40);//x axis, y axis, width, height

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
                Bookstore bs = new Bookstore("UWindsor", 100);
                Book b1 = new Book("Astro 3", 0);
                bs.add(b1);

                try {
                    int bookquantity = Integer.parseInt(bquantity);
                } catch (NumberFormatException e1) {
                    numeric = false;
                }


                if(numeric) {
                    String pmessage = bs.addBook(book, Integer.parseInt(bquantity));

                    message.setText(pmessage);
                }
                else {
                    message.setText("Quantity must be an integer!");
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
                Bookstore bs = new Bookstore("UWindsor", 100);
                Book b1 = new Book("Intro to agile 1", 0);
                bs.add(b1);

                try {
                    int bookquantity = Integer.parseInt(bquantity);
                } catch (NumberFormatException e1) {
                    numeric = false;
                }


                if(numeric) {
                    String pmessage = bs.updateavailability(book, Integer.parseInt(bquantity));

                    message.setText(pmessage);
                }
                else {
                    message.setText("Quantity must be an integer!");
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
                Bookstore bs = new Bookstore("UWindsor", 100);
                Book b1 = new Book("Intro to physics 1", 0);
                bs.add(b1);

                try {
                    int bookquantity = Integer.parseInt(bquantity);
                } catch (NumberFormatException e1) {
                    numeric = false;
                }


                if(numeric) {
                    String pmessage = bs.requestBooks(book, Integer.parseInt(bquantity));

                    message.setText(pmessage);
                }
                else {
                    message.setText("Quantity must be an integer!");
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

        Bookstore bs = new Bookstore("UWindsor", 100);
        Book b1 = new Book("Agility Intro", 0);
        Book b2 = new Book("Mechanics and power", 0);
        Book b3 = new Book("Cells in animals", 0);

        bs.add(b1);
        bs.add(b2);
        bs.add(b3);

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

    public static void exitProg(){
        System.exit(0);
    }

}