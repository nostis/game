package gameprocessing;

import java.util.List;

public class Player extends Obstacle {
    public final float MAXSPEED = 20f;
    public final float GRAVITY = 0.7f;
    public final float ACCELERATION = 2f;
    public final float JUMP_DISTANCE = 25f;

    private float velocityX;
    private float velocityY;

    public Player(int posX, int posY, int width, int height){
        super(posX, posY, width, height);

        velocityX = 0.f;
        velocityX = 0.f;
    }

    public void updatePosAndCheckCollisions(float deltaTime, List<Obstacle> obstacles){
        this.move(this.getVelocityX() * deltaTime, 0);

        for(Obstacle ob : obstacles){
            if(Collider.areColliding(this, ob)){
               this.setPosX(this.getPosX() - Collider.getDepthX(this, ob));
               this.setVelocityX(0);

            }
        }

        this.move(0, this.getVelocityY() * deltaTime);

        for(Obstacle ob : obstacles){
            if(Collider.areColliding(this, ob)){
                this.setPosY(this.getPosY() - Collider.getDepthY(this, ob));
                this.setVelocityY(0);
                this.updateVelX(Math.signum(velocityX) * -1.0F * Math.min(0.5F, Math.abs(velocityX))); //stopping player in x

            }
        }

        this.updateVelY(this.GRAVITY); //pulling player down - gravity
    }

    public boolean isOnGround(){
        return this.getVelocityY() == this.GRAVITY;
    }

    private void move(float x, float y){
        this.setPosX(this.getPosX() + x);
        this.setPosY(this.getPosY() + y);
    }

    public void updateVelX(float velX){
        velocityX += velX;
    }

    public void updateVelY(float velY){
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

}
