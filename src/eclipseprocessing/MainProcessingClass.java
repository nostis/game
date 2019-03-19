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
        r = new Obstacle(0, 0, 10, 100);
    }

    public void draw() {
        r.display(this);
    }
    
    public void keyPressed() {
    }
}