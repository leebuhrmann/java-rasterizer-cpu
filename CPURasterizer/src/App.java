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
        Model scaledModel = model.scaleModel(50);
        printModel(model);
        printModel(scaledModel);
        // end import.
        
        // Fill buffer
        ArrayList<Pixel> buffer = scaledModel.getPixels(); 

        // Render buffer
        frame.updatePanel(buffer);
    }

    private static void printModel(Model model) {
        ArrayList<Triangle> t = model.getTriangles();
        for (int i = 0; i < t.size(); i++) {
            System.out.printf("Triangle #%d: " + t.get(i).toString() + "\n", i);
        }
    }
}
