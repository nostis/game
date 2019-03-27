package gameprocessing;
import processing.core.*;

import java.util.ArrayList;
import java.util.List;


public class Game extends PApplet {
    private boolean fullscreen = false;

    private Obstacle floor;
    private Obstacle cloud;
    private List<Obstacle> obstacles;
    private Player player;

    private float timePassed;
    private float timePrevious;

    private boolean isUp;
    private boolean isDown;
    private boolean isLeft;
    private boolean isRight;

    public void settings() {
        this.size(1024, 768);
    }

    public void setup() {
        floor = new Obstacle(0, 190, 200, 10);
        cloud = new Obstacle(50, 50, 80, 20);

        player = new Player(50, 50, 10, 10);

        obstacles = new ArrayList<>();

        timePassed = millis();
        timePrevious = 0f;

        obstacles.add(floor);
        obstacles.add(cloud);

        obstacles.add(new Obstacle(250, 20, 100, 30));
        obstacles.add(new Obstacle(400, 20, 100, 30));
        obstacles.add(new Obstacle(550, 20, 100, 30));
        obstacles.add(new Obstacle(700, 20, 100, 30));
        obstacles.add(new Obstacle(850, 20, 100, 30));

        obstacles.add(new Obstacle(250, 70, 100, 30));
        obstacles.add(new Obstacle(400, 120, 100, 30));
        obstacles.add(new Obstacle(550, 170, 100, 30));
        obstacles.add(new Obstacle(700, 220, 100, 30));
        obstacles.add(new Obstacle(850, 270, 100, 30));

        obstacles.add(new Obstacle(870, 320, 100, 30));
        obstacles.add(new Obstacle(700, 370, 100, 30));
        obstacles.add(new Obstacle(550, 420, 100, 30));
        obstacles.add(new Obstacle(400, 470, 100, 30));
        obstacles.add(new Obstacle(250, 520, 100, 30));
        obstacles.add(new Obstacle(120, 570, 100, 30));
        obstacles.add(new Obstacle(210, 640, 100, 30));
        obstacles.add(new Obstacle(300, 710, 100, 30));

        obstacles.add(new Obstacle(0, 748, 1024, 20));

        isDown = false;
        isLeft = false;
        isRight = false;
        isUp = false;
    }

    public void draw() {

        timePassed = millis() - timePrevious;

        System.out.println("FPS: " + 1.f / (timePassed / 1000));

        timePrevious = millis();
        timePassed /= 100;

        if (isLeft) {
            player.updateVelX(-player.ACCELERATION);
            if (player.getVelocityX() < -player.MAX_SPEED) {
                player.setVelocityX(-player.MAX_SPEED);
            }
        }
        if (isRight) {
            player.updateVelX(player.ACCELERATION);
            if (player.getVelocityX() > player.MAX_SPEED) {
                player.setVelocityX(player.MAX_SPEED);
            }

        }
        if (isUp) {
            if(player.isOnGround()){
                player.updateVelY(-player.JUMP_DISTANCE);
            }
        }
        /*if (isDown) {
            player.updateVelY(player.ACCELERATION);
            if (player.getVelocityY() > player.MAX_SPEED) {
                player.setVelocityY(player.MAX_SPEED);
            }
        }*/

        player.updatePosAndCheckCollisions(timePassed, obstacles);

        clear();

        for(Obstacle ob : obstacles) {
            ob.display(this);
        }

        player.display(this);

    }

    public void keyReleased() {
        if (keyCode == LEFT) {
            isLeft = false;
        }
        if (keyCode == RIGHT) {
            isRight = false;
        }
        if (keyCode == UP) {
            isUp = false;
        }
        if (keyCode == DOWN) {
            isDown = false;
        }
    }

    public void keyPressed(){
        if (keyCode == LEFT) {
            isLeft = true;
        }
        if (keyCode == RIGHT) {
            isRight = true;
        }
        if (keyCode == UP) {
            isUp = true;
        }
        if (keyCode == DOWN) {
            isDown = true;
        }
    }

}