package eclipseprocessing;
import processing.core.*;


public class MainProcessingClass extends PApplet{
    public OtherClass extra;
    private boolean fullscreen=false;
    private Obstacle r;
    private Player p;
    
    public void settings() {
        this.size(200, 200);
    }
    
    public void setup() {
        r = new Obstacle(0, 190, 200, 10);
        p = new Player(0, 180, 10, 10);
    }

    public void draw() {
        clear();
        r.display(this);
        p.display(this);
    }
    
    public void keyPressed() {
        if(keyCode == LEFT){
            p.move(-5, 0);

        }
        if(keyCode == RIGHT){
            p.move(5, -0);
        }
    }
}