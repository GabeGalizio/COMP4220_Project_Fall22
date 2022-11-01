import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UpdateBookAvailability {
	 
	@Test
		//updating book stock to available 
	void test2() {
		Book b1 = book("Intro to agile 1", 0);
		
		BookStore bs1 = new BookStore("UWindsor", 100);
		
		bs1.add(b1);
		
		asserEquals("The book 'Intro to agile 1' is in stock with 5 books available for purchase", bs1.updateAvaialbilty("Intro to agile 1", 5));
	}

	@Test
		//updating book stock to not available
	void test3() {
		Book b1 = book("Intro to agile 1", 5);
		
		BookStore bs1 = new BookStore("UWindsor", 100);
		
		bs1.add(b1);
		asserEquals("The book 'Intro to agile 1' is out of stock with 0 books available for purchase", bs1.updateAvaialbilty("Intro to agile 1", -5));
	}
	
}
