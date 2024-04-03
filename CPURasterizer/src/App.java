import RenderingComponents.Frame;

public class App {
    public static void main(String[] args) throws Exception {
        Frame frame = new Frame();
        frame.setVisible(true);
        frame.addPanel(100);
        frame.addPanel(200);
    }
}
