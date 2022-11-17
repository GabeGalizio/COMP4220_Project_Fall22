import org.junit.jupiter.api.Test;
import java.util.ArrayList;

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
        bookstore bs1 = new bookstore("uwin", 100);


        bs1.add(b1);
        bs1.add(b2);
        bs1.add(b3);
        bs1.add(b4);

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Intro to agile 1");
        expected.add("Intro to java 2");
        expected.add("Intro to assembly 1");
        expected.add("Intro to c 1");

        assertEquals(expected,bs1.getBooks());
    }



    @Test
        //testing with some items being from the book store some from library
    void testCase2() {
        book b1 = new book("Intro to agile 1", 1);
        book b2 = new book("Intro to java 2", 1);
        book b3 = new book("Intro to assembly 1", 1);
        book b4 = new book("Intro to c 1", 1);

        //creates 2 bookstores
        bookstore bs1 = new bookstore("uwin", 100);
        bookstore bs2 = new bookstore("uwin2", 101);
        bs1.add(b1);
        bs1.add(b2);
        bs2.add(b3);
        bs2.add(b4);

        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Intro to agile 1");
        expected.add("Intro to java 2");
        assertEquals(expected,bs1.getBooks());

    }


    @Test
        //testing with all of the  items being from the library none from library
    void testCase3() {
        book b1 = new book("Intro to agile 1", 1);
        book b2 = new book("Intro to java 2", 1);
        book b3 = new book("Intro to assembly 1", 1);
        book b4 = new book("Intro to c 1", 1);

        // creates new bookstore to store books
        bookstore bs1 = new bookstore("uwin", 100);
        bookstore bs2 = new bookstore("uwin2", 101);
        bs2.add(b1);
        bs2.add(b2);
        bs2.add(b3);
        bs2.add(b4);

        ArrayList<String> expected = new ArrayList<String>();
        assertEquals(expected,bs1.getBooks());
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
        bookstore bs1 = new bookstore("uwin", 100);
        bs1.add(b1);
        bs1.add(b2);
        bs1.add(b3);
        bs1.add(b4);


        ArrayList<String> expected = new ArrayList<String>();
        expected.add("Intro to java 2");
        expected.add("Intro to assembly 1");
        expected.add("Intro to c 1");
        assertEquals(expected,bs1.getBooks());


    }


}
