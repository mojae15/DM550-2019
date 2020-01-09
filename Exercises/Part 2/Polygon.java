public class Polygon{

    //Class Attributes
    private Point2D[] vertices;
    private int id;

    private static int ids = 0;
    private static Polygon mostRecentTriangle = null;

    private double longest = 0.0;

    public Polygon(Point2D[] vertices){
        this.vertices = new Point2D[vertices.length];

        for (int i = 0; i < vertices.length; i++){
            this.vertices[i] = vertices[i];
        }

        this.id = ids;

        if (this.isTriangle()){
            mostRecentTriangle = this;
        }

        ids++;

    }

    //Getters and Setters
    public int getId() {
        return this.id;
    }

    public double perimeter(){
        double per = 0;

        int i;
        for (i = 0; i < this.vertices.length-1; i++) {
            double dist = this.vertices[i].distanceTo(this.vertices[i+1]);
            if (dist > longest){
                longest = dist;
            }
            per = per + dist;
        }

        double dist = this.vertices[i].distanceTo(this.vertices[0]);
        if (dist > longest){
            longest = dist;
        }
        per = per + dist;

        return per;

    }

    public Point2D nearest(){
        Point2D nearest = null;
        double distance = Double.MAX_VALUE;

        for(Point2D p: this.vertices){
            if (p.distanceToOrigin() < distance){
                nearest = p;
                distance = p.distanceToOrigin();
            }
        }
        
        return nearest.copy();

    }

    public double longestSide(){
        return longest;

    }

    public void move(double deltaX, double deltaY){
        for(Point2D p: this.vertices){
            p.move(deltaX, deltaY);
        }
    }

    public int verticesInQuadrant(int n){
        int count = 0;

        for(Point2D p: this.vertices){
            switch(n){
                case (1):
                    if ((p.getHori() > 0) && (p.getVert() > 0)){
                        count++;
                    }
                    break;

                case (2):
                    if ((p.getHori() < 0) && (p.getVert() > 0)){
                        count++;
                    }
                break;

                case (3):
                    if ((p.getHori() < 0) && (p.getVert() < 0)){
                        count++;
                    }
                break;

                case (4):
                    if ((p.getHori() > 0) && (p.getVert() < 0)){
                        count++;
                    }
                break;
                
            }
        }

        return count;

    }

    public boolean isTriangle(){

        return (vertices.length == 3);

    }

    private static boolean isRightAngle(Point2D p1, Point2D p2, Point2D p3) {
        return (((p1.getHori()-p2.getHori())*(p2.getHori()-p3.getHori())+(p1.getVert()-p2.getVert())*(p2.getVert()-p3.getVert())) == 0);
    }

    public boolean isRectangle(){
        return ((vertices.length == 4)
            && isRightAngle(vertices[0],vertices[1],vertices[2])
            && isRightAngle(vertices[1],vertices[2],vertices[3])
            && isRightAngle(vertices[2],vertices[3],vertices[0]));
    }

    public Polygon mostRecentTriangle(){
        return mostRecentTriangle;
    }

    public boolean equals(Object other) {
        if (!(other instanceof Polygon))
            return false;
    
        Polygon otherPolygon = (Polygon) other;
        // check that they have the same number of vertices
        if (this.vertices.length != otherPolygon.vertices.length){
            return false;
        }
    
        // first we find the first vertex
        int start = 0;
        boolean found = false;
        while ((start < otherPolygon.vertices.length) && !found) {
            if (this.vertices[0].equals(otherPolygon.vertices[start]))
            found = true;
            else
            start++;
        }
        if (!found)
            return false; // avoids long else
    
        // now we find the direction
        boolean goingUp = (this.vertices[1].equals(otherPolygon.vertices[(start+1)%vertices.length]));
        boolean equals = true;
        if (goingUp) { // loop forward
            int i = 2;
            while ((i < vertices.length) && equals) {
            if (!this.vertices[i].equals(otherPolygon.vertices[(start+i)%vertices.length]))
                equals = false;
            i++;
            }
        }
        else { // loop backwards
            int i = 1;
            while ((i < vertices.length) && equals) {
            if (!this.vertices[vertices.length-i].equals(otherPolygon.vertices[(start+i)%vertices.length]))
                equals = false;
            i++;
            }
        }
        return equals;
    }

    public String toString(){

        String res = "";

        int i;

        for(i = 0; i < vertices.length-1; i++){

            res = res + vertices[i].toString() + " ";

        }

        res = res + vertices[i].toString();

        return res;

    }

}