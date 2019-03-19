package eclipseprocessing;
import processing.core.*;


public class MainProcessingClass extends PApplet{
    public OtherClass extra;
    private boolean fullscreen=false;
    private Obstacle obstacle;
    private Player player;
    private float timePassed;
    private float timePrevious;
    private float velocityX;
    private float velocityY;
    
    public void settings() {
        this.size(200, 200);
    }
    
    public void setup() {
        obstacle = new Obstacle(0, 190, 200, 10);
        player = new Player(0, 180, 10, 10);
        timePassed = millis();
        timePrevious = 0f;
        velocityX = 0f;
        velocityY = 0f;
    }

    public void draw() {

        timePassed = millis() - timePrevious;

        timePrevious = millis();

        clear();

        player.display(this);


        if(keyPressed){
            if(keyCode == LEFT) {
                velocityX -= (timePassed / 100f * player.SPEED);
            }
            if(keyCode == RIGHT){
                velocityX += (timePassed / 100f * player.SPEED);
            }
            if(keyCode == UP){
                velocityY -= (timePassed / 100f * player.SPEED);
            }
            if(keyCode == DOWN){
                velocityY += (timePassed / 100f * player.SPEED);
            }
        }

        player.setPosition(velocityX, velocityY);

    }
    
    public void keyPressed() {
    }
}