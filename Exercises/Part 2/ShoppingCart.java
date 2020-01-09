import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {

    private Product[] cart;
    private int cartLength;
    private int point;

    // for the static methods
    private static int howMany = 0;
    private static double mostExpensive = Double.MIN_VALUE;
    private static ShoppingCart last = null;

    /*
     * Initializes an empty shopping cart.
     */
    public ShoppingCart() {

        this.cartLength = 10;
        this.point = 0;

        this.cart = new Product[cartLength];
        for (int i = 0; i < cartLength; i++) {
            this.cart[i] = null;
        }


        howMany++;
        last = this;
    }

    /*
     * No getters or setters.
     */

    /*
     * Adds an item to this shopping cart.
     */
    public void add(Product p) {

        if (point == cartLength){
            extendCart();
        }

        cart[point] = p;
        
        point++;

        if (this.totalPrice() > mostExpensive)
            mostExpensive = this.totalPrice();
    }

    private void extendCart(){
        
        Product[] newCart = new Product[cartLength*2];

        for (int i = 0; i < cartLength; i++){
            newCart[i] = cart[i];
        }

        this.cartLength = this.cartLength*2;
        this.cart = newCart;

    }

    /*
     * Returns the number of items in this shopping cart.
     */
    public int numberOfItems() {
        return point;
    }

    /*
     * Indicates whether this cart is eligible for free delivery.
     */
    public boolean freeDelivery() {
        return (point > 50);
    }

    /*
     * Returns the cost of this shopping cart.
     */
    public double totalPrice() {
        double total = 0;

        for (int i = 0; i < point; i++){
            total = total + this.cart[i].price();
        }

        return total;
    }

    /*
     * Returns the most expensive product in this shopping cart.
     */
    public Product mostExpensive() {
        Product mostExpensive = null;
        double price = Double.MIN_VALUE;

        for (int i = 0; i < point; i++){
            Product p = this.cart[i];
            if (p.price() > price) {
                mostExpensive = p;
                price = p.price();
            }
        }

        return mostExpensive;
    }

    /*
     * Returns the price of the most expensive product in this shopping cart.
     */
    public double highestPrice() {
        return mostExpensive().price();
    }

    /*
     * Counts the number of copies of a product in this shopping cart.
     */
    public int howMany(Product product) {
        int count = 0;

        for (int i = 0; i < point; i++){
            Product p = this.cart[i];
            if (product.equals(p))
                count = count + 1;

        }
        return count;
    }

    /*
     * Removes all copies of the most expensive product in the shopping cart.
     */
    public void removeMostExpensive() {
        Product target = mostExpensive();

        int i = 0;

        while ( i < point){

            Product cur = this.cart[i];
            if (cur.equals(target)){
                this.cart[i] = this.cart[point-1];
                this.cart[point-1] = null;
                point--;
            } else {
                i++;
            }

        }

    }

    /*
     * Returns the total number of shopping carts ever created.
     */
    public static int howMany() {
        return howMany;
    }

    /*
     * Returns the price of the most expensive shopping cart ever seen.
     */
    public static double mostExpensiveShoppingCart() {
        return mostExpensive;
    }

    /*
     * Returns a reference to the most recently created shopping cart.
     */
    public static ShoppingCart last() {
        return last;
    }

    /*
     * Basic testing of most methods.
     */
    public static void main(String[] args) {
        Product p1 = new Product("a", 2.0), p2 = new Product("b", 1.0), p3 = new Product("c", 6.0),
                p4 = new Product("d", 3.4);
        ShoppingCart test = new ShoppingCart();
        test.add(p1);
        test.add(p1);
        test.add(p2);
        test.add(p3);
        test.add(p1);
        test.add(p4);
        test.add(p2);
        test.add(p3);
        test.add(p1);
        test.add(p2);
        test.add(p1);
        test.add(p4);
        System.out.println("Number of items: " + test.numberOfItems());
        System.out.println("Free delivery: " + test.freeDelivery());
        System.out.println("Total price: " + test.totalPrice());
        System.out.println("Most expensive: " + test.mostExpensive());
        System.out.println("Highest price: " + test.highestPrice());
        test.removeMostExpensive();
        System.out.println("Number of items: " + test.numberOfItems());
        System.out.println("Free delivery: " + test.freeDelivery());
        System.out.println("Total price: " + test.totalPrice());
        System.out.println("Most expensive: " + test.mostExpensive());
        System.out.println("Highest price: " + test.highestPrice());
    }

}
