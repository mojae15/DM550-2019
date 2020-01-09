public class Product {

    private double price;
    private String name;

    /*
     * Constructor.
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /*
     * Getters and setters.
     */
    public String name() {
        return name;
    }

    public double price() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /*
     * Tests whether this product is the same as another.
     */
    public boolean equals(Object other) {
        if (!(other instanceof Product))
            return false;

        Product otherProduct = (Product) other;
        return (this.name.equals(otherProduct.name) && (this.price == otherProduct.price));
    }

    /*
     * Returns a hash of this product.
     */
    public int hashCode() {
        return Double.hashCode(price) + 31 * name.hashCode();
    }

    /*
     * Returns a copy of this product.
     */
    public Product copy() {
        return new Product(name, price);
    }

    /*
     * Returns a textual representation of this product.
     */
    public String toString() {
        return name + ": " + price;
    }

}
