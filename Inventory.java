public class Inventory {
    int requestBook;
    int quantity;

    public Inventory(int requestBook, int quantity){
        this.quantity = quantity;
        this.requestBook = requestBook;
    }

    public int getQuantity(){
        return quantity;
    }

    public int getRequestBook(){
        return requestBook;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setRequestBook(int requestBook) {
        this.requestBook = requestBook;
    }

    public String toString(){
        return + requestBook + "number of books request. Quantity:" + quantity;
    }
}