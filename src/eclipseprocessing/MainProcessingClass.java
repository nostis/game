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
    private float acceleration;
    
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
        acceleration = 1f;
    }

    public void draw() {

        timePassed = millis() - timePrevious;

        timePrevious = millis();

        clear();

        player.display(this);

        if(keyPressed){
            if(keyCode == LEFT) {
                velocityX -= acceleration;
                if(velocityX < -player.MAXSPEED){
                    velocityX = -player.MAXSPEED;
                }
            }
            if(keyCode == RIGHT){
                velocityX += acceleration;
                if(velocityX > player.MAXSPEED){
                    velocityX = player.MAXSPEED;
                }
            }
            if(keyCode == UP){
                velocityY -= acceleration;
                if(velocityY < -player.MAXSPEED){
                    velocityY = -player.MAXSPEED;
                }
            }
            if(keyCode == DOWN){
                velocityY += acceleration;
                if(velocityY > player.MAXSPEED){
                    velocityY = player.MAXSPEED;
                }
            }
        }

        velocityX += Math.signum(velocityX) * -1.0F * Math.min(0.5F, Math.abs(velocityX)); //nie boj sie tego xD
        velocityY += Math.signum(velocityY) * -1.0F * Math.min(0.5F, Math.abs(velocityY));
        player.move(velocityX * timePassed / 100, velocityY * timePassed / 100);
    }
    
    public void keyPressed() {
    }
}