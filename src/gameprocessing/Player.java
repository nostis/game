package gameprocessing;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.List;

public class Player extends Obstacle {
    public final float MAX_SPEED = 20f;
    public final float GRAVITY = 0.7f;
    public final float ACCELERATION = 2f;
    public final float JUMP_DISTANCE = 25f;

    private PImage jumpingAnimation;
    private PImage actualAnimation;
    private List<PImage> animations;
    private int whichAnimation;

    private float velocityX;
    private float velocityY;

    private boolean isOnGround;
    private boolean wasLeft;
    private boolean isMoving;

    public Player(int posX, int posY, int width, int height, List<PImage> animations, PImage jumpingAnimation) {
        super(posX, posY, width, height);

        this.jumpingAnimation = jumpingAnimation;
        this.animations = animations;

        velocityX = 0.f;
        velocityX = 0.f;
        whichAnimation = 0;

        wasLeft = false;
        isMoving = false;
        isOnGround = false;

        actualAnimation = this.animations.get(0);

        for(PImage img : animations) {
            img.resize(40, 54);
        }

        jumpingAnimation.resize(38, 53);

        this.setWidth(animations.get(0).width);
        this.setHeight(animations.get(0).height);
    }

    public void updatePosAndCheckCollisions(float deltaTime, List<Obstacle> obstacles) {
        this.move(this.getVelocityX() * deltaTime, 0);

        for (Obstacle ob : obstacles) {
            if (Collider.areColliding(this, ob)) {
                this.setPosX(this.getPosX() - Collider.getDepthX(this, ob));
                this.setVelocityX(0);
            }
        }

        this.move(0, this.getVelocityY() * deltaTime);

        isOnGround = false;

        for (Obstacle ob : obstacles) {

            if (Collider.areColliding(this, ob)) {
                if (Collider.getDepthY(this, ob) > 0f) {
                    isOnGround = true;
                }

                this.setPosY(this.getPosY() - Collider.getDepthY(this, ob));
                this.setVelocityY(0);
                this.updateVelX(Math.signum(velocityX) * -1.0F * Math.min(0.5F, Math.abs(velocityX))); //stopping player in x
            }
        }

        this.updateVelY(this.GRAVITY); //pulling player down - gravity

        if(velocityX < 0) {
            wasLeft = true;
        }
        else if(velocityX > 0) {
            wasLeft = false;
        }

        if(velocityX != 0 && velocityY != 0) {
            isMoving = true;
        }
        else {
            isMoving = false;
        }

    }

    public boolean isOnGround() {
        //return this.getVelocityY() == this.GRAVITY; //bug as feature - uncomment this and comment below :)
        return isOnGround;
    }

    private void move(float x, float y) {
        this.setPosX(this.getPosX() + x);
        this.setPosY(this.getPosY() + y);
    }

    public void updateVelX(float velX) {
        velocityX += velX;
    }

    public void updateVelY(float velY) {
        velocityY += velY;
    }

    public float getVelocityX() {
        return velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }

    @Override
    public void display(PApplet screen) {
        if (whichAnimation == animations.size() - 1 || animations.size() - 1 == 0) {
            whichAnimation = 0;
        }

        if(!isOnGround){
            actualAnimation = jumpingAnimation;
        }
        else{
            actualAnimation = animations.get(whichAnimation);
        }

        if(this.wasLeft){ //to reverse image in x, when player was looking to left side
            screen.pushMatrix();
            screen.scale(-1, 1);
            screen.image(actualAnimation, -this.getPosX() - this.getWidth(), this.getPosY());
            screen.popMatrix();
        }
        else{
            screen.image(actualAnimation, this.getPosX(), this.getPosY());
        }

        if(isMoving && isOnGround){ //to change animation to normal when player fell down, and is on ground
            whichAnimation++;
            actualAnimation = animations.get(whichAnimation);
        }

    }

}

