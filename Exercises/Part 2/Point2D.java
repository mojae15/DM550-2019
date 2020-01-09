public class Point2D {

    // Class Attributes
    private double hori;
    private double vert;

    private static int numberOfOrigins = 0;

    // Constructor
    public Point2D(double hori, double vert) {
        this.hori = hori;
        this.vert = vert;
        if (isOrigin()) {
            numberOfOrigins++;
        }
    }

    // Gettera and setters
    public double getHori() {
        return this.hori;
    }

    public double getVert() {
        return this.vert;
    }

    public void setHori(double hori) {
        this.hori = hori;
    }

    public void setVert(double vert) {
        this.vert = vert;
    }

    public boolean isOrigin() {
        return (this.hori == 0 && this.vert == 0);
    }

    public void move(double deltaX, double deltaY) {
        if (isOrigin()) {
            numberOfOrigins--;
        }
        this.hori = this.hori + deltaX;
        this.vert = this.vert + deltaY;
        if (isOrigin()) {
            numberOfOrigins++;
        }
    }

    public double distanceToOrigin() {
        return Math.hypot(this.hori, this.vert);
    }

    public double distanceTo(Point2D point) {
        return Math.hypot(this.hori - point.hori, this.vert - point.vert);
    }

    public static int howManyOrigins() {
        return numberOfOrigins;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Point2D)) {
            return false;
        }

        Point2D otherPoint = (Point2D) other;
        return ((this.hori == otherPoint.hori) && (this.vert == otherPoint.vert));
    }

    public int hashCode(){
        return Double.hashCode(this.hori) + Double.hashCode(this.hori)*31;
    }

    public Point2D copy() {
        return new Point2D(this.hori, this.vert);
    }

    public String toString() {
        return "(" + this.hori + ", " + this.vert + ")";
    }

    public static void main(String[] args) {
        Point2D p1 = new Point2D(0, 0);
        Point2D p2 = p1;
        Point2D p3 = new Point2D(0, 0);

        p1.move(1, 1);
        System.out.println(p2.toString());

        p2.move(3, 3);
        System.out.println(p1.toString());
        
        System.out.println(Point2D.howManyOrigins());
    }

}