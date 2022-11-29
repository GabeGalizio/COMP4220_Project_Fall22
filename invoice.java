//used to create invoice PULL FROM SPRINT 1 shit

import java.util.ArrayList;

public class invoice {
    private String invoiceNum;
    private int quantityOrdered;
    private ArrayList<Book> books;

    public invoice(String invoiceNum) {
        this.invoiceNum = invoiceNum;
        books = new ArrayList<>();
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBooks(Book b) {
        this.books.add(b);
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }
}
