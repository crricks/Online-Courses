public class RegularPolygon {
    private int n;
    private double side;
    private double x;
    private double y;
    
    public RegularPolygon() {
        this(3, 1, 0, 0);
    }
    
    public RegularPolygon(int n, double side) {
        this(n, side, 0, 0);
    }
    
    public RegularPolygon(int n, double side, double x, double y) {
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }
    
    public int getSides() {
        return this.n;
    }
    
    public double getSideLength() {
        return this.side;
    }
    
    public double getXCoord() {
        return this.x;
    }
    
    public double getYCoord() {
        return this.y;
    }
    
    public void setSides(int sides) {
        this.n = sides;
    }
    
    public void setSideLength(double length) {
        this.side = length;
    }
    
    public void setXCoord(double xCoord) {
        this.x = xCoord;
    }
    
    public void setYCoord(double yCoord) {
        this.y = yCoord;
    }
    
    public double getPerimeter() {
        return this.side * this.n;
    }
    
    public double getArea() {
        double area = (this.n * this.side * this.side) /
                            (4 * Math.tan(Math.PI / this.n));
        return area;
    }
    
}
