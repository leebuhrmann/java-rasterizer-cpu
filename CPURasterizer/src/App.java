import java.util.ArrayList;

import ModelPOJOs.Model;
import ModelPOJOs.Triangle;
import RenderingComponents.Frame;
import RenderingComponents.Pixel;

public class App {
    public static void main(String[] args) throws Exception {
        // Create window
        Frame frame = new Frame(false, false, false);
        frame.setVisible(true);
        // end create window

        // Import blender obj model
        OBJParser modelParser = new OBJParser();
        // Model model = modelParser.loadModel("CPURasterizer/src/WavefrontFiles/cube.obj"); // laptop
        Model model = modelParser.loadModel("src/WavefrontFiles/cube.obj"); // desktop
        Model scaledModel = model.scaleModel(50);
        // end import.
        
        // Render
        frame.render(scaledModel);
    }
}
