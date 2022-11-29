import java.util.ArrayList;

public class Bookstore {
    public String name;
    public int storeID;
    public ArrayList<Book> Books;
    public ArrayList<invoice> invoice;

    public Bookstore(String name, int storeID) {
        this.name = name;
        this.storeID = storeID;
        Books = new ArrayList<>();
        invoice = new ArrayList<>();
    }

    public void add(Book b1) {
        this.Books.add(b1);
    }


    public ArrayList<Book> getBooks() {
        ArrayList<Book> temp = new ArrayList<Book>();
        for (int i = 0; i < this.Books.size(); i++) {
            if (this.Books.get(i).getQuantity() > 0) {
                temp.add(Books.get(i));
            }
        }
        return temp;
    }

    public String updateavailability(String BookName, int updatedQuantity) {
        for (int i = 0; i < this.Books.size(); i++) {
            if (this.Books.get(i).getName().equals(BookName)) {
                int BookQuantity = this.Books.get(i).getQuantity();

                if (updatedQuantity == 0) {
                    return "No updates made";
                } else if (BookQuantity >= 0 && BookQuantity + updatedQuantity > 0) {
                    this.Books.get(i).setQuantity(BookQuantity + updatedQuantity);
                    return "The Book '" + BookName + "' now has " + this.Books.get(i).getQuantity() + " books in stock";
                } else if (BookQuantity > 0 && BookQuantity + updatedQuantity <= 0) {
                    if (BookQuantity + updatedQuantity < 0) {
                        return "The Book '" + BookName + "' has insufficent stock";
                    } else {
                        this.Books.get(i).setQuantity(BookQuantity + updatedQuantity);
                        return "The Book '" + BookName + "' is now out of stock";
                    }

                } else if (BookQuantity == 0 && BookQuantity + updatedQuantity < 0) {
                    return "The Book '" + BookName + "' is not in stock";

                }
            }
        }
        return "Book does not exist within the inventory";
    }

    public String requestBooks(String BookName, int requestedQuantity) {
        for (int i = 0; i < this.Books.size(); i++) {
            if (this.Books.get(i).getName().equals(BookName)) {
                int BookQuantity = this.Books.get(i).getQuantity();

                if (requestedQuantity == 0) {
                    return "No requests submitted";
                } else if (BookQuantity >= 0 && BookQuantity + requestedQuantity > 0) {
                    this.Books.get(i).setQuantity(BookQuantity + requestedQuantity);
                    return "" + BookName + "' has been requested for shipment. " + this.Books.get(i).getQuantity() + " \namount of books have been requested.";
                }
            }
        }
        return "Book does not exist within the inventory";
    }

    public String addBook(String BookName, int addedQuantity) {
        for (int i = 0; i < this.Books.size(); i++) {
            if (this.Books.get(i).getName().equals(BookName)) {
                int BookQuantity = this.Books.get(i).getQuantity();

                if (addedQuantity == 0) {
                    return "No requests submitted";
                } else if (BookQuantity >= 0 && BookQuantity + addedQuantity > 0) {
                    this.Books.get(i).setQuantity(BookQuantity + addedQuantity);
                    return "" + BookName + "' has been added to inventory. Quantity: " + this.Books.get(i).getQuantity() + "";
                }
            } else {
                Book temp = new Book(BookName, addedQuantity);
                this.Books.add(temp);
                return "" + BookName + "' has been added to the inventory, with quantity: " + addedQuantity + "";
            }
        }
        return "Book does not exist within the inventory";
    }

    public boolean inStore(String n) {
        for (int i = 0; i < this.Books.size(); i++) {
            if (this.Books.get(i).getName().equals(n)) {
                return true;
            }
        }
        return false;
    }
    //takes in the book to be added to the invoice and the quantity
    public String createInvoice(Book b, int q, String invoiceName){
        invoice temp = new invoice(invoiceName);
        temp.setQuantityOrdered(q);
        temp.addBooks(b);
        b.setQuantity(b.getQuantity()-1);
        return "Invoice created : "  + invoiceName + " for " + q +" of " + b.getName();
    }


    public Book getBook(String n) {
        Book temp = new Book();
        for (int i = 0; i < this.Books.size(); i++) {
            if (this.Books.get(i).getName().equals(n)) {
                temp.setName(this.Books.get(i).getName());
                temp.setQuantity(this.Books.get(i).getQuantity());
            }
        }
        return temp;
    }


}


