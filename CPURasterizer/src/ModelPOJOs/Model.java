package ModelPOJOs;

import java.util.ArrayList;

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
        return vs;
    }

    public void setVNS(ArrayList<Point3> vns) {
        this.vns = vns;
    }

    public ArrayList<Point3> getVNS() {
        return vns;
    }

    public void setVTS(ArrayList<Point2> vts) {
        this.vts = vts;
    }

    public ArrayList<Point2> getVTS() {
        return vts;
    }

    public void setTriangles(ArrayList<Triangle> t) {
        this.t = t;
    }

    public ArrayList<Triangle> getTriangles() {
        return t;
    }
}