import javax.swing.JFrame;

public class Frame extends JFrame{
    
    public Frame() {
        setTitle("Lee's Rasterizer");
        setSize(500,500);
        setLocationRelativeTo(null); // null tells this method to center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel panel = new Panel();
        add(panel);
    }
}
