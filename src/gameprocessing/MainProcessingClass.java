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

    float lastX;
    float lastY;

    public void settings() {
        this.size(1024, 768);
    }

    public void setup() {
        floor = new Obstacle(0, 190, 200, 10);
        cloud = new Obstacle(100, 50, 80, 20);
        player = new Player(50, 50, 10, 10);
        obstacles = new ArrayList<>();
        timePassed = millis();
        timePrevious = 0f;
        velocityX = 0f;
        velocityY = 0f;
        acceleration = 2f;

        obstacles.add(floor);
        obstacles.add(cloud);

        isDown = false;
        isLeft = false;
        isRight = false;
        isUp = false;

        lastX = 0;
        lastY = 0;
    }

    public void draw() {
        timePassed = millis() - timePrevious;

        timePrevious = millis();

        timePassed /= 100;

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

        //velocityX += Math.signum(velocityX) * -1.0F * Math.min(0.5F, Math.abs(velocityX)); //nie boj sie tego xD
        //velocityY += Math.signum(velocityY) * -1.0F * Math.min(0.5F, Math.abs(velocityY)); //stopping player

        lastX = player.getPosX();
        lastY = player.getPosY();

        player.move(velocityX * timePassed, velocityY * timePassed);

        for (Obstacle ob : obstacles) {
            if (player.isCollidingWith(ob)) {
                /*player.setPosition(lastX, lastY);
                velocityX = 0;
                velocityY = 0;*/
                if((player.getPosX() + player.getWidth() > ob.getPosX()) || player.getPosX() < ob.getPosX() + ob.getWidth()){
                    //velocityX = 0;
                    velocityX += Math.signum(velocityX) * -1.0F * Math.min(0.5F, Math.abs(velocityX));
                    System.out.println("colliding x");
                }
                if((player.getPosY() + player.getHeight() > ob.getPosY()) || player.getPosY() < ob.getPosY() + ob.getHeight()){
                    velocityY = 0;
                    player.setPosY(lastY);
                    System.out.println("colliding y");
                }
            }
            else{
                velocityY += 0.2f; //gravity
            }
        }

        //velocityY += 0.2f;

        System.out.println(player.getPosX());

        //player.moveWithCollisions(floor, velocityX * timePassed, velocityY * timePassed);

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