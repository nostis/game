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



}
