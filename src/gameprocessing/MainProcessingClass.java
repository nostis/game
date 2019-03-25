package gameprocessing;
import processing.core.*;

import java.util.ArrayList;
import java.util.List;


public class MainProcessingClass extends PApplet {
    private boolean fullscreen = false;
    private Obstacle floor;
    private Obstacle cloud;
    private List<Obstacle> obstacles;
    private Player player;
    private float timePassed;
    private float timePrevious;
    private float velocityX;
    private float velocityY;
    private float acceleration;

    private boolean isUp;
    private boolean isDown;
    private boolean isLeft;
    private boolean isRight;

    public void settings() {
        this.size(200, 200);
    }

    public void setup() {
        floor = new Obstacle(0, 190, 200, 10);
        cloud = new Obstacle(100, 50, 80, 20);
        player = new Player(0, 50, 10, 10);
        obstacles = new ArrayList<>();
        timePassed = millis();
        timePrevious = 0f;
        velocityX = 0f;
        velocityY = 0f;
        acceleration = 1f;

        obstacles.add(floor);
        obstacles.add(cloud);

        isDown = false;
        isLeft = false;
        isRight = false;
        isUp = false;
    }

    public void draw() {
        timePassed = millis() - timePrevious;

        timePrevious = millis();

        if (keyPressed) {
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

        if (isLeft) {
            velocityX -= acceleration;
            if (velocityX < -player.MAXSPEED) {
                velocityX = -player.MAXSPEED;
            }
        }
        if (isRight) {
            velocityX += acceleration;
            if (velocityX > player.MAXSPEED) {
                velocityX = player.MAXSPEED;
            }
        }
        if (isUp) {
            velocityY -= acceleration;
            if (velocityY < -player.MAXSPEED) {
                velocityY = -player.MAXSPEED;
            }
        }
        if (isDown) {
            velocityY += acceleration;
            if (velocityY > player.MAXSPEED) {
                velocityY = player.MAXSPEED;
            }
        }

        velocityX += Math.signum(velocityX) * -1.0F * Math.min(0.5F, Math.abs(velocityX)); //nie boj sie tego xD
        velocityY += Math.signum(velocityY) * -1.0F * Math.min(0.5F, Math.abs(velocityY)); //stopping player

        float lastX = player.getPosX();
        float lastY = player.getPosY();

        player.move(velocityX * timePassed / 100, velocityY * timePassed / 100);

        for (Obstacle ob : obstacles) {
            if (player.isCollidingWith(ob)) {
                player.setPosition(lastX, lastY);
                velocityX = 0;
                velocityY = 0;
            }
        }

        clear();

        for (Obstacle ob : obstacles) {
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
}