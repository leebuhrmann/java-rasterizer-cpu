import ModelPOJOs.Model;
import RenderingComponents.Frame;

public class App {
    public static void main(String[] args) throws Exception {
        // Create window
        Frame frame = new Frame(true, true, false);
        frame.setVisible(true);
        // end create window

        // Import blender obj model
        OBJParser modelParser = new OBJParser();
        Model model = modelParser.loadModel("src/WavefrontFiles/cube.obj");
        model.scaleModel(50);
        // end import.
        
        // Render
        frame.render(model);
    }
}
