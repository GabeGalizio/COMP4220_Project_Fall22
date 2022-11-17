public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Intro to physics","Rl.Clyde",002,31,20.00);
        Book b2 = new Book("Intro to ethics","DJ. Anderson",003,50,45.00);
        Book b3 = new Book("Intro to math","MD.Peters",004,19,82.00);


        Bookstore bs1 = new Bookstore("University of Windsor", 400);
        b3.setQuantity(33);
        System.out.println(b3);
    }


}