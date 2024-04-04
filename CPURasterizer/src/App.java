import java.util.ArrayList;

import ModelPOJOs.Model;
import ModelPOJOs.Triangle;
import ModelPOJOs.Edge;
import ModelPOJOs.Point3;
import RenderingComponents.Frame;
import RenderingComponents.Pixel;

public class App {
    public static void main(String[] args) throws Exception {
        // Create window
        Frame frame = new Frame();
        frame.setVisible(true);
        // end create window

        // Import blender obj model
        OBJParser modelParser = new OBJParser();
        Model model = modelParser.loadModel("src/WavefrontFiles/cube.obj");
        printModel(model);
        // end import.
        
        // Fill buffer

        ArrayList<Pixel> buffer = model.getPixels();

        // test shape pojos getPixels
        // ArrayList<Pixel> buffer = new ArrayList<>();

        // Point3 pOne = new Point3(100,100,0);
        // Point3 pTwo = new Point3(150,75,0);
        // Point3 pThree = new Point3(126,175,0);

        // Edge eOne = new Edge(pOne, pTwo);
        // Edge eTwo = new Edge(pTwo, pThree);
        // Edge eThree = new Edge(pThree, pOne);

        // buffer.addAll(eOne.getPixels());
        // buffer.addAll(eTwo.getPixels());
        // buffer.addAll(eThree.getPixels());

        // // test triangle
        // Triangle t = new Triangle(pOne, pTwo, pThree);
        // buffer = t.getPixels();

        frame.updatePanel(buffer);
    }

    private static void printModel(Model model) {
        ArrayList<Triangle> t = model.getTriangles();
        for (int i = 0; i < t.size(); i++) {
            System.out.printf("Triangle #%d: " + t.get(i).toString() + "\n", i);
        }
    }
}
