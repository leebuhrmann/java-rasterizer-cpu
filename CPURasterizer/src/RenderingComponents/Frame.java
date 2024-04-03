package RenderingComponents;
import java.util.ArrayList;

import javax.swing.JFrame;

import ObjectPOJOs.Pixel;

public class Frame extends JFrame{
    
private Panel panel;

    public Frame() {
        setTitle("Lee's Rasterizer");
        setSize(500,500);
        setLocationRelativeTo(null); // null tells this method to center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new Panel();
        add(panel);
    }

    public void updatePanel(ArrayList<Pixel> buffer) {
        panel.setBuffer(buffer);
        panel.repaint();
    }
}
