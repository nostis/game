package gameprocessing;

import java.util.List;

public class Player extends Obstacle {
    public final static float MAXSPEED = 20f;

    public Player(int posX, int posY, int width, int height){
        super(posX, posY, width, height);
    }

    public void move(float x, float y){
        this.setPosX(this.getPosX() + x);
        this.setPosY(this.getPosY() + y);
    }

    public void setPosition(float x, float y){
        this.setPosX(x);
        this.setPosY(y);
    }

    public void moveWithCollisions(Obstacle obstacle, float x, float y){
        /*float differenceX;
        float differenceY;

        differenceX = this.getPosX() + x - obstacle.getPosX();
        differenceY = this.getPosY() + y - obstacle.getPosY();

        if((differenceX < -this.getWidth() || differenceX > obstacle.getWidth()) && (differenceY < -this.getHeight() || differenceY > obstacle.getHeight())){
            System.out.println("Not colliding");
            //this.move(x, y);
        }
        else{
            if(differenceX < 0){
                x -= this.getWidth() + differenceX;
            }
            else if(differenceX >= 0){
                x += obstacle.getWidth() - differenceX;
            }

            if(differenceY < 0){
                y -= this.getHeight() + differenceY;
            }
            else if(differenceY >= 0){
                y += obstacle.getHeight() - differenceY;
            }

            //this.move(x, y);
        }*/

        //this.move(x, y);

        //float afterX = this.getPosX() + x;
        //float afterY = this.getPosY() + y;

        //if((afterX + this.getWidth() > obstacle.getPosX()) && ())
    }



}
