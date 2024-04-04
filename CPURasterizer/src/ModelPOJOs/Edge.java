package ModelPOJOs;

import RenderingComponents.Pixel;
import java.util.ArrayList;

public class Edge {
    
    private Point3 one;
    private Point3 two;

    public Edge(Point3 one, Point3 two) {
        this.one = one;
        this.two = two;
    }

    public ArrayList<Pixel> getPixels() {
        // TODO
        return null;
    }
}
