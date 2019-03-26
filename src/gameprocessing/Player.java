package gameprocessing;

public class Player extends Obstacle {
    public final static float MAXSPEED = 10f;

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


    public float getXDepth(Obstacle ob){
        if((this.getPosX() + this.getWidth() > ob.getPosX()) && (this.getPosX() < ob.getPosX())){
            return -(ob.getPosX() - this.getPosX()) + this.getWidth();
        }
        else{
            return -(ob.getPosX() + (ob.getWidth() - this.getPosX()));
        }
    }

    public float getYDepth(Obstacle ob){
        if((this.getPosY() + this.getHeight() > ob.getPosY()) && (this.getPosY() < ob.getPosY())){
            return -(ob.getPosY() - this.getPosY()) + this.getHeight();
        }
        else{
            return -(ob.getPosY() + (ob.getHeight() - this.getPosY()));
        }
    }

}
