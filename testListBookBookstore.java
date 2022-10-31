import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testListBookBookstore {

    @Test
        //testing with all items being from the library
    void testCase1() {
        // creates a new book item with title, quantity
        book b1 = new book("Intro to agile 1", 1);
        book b2 = new book("Intro to java 2", 1);
        book b3 = new book("Intro to assembly 1", 1);
        book b4 = new book("Intro to c 1", 1);
        // creates new book store to store books
        bookstore bs1 = new BookStore("uwin", 100);
        bs1.add(b1);
        bs1.add(b2);
        bs1.add(b3);
        bs1.add(b4);


        String expected[] = new String[] {"Intro to agile 1", "Intro to java 2", "Intro to assembly 1", "Intro to c 1"};
        assertArrayEquals(expected, bs1.getbooks());

    }


    @Test
        //testing with some items being from the book store some from library
    void testCase2() {
        book b1 = new book("Intro to agile 1", 1);
        book b2 = new book("Intro to java 2", 1);
        book b3 = new book("Intro to assembly 1", 1);
        book b4 = new book("Intro to c 1", 1);

        // creates new libaray to store books
        bookstore bs1 = new BookStore("uwin", 100);
        bs1.add(b1);
        bs1.add(b2);
        Library l1 = new Library("Leddy", 100);
        l1.add(b3);
        l1.add(b4);

        String expected[] = new String[] {"Intro to agile 1", "Intro to java 2"};
        assertArrayEquals(expected, bs1.getbooks());

    }


    @Test
        //testing with all of the  items being from the book store none from library
    void testCase3() {
        book b1 = new book("Intro to agile 1", 1);
        book b2 = new book("Intro to java 2", 1);
        book b3 = new book("Intro to assembly 1", 1);
        book b4 = new book("Intro to c 1", 1);

        // creates new libaray to store books
        bookstore bs1 = new BookStore("uwin", 100);

        String expected[] = new String[] {};
        assertArrayEquals(expected, bs1.getbooks());
    }

    @Test
        //testing stock is equal to zero in the book store
        // the book should not show up in the list
    void testCase4() {
        // creates a new book item with title, quantity
        book b1 = new book("Intro to agile 1", 0);
        book b2 = new book("Intro to java 2", 1);
        book b3 = new book("Intro to assembly 1", 1);
        book b4 = new book("Intro to c 1", 1);
        // creates new book store to store books
        bookstore bs1 = new BookStore("uwin", 100);
        bs1.add(b1);
        bs1.add(b2);
        bs1.add(b3);
        bs1.add(b4);


        String expected[] = new String[] {"Intro to java 2", "Intro to assembly 1", "Intro to c 1"};
        assertArrayEquals(expected, bs1.getbooks());


    }


}
