package RenderingComponents;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Panel extends JPanel {
 
    private int width;

    public Panel(int width) {
        this.width = width;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color color = Color.RED;
    
        for (int x = 0; x < width; x++) {
            int y = x; // Simple logic for a diagonal line
            drawPixel(g, x, y, color);
        }
    }

    private void drawPixel(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.drawLine(x, y, x, y);
    }
    
}
