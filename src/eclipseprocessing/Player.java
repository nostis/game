package eclipseprocessing;

public class Player extends Obstacle {
    public Player(int posX, int posY, int width, int height){
        super(posX, posY, width, height);
    }

    public void move(int x, int y){
        this.setPosX(this.getPosX() + x);
        this.setPosY(this.getPosY() + y);
    }

}
