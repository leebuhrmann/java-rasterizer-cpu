package RenderingComponents;
import java.util.ArrayList;
import javax.swing.Timer;

import ModelPOJOs.Edge;
import ModelPOJOs.Model;
import ModelPOJOs.Point2;
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
            this.tick++;
            System.out.println("tick: " + tick);
        });
        timer.start();
    }

    private ArrayList<Pixel> prepareBuffer() {
            System.out.println("Enter prepareBuffer");
            ArrayList<Pixel> buffer = new ArrayList<>();

            for (Triangle t : this.model.getTriangles()) {
                Point3 one = t.getOne().clone();
                Point3 two = t.getTwo().clone();
                Point3 three = t.getThree().clone();

                if (animate) {
                    float angle = (float)tick / 10;

                    float[] out = rotate(one.getX(), one.getZ(), angle);
                    one.setX(out[0]);
                    one.setZ(out[1]);
          
                    out = rotate(two.getX(), two.getZ(), angle);
                    two.setX(out[0]);
                    two.setZ(out[1]);
          
                    out = rotate(three.getX(), three.getZ(), angle);
                    three.setX(out[0]);
                    three.setZ(out[1]);
                }


                if (perspective) {

                }

                Point3 twoOne = two.getSubtract(one);
                Point3 threeOne = three.getSubtract(one);
                Point3 cross = twoOne.getCross(threeOne);
                Point3 normal = cross.getNormalized();

                if (backFaceCulling && normal.getZ() < 0) {
                    continue;
                }

                buffer.addAll(new Edge(one,two).getPixels());
                buffer.addAll(new Edge(two,three).getPixels());
                buffer.addAll(new Edge(three,one).getPixels());
            }

            return buffer;
    }

    private void center() {
        int shiftX = Math.round(this.getWidth() / 2);
        int shiftY = Math.round(this.getHeight() / 2);
        this.model.shiftX(shiftX);
        this.model.shiftY(shiftY);
    }

    private float[] rotate(float x, float y, float angle) {
        float _bw = this.getWidth() / 2;
        float _y = y;
        float _x = x - _bw;
        float _r = (float)Math.sqrt(Math.pow(_x,2) + Math.pow(_y,2));
        float _tan = (float)Math.atan2(_y,_x);
        float _angle = _tan + angle;
        float _x2 = (float)Math.cos(_angle) * _r;
        float _y2 = (float)Math.sin(_angle) * _r;
        System.out.printf("x: %f | y: %f | angle: %f | x2: %f | y2: %f\n", x, y, angle, _x2, _y2);
        return new float[]{_x2 + _bw, _y2};
    }
}
