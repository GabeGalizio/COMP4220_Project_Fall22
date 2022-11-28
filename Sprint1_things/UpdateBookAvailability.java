/*
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UpdateBookAvailability {
	 
	@Test
	//testing the input of 0 in quantity to add 
	void test1() {
		Book b1 = new Book("Intro to agile 1", 0);
		
		Bookstore bs1 = new Bookstore("UWindsor", 100);
		
		bs1.add(b1);
		
		assertEquals("No updates made", bs1.updateavailability("Intro to agile 1", 0));
	}
	
	@Test
		//testing the increase on book stock
	void test2() {
		Book b1 = new Book("Intro to agile 1", 0);
		
		Bookstore bs1 = new Bookstore("UWindsor", 100);
		
		bs1.add(b1);
		
		assertEquals("The Book 'Intro to agile 1' now has 5 books in stock", bs1.updateavailability("Intro to agile 1", 5));
	}

	@Test
		//testing the withdrawal of more books than available
	void test3() {
		Book b1 = new Book("Intro to agile 1", 5);
		
		Bookstore bs1 = new Bookstore("UWindsor", 100);
		
		bs1.add(b1);
		assertEquals("The Book 'Intro to agile 1' has insufficent stock", bs1.updateavailability("Intro to agile 1", -10));
	}
	
	@Test
	//testing the withdrawal of all books in stock
	void test4() {
		Book b1 = new Book("Intro to agile 1", 5);
		
		Bookstore bs1 = new Bookstore("UWindsor", 100);
		
		bs1.add(b1);
		assertEquals("The Book 'Intro to agile 1' is now out of stock", bs1.updateavailability("Intro to agile 1", -5));
	}
	
	@Test
	//testing withdrawal of book when stock is at 0
	void test5() {
		Book b1 = new Book("Intro to agile 1", 0);
		
		Bookstore bs1 = new Bookstore("UWindsor", 100);
		
		bs1.add(b1);
		assertEquals("The Book 'Intro to agile 1' is not in stock", bs1.updateavailability("Intro to agile 1", -5));
	}
	
	@Test
	//testing when book name is not within inventory
	void test6() {
		Book b1 = new Book("Intro to agile 1", 0);
		
		Bookstore bs1 = new Bookstore("UWindsor", 100);
		
		bs1.add(b1);
		assertEquals("Book does not exist within the inventory", bs1.updateavailability("Intro to algorithms", -5));
	}
}


 */