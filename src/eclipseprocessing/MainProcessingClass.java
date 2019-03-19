package eclipseprocessing;
import processing.core.*;


public class MainProcessingClass extends PApplet{
    public OtherClass extra;
    private boolean fullscreen=false;
    private Obstacle r;
    private int i;
    
    public void settings() {
        this.size(200, 200);
    }
    
    public void setup() {
        r = new Obstacle(0, 0, 10, 100);
        i = 0;
    }

    public void draw() {
        r.display(this);

        //r.setWidth(i);

        //System.out.println(i);

        //i++;
    }
    
    public void keyPressed() {
    }
}