package RenderingComponents;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.util.ArrayList;

public class Panel extends JPanel {
 
    private ArrayList<Pixel> buffer;

    public Panel() {
        this.buffer = new ArrayList();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBuffer(g);
    }

    private void drawBuffer(Graphics g) {
        for (Pixel p : buffer) {
            drawPixel(g, p);
        }
    }

    private void drawPixel(Graphics g, Pixel pixel) {
        int x = pixel.getX();
        int y = pixel.getY();
        g.setColor(pixel.getColor());
        g.drawLine(x, y, x, y);
    }

    public void setBuffer(ArrayList<Pixel> buffer) {
        this.buffer = buffer;
    }
    
}
