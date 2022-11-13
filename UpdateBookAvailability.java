import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UpdateBookAvailability {
	 
	@Test
		//updating Book stock to available 
	void test1() {
		Book b1 = new Book("Intro to agile 1", 0);
		
		Bookstore bs1 = new Bookstore("UWindsor", 100);
		
		bs1.add(b1);
		
		assertEquals("The Book 'Intro to agile 1' is now in stock with 5 Books available for purchase", bs1.updateAvailability("Intro to agile 1", 5));
	}

	@Test
		//updating Book stock to not available
	void test2() {
		Book b1 = new Book("Intro to agile 1", 5);
		
		Bookstore bs1 = new Bookstore("UWindsor", 100);
		
		bs1.add(b1);
		assertEquals("The Book 'Intro to agile 1' is now out of stock", bs1.updateAvailability("Intro to agile 1", -5));
	}
	
	@Test
	//updating Book stock quantity below 0
	void test3() {
		Book b1 = new Book("Intro to agile 1", 0);
		
		Bookstore bs1 = new Bookstore("UWindsor", 100);
		
		bs1.add(b1);
		assertEquals("No updates made", bs1.updateavailability("Intro to agile 1", 0));
	}
	
	@Test
	//updating Book stock quantity below 0
	void test4() {
		Book b1 = new Book("Intro to agile 1", 0);
		
		Bookstore bs1 = new Bookstore("UWindsor", 100);
		
		bs1.add(b1);
		assertEquals("The Book 'Intro to agile 1' has no stock to purchase from", bs1.updateavailability("Intro to agile 1", -5));
	}
	
	@Test
	//testing if wrong book name is given
	void test5() {
		Book b1 = new Book("Intro to agile 1", 0);
		
		Bookstore bs1 = new Bookstore("UWindsor", 100);
		
		bs1.add(b1);
		assertEquals("Book does not exist within the inventory", bs1.updateavailability("Intro to algorithms", -5));
	}
}
