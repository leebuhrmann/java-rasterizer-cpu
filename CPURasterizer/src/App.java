import java.util.ArrayList;

import ModelPOJOs.Model;
import RenderingComponents.Frame;
import RenderingComponents.Pixel;

public class App {
    public static void main(String[] args) throws Exception {
        // Create window
        Frame frame = new Frame(true, true, true, true);
        frame.setVisible(true);
        // end create window

        // Import blender obj model
        OBJParser modelParser = new OBJParser();
        Model model = modelParser.loadModel("src/WavefrontFiles/cube.obj");
        // Model model = modelParser.loadModel("src/WavefrontFiles/untitled.obj");
        // Model model = modelParser.loadModel("src/WavefrontFiles/star.obj");
        model.scaleModel(100);
        // end import.
        
        ArrayList<Pixel> buffer = new ArrayList();
        for (int x = 0; x < 101; x++) {
            for (int y = 0; y < 101; y++) {
                buffer.add(new Pixel(x,y,x+y,x,y));
            }
        }

        // Render
        frame.render(buffer);



    }
}
