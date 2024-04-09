package ModelPOJOs;

import java.util.ArrayList;
import RenderingComponents.Pixel;

public class Model {
    
    private ArrayList<Point3> vs;
    private ArrayList<Point3> vns;
    private ArrayList<Point2> vts;
    private ArrayList<Triangle> t;

    public Model(ArrayList<Point3> vs, ArrayList<Point3> vns, ArrayList<Point2> vts, ArrayList<Triangle> t) {
        this.vs = vs;
        this.vns = vns;
        this.vts = vts;
        this.t = t;
    }

    public void setVS(ArrayList<Point3> vs) {
        this.vs = vs;
    }

    public ArrayList<Point3> getVS() {
        return this.vs;
    }

    public void setVNS(ArrayList<Point3> vns) {
        this.vns = vns;
    }

    public ArrayList<Point3> getVNS() {
        return this.vns;
    }

    public void setVTS(ArrayList<Point2> vts) {
        this.vts = vts;
    }

    public ArrayList<Point2> getVTS() {
        return this.vts;
    }

    public void setTriangles(ArrayList<Triangle> t) {
        this.t = t;
    }

    public ArrayList<Triangle> getTriangles() {
        return this.t;
    }

    public ArrayList<Pixel> getPixels() {
        ArrayList<Pixel> pixels = new ArrayList<>();
        for (Triangle tri : this.t) {
            pixels.addAll(tri.getPixels());
        }
        return pixels;
    }

    public Model scaleModel(int scale) {
        ArrayList<Point3> scaledVs = new ArrayList<>();
        ArrayList<Point3> scaledVns = new ArrayList<>();
        ArrayList<Point2> scaledVts = new ArrayList<>();
        ArrayList<Triangle> scaledT = new ArrayList<>();

        for (Point3 v : this.vs) {
            scaledVs.add(v.scalePoint3(scale));
        }
        for (Point3 vn : this.vns) {
            scaledVns.add(vn.scalePoint3(scale));
        }
        for (Point2 vt : this.vts) {
            scaledVts.add(vt.scalePoint2(scale));
        }
        for (Triangle t : this.t) {
            scaledT.add(t.scaleTriangle(scale));
        }

        return new Model(scaledVs, scaledVns, scaledVts, scaledT);
    }
}
