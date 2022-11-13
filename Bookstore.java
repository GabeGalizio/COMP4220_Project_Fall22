import java.util.ArrayList;

public class Bookstore {
    public String name;
    public int storeID;
    public ArrayList<book> Books;

    public Bookstore(String name, int storeID) {
        this.name = name;
        this.storeID = storeID;
        Books = new ArrayList<>();
    }

    public void add(Book b1) {
        this.Books.add(b1);
    }


    public ArrayList<String> getBooks() {
        ArrayList temp = new ArrayList<String>();
        for (int i = 0; i < this.Books.size(); i++) {
            if (this.Books.get(i).getQuantity() > 0) {
                temp.add(Books.get(i).toString());
            }
        }
        return temp;
    }
    
    public String updateAvailability(String BookName, int updatedQuantity) {
    	for(int i = 0; i < this.Books.size(); i++) {
    		if (this.Books.get(i).getName().equals(BookName)) {
    			int BookQuantity = this.Books.get(i).getQuantity();
    			
    			if(BookQuantity == 0 && BookQuantity + updatedQuantity > 0) {
    				this.Books.get(i).setQuantity(BookQuantity+updatedQuantity);
    				return "The Book '"+BookName+"' is now in stock with "+this.Books.get(i).getQuantity()+" Books available for purchase";
    			}
    			else if(BookQuantity > 0 && BookQuantity + updatedQuantity == 0) {
    				this.Books.get(i).setQuantity(BookQuantity+updatedQuantity);
    				return "The Book '"+BookName+"' is now out of stock";
    			}
    			else if(BookQuantity == 0 && BookQuantity + updatedQuantity <= 0) {
    				if(BookQuantity + updatedQuantity == 0) {
    					return "No update made";
    				}
    				else {
    					return "The Book '"+BookName+"' has no stock to purchase from";
    				}
    				
    			}
    		}
    	}
    	return "Book does not exist within the inventory";
    }
}
