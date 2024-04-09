package RenderingComponents;
import java.util.ArrayList;

import javax.swing.JFrame;

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
        buffer = center(buffer); 
        panel.setBuffer(buffer);
        panel.repaint();
    }

    private ArrayList<Pixel> center(ArrayList<Pixel> buffer) {
        ArrayList<Pixel> centeredBuffer = new ArrayList<>();
        int shiftX = Math.round(this.getWidth() / 2);
        int shiftY = Math.round(this.getHeight() / 2);
        for (Pixel p : buffer) {
            centeredBuffer.add(new Pixel(p.getX() + shiftX, p.getY() + shiftY, p.getColor()));
        }
        return centeredBuffer;
    }
}
