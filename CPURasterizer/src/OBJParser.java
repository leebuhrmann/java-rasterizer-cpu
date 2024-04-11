import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ModelPOJOs.Model;
import ModelPOJOs.Point2;
import ModelPOJOs.Point3;
import ModelPOJOs.Triangle;

public class OBJParser {
    
    private ArrayList<Point3> vs;
    private ArrayList<Point3> vns;
    private ArrayList<Point2> vts;
    private ArrayList<Triangle> t;

    public OBJParser() {
        this.vs = new ArrayList<>();
        this.vns = new ArrayList<>();
        this.vts = new ArrayList<>();
        this.t = new ArrayList<>();
    }

    public Model loadModel(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = null;

        while ((line = reader.readLine()) != null) {
            String[] tokens = line.trim().split("\\s+");
            if (tokens[0].equals("v")) {
                vs.add(new Point3(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2]), Float.parseFloat(tokens[3])));
            }
            else if (tokens[0].equals("vn")) {
                vns.add(new Point3(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2]), Float.parseFloat(tokens[3])));
            }
            else if (tokens[0].equals("vt")) {
                vts.add(new Point2(Float.parseFloat(tokens[1]), Float.parseFloat(tokens[2])));
            }
            else if (tokens[0].equals("f")) {
                Point3[] points = new Point3[3];
                for (int i = 0; i < 3; i++) {
                    String[] split = tokens[i + 1].split("/");
                    points[i] = vs.get(Integer.parseInt(split[0]) - 1);
                }

                t.add(new Triangle(points[0], points[1], points[2]));
            }
        }
        reader.close();

        return new Model(vs, vns, vts, t);
    }
}