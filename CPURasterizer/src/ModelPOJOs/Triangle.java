package ModelPOJOs;

public class Triangle {
    
    private Point3 one;
    private Point3 two;
    private Point3 three;

    public Triangle(Point3 one, Point3 two, Point3 three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    public String toString() {
        return String.format("one: (%f,%f), two: (%f,%f), three: (%f,%f)", 
                            one.getX(), one.getY(), two.getX(), two.getY(), three.getX(), three.getY());
    }
}