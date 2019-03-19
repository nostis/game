package eclipseprocessing;
import processing.core.*;


public class MainProcessingClass extends PApplet{
    public OtherClass extra;
    private boolean fullscreen=false;
    private Obstacle r;
    
    public void settings() {
        this.size(200, 200);
    }
    
    public void setup() {
        r = (Obstacle) createShape(RECT, 0, 0, 100, 50);
    }

    public void draw() {
        shape(r);
    }
    
    public void keyPressed() {
    }
}