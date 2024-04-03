import java.awt.Color;
import java.util.ArrayList;

import ModelPOJOs.Model;
import ModelPOJOs.Triangle;
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
        Model model = modelParser.loadModel("CPURasterizer/src/WavefrontFiles/cube.obj");
        printModel(model.getTriangles());
        // end import
        
        // Fill buffer
        ArrayList<Pixel> buffer = new ArrayList();
        for (int x = 0; x < frame.getWidth(); x++) {
            buffer.add(new Pixel(x, 25, Color.BLUE));
        }

        frame.updatePanel(buffer);
    }

    private static void printModel(ArrayList<Triangle> model) {
        for (Triangle t : model) {
            System.out.println(t.toString());
        }
    }
}
