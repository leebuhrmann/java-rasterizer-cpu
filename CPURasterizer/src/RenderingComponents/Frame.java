package RenderingComponents;
import java.util.ArrayList;
import javax.swing.Timer;

import ModelPOJOs.Model;
import ModelPOJOs.Point3;
import ModelPOJOs.Triangle;

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

    // public void render(Model model) {
    //     this.model = model;
    //     center();
    //     panel.setBuffer(this.model.getPixels());
    //     Timer timer = new Timer(16, e -> {
    //         panel.repaint();
    //         tick++;
    //         // System.out.println("tick: " + tick);
    //     });
    //     timer.start();
    // }

    public void render(Model model) {
        this.model = model;
        center();
        Timer timer = new Timer(16, e -> {
            panel.setBuffer(prepareBuffer());
            panel.repaint();
            tick++;
            // System.out.println("tick: " + tick);
        });
        timer.start();
    }

    private ArrayList<Pixel> prepareBuffer() {
            // get triangle
            // if (animate) rotate();
            // if (perspective) perspective();
            // if (backFaceCulling) backFaceCulling(); 
            // insert into buffer

            ArrayList<Pixel> buffer = new ArrayList<>();

            for (Triangle t : this.model.getTriangles()) {
                Point3 twoOne = t.getTwo().getSubtract(t.getOne());
                Point3 threeOne = t.getThree().getSubtract(t.getOne());
                Point3 cross = twoOne.getCross(threeOne);
                Point3 normal = cross.getNormalized();

                if (backFaceCulling && normal.getZ() < 0) {
                    continue;
                }

                buffer.addAll(t.getPixels());
            }

            return buffer;
    }

    private void center() {
        int shiftX = Math.round(this.getWidth() / 2);
        int shiftY = Math.round(this.getHeight() / 2);
        this.model.shiftX(shiftX);
        this.model.shiftY(shiftY);
    }

    private void rotate() {

    }
}
