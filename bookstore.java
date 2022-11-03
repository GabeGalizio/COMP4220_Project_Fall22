import java.util.ArrayList;

public class bookstore {
    public String name;
    public int storeID;
    public ArrayList<book> books;

    public bookstore(String name, int storeID) {
        this.name = name;
        this.storeID = storeID;
        books = new ArrayList<>();
    }

    public void add(book b1) {
        this.books.add(b1);
    }


    public ArrayList<String> getBooks() {
        ArrayList temp = new ArrayList<String>();
        for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).getQuantity() > 0) {
                temp.add(books.get(i).toString());
            }
        }
        return temp;
    }
}
