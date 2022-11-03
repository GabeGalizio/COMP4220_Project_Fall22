import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookStoreSearch {
	
	//test whether the search function returns a book 
	@Test
	void testCase1() {
		book b1 = new book("Intro to Agile 1", 1);
		
		bookstore bs1 = new BookStore("UWin", 100);
		bs1.add(b1);
		
		String expected[] = new String[] {"Intro to Agile 1"};
		assertArrayEquals(expected, bs1.getbooks());
	}
	
	//test whether the search function wont return a book 
	@Test
	void TestCase2() {
		book b1 = new book("Intro to Agile 1", 0);
		
		bookstore bs1 = new BookStore("UWin", 100);
		bs1.add(b1);
		
		String expected[] = new String[] {"Intro to Agile 1"};
		assertArrayEquals(expected, bs1.getbooks());
	}
}
