import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class Panel extends JPanel {
 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Color myColor = Color.RED; // Choose your color
    
        for (int x = 0; x < getWidth(); x++) {
            int y = x; // Simple logic for a diagonal line
            drawPixel(g, x, y, myColor);
        }
    }

    private void drawPixel(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.drawLine(x, y, x, y); // Draws a line of length 0
    }
    
}
