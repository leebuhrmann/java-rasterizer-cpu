import java.awt.Color;
import java.util.ArrayList;

import ObjectPOJOs.Pixel;
import RenderingComponents.Frame;

public class App {
    public static void main(String[] args) throws Exception {
        // Create window
        Frame frame = new Frame();
        frame.setVisible(true);

        // Import Model
        

        ArrayList<Pixel> buffer = new ArrayList();

        for (int x = 0; x < 200; x++) {
            buffer.add(new Pixel(x, 25, Color.BLUE));
        }

        frame.updatePanel(buffer);
    }
}
