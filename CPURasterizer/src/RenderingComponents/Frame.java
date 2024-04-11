package RenderingComponents;
import java.util.ArrayList;
import javax.swing.Timer;

import ModelPOJOs.Model;

import javax.swing.JFrame;

public class Frame extends JFrame{
    
private Panel panel;

    private ArrayList<Pixel> buffer;
    private Model model;
    private boolean animate;
    private boolean backFaceCulling;
    private boolean perspective;
    private int tick;

    public Frame(boolean animate, boolean backFaceCulling, boolean perspective) {
        setTitle("Lee's Rasterizer");
        setSize(500,500);
        setLocationRelativeTo(null); // null tells this method to center the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.tick = 0;
        this.buffer = null;
        this.model = null;
        this.animate = animate;
        this.backFaceCulling = backFaceCulling;
        this.perspective = perspective;

        panel = new Panel();
        add(panel);
    }

    public void render(Model model) {
        this.model = model;
        panel.setBuffer(center(this.model.getPixels()));
        Timer timer = new Timer(16, e -> {
            // this.buffer = panel.getBuffer();
            // if (animate) rotate();
            // if (perspective) perspective();
            // if (backFaceCulling) backFaceCulling(); 
            panel.repaint();
            tick++;
        });
        timer.start();
    }

    private void prepareBuffer() {
        
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

    private void rotate() {

    }
}
