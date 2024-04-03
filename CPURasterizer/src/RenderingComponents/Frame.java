package RenderingComponents;
import javax.swing.JFrame;

public class Frame extends JFrame{
    
    public Frame() {
        setTitle("Lee's Rasterizer");
        setSize(500,500);
        setLocationRelativeTo(null); // null tells this method to center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addPanel(int width) {
        Panel panel = new Panel(width);
        add(panel);
    }
}
