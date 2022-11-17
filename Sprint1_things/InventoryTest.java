import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {

    @Test
    //test to request positive number of books
    void TestCase1{
        book b1 = new book("Intro to agile 1", 1);
        book b2 = new book("Intro to java 2", 1);
        book b3 = new book("Intro to assembly 1", 1);
        book b4 = new book("Intro to c 1", 1);

        bookstore bs1 = new BookStore("University of Windsor",100);

        bs1.request(b1,12);
        bs1.request(b2,28);
        bs1.request(b3,6);
        bs1.request(b4,40);

        String expected[] = new String[] {"Requested: Intro to agile 1. Quantity: 12 ", "Requested: Intro to java 2. Quantity: 28", "Requested: Intro to assembly 1. Quantity: 6", "Requested: Intro to c 1. Quantity: 40"};
        assertArrayEquals(expected, bs1.requestbooks());

    }
    //test to request negative number of books
    void TestCase2{
        book b1 = new book("Intro to agile 1", 1);
        book b2 = new book("Intro to java 2", 1);
        book b3 = new book("Intro to assembly 1", 1);
        book b4 = new book("Intro to c 1", 1);

        bookstore bs1 = new BookStore("University of Windsor",100);

        bs1.request(b1,-3);
        bs1.request(b2,-2);
        bs1.request(b3,-10);
        bs1.request(b4,-25);

        String expected[] = new String[] {"Requested: Intro to agile 1. Request failed. Quantity Invalid. ", "Requested: Intro to java 2. Request failed. Quantity Invalid.", "Requested: Intro to assembly 1. Request failed. Quantity Invalid.", "Requested: Intro to c 1. Request failed. Quantity Invalid."};
        assertArrayEquals(expected, bs1.requestbooks());

    }
    void TestCase3{
        //test to request as a string
        book b1 = new book("Intro to agile 1", 1);
        book b2 = new book("Intro to java 2", 1);
        book b3 = new book("Intro to assembly 1", 1);
        book b4 = new book("Intro to c 1", 1);

        bookstore bs1 = new BookStore("University of Windsor",100);

        bs1.request(b1,hello);
        bs1.request(b2,anthony);
        bs1.request(b3,welcome);
        bs1.request(b4,joesph);

        String expected[] = new String[] {"Requested: Intro to agile 1. Request failed. Quantity must be an integer", "Requested: Intro to java 2. Request failed. Quantity must be an integer", "Requested: Intro to assembly 1. Request failed. Quantity must be an integer", "Requested: Intro to c 1. Request failed. Quantity must be an integer"};
        assertArrayEquals(expected, bs1.requestbooks());

    }
}